/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arj.jdbcexample.entity;

import java.util.Date;

/**
 *
 * @author Zeppelin
 */
public class Document {
    private int id;
    private String title,description,imgFile;
    private Date addedDate, modifiedDate;

    public Document() {
    }

    public Document(int id, String title, String description, String imgFile, Date addedDate, Date modifiedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgFile = imgFile;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    
    
}
