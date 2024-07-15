package vn.ths.BTCuoiKhoa.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Role;
import vn.ths.BTCuoiKhoa.service.AccountService;
import vn.ths.BTCuoiKhoa.service.AccountServiceIpm;
import vn.ths.BTCuoiKhoa.service.MyService;
import vn.ths.BTCuoiKhoa.service.RoleService;

import javax.sql.DataSource;

@Configuration
public class MySecurity {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(AccountService accountService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(accountService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/delete/**", "/getAll/**", "/create/**", "/save/**", "/update/**").hasRole("ADMIN")
                        .requestMatchers("/teacherGetAll/**", "/teacherUpdate/**").hasAnyRole("ADMIN","TEACHER")
                        .requestMatchers("/save/student/**","/save/classRoom/**","/save/reportCard/**",
                                "/save/schoolProfile/**","/save/starterBook/**","/save/studentCard/**",
                                "/save/subject/**","/save/transcript/**","/search/**").hasAnyRole("ADMIN","TEACHER")
                        .requestMatchers("/myInfo/thread").hasAnyRole("USER","TEACHER")
                        .requestMatchers("/myInfo/teacher").hasRole("TEACHER")
                        .requestMatchers("/myInfo/student").hasRole("USER")
                        .anyRequest().permitAll()
        ).formLogin(
                login->login
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticationTheUser")
                        .permitAll()
                        .defaultSuccessUrl("/home")
                        .failureUrl("/showLoginPage?error")
        ).logout(
                logout->logout.permitAll()
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(crsrf->crsrf.disable());
                return http.build();
    }
}
