package br.com.alura.alugames.modelo

class PlanoAssinatura (
    tipoPlano: String,
    val mensalidade: Double,
    val quantidadeDeJogosIncluidos: Int,
    val jogosIncluidos: Int,
    val percentualDesconto: Double = 0.15,
    id: Int = 0
): Plano(tipoPlano) {
    override fun obterValor(aluguel: Aluguel): Double {
        val jogosAlugadosPorMes = aluguel.gamer.jogosAlugadosPorMes(6).size+1
        return if (jogosAlugadosPorMes <= quantidadeDeJogosIncluidos) {
            0.0
        }else {
            var valorOrigial = super.obterValor(aluguel)
            if(aluguel.gamer.media > 8) {
                valorOrigial -= valorOrigial * percentualDesconto
            }

            valorOrigial
        }
    }
    override fun toString(): String {
        return "Plano Assinatura\n" +
                "Tipo: $tipo\n" +
                "Id: $id\n" +
                "Mensalidade: $mensalidade\n" +
                "Jogos Incluidos: $jogosIncluidos\n" +
                "Percentual Desconto Reputacao: $percentualDesconto\n"
    }
}