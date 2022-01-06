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
    
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        lazyCars = new ArrayList<>();
        lazyModel = new LazyDataModel<ArticulosVO>() {
            @Override
                    public int count(Map<String, FilterMeta> filterBy) {
                        int totalRowCount = 1000;
                        return totalRowCount;
                    }

                    @Override
                    public List<ArticulosVO> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                        System.out.println(first);
                        System.out.println(pageSize);
                            first += 1;
                            pageSize += first;
                            lazyCars = getArticulos(first, pageSize);
                        return lazyCars;
                    }
                };
    }
    
    public void getCargarImagen(String rutaImagen) {
//          Para eliminar el error de que no encuentra la imagen
        if (rutaImagen.equals("")) {
            
        } else {
            try {
                StreamedContent imagenArticulo = null;
                String ruta;
                String ext;
                ruta = rutaImagen.replace("\\", "/");
                ext = ruta.substring(ruta.lastIndexOf(".") + 1);
                imagen = DefaultStreamedContent.builder()
                        .contentType("image/" + ext)
                        .stream(() -> {
                            try {
                                File initialFile = new File(ruta);
                                return new FileInputStream(initialFile);
                            } catch (IOException e) {
                                return null;
                            }
                        })
                        .build();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public List<ArticulosVO> getArticulos(int first, int pageSize){
        System.out.println("Entra");
        List<ArticulosVO> vo = new ArrayList<>();
        for (int i = first; i < pageSize; i++) {
            System.out.println("L:\\IMAGES\\IMG"+i+".webp");
            vo.add(new ArticulosVO("id: " + i, "name: " + i, "L:\\IMAGES\\IMG"+(int)(Math.random()*(21-0+1)+0)+".webp"));
        }
        return vo;
    }
    
    public LazyDataModel<ArticulosVO> getLazyModel() {
        return lazyModel;
    }
    
}
