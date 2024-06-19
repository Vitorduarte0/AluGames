package br.com.alura.alugames.modelo

import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var name: String, var email: String
): IRecomenda{
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

    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscado = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota in 1 .. 10) {
            listaNotas.add(nota)
        } else {
            throw RuntimeException("Nota inválida! Por favor preencha uma nota entre 1 a 10")
        }
    }

    constructor(name: String, email: String, dataNascimento: String, usuario: String, idInterno: String? = null) :
            this(name, email) {
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                createIdInterno()
            }

    override fun toString(): String {
        return "Gamer(name='$name', " +
                " email='$email', " +
                " dataNascimento=$dataNascimento, " +
                " usuario=$usuario, " +
                "idInterno=$idInterno), " +
                "media=$media"
    }

    private fun createIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        this.idInterno = "$usuario#$tag"

    }

     fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
         val aluguel = Aluguel(this, jogo, periodo)
         jogosAlugados.add(aluguel)

         return aluguel
    }

    fun jogosAlugadosPorMes(mes: Int): List<Aluguel> {
        val listasAlugadas = jogosAlugados.filter { aluguel ->
            aluguel.periodo.dataInicial.monthValue == mes
        }

        return listasAlugadas
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
