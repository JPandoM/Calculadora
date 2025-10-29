package com.example.calculadora.service;

import com.example.calculadora.model.OperacionResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraServiceTest {

    private CalculadoraService service;

    @BeforeEach
    void setUp() {
        service = new CalculadoraService();
    }

    @Test
    void testSuma() {
        OperacionResponseDTO result = service.suma(5, 3);
        assertEquals("suma", result.operacion());
        assertEquals(5, result.a());
        assertEquals(3, result.b());
        assertEquals(8, result.resultado());
    }

    @Test
    void testResta() {
        OperacionResponseDTO result = service.resta(10, 4);
        assertEquals("resta", result.operacion());
        assertEquals(10, result.a());
        assertEquals(4, result.b());
        assertEquals(6, result.resultado());
    }
}
