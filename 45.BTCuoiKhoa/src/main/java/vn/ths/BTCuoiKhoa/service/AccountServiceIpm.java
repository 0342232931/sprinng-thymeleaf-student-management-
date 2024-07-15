package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.AccountRepository;
import vn.ths.BTCuoiKhoa.entity.Account;
import vn.ths.BTCuoiKhoa.entity.Role;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceIpm implements MyService<Account>,AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceIpm(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(int id) {
        return accountRepository.findAccountByIdJoinFetch(id);
    }

    @Override
    @Transactional
    public Account add(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    @Transactional
    public Account update(Account account) {
        Optional<Account> optionalAccount = accountRepository.findById(account.getId());
        if(optionalAccount.isPresent()){
            return accountRepository.saveAndFlush(account);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account findByName(String name) {
        return accountRepository.findByUserName(name);
    }

    @Override
    //@Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);
        if (account == null){
            throw new UsernameNotFoundException("Khong ton tai tai khoan nay");
        }
        Account account1 = accountRepository.findAccountByIdJoinFetch(account.getId());
        return new User(account1.getUserName(),account1.getPassword(),rolesToAuthorities(account1.getRole()));
    }

    //@Transactional
    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }
}
