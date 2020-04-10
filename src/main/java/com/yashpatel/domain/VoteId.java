/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;

/**
 *
 * @author Yash Patel
 */
@Embeddable
public class VoteId implements  Serializable{
   
    
    private static final long serialversionUID=6202269445639364170L;
    @ManyToOne
    private User user;
    @ManyToOne
    private Feature feature ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    
    
    
}
