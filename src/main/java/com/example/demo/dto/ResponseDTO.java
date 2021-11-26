package com.example.demo.dto;

public class ResponseDTO {
    private Double result;

    public ResponseDTO() {
    }

    public ResponseDTO(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
