import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import br.com.alura.alugames.utils.transformaEmIdade
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Bem vindo ao AluGame...")

    val gamer = Gamer.criarGamer(scanner)

    println(gamer)
    println("Idade do gamer: ${gamer.dataNascimento?.transformaEmIdade()}" )

    do {
        println("Digite um código de jogo para buscar:")
        val leitura = scanner.nextLine()
        val buscaJogo = ConsumoApi().buscaJogoPorId(leitura)
        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(buscaJogo.info.title, buscaJogo.info.thumb)
        }

        resultado.onFailure {
            println("Cara, falhou aqui nessa bomba!!")
        }

        resultado.onSuccess {
            println("Deseja incluir uma descrição personalida? S/N")
            val opcao = scanner.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição do filme: ${meuJogo?.titulo}")
                val descricaoDoUsuario = scanner.nextLine()
                meuJogo?.descricao = descricaoDoUsuario
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }

            gamer.jogosBuscado.add(meuJogo)
        }

        println(meuJogo)

        println("Deseja buscar mais um jogo? S/N")
        val continuaBusca = scanner.nextLine()

    } while (continuaBusca.equals("s", true))

    println("Lista de jogos sem esta ordenada ${gamer.jogosBuscado}")

    println("\n Lista ordenada por titulo: ")
    gamer.jogosBuscado.sortBy {
        it?.titulo
    }
    gamer.jogosBuscado.forEach {
        println(it)
    }
    println("\n lista de jogos filtrado")
    gamer.jogosBuscado.filter { jogo ->
        jogo?.titulo?.contains("the Darkness") ?: false
    }

   println("Deseja remover um item da lista?")
   val opcao = scanner.nextLine()
   if (opcao.equals("s", true)) {
      println("Digite a posicao do item a ser excluido")
      val posicao = scanner.nextInt()
      if (posicao > gamer.jogosBuscado.size) {
         throw IllegalArgumentException("Operacao invalida, pois o numero digita e maior que a quantidade de itens na lista")
      }
      gamer.jogosBuscado.removeAt(posicao)
      println("\n Minha lista apos excluir um item")
      println(gamer.jogosBuscado)

   }
}
