package org.example.entities

class Cliente (nombre: String, correo: String, contrasena: String) : Usuario(nombre, correo, contrasena){

    val INTENTOS_MAXIMOS = 3

    override fun iniciarSesion(nombreInput: String, contrasenaInput: String): Result<String> {

        val habilitado = super.intentos < INTENTOS_MAXIMOS

        if (!habilitado){
            return Result.failure(IllegalStateException("Acceso de usuario denegado por seguridad"))
        }

        val mismaContrasena = contrasenaInput == super.contrasena
        val mismoNombre = nombreInput.lowercase() == super.nombre

            return if(mismaContrasena && mismoNombre){
                super.intentos = 0
                Result.success("Bienvenido cliente $nombre!")
            } else {
                super.intentos += 0
                Result.failure(IllegalArgumentException("Credenciales de cliente incorrectas. Intentos fallidos: ${super.intentos}"))

            }


    }


}