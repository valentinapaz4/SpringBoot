package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class MensajeProdService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("Sistema de Gestión de Tareas - MODO PRODUCCIÓN");
        System.out.println("Sistema operativo - Acceso autorizado");
        System.out.println("Logging nivel: ERROR - Solo se mostrarán errores críticos");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Sistema de Gestión de Tareas - Finalizado");
        System.out.println("Todos los datos han sido procesados correctamente");
        System.out.println("=================================================");
    }
}