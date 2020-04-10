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
public class DashboardController {
    
    
    @RequestMapping(value = "/" , method=RequestMethod.GET)
    public String rootView(){
    return "index";
    }
    
    @RequestMapping(value = "/dashboard" , method=RequestMethod.GET)
    public String dashboard(){
    return "dashboard";
    }
    
    
}
