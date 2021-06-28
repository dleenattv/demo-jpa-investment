package jpa.study.demojpainvestment.domain.investment.service;

import jpa.study.demojpainvestment.api.dto.InvestmentCreateDto;
import jpa.study.demojpainvestment.domain.investment.entity.Investment;
import jpa.study.demojpainvestment.domain.investment.repository.InvestmentRepository;
import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import jpa.study.demojpainvestment.domain.investor.service.InvestorService;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final ProductService productService;
    private final InvestorService investorService;

    public InvestmentService(InvestmentRepository investmentRepository, ProductService productService, InvestorService investorService) {
        this.investmentRepository = investmentRepository;
        this.productService = productService;
        this.investorService = investorService;
    }

    public Investment investProduct(InvestmentCreateDto investmentCreateDto) throws Throwable {
        Product product = findProductById(investmentCreateDto);
        Investor investor = findInvestorById(investmentCreateDto);

        product.addMoneyBy(investmentCreateDto);

        Investment investment = new Investment(product, investor, investmentCreateDto.getAmountOfMoney());

        return investmentRepository.save(investment);
    }

    private Investor findInvestorById(InvestmentCreateDto investmentCreateDto) {
        return investorService.findInvestorById(investmentCreateDto.getInvestorId());
    }

    private Product findProductById(InvestmentCreateDto investmentCreateDto) {
        return productService.getProductById(investmentCreateDto.getProductId());
    }

    public List<Product> findMyProductsBy(String investorId) {
        Investor investor = investorService.findInvestorById(investorId);
        Set<Investment> investments = investor.getInvestments();

        List<Product> products = new ArrayList<>();
        for (Investment investment : investments) {
            products.add(investment.getProduct());
        }

        return products;
    }
}
