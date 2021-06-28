package jpa.study.demojpainvestment.api.controller;

import jpa.study.demojpainvestment.api.dto.ProductCreateDto;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(ProductCreateDto productCreateDto) {
        return productService.createProduct(productCreateDto);
    }
}
