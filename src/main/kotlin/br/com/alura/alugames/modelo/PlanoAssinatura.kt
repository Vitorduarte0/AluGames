package br.com.alura.alugames.modelo

class PlanoAssinatura (
    tipoPlano: String,
    val mensalidade: Double,
    val quantidadeDeJogosIncluidos: Int
): Plano(tipoPlano) {
    override fun obterValor(aluguel: Aluguel): Double {
        val jogosAlugadosPorMes = aluguel.gamer.jogosAlugadosPorMes(6).size+1
        return if (jogosAlugadosPorMes <= quantidadeDeJogosIncluidos) {
            0.0
        }else {
            super.obterValor(aluguel)
        }
    }
}