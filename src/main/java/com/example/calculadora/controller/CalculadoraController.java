package com.example.calculadora.controller;

import com.example.calculadora.model.OperacionResponseDTO;
import com.example.calculadora.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/suma")
    public ResponseEntity<OperacionResponseDTO> suma(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(calculadoraService.suma(a, b));
    }

    @GetMapping("/resta")
    public ResponseEntity<OperacionResponseDTO> resta(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(calculadoraService.resta(a, b));
    }
}
