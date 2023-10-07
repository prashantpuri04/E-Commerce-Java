package dev.prashant.productcatalog.controllers;

import dev.prashant.productcatalog.dtos.GenericProductDto;
import dev.prashant.productcatalog.exceptions.NotFoundException;
import dev.prashant.productcatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    // @Autowired - 1way to inject
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // constructor injection - 2nd way
//    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
//        this.productService = productService;
//    }

    // setter Injection - 3rd way - prefer to use 2nd way
    //    @Autowired
    //    public  void setProductService(ProductService productService){
    //        this.productService = productService;
    //    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {

        return  productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){

        return productService.createProduct(product);
    }

    @PutMapping()
    public void updateProductById(){

    }
}
