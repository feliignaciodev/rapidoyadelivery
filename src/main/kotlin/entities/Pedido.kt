package org.example.entities

import kotlinx.coroutines.delay

class Pedido (

    val id : Int,
    val cliente : Cliente,
    val repartidor: Repartidor,
    val direccion : String,
    var estado : EstadoPedido ) {

    init {
        require(id > 0 ){
            "El identificador del pedido debe ser mayor a 0"
        }
        require(direccion.isNotBlank()){
            "La direccion del pedido no puede estar vacia"
        }
    }

    suspend fun notificarClienteAsync(): String{
        delay(500L)
        return "Notificacion enviada a $cliente con id $id"
    }


}