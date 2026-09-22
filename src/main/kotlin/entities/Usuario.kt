package org.example.entities


abstract class Usuario (nombreInput: String, correoInput: String, contrasenaInput: String){

    companion object {
        val IS_EMAIL = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    }

    val nombre: String
    val correo: String
    val contrasena: String
    var intentos: Int = 0

    init {
        require(nombreInput.length > 3){"El nombre de usuario debe tener mas de 3 caracteres."}
        this.nombre = nombreInput.lowercase()

        require(correoInput.matches(IS_EMAIL)){"El formato del correo es incorrecto"}
        this.correo = correoInput.lowercase()

        require(contrasenaInput.length >= 8){"La contrasena debe tener minimo 8 caracteres."}
        this.contrasena = contrasenaInput
    }

    abstract fun iniciarSesion(nombreInput: String, contrasenaInput: String): Result<String>

}