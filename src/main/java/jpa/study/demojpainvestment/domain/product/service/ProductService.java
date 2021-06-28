package jpa.study.demojpainvestment.domain.product.service;

import jpa.study.demojpainvestment.api.dto.InvestmentCreateDto;
import jpa.study.demojpainvestment.api.dto.ProductCreateDto;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

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

    public Product getProductById(Long productId) throws Throwable {
        Product product = productRepository.findProductByProductId(productId);
        return product.getOnSaleProduct(product);
    }

    public void addCurrentMoney(Product product, InvestmentCreateDto investmentCreateDto) {
        product.setCurrentMoney(investmentCreateDto.getAmountOfMoney());
    }

    public List<Product> findProductsAreOnSale(Boolean param) {
        return productRepository.findProductsByIsOnSale(param);
    }
}
