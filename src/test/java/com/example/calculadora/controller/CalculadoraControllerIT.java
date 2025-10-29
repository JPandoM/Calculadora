package com.example.calculadora.controller;

import com.example.calculadora.model.OperacionResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculadoraControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSumaEndpoint() {
        OperacionResponseDTO response = restTemplate.getForObject("/api/suma?a=2&b=3", OperacionResponseDTO.class);
        assertEquals("suma", response.operacion());
        assertEquals(2, response.a());
        assertEquals(3, response.b());
        assertEquals(5, response.resultado());
    }

    @Test
    void testRestaEndpoint() {
        OperacionResponseDTO response = restTemplate.getForObject("/api/resta?a=10&b=4", OperacionResponseDTO.class);
        assertEquals("resta", response.operacion());
        assertEquals(10, response.a());
        assertEquals(4, response.b());
        assertEquals(6, response.resultado());
    }
}
