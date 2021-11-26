package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class MultiplyDTO {

    @ApiModelProperty(value = "Value of the first factor.")
    @NotNull(message = "First factor cannot be null.")
    private Double value1;

    @ApiModelProperty(value = "Value of the second factor.")
    @NotNull(message = "Second factor cannot be null.")
    private Double value2;

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public MultiplyDTO(Double value1, Double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public MultiplyDTO() {
    }
}
