package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Data;
import org.primefaces.event.CellEditEvent;

@Data
@Named
@RequestScoped
public class TestView {

    private String string;

    @PostConstruct
    public void init() {
        string = "PrimeFaces";
    }

    public void throwViewExpiredException() {
        throw new ViewExpiredException("A ViewExpiredException!",
                FacesContext.getCurrentInstance().getViewRoot().getViewId());
    }

}
