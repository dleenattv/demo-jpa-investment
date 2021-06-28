package jpa.study.demojpainvestment.domain.product.service;

import jpa.study.demojpainvestment.api.dto.InvestmentCreateDto;
import jpa.study.demojpainvestment.api.dto.ProductCreateDto;
import jpa.study.demojpainvestment.domain.investment.service.InvestmentService;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final InvestmentService investmentService;

    public ProductService(ProductRepository productRepository, InvestmentService investmentService) {
        this.productRepository = productRepository;
        this.investmentService = investmentService;
    }

    public Product createProduct(ProductCreateDto productCreateDto) {
        Product product = getProductBy(productCreateDto);

        return productRepository.save(product);
    }

    private Product getProductBy(ProductCreateDto productCreateDto) {
        return new Product(productCreateDto.getProductName(),
                            productCreateDto.getAmountOfTotalMoney());
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findProductsAreOnSale() {
        return productRepository.findProductsByIsOnSale(true);
    }

    public List<Product> findProductsAreNotOnSale() {
        return productRepository.findProductsByIsOnSale(false);
    }

    public Product getProductById(Long productId) throws Throwable {
        Product product = (Product) productRepository
                        .findProductByProductId(productId)
                        .orElseThrow(() -> new Exception("Product does not exist"));

        return product.getOnSaleProduct(product);
    }

    public void addCurrentMoney(Product product, InvestmentCreateDto investmentCreateDto) {
        product.setCurrentMoney(investmentCreateDto.getAmountOfMoney());
    }

    public List<Product> findMyProductsBy(String investorId) throws Throwable {
        return investmentService.findMyProductsBy(investorId);
    }
}
