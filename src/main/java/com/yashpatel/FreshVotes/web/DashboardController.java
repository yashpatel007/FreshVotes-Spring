/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.web;

import com.yashpatel.FreshVotes.repositories.ProductRepository;
import com.yashpatel.FreshVotes.repositories.UserRepository;
import com.yashpatel.domain.Product;
import com.yashpatel.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yash Patel
 */

@Controller
public class DashboardController {
    
    @Autowired
    ProductRepository productRepo;
    
    @RequestMapping(value = "/" , method=RequestMethod.GET)
    public String rootView(){
        return "index";
    }
    
    @RequestMapping(value = "/dashboard" , method=RequestMethod.GET)
    public String dashboard(@AuthenticationPrincipal User user,ModelMap model){
        List<Product> products = productRepo.findByUser(user);
        model.put("user", user);  
        model.put("products", products);
        return "dashboard";
    }
    
    
    
}
