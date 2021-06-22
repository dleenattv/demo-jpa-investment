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
}
