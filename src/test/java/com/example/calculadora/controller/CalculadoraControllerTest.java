package com.example.calculadora.controller;

import com.example.calculadora.model.OperacionResponseDTO;
import com.example.calculadora.service.CalculadoraService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class CalculadoraControllerTest {

    @Mock
    private CalculadoraService calculadoraService;

    @InjectMocks
    private CalculadoraController controller;

    private final AutoCloseable mocks;

    public CalculadoraControllerTest() {
        mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mocks.close();
    }

    @Test
    void testSumaEndpoint() {
        OperacionResponseDTO mockResponse = new OperacionResponseDTO("suma", 2, 3, 5);
        when(calculadoraService.suma(2, 3)).thenReturn(mockResponse);

        ResponseEntity<OperacionResponseDTO> response = controller.suma(2, 3);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("suma", response.getBody().operacion());
        assertEquals(2, response.getBody().a());
        assertEquals(3, response.getBody().b());
        assertEquals(5, response.getBody().resultado());
    }

    @Test
    void testRestaEndpoint() {
        OperacionResponseDTO mockResponse = new OperacionResponseDTO("resta", 10, 4, 6);
        when(calculadoraService.resta(10, 4)).thenReturn(mockResponse);

        ResponseEntity<OperacionResponseDTO> response = controller.resta(10, 4);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("resta", response.getBody().operacion());
        assertEquals(10, response.getBody().a());
        assertEquals(4, response.getBody().b());
        assertEquals(6, response.getBody().resultado());
    }

    @Test
    void testSumaOverflow() {
        doThrow(new IllegalArgumentException("Suma produce overflow"))
                .when(calculadoraService).suma(Integer.MAX_VALUE, 1);

        try {
            controller.suma(Integer.MAX_VALUE, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Suma produce overflow", e.getMessage());
        }
    }

    @Test
    void testRestaOverflow() {
        doThrow(new IllegalArgumentException("Resta produce overflow"))
                .when(calculadoraService).resta(Integer.MIN_VALUE, 1);

        try {
            controller.resta(Integer.MIN_VALUE, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Resta produce overflow", e.getMessage());
        }
    }

}
