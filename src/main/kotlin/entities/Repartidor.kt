package org.example.entities

class Repartidor (nombre: String, correo: String, contrasena: String): Usuario(nombre, correo, contrasena) {

    private val INTENTOS_MAXIMOS = 1

    override fun iniciarSesion(nombreInput: String, contrasenaInput: String): Result<String> {

        val  habilitado = super.intentos < INTENTOS_MAXIMOS

        if (!habilitado) {
            return Result.failure(IllegalStateException("Acceso de repartidor bloqueado por seguridad"))
        }

        val mismaContrasena = contrasenaInput == super.contrasena
        val mismoNombre = nombreInput.lowercase() == super.nombre

            return if (mismaContrasena && mismoNombre) {
                super.intentos = 0
                Result.success("Bienvenido Repartidor $nombre!")
            } else {
                super.intentos +=1
                Result.failure(IllegalArgumentException("Credenciales de Repartidor incorrectas. Intentos fallidos: ${super.intentos}"))
            }

    }


    private val entregas: MutableList<UInt> = mutableListOf()
    private val TIEMPO_MAXIMO_ENTREGA: UInt = 180u

    fun registrarEntrega(tiempoMinutos : UInt){

        require (tiempoMinutos > 0u && tiempoMinutos <= TIEMPO_MAXIMO_ENTREGA){
            "El tiempo de la entrega debe ser mayor a cero y no superar los $TIEMPO_MAXIMO_ENTREGA minutos"}

        entregas.add(tiempoMinutos)
    }

    fun obtenerEntregas(): List<UInt>{
        return entregas.toList()
    }





}