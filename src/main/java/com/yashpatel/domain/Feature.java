/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Yash Patel
 */
@Entity
public class Feature {

    @Id
    private Long id;
    private String  title;
    private String description;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Feature{" + "id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + '}';
    }
    
}
