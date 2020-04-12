/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.repositories;

import com.yashpatel.domain.Product;
import com.yashpatel.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yash Patel
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findByIdAndUser(Long id, User user);
    
    @Query("select p from Product p"+" join fetch p.user"
            +" where p.id = :id" )
    Optional<Product> findByIdWithUser(Long id);
    
    
    List<Product> findByUser(User user);
}
