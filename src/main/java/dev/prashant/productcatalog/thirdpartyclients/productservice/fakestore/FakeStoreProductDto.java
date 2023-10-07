package dev.prashant.productcatalog.thirdpartyclients.productservice.fakestore;
import  dev.prashant.productcatalog.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
