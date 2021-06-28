package jpa.study.demojpainvestment.domain.investment.service;

import jpa.study.demojpainvestment.api.dto.InvestmentCreateDto;
import jpa.study.demojpainvestment.domain.investment.entity.Investment;
import jpa.study.demojpainvestment.domain.investment.repository.InvestmentRepository;
import jpa.study.demojpainvestment.domain.investor.entity.Investor;
import jpa.study.demojpainvestment.domain.investor.service.InvestorService;
import jpa.study.demojpainvestment.domain.product.entity.Product;
import jpa.study.demojpainvestment.domain.product.service.ProductService;
import org.springframework.stereotype.Service;

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
        Investment investment = new Investment();
        Product product = findProductById(investmentCreateDto);
        Investor investor = findInvestorById(investmentCreateDto);
        if (checkMoney(investmentCreateDto, product)) {
            investment = investment.getInvestment(product, investor, investmentCreateDto);
        } else {
            throw new Exception("Invest failed.");
        }
        addMoneyToProduct(product, investmentCreateDto);
        return investmentRepository.save(investment);
    }

    private void addMoneyToProduct(Product product, InvestmentCreateDto investmentCreateDto) {
        productService.addCurrentMoney(product, investmentCreateDto);
    }

    private Investor findInvestorById(InvestmentCreateDto investmentCreateDto) throws Throwable {
        return investorService.findInvestorById(investmentCreateDto.getInvestorId());
    }

    private Boolean checkMoney(InvestmentCreateDto investmentCreateDto, Product product) throws Throwable {
        if (product.getBalance() >= investmentCreateDto.getAmountOfMoney()) {
            return true;
        } else {
            throw new Exception("The investment must be less than the balance.");
        }
    }

    private Product findProductById(InvestmentCreateDto investmentCreateDto) throws Throwable {
        return productService.getProductById(investmentCreateDto.getProductId());
    }
}
