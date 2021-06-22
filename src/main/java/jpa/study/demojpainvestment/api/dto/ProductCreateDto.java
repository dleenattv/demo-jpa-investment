package jpa.study.demojpainvestment.api.dto;

import javax.validation.constraints.NotBlank;

public class ProductCreateDto {

    @NotBlank
    private String productName;

    @NotBlank
    private Long amountOfTotalMoney;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getAmountOfTotalMoney() {
        return amountOfTotalMoney;
    }

    public void setAmountOfTotalMoney(Long amountOfTotalMoney) {
        this.amountOfTotalMoney = amountOfTotalMoney;
    }
}
