package com.example.calculadora.service;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    private final TracerImpl tracer = new TracerImpl();

    public int suma(int a, int b) {
        int resultado = a + b;
        tracer.trace(resultado);
        return resultado;
    }

    public int resta(int a, int b) {
        int resultado = a - b;
        tracer.trace(resultado);
        return resultado;
    }
}
