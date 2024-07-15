package vn.ths.BTCuoiKhoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = "vn.ths.BTCuoiKhoa")
public class BtCuoiKhoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtCuoiKhoaApplication.class, args);
	}

}
