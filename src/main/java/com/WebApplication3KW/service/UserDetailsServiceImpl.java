package com.WebApplication3KW.service;

//import com.WebApplication3KW.model.RoleEntity;
//import com.WebApplication3KW.model.UserEntity;
//import com.WebApplication3KW.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String userName) {
//        UserEntity userEntity = checkAndSetUserEntity(userName);
//        Set<GrantedAuthority> grantedAuthoritySet = getAuthorities(userEntity);
//        return new User(userEntity.getUserName(), userEntity.getPassword(), grantedAuthoritySet);
//    }
//
//    private UserEntity checkAndSetUserEntity(String userName) {
//        UserEntity user = userRepository.findByUserName(userName);
//        if (user == null) {
//            throw new UsernameNotFoundException(userName);
//        }
//        return user;
//    }
//
//    private Set<GrantedAuthority> getAuthorities(UserEntity user) {
//        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//        for (RoleEntity role : user.getRoles()) {
//            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getRoleName()));
//        }
//        return grantedAuthoritySet;
//    }
//}
