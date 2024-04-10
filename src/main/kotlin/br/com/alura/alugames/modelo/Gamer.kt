package br.com.alura.alugames.modelo

import kotlin.random.Random

data class Gamer(
    var name: String, var email: String
){
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                createIdInterno()
            }

        }
    var idInterno: String? = null
        get

    constructor(name: String, email: String, dataNascimento: String, usuario: String, idInterno: String? = null) :
            this(name, email) {
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                createIdInterno()
            }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    private fun createIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        this.idInterno = "$usuario#$tag"

    }

}
