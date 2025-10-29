package com.example.calculadora.controller;

import com.example.calculadora.service.CalculadoraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/suma")
    public int suma(@RequestParam int a, @RequestParam int b) {
        return calculadoraService.suma(a, b);
    }

    @GetMapping("/resta")
    public int resta(@RequestParam int a, @RequestParam int b) {
        return calculadoraService.resta(a, b);
    }
}
