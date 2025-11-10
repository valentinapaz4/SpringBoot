package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("🎉 ¡Bienvenido al Sistema de Gestión de Tareas! (MODO DESARROLLO)");
        System.out.println("Este es el entorno de desarrollo - Puedes probar todas las funcionalidades");
        System.out.println("Logging nivel: DEBUG - Verás información detallada");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("👋 ¡Hasta pronto! Recuerda que estás en modo desarrollo");
        System.out.println("Puedes realizar pruebas libremente sin afectar producción");
        System.out.println("==========================================================");
    }
}