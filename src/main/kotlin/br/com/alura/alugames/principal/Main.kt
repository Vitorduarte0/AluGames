import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import java.util.Scanner

fun main() {
   val scanner = Scanner(System.`in`)
   println("Digite um código de jogo para buscar:")
   val busca = scanner.nextLine()

   val buscaJogo = ConsumoApi().buscaJogoPorId(busca)

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
  }
   println(meuJogo)

}
