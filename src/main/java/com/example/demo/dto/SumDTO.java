package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class SumDTO {

    @ApiModelProperty(value = "List of values to sum.")
    @NotEmpty(message = "Values list cannot be empty.")
    private List<Double> values;

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }

    public SumDTO(List<Double> values) {
        this.values = values;
    }

    public SumDTO() {
    }
}
