package com.example.demo.controller;

import com.example.demo.dto.MultiplyDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SumDTO;
import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
@RestController
public class DemoController {

    @Autowired
    private DemoService service;

    @PostMapping("/sum")
    public @ResponseBody
    ResponseDTO doSum(
            @Valid
            @RequestBody
            @NotNull(message = "Input cannot be empty.")
            SumDTO request) {
        return new ResponseDTO(service.doSum(request));
    }

    @PostMapping("/multiply")
    public @ResponseBody
    ResponseDTO doMultiply(
            @Valid
            @RequestBody
            @NotNull(message = "Input cannot be empty.")
            MultiplyDTO request) {

        return new ResponseDTO(service.doMultiply(request));
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        List<FieldErrorResource> fieldErrorResources = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();
        for (FieldError constraintViolation : bindingResult.getFieldErrors()) {
            fieldErrorResources.add(FieldErrorResource.builder()
                    .field(constraintViolation.getField())
                    .resource(request.getContextPath())
                    .message(constraintViolation.getDefaultMessage()).build());
        }

        return responseEntityFor(HttpStatus.BAD_REQUEST,
                "The content you've sent contains " + bindingResult.getErrorCount() + " validation errors.", fieldErrorResources);
    }*/
}
