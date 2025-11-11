-DESCRIPCIÓN GENERAL-
Este proyecto implementa un Sistema de Gestión de Tareas (To-Do List) desarrollado con Spring Boot, aplicando los principios fundamentales del framework y las buenas prácticas de programación en Java.

El objetivo principal es demostrar el uso de:

Inyección de dependencias mediante @Autowired y constructores.
Estereotipos (@Service, @Repository, @Component).
Configuración mediante properties y profiles para diferentes entornos (dev y prod).
CommandLineRunner para ejecutar la lógica principal al iniciar la aplicación.
Objetivos del Proyecto
✅ Crear proyectos Spring Boot con estructura profesional.
✅ Aplicar inyección de dependencias por constructor.
✅ Utilizar estereotipos según la responsabilidad de cada clase.
✅ Configurar la aplicación mediante application.properties.
✅ Inyectar valores de configuración con @Value.
✅ Gestionar diferentes entornos con profiles (dev / prod).
✅ Implementar CommandLineRunner para la ejecución inicial.

-Tecnologías Utilizadas-
Tecnología / Herramienta	Descripción
-Java 17+	Lenguaje base del desarrollo 
-Spring Boot 3.x	Framework principal para la aplicación
-Maven	Gestión de dependencias y build
-Lombok	Simplifica el código (getters, setters, constructores)
-Spring Boot DevTools	Recarga automática y utilidades para desarrollo
-Estructura del Proyecto

com.utn.tareas
├── model
│   ├── Tarea.java
│   └── Prioridad.java
│
├── repository
│   └── TareaRepository.java
│
├── service
│   ├── TareaService.java
│   ├── MensajeService.java
│   ├── MensajeDevService.java
│   └── MensajeProdService.java
│
└── TareasApplication.java

📁 model: Contiene las entidades del dominio (tareas y prioridades).
📁 repository: Gestiona los datos en memoria.
📁 service: Lógica de negocio y servicios de mensajes.
📁 application: Clase principal que ejecuta el flujo completo.

 -Ejecución del Proyecto-
 1. Clonar el repositorio
git clone https://github.com/usuario/tareas-springboot.git
cd tareas-springboot
 2. Compilar y ejecutar
mvn clean install
mvn spring-boot:run
Al iniciar la aplicación, se mostrará en consola:

Mensaje de bienvenida
Configuración activa
Listado de tareas iniciales
Agregado de una nueva tarea
Listado de tareas pendientes
Marcado de tarea como completada
Estadísticas
Mensaje de despedida
-Configuración de Entornos (Profiles)-
Spring Boot permite cambiar el comportamiento del sistema según el entorno activo.

Archivos principales
application.properties

spring.profiles.active=dev
application-dev.properties

app.max-tareas=10
app.mostrar-estadisticas=true
logging.level.com.utn.tareas=DEBUG
application-prod.properties

app.max-tareas=1000
app.mostrar-estadisticas=false
logging.level.com.utn.tareas=ERROR
Cambiar entre entornos
Para usar el entorno de producción:

spring.profiles.active=prod
Los beans MensajeDevService y MensajeProdService se activan automáticamente según el profile definido.

-Evidencia de Ejecución-
Profile dev
![Imagen de WhatsApp 2025-11-08 a las 02 30 01_8429d975](https://github.com/user-attachments/assets/75bfbced-d533-4d86-9dbb-51e5b644b98f)
![Imagen de WhatsApp 2025-11-08 a las 02 30 01_1fa30c62](https://github.com/user-attachments/assets/365e3c76-2b53-445e-a11a-daac3081b9f7)


Profile prod
![Imagen de WhatsApp 2025-11-08 a las 02 30 27_e9488be0](https://github.com/user-attachments/assets/e8eaceed-134a-430b-90fd-ba9ba58c8be0)
![Imagen de WhatsApp 2025-11-08 a las 02 30 27_9fa26951](https://github.com/user-attachments/assets/e65fd157-8210-4494-8c04-a2b831fc5976)



-Conclusiones-
El desarrollo de este trabajo práctico permitió aplicar los fundamentos de Spring Boot en un proyecto real, comprendiendo el valor de:

La inversión de control (IoC) y la inyección de dependencias.
La organización modular con estereotipos.
La configuración dinámica mediante archivos properties.
El uso de profiles para distintos entornos.
El diseño limpio y mantenible que propone el ecosistema Spring.

Alumnas:
Nombre: Abigail Muñoz 51004/ Valentina Paz 51029/ Natalia Vega 51139 
