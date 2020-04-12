/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.web;

import com.yashpatel.FreshVotes.repositories.ProductRepository;
import com.yashpatel.domain.Product;
import com.yashpatel.domain.User;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Yash Patel
 */

@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository productRepo;
    
    @GetMapping("/products")
    public String getProducts(ModelMap model, @AuthenticationPrincipal User user){
      
        return "products";
    } 
    
    @GetMapping("/products/{productID}")
    public String getProduct(@PathVariable Long productID, ModelMap model, HttpServletResponse response, @AuthenticationPrincipal User user) throws  IOException{
        // optional is kinda wrapper which says that this object can be null thus avoiding null pointer exception
        Optional<Product> productOpt = productRepo.findByIdWithUser(productID);
        
        model.put("user", user);
        if(productOpt.isPresent()){
            Product product = productOpt.get();
            model.put("product", product);
        }else{
            response.sendError(HttpStatus.NOT_FOUND.value(),"product with product id "+productID+" not found");
            return "product";
        }
        
        return "product";
    }
    
    @PostMapping("/products/{productID}")
    public String saveProduct(@PathVariable Long productID, @ModelAttribute Product product,@AuthenticationPrincipal User user){
        System.out.println(product);
        //product.setUser(user);
        product = productRepo.save(product);
        return "redirect:/products/"+product.getId();
    }
    
    
    @PostMapping("/products")
    public String createProduct(@AuthenticationPrincipal User user){
        
        Product product = new Product();
        product.setPublished(false);
        product.setUser(user);
        
        product = productRepo.save(product);
        
        return "redirect:/products/"+product.getId();
    }
}
