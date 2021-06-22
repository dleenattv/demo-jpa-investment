package jpa.study.demojpainvestment.domain.investment.repository;

import jpa.study.demojpainvestment.domain.investment.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}
