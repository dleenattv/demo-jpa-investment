package jpa.study.demojpainvestment.domain.investment.repository;

import jpa.study.demojpainvestment.domain.investment.entity.Investment;
import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    List<Investment> findInvestmentsByInvestor(Investor investor);

}
