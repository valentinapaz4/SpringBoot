// Actualiza la clase TareaService
package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Value("${app.nombre:Mi App de Tareas}")
    private String nombreApp;

    @Value("${app.max-tareas:10}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas:true}")
    private boolean mostrarEstadisticas;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        // Validar límite máximo de tareas
        if (tareaRepository.obtenerTodas().size() >= maxTareas) {
            throw new IllegalStateException("No se pueden agregar más tareas. Límite máximo: " + maxTareas);
        }

        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setDescripcion(descripcion);
        nuevaTarea.setPrioridad(prioridad);
        nuevaTarea.setCompletada(false);

        return tareaRepository.guardar(nuevaTarea);
    }

    public void mostrarConfiguracion() {
        System.out.println("=== Configuración de la Aplicación ===");
        System.out.println("Nombre: " + nombreApp);
        System.out.println("Máximo de tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
        System.out.println("======================================");
    }

    // Los demás métodos permanecen igual...
    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public boolean marcarComoCompletada(Long id) {
        return tareaRepository.buscarPorId(id)
                .map(tarea -> {
                    tarea.setCompletada(true);
                    tareaRepository.guardar(tarea);
                    return true;
                })
                .orElse(false);
    }

    public String obtenerEstadisticas() {
        if (!mostrarEstadisticas) {
            return "Las estadísticas están deshabilitadas en la configuración";
        }

        List<Tarea> todas = tareaRepository.obtenerTodas();
        long total = todas.size();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;

        return String.format("Estadísticas: Total=%d, Completadas=%d, Pendientes=%d",
                total, completadas, pendientes);
    }
}