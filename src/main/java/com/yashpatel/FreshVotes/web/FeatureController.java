/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.web;

import com.yashpatel.FreshVotes.service.FeatureService;
import com.yashpatel.domain.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yash Patel
 */


@Controller
@RequestMapping("/products/{productID}/features")// acts as parent to inner url
public class FeatureController {
    
    @Autowired
    private FeatureService featureService;
    
    @PostMapping("")
    public String createFeature(@PathVariable long productID){
        Feature feature = featureService.createFeature(productID);
        return "feature";
    }
   
    
    
}
