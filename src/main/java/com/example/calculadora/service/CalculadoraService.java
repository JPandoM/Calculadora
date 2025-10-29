package com.example.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }
}
