package com.example.calculadora.service;

import com.example.calculadora.model.OperacionResponseDTO;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    private final TracerImpl tracer = new TracerImpl();

    public OperacionResponseDTO suma(int a, int b) {
        try {
            int resultado = Math.addExact(a, b);
            tracer.trace(resultado);
            return new OperacionResponseDTO("suma", a, b, resultado);
        } catch (ArithmeticException e) {
            tracer.trace("Overflow en suma: " + e.getMessage());
            throw new IllegalArgumentException("Suma produce overflow", e);
        }
    }

    public OperacionResponseDTO resta(int a, int b) {
        try {
            int resultado = Math.subtractExact(a, b);
            tracer.trace(resultado);
            return new OperacionResponseDTO("resta", a, b, resultado);
        } catch (ArithmeticException e) {
            tracer.trace("Overflow en resta: " + e.getMessage());
            throw new IllegalArgumentException("Resta produce overflow", e);
        }
    }
}
