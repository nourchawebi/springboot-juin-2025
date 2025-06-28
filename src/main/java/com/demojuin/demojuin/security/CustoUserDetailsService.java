package com.demojuin.demojuin.security;

import com.demojuin.demojuin.entities.Role;
import com.demojuin.demojuin.entities.UserEntity;
import com.demojuin.demojuin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class CustoUserDetailsService  implements UserDetailsService {
    private final UserRepo userRepo;
    @Autowired
    public CustoUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user= userRepo.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(),mapRolesToAuthorities(user.getRole()));
    }
     private Collection<GrantedAuthority> mapRolesToAuthorities(Role userRole){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority((userRole.getRoleName().toString())));
        return authorities;
     }
}
