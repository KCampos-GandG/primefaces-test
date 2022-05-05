package org.primefaces.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.StreamedContent;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private LazyDataModel<ArticulosVO> lazyModel;
    private List<ArticulosVO> lazyCars;
    private StreamedContent imagen;

    private StreamedContent archivoXML;

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        archivoXML = DefaultStreamedContent.builder()
                .name("archivo.xml")
                .contentType("text/xml")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/temp/RespuestaHacienda.xml"))
                .build();
    }

    public LazyDataModel<ArticulosVO> getLazyModel() {
        return lazyModel;
    }

    public StreamedContent getArchivoXML() {
        return archivoXML;
    }
    
    public void setArchivoXML(StreamedContent archivoXML) {
        this.archivoXML = archivoXML;
    }

}
