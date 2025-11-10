package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGrupo4Application implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    // Inyección por constructor de ambos servicios
    public SpringGrupo4Application(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringGrupo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Mostrar mensaje de bienvenida (según el profile activo)
        mensajeService.mostrarBienvenida();
        System.out.println();

        // 2. Mostrar la configuración actual
        tareaService.mostrarConfiguracion();
        System.out.println();

        // 3. Listar todas las tareas iniciales
        System.out.println("=== Tareas Iniciales ===");
        tareaService.listarTodas().forEach(tarea -> {
            String estado = tarea.isCompletada() ? "✅ COMPLETADA" : "⏳ PENDIENTE";
            System.out.println("- ID: " + tarea.getId() + " | " + tarea.getDescripcion() +
                    " [" + tarea.getPrioridad() + "] - " + estado);
        });
        System.out.println();

        // 4. Agregar una nueva tarea
        System.out.println("=== Agregando Nueva Tarea ===");
        try {
            tareaService.agregarTarea("Preparar presentación del TP", Prioridad.ALTA);
            System.out.println("✅ Nueva tarea agregada exitosamente");
        } catch (Exception e) {
            System.out.println("❌ Error al agregar tarea: " + e.getMessage());
        }
        System.out.println();

        // 5. Listar tareas pendientes
        System.out.println("=== Tareas Pendientes ===");
        tareaService.listarPendientes().forEach(tarea ->
                System.out.println("- " + tarea.getDescripcion() + " [" + tarea.getPrioridad() + "]"));
        System.out.println();

        // 6. Marcar una tarea como completada
        System.out.println("=== Completando Tarea ===");
        Long idTareaACompletar = 2L; // Probamos con la tarea ID 2
        if (tareaService.marcarComoCompletada(idTareaACompletar)) {
            System.out.println("✅ Tarea ID " + idTareaACompletar + " marcada como completada");
        } else {
            System.out.println("❌ No se pudo encontrar la tarea con ID " + idTareaACompletar);
        }
        System.out.println();

        // 7. Mostrar estadísticas
        System.out.println("=== Estadísticas ===");
        System.out.println(tareaService.obtenerEstadisticas());
        System.out.println();

        // 8. Listar tareas completadas
        System.out.println("=== Tareas Completadas ===");
        tareaService.listarCompletadas().forEach(tarea ->
                System.out.println("- " + tarea.getDescripcion() + " [" + tarea.getPrioridad() + "]"));
        System.out.println();

        // 9. Mostrar mensaje de despedida (según el profile activo)
        mensajeService.mostrarDespedida();
    }
}