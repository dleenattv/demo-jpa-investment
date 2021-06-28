package jpa.study.demojpainvestment.domain.investor.repository;

import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {

    Optional<Investor> findInvestorByInvestorId(String investorId);

}
