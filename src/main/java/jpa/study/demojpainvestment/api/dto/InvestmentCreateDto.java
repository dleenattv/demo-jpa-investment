package jpa.study.demojpainvestment.api.dto;

public class InvestmentCreateDto {

    private Long productId;

    private String investorId;

    private Long amountOfMoney;

    public Long getProductId() {
        return productId;
    }

    public String getInvestorId() {
        return investorId;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }
}
