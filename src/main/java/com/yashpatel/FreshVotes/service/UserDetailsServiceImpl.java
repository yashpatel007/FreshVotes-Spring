/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.service;

import com.yashpatel.FreshVotes.repositories.UserRepository;
import com.yashpatel.FreshVotes.security.CustomSecurityUser;
import com.yashpatel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * @author Yash Patel
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // acess database and see if user and password match
        User user = userRepo.findByUsername(username);
        
        if(user ==null){
        throw new UsernameNotFoundException("Invalid Username and Password");
        }
        return new CustomSecurityUser(user);
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    
}
