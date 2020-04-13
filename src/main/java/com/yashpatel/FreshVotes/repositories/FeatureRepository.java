/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.repositories;

import com.yashpatel.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yash Patel
 */

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    
}
