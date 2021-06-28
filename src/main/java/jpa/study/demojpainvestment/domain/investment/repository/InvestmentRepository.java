package jpa.study.demojpainvestment.domain.investment.repository;

import jpa.study.demojpainvestment.domain.investment.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
