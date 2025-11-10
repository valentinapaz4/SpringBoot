
---

## 📘 Descripción General

Este proyecto implementa un **Sistema de Gestión de Tareas (To-Do List)** desarrollado con **Spring Boot**, aplicando los principios fundamentales del framework y las buenas prácticas de programación en Java.

El objetivo principal es demostrar el uso de:
- **Inyección de dependencias** mediante `@Autowired` y constructores.
- **Estereotipos** (`@Service`, `@Repository`, `@Component`).
- **Configuración mediante properties** y **profiles** para diferentes entornos (`dev` y `prod`).
- **CommandLineRunner** para ejecutar la lógica principal al iniciar la aplicación.

---

## 🎯 Objetivos del Proyecto

✅ Crear proyectos Spring Boot con estructura profesional.  
✅ Aplicar inyección de dependencias por constructor.  
✅ Utilizar estereotipos según la responsabilidad de cada clase.  
✅ Configurar la aplicación mediante *application.properties*.  
✅ Inyectar valores de configuración con `@Value`.  
✅ Gestionar diferentes entornos con *profiles* (`dev` / `prod`).  
✅ Implementar *CommandLineRunner* para la ejecución inicial.

---

## ⚙️ Tecnologías Utilizadas

| Tecnología / Herramienta | Descripción |
|---------------------------|-------------|
| ☕ **Java 17+** | Lenguaje base del desarrollo |
| 🚀 **Spring Boot 3.x** | Framework principal para la aplicación |
| 🧱 **Maven** | Gestión de dependencias y build |
| 🧩 **Lombok** | Simplifica el código (getters, setters, constructores) |
| 🔁 **Spring Boot DevTools** | Recarga automática y utilidades para desarrollo |

---

## 🏗️ Estructura del Proyecto

```

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

````

📁 **model:** Contiene las entidades del dominio (tareas y prioridades).  
📁 **repository:** Gestiona los datos en memoria.  
📁 **service:** Lógica de negocio y servicios de mensajes.  
📁 **application:** Clase principal que ejecuta el flujo completo.

---

## 🚀 Ejecución del Proyecto

### 🔹 1. Clonar el repositorio
```bash
git clone https://github.com/usuario/tareas-springboot.git
cd tareas-springboot
````

### 🔹 2. Compilar y ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

🖥️ Al iniciar la aplicación, se mostrará en consola:

1. Mensaje de bienvenida
2. Configuración activa
3. Listado de tareas iniciales
4. Agregado de una nueva tarea
5. Listado de tareas pendientes
6. Marcado de tarea como completada
7. Estadísticas
8. Mensaje de despedida

---

## 🔧 Configuración de Entornos (Profiles)

Spring Boot permite cambiar el comportamiento del sistema según el entorno activo.

### 📂 Archivos principales

**application.properties**

```properties
spring.profiles.active=dev
```

**application-dev.properties**

```properties
app.max-tareas=10
app.mostrar-estadisticas=true
logging.level.com.utn.tareas=DEBUG
```

**application-prod.properties**

```properties
app.max-tareas=1000
app.mostrar-estadisticas=false
logging.level.com.utn.tareas=ERROR
```

### 🧭 Cambiar entre entornos

Para usar el entorno de producción:

```properties
spring.profiles.active=prod
```

🧠 Los beans `MensajeDevService` y `MensajeProdService` se activan automáticamente según el *profile* definido.

---

## 📸 Evidencia de Ejecución

### 🧩 Profile `dev`

> *(Captura de consola mostrando mensajes detallados y estadísticas activas)*
> ![profiles-dev.png](../../profiles-dev.png)

### 🧩 Profile `prod`

> *(Captura de consola mostrando mensajes simplificados y estadísticas desactivadas)*
> ![profiles-prod.png](../../profiles-prod.png)

---

## 💭 Conclusiones Personales

El desarrollo de este trabajo práctico permitió aplicar los fundamentos de **Spring Boot** en un proyecto real, comprendiendo el valor de:

* La inversión de control (IoC) y la inyección de dependencias.
* La organización modular con estereotipos.
* La configuración dinámica mediante archivos *properties*.
* El uso de *profiles* para distintos entornos.
* El diseño limpio y mantenible que propone el ecosistema Spring.

---

## 👤 Autoras

**Nombre:** Abigail Muñoz / Valentina Paz / Natalia Vega
**Legajo:** 51004 / 51029 / 51139
**Materia:** Desarrollo de Software
**Carrera:** Ingeniería en Sistemas de la Información
**Institución:** Universidad Tecnológica Nacional (UTN)

---

## 📚 Recursos y Documentación Consultada

* 📘 [Documentación oficial de Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* 🌐 [Spring Initializr](https://start.spring.io/)
* 🧩 [Lombok Documentation](https://projectlombok.org/features/all)
* ⚙️ [Profiles en Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.profiles)

---

