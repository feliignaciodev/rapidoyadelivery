# Rápido y Delivery

Proyecto de práctica en Kotlin para modelar un sistema de entregas de comida o paquetes. El objetivo es aplicar conceptos de programación orientada a objetos, validaciones de datos, herencia, encapsulamiento, clases selladas, uso de corrutinas y manejo de estados.

Este repositorio sirve como ejemplo de estudio para una prueba o evaluación práctica, porque combina varias ideas clave del lenguaje y del diseño de software en un caso realista y sencillo.

## ¿Qué problema resuelve?

El sistema simula una plataforma de delivery con:

- clientes que se registran e inician sesión
- repartidores que entregan pedidos
- centros de distribución con cupo limitado
- pedidos con estados distintos
- notificaciones asíncronas al cliente

## Objetivos de aprendizaje

Con este proyecto se pueden practicar los siguientes temas:

- clase base y herencia
- validación con `require`
- uso de `sealed class`
- propiedades y encapsulamiento
- listas y conjuntos mutables
- control de intentos de login
- manejo de `Result` para errores
- corrutinas con `delay()`
- modelado de un dominio real

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
├── README.md
└── gradle.properties
```

## Explicación de cada clase

### 1. `Usuario`
Es la clase base del sistema.

Características:

- guarda `nombre`, `correo` y `contrasena`
- valida el formato del nombre, correo y contraseña
- usa `require(...)` para lanzar error si los datos no cumplen reglas
- define el método abstracto `iniciarSesion(...)`

Ejemplo de validaciones:

- nombre: debe tener más de 3 caracteres
- correo: debe cumplir una expresión regular
- contraseña: mínimo 8 caracteres

Esto permite reutilizar lógica en todas las clases derivadas.

### 2. `Cliente`
Hereda de `Usuario`.

Tiene lógica para:

- validar si el nombre y password coinciden
- controlar los intentos fallidos
- devolver un `Result<String>` con éxito o error

La idea de `Result` es muy útil en Kotlin para manejar errores sin lanzar excepciones en flujo normal.

### 3. `Repartidor`
También hereda de `Usuario`.

Incluye:

- validación de login
- lista privada de tiempos de entrega
- método `registrarEntrega()`
- método `obtenerEntregas()`

Esto enseña cómo encapsular datos internos y controlar accesos.

### 4. `CentroDistribucion`
Representa un centro donde se asignan repartidores.

Tiene:

- `codigo` del centro
- `capacidadMaxima`
- conjunto privado de repartidores

También valida que:

- el código no sea vacío
- la capacidad sea mayor que 0
- no se agreguen más repartidores que la capacidad permitida

Usa `MutableSet` para evitar duplicados.

### 5. `Pedido`
Representa un pedido con:

- identificador
- cliente asociado
- repartidor asociado
- dirección
- estado actual

Incluye validaciones como:

- id mayor a 0
- dirección no vacía

Además, define una función asíncrona `notificarClienteAsync()` usando `delay(500L)`, que muestra cómo usar corrutinas para simular tiempo de espera.

### 6. `EstadoPedido`
Se usa `sealed class` para restringir los estados posibles.

Estados implementados:

- `EnCamino`
- `Entregado`
- `Cancelado`

La extensión `esFinalizado` permite saber si un pedido ya terminó.

Esto es útil porque evita estados no válidos y facilita el manejo de decisiones por tipo.

## Flujo principal del programa

En `Main.kt` se crean los objetos principales:

1. se instancia un `CentroDistribucion`
2. se crean varios repartidores
3. se agregan al centro
4. se construye el escenario del sistema

El programa demuestra cómo se conectan las entidades entre sí y cómo se inicializa un caso realista de negocio.

## Conceptos clave que puedes estudiar para una prueba

### Herencia
El proyecto usa jerarquía con `Usuario` como clase base, y `Cliente` y `Repartidor` como subclases.

Pregunta típica:

- ¿Qué ventajas tiene utilizar una clase base?
- ¿Qué métodos o propiedades se reutilizan?

### Validación
Se usan `require` en `init` para asegurar que los datos ingresados son correctos.

Pregunta típica:

- ¿Qué pasa si se intenta crear un objeto con datos inválidos?
- ¿Por qué es importante validar antes de ejecutar la lógica?

### Encapsulamiento
En `Repartidor` y `CentroDistribucion` se usan propiedades privadas para proteger datos internos.

Pregunta típica:

- ¿Por qué conviene mantener listas o conjuntos privados?
- ¿Qué diferencia hay entre `val`, `var` y propiedades privadas?

### Clases selladas
`EstadoPedido` es una `sealed class`, lo cual es ideal para modelar un conjunto finito de estados.

Pregunta típica:

- ¿Por qué es mejor usar una clase sellada en vez de `String` o `Enum` en este caso?

### Corrutinas
Se usa `delay` para simular espera de notificación al cliente.

Pregunta típica:

- ¿Qué beneficio tiene usar corrutinas para tareas asíncronas?

### Manejo de errores
Se devuelve `Result.failure(...)` y `Result.success(...)` para indicar éxito o fracaso de una operación.

Pregunta típica:

- ¿Qué diferencia hay entre lanzar una excepción y devolver un `Result`?

## Ejercicios de práctica recomendados

### Ejercicio 1: agregar más validaciones
Agregar validaciones a:

- nombre no vacío
- correo no vacío
- contraseña con al menos 8 caracteres y al menos un número

### Ejercicio 2: controlar intentos por usuario
Que cada usuario tenga un máximo de intentos y que se bloquee si supera el límite.

### Ejercicio 3: agregar más estados
Incluir nuevos estados como:

- `Preparando`
- `Pendiente`
- `Devuelto`

### Ejercicio 4: calcular promedio de entregas
En `CentroDistribucion` ya existe una idea parecida; puedes ampliarla para que calcule el tiempo promedio de entregas por repartidor.

### Ejercicio 5: crear más objetos
Agregar usuarios reales, clientes, pedidos y centros para ver el sistema funcionando de manera más completa.

## Cómo ejecutar el proyecto

Desde la raíz del repositorio:

```bash
./gradlew run
```

En Windows:

```powershell
./gradlew.bat run
```

## Cómo compilar

```bash
./gradlew build
```

## Cómo ejecutar pruebas

```bash
./gradlew test
```

## Tecnologías usadas

- Kotlin
- Gradle
- Kotlin Coroutines

## Recomendaciones para estudiar este proyecto

1. leer cada archivo por separado
2. identificar qué responsabilidad tiene cada clase
3. dibujar un diagrama de relaciones entre entidades
4. explicar en voz alta cómo funciona el flujo principal
5. practicar creando variantes del proyecto para reforzar conceptos

## Resumen breve

Este proyecto es ideal para practicar la programación orientada a objetos en Kotlin porque combina:

- clases y objetos
- herencia
- validaciones
- encapsulamiento
- colecciones
- estados
- corrutinas
- errores y manejo de resultados

Es una buena base para estudiar antes de una prueba práctica de Kotlin.

## Autor

Proyecto de práctica para reforzar conceptos de programación en Kotlin orientado a sistemas de delivery.
