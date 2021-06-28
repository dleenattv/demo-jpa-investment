package jpa.study.demojpainvestment.api.controller;

import jpa.study.demojpainvestment.api.dto.ProductCreateDto;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/products/{investorId}")
    public List<Product> findMyProducts(@PathVariable String investorId) throws Throwable {
        return productService.findMyProductsBy(investorId);
    }
}
