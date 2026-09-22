package org.example

import org.example.entities.HolaMundo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.entities.CentroDistribucion
import org.example.entities.Repartidor


fun main(): Unit = runBlocking {

    val centroDistribucion1 = CentroDistribucion("centro-001", 4)

    println("Se ha creado el  $centroDistribucion1")

    //esto es un separador


    val repartidor1 = Repartidor("Felipe", "felipe@gmail.com", "felipe123")
    val repartidor2 = Repartidor("Carlos", "carlos@gmail.com", "carlos12345")
    val repartidor3 = Repartidor("Jose", "jose@gmail.com", "jose123456")
    val repartidor4 = Repartidor("Esteban", "esteban@gmail.com", "esteban123")

    centroDistribucion1.agregarRepartidor(repartidor1)
    centroDistribucion1.agregarRepartidor(repartidor2)
    centroDistribucion1.agregarRepartidor(repartidor3)
    centroDistribucion1.agregarRepartidor(repartidor4)

    println("Estos son los repartidores ")
    //esto es un









}