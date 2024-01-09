package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Data;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Data
@Named
@RequestScoped
public class TestView {

    private MenuModel model;
    private String string;

    @PostConstruct
    public void init() {
        string = "PrimeFaces";
        model = new DefaultMenuModel();
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("Options")
                .build();
        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("Delete")
                .icon("pi pi-times")
                .command("#{testView.delete}")
                .build();
        firstSubmenu.getElements().add(item);
        model.getElements().add(firstSubmenu);

    }

    public void delete() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Delete", "Data deleted");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void throwViewExpiredException() {
        throw new ViewExpiredException("A ViewExpiredException!",
                FacesContext.getCurrentInstance().getViewRoot().getViewId());
    }

}
