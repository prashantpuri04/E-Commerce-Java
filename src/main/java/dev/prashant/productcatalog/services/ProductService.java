package dev.prashant.productcatalog.services;

import dev.prashant.productcatalog.dtos.GenericProductDto;
import dev.prashant.productcatalog.exceptions.NotFoundException;
import dev.prashant.productcatalog.models.Product;

import java.util.List;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);
}
