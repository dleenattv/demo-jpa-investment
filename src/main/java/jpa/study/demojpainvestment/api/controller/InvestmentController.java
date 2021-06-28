package jpa.study.demojpainvestment.api.controller;

import jpa.study.demojpainvestment.api.dto.InvestmentCreateDto;
import jpa.study.demojpainvestment.domain.investment.entity.Investment;
import jpa.study.demojpainvestment.domain.investment.service.InvestmentService;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping("/investments")
    public Investment investProduct(@RequestBody InvestmentCreateDto investmentCreateDto) throws Throwable {
        return investmentService.investProduct(investmentCreateDto);
    }

    @GetMapping("/products/{investorId}")
    public List<Product> findMyProducts(@PathVariable String investorId) throws Throwable {
        return investmentService.findMyProductsBy(investorId);
    }
}
