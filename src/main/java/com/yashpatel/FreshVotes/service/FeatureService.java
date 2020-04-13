/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.service;

import com.yashpatel.FreshVotes.repositories.FeatureRepository;
import com.yashpatel.FreshVotes.repositories.ProductRepository;
import com.yashpatel.domain.Feature;
import com.yashpatel.domain.Product;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash Patel
 */

@Service
public class FeatureService {
    
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private FeatureRepository featureRepo;
    
    
    public Feature createFeature(Long productID){
        Feature feature = new Feature();
        Optional<Product> productOpt = productRepo.findById(productID);
        
        if(productOpt.isPresent()){
            Product product = productOpt.get();
            feature.setProduct(product);
            product.getFeatures().add(feature);
            feature.setStatus("Pending Review");
            featureRepo.save(feature);
        }
        
        return feature;
        
    }
}
