package com.jackie.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackie on 2016/5/10.
 */
public class Product implements Serializable {

    private static final long serialVersioinUID = 74458L;

    //    @NotNull
//    @Size(min = 1, max =10)
    private String name;

    private String description;
    private Float price;
    private List<MultipartFile> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
