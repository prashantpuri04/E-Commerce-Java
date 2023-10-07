package dev.prashant.productcatalog.services;

// import dev.prashant.productcatalog.dtos.FakeStoreProductDto;
import dev.prashant.productcatalog.dtos.GenericProductDto;
import dev.prashant.productcatalog.exceptions.NotFoundException;
import dev.prashant.productcatalog.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;

import dev.prashant.productcatalog.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.prashant.productcatalog.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Primary
@Repository("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }


    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProduct(id));
    }
}
//
//@Service("fakeStoreProductService")
//public class FakeStoreProductService implements ProductService{
//
//    private RestTemplateBuilder restTemplateBuilder;
//
//    private  String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
//    private String productRequestsBaseUrl = "https://fakestoreapi.com/products";
//
//    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
//        this.restTemplateBuilder = restTemplateBuilder;
//    }
//
//    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {
//
//        GenericProductDto product = new GenericProductDto();
//        product.setId(fakeStoreProductDto.getId());
//        product.setImage(fakeStoreProductDto.getImage());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setPrice(fakeStoreProductDto.getPrice());
//        product.setCategory(fakeStoreProductDto.getCategory());
//
//        return product;
//    }
//
//    public GenericProductDto createProduct(GenericProductDto product){
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(
//                productRequestsBaseUrl, product, GenericProductDto.class
//        );
//        return response.getBody();
//    }
//
//
//    @Override
//    public GenericProductDto getProductById(Long id) throws NotFoundException {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response =  restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
//
//        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//        if (fakeStoreProductDto == null) {
//            throw new NotFoundException("Product with id: " + id + " doesn't exist.");
//        }
//
//
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
//        // return null;
//    }
//
//    @Override
//    public List<GenericProductDto> getAllProducts() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ResponseEntity<FakeStoreProductDto[]> response =
//                restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);
//
//        List<GenericProductDto> answer = new ArrayList<>();
//
//        for ( FakeStoreProductDto fakeStoreProductDto: response.getBody()) {
//            answer.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
//        }
//
//        return answer;
//    }
//
//    @Override
//    public GenericProductDto deleteProduct(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
//                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE,
//                requestCallback, responseExtractor, id);
//
//        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
//    }
//}
