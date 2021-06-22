package jpa.study.demojpainvestment.domain.investment.entity;

import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import jpa.study.demojpainvestment.domain.product.entity.Product;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "INVESTOR_ID")
    private Investor investor;

    @Column
    private Long amountOfMoney;

    @Column
    private LocalDateTime investedAt;

    public Investment() {
    }
}
