package com.example.calculadora.model;

public record OperacionResponseDTO(
        String operacion,
        int a,
        int b,
        int resultado
) {
}
