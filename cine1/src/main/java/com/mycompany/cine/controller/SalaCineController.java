package com.mycompany.cine.controller;
import com.mycompany.cine.service.SalaCineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salas")
public class SalaCineController {
    @Autowired private SalaCineService service;
// Endpoint requerido para la evaluación de disponibilidad
    @GetMapping("/validar/{nombre}")
    public ResponseEntity<String> validarSala(@PathVariable String nombre) {
        return ResponseEntity.ok(service.validarSala(nombre));
    }
}
