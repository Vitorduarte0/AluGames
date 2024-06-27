package br.com.alura.alugames.modelo

class PlanoAssinatura (
    tipoPlano: String,
    val mensalidade: Double,
    val quantidadeDeJogosIncluidos: Int,
    val percentualDesconto: Double
): Plano(tipoPlano) {
    override fun obterValor(aluguel: Aluguel): Double {
        val jogosAlugadosPorMes = aluguel.gamer.jogosAlugadosPorMes(6).size+1
        return if (jogosAlugadosPorMes <= quantidadeDeJogosIncluidos) {
            0.0
        }else {
            var valorOrigial = super.obterValor(aluguel)
            if(aluguel.gamer.media.intValueExact() > 8) {
                valorOrigial -= valorOrigial * 0.15
            }

            valorOrigial
        }
    }
}