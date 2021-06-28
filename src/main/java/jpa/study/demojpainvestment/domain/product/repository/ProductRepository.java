package jpa.study.demojpainvestment.domain.product.repository;

import jpa.study.demojpainvestment.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByIsOnSale(Boolean isOnSale);

    Optional findProductByProductId(Long productId);
}
