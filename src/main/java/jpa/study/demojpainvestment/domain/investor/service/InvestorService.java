package jpa.study.demojpainvestment.domain.investor.service;

import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import jpa.study.demojpainvestment.domain.investor.repository.InvestorRepository;
import org.springframework.stereotype.Service;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public Investor findInvestorById(String investorId) throws Throwable {
        return (Investor) investorRepository.findInvestorByInvestorId(investorId).orElseThrow(()-> new Exception(investorId + " is not a member."));
    }
}
