package jpa.study.demojpainvestment.api.controller;

import jpa.study.demojpainvestment.api.dto.ProductCreateDto;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody ProductCreateDto productCreateDto) {
        return productService.createProduct(productCreateDto);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/products/is-on-sale/true")
    public List<Product> findProductsAreOnSale() {
        return productService.findProductsAreOnSale();
    }

    @GetMapping("/products/is-on-sale/false")
    public List<Product> findProductsAreNotOnSale() {
        return productService.findProductsAreNotOnSale();
    }
}
