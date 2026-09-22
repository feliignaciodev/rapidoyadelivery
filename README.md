# Rápido y Delivery

Proyecto desarrollado en Kotlin para modelar un sistema de entregas con centros de distribución, repartidores, clientes y pedidos. El objetivo es practicar conceptos de programación orientada a objetos, validación de datos, estados de un pedido y uso de corrutinas para tareas asíncronas.

## Descripción

La aplicación simula una pequeña plataforma de delivery donde se gestionan:

- Clientes con validación de correo y contraseña
- Repartidores con registro de tiempos de entrega
- Centros de distribución con capacidad máxima
- Pedidos con estado: en camino, entregado o cancelado
- Notificaciones asíncronas al cliente

## Estructura del proyecto

```text
rapidoyadelivery/
├── src/
│   └── main/
│       └── kotlin/
│           ├── Main.kt
│           └── entities/
│               ├── CentroDistribucion.kt
│               ├── Cliente.kt
│               ├── EstadoPedido.kt
│               ├── HolaMundo.kt
│               ├── Pedido.kt
│               ├── Repartidor.kt
│               └── Usuario.kt
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
├── .gitignore
└── README.md
```

## Principales entidades

### Usuario
Clase base que valida:

- nombre con longitud mínima
- correo con formato válido
- contraseña con longitud mínima
- control de intentos de inicio de sesión

### Cliente
Extiende `Usuario` y valida credenciales para iniciar sesión.

### Repartidor
Extiende `Usuario` y permite:

- registrar tiempos de entrega
- obtener el historial de entregas
- calcular promedios de rendimiento

### CentroDistribucion
Representa un centro con una capacidad máxima de repartidores y permite agregarlos y obtener la lista.

### Pedido
Contiene información del cliente, del repartidor, la dirección y el estado del pedido.

### EstadoPedido
Uso de una jerarquía sellada (`sealed class`) para representar los estados:

- `EnCamino`
- `Entregado`
- `Cancelado`

## Requisitos

- JDK 24 o compatible
- Gradle Wrapper incluido en el proyecto
- Kotlin JVM

## Cómo ejecutar

Desde la raíz del proyecto:

```bash
./gradlew run
```

Si estás en Windows:

```powershell
./gradlew.bat run
```

## Cómo compilar

```bash
./gradlew build
```

## Cómo probar

```bash
./gradlew test
```

## Tecnologías utilizadas

- Kotlin
- Gradle
- Kotlin Coroutines

## Autor

Proyecto de práctica con foco en modelado de dominio y validaciones en Kotlin.
