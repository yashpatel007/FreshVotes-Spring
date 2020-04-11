/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.repositories;

import com.yashpatel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yash Patel
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   User findByUsername(String username);
   
    
}
