package com.example.calculadora.service;

import com.example.calculadora.model.OperacionResponseDTO;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    private final TracerImpl tracer = new TracerImpl();

    public OperacionResponseDTO suma(int a, int b) {
        int resultado = a + b;
        tracer.trace(resultado);
        return new OperacionResponseDTO("suma", a, b, resultado);
    }

    public OperacionResponseDTO resta(int a, int b) {
        int resultado = a - b;
        tracer.trace(resultado);
        return new OperacionResponseDTO("resta", a, b, resultado);
    }
}
