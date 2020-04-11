/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.service;

import com.yashpatel.FreshVotes.repositories.UserRepository;
import com.yashpatel.domain.Authority;
import com.yashpatel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    public User save(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUser(user);
        user.getAuthorities().add(authority);
        
        
       return  userRepo.save(user);
    }
}
