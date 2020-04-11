/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.web;

import com.yashpatel.FreshVotes.service.UserService;
import com.yashpatel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yash Patel
 */

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;
      // both are equvalent
      //@GetMapping(value = "")
      @RequestMapping(value = "/login" , method=RequestMethod.GET)
      public String loginView(){
        return "login";
      }
      
       @RequestMapping(value = "/register" , method=RequestMethod.GET)
       public String registerView(ModelMap model){
        model.put("user", new User());
        return "register";
      }
       
      @PostMapping("/register")
      public String registerPost(@ModelAttribute User user){
         //System.out.println(user);
         // lets put data into database
         
          userService.save(user);
         return "redirect:/login";
      } 
    
}
