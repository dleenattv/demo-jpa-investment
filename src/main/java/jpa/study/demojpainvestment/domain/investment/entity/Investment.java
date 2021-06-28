package jpa.study.demojpainvestment.domain.investment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jpa.study.demojpainvestment.api.dto.InvestmentCreateDto;
import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import jpa.study.demojpainvestment.domain.product.entity.Product;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "INVESTOR_ID")
    @JsonBackReference
    private Investor investor;

    @Column
    private Long amountOfMoney;

    @Column
    private ZonedDateTime investedAt;

    public Investment() {
    }

    public Investment(Product product, Investor investor, Long amountOfMoney) {
        this.product = product;
        this.investor = investor;
        this.amountOfMoney = amountOfMoney;
        this.investedAt = ZonedDateTime.now();
    }

    public Product getProduct() {
        return product;
    }
}
