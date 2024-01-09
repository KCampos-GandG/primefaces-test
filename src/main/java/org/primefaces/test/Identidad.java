/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.primefaces.test;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Identidad implements Serializable {

    private String temaSeleccionado = "saga";
    
    public String getTemaSeleccionado() {
        return temaSeleccionado;
    }

    public void setTemaSeleccionado(String temaSeleccionado) {
        this.temaSeleccionado = temaSeleccionado;
    }
}
