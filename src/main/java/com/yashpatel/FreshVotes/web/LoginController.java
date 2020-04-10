/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.FreshVotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yash Patel
 */

@Controller
public class LoginController {
    
      // both are equvalent
      //@GetMapping(value = "")
      @RequestMapping(value = "/login" , method=RequestMethod.GET)
      public String loginView(){
        return "login";
      }

    
}
