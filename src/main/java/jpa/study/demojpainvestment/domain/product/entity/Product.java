package jpa.study.demojpainvestment.domain.product.entity;

import jpa.study.demojpainvestment.domain.investment.entity.Investment;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime startedAt;

    @Column
    private LocalDateTime endedAt;

    @OneToMany(mappedBy = "product")
    private Set<Investment> investments;

    public Product() {
    }

    public Product(String productName, Long amountOfTotalMoney) {
        this.productName = productName;
        this.amountOfTotalMoney = amountOfTotalMoney;
        this.isOnSale = false;
        setStartedAt();
        setEndedAt();
    }

    public void setStartedAt() {
        this.startedAt = LocalDateTime.now();
    }

    public void setEndedAt() {
        this.endedAt = startedAt.plusDays(7);
    }
}
