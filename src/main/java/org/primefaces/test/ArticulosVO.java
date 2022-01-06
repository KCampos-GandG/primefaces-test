/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author GandG
 */
public class ArticulosVO {
    private String id;
    private String name;
    private String path;    
    
    public ArticulosVO(String id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public ArticulosVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
