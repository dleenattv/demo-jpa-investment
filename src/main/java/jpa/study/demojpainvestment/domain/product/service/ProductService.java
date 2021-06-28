package jpa.study.demojpainvestment.domain.product.service;

import jpa.study.demojpainvestment.api.dto.ProductCreateDto;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductCreateDto productCreateDto) {
        Product product = getProductBy(productCreateDto);

        return productRepository.save(product);
    }

    private Product getProductBy(ProductCreateDto productCreateDto) {
        return new Product(productCreateDto);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository
                .findProductByProductIdAndIsOnSale(productId, Boolean.TRUE)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Product> findProductsAreOnSale(Boolean param) {
        return productRepository.findProductsByIsOnSale(param);
    }
}
