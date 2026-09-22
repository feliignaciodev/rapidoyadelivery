package org.example.entities

class CentroDistribucion (

    val codigo : String,
    val capacidadMaxima : Int
) {

    private val repartidores: MutableSet<Repartidor> = mutableSetOf()

    init {
        require(codigo.isNotBlank()) {
            "El codigo no puede estar vacio"
        }
        require(capacidadMaxima > 0) {
            "La capacidad del centro de distribucion debe ser mayor a 0"
        }
    }

    fun agregarRepartidor(repartidor: Repartidor) {
        require(repartidores.size < capacidadMaxima) {
            "El centro de distribucion esta lleno"
        }

        repartidores.add(repartidor)
    }

    fun obtenerRepartidores(): Set<Repartidor> {
        return repartidores.toSet()
    }

    suspend fun calcularPromedioEntregaCentro(): Double {

        val tiempos = obtenerRepartidores()
            .flatMap { repartidor -> repartidor.obtenerEntregas() }

        return if (tiempos.isEmpty()) {
            0.0
        } else {

            val suma = tiempos.fold(0u) { acumulado, tiempo -> acumulado + tiempo }

            suma.toDouble() / tiempos.size
        }

    }

    //override fun toString(): String {
      //  return "Centro Distribucion codigo: '$codigo', capacidad: $capacidadMaxima, Repartidores Registrados: ${repartidores.size}"
   // }

     override fun toString(): String {
        return "Los repartidores registrados son ${repartidores.toSet()}"
    }
}


