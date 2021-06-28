package jpa.study.demojpainvestment.domain.product.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jpa.study.demojpainvestment.api.dto.ProductCreateDto;
import jpa.study.demojpainvestment.domain.investment.entity.Investment;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column
    private String productName;

    @Column
    private Long amountOfTotalMoney;

    @Column
    private Long amountOfCurrentMoney;

    @Column
    private Boolean isOnSale;

    @Column
    private ZonedDateTime startedAt;

    @Column
    private ZonedDateTime endedAt;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<Investment> investments;

    public Product() {
    }

    public Product(ProductCreateDto productCreateDto) {
        this.productName = productCreateDto.getProductName();
        this.amountOfTotalMoney = productCreateDto.getAmountOfTotalMoney();
        this.amountOfCurrentMoney = 0L;
        this.isOnSale = false;
        this.startedAt = ZonedDateTime.now();
        this.endedAt = this.startedAt.plusDays(7);
    }

    public Product getOnSaleProduct(Product product) throws Exception {
        if (product.getOnSale()) {
            return product;
        } else {
            throw new Exception("This product is not on sale.");
        }
    }

    public Long getBalance() {
        return amountOfTotalMoney - amountOfCurrentMoney;
    }

    public void setCurrentMoney(Long money) {
        amountOfCurrentMoney = amountOfCurrentMoney + money;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Long getAmountOfTotalMoney() {
        return amountOfTotalMoney;
    }

    public Long getAmountOfCurrentMoney() {
        return amountOfCurrentMoney;
    }

    public Boolean getOnSale() {
        return isOnSale;
    }

    public ZonedDateTime getStartedAt() {
        return startedAt;
    }

    public ZonedDateTime getEndedAt() {
        return endedAt;
    }
}
