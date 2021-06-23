package jpa.study.demojpainvestment.domain.investment.service;

import jpa.study.demojpainvestment.domain.investment.repository.InvestmentRepository;
import jpa.study.demojpainvestment.domain.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final ProductService productService;

    public InvestmentService(InvestmentRepository investmentRepository, ProductService productService) {
        this.investmentRepository = investmentRepository;
        this.productService = productService;
    }
}
