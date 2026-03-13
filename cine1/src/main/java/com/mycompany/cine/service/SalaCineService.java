package com.mycompany.cine.service;
import com.mycompany.cine.repository.SalaCineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaCineService {
    @Autowired private SalaCineRepository salaCineRepo;
// Regla de negocio: Determina el estado de la sala según el conteo de películas
    public String validarSala(String nombreSala) {
        Integer resultado = salaCineRepo.contarPeliculasPorSala(nombreSala);
        int cantidad = (resultado != null) ? resultado : 0; 
        
        if (cantidad < 3) return "Sala disponible";
        if (cantidad <= 5) return "Sala con " + cantidad + " películas asignadas";
        return "Sala no disponible";
    }
}
