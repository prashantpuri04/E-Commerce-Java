package dev.prashant.productcatalog.dtos;

// dtos are to send or recieve data of same type or field it should be one to one mapped

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private  String category;
    private String description;
    private String image;
}
