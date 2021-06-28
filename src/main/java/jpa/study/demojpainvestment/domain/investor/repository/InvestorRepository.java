package jpa.study.demojpainvestment.domain.investor.repository;

import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvestorRepository extends JpaRepository<Investor, Long> {

    Optional findInvestorByInvestorId(String investorId);

}
