package com.example.demo.services;

import com.example.demo.dto.MultiplyDTO;
import com.example.demo.dto.SumDTO;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public Double doSum(SumDTO valuesList) {
        return valuesList.getValues()
                .stream()
                .reduce(0.0, (subtotal, element) -> subtotal + element);
    };

    public Double doMultiply(MultiplyDTO valuesList) {
        return valuesList.getValue1() * valuesList.getValue2();
    }
}
