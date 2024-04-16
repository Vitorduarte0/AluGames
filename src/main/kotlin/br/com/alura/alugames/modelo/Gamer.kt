package br.com.alura.alugames.modelo

import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var name: String, var email: String
){
    var dataNascimento: String? = null
        set(value) {
            field = value
        }
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                createIdInterno()
            }

        }
    var idInterno: String? = null
        get

    val jogosBuscado = mutableListOf<Jogo?>()
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

    fun validaEmail(): String {
        val regex = Regex(
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
        )

        if (!regex.matches(email)) {
            return throw IllegalArgumentException("Email invalido")
        }else {
            return email
        }
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Nome invalidooo!")
        }
        validaEmail()
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Aeeeee, boas vindas ao AluGames! Vamos fazer seu cadastro \n")
            println("Insira o nome:")
            val nome = leitura.nextLine()
            println("Insira o email:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a data de nascimento (DD/MM/AAAA): ")
                val dataNascimento = leitura.nextLine()
                println("Insira o nome do seu usuario: ")
                val usuario = leitura.nextLine()
                return Gamer(nome, email, dataNascimento, usuario)
            }else {
                return Gamer(nome, email)
            }
        }
    }
}