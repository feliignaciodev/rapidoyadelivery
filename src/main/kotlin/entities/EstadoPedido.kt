package org.example.entities

sealed class EstadoPedido{
    data class EnCamino(val direccion: String, val minutosEstimados : UInt): EstadoPedido()
    data class Entregado(val direccion: String, val tiempoMinutos : UInt): EstadoPedido()
    data class Cancelado(val direccion : String, val motivo : String): EstadoPedido()
}

val EstadoPedido.esFinalizado: Boolean
    get () = when (this) {
        is EstadoPedido.EnCamino -> false
        is EstadoPedido.Entregado -> true
        is EstadoPedido.Cancelado -> true
    }


