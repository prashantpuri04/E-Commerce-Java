package dev.prashant.productcatalog.services;

import dev.prashant.productcatalog.dtos.GenericProductDto;
import dev.prashant.productcatalog.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
