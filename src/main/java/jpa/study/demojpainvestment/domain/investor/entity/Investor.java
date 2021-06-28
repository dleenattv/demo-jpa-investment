package jpa.study.demojpainvestment.domain.investor.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jpa.study.demojpainvestment.domain.investment.entity.Investment;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String investorId;

    @OneToMany(mappedBy = "investor")
    @JsonManagedReference
    private Set<Investment> investments;

    public Investor() {
    }
}
