package jpa.study.demojpainvestment.domain.investor.repository;

import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
