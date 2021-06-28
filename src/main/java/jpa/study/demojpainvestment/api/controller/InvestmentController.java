package jpa.study.demojpainvestment.api.controller;

import jpa.study.demojpainvestment.api.dto.InvestmentCreateDto;
import jpa.study.demojpainvestment.domain.investment.entity.Investment;
import jpa.study.demojpainvestment.domain.investment.service.InvestmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping("/investments")
    public Investment investProduct(InvestmentCreateDto investmentCreateDto) throws Throwable {
        return investmentService.investProduct(investmentCreateDto);
    }
}
