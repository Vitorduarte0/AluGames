package br.com.alura.alugames.modelo

class PlanoAvulso(tipoDoPlano: String): Plano(tipoDoPlano) {
    override fun obterValor(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValor(aluguel)

        if(aluguel.gamer.media.intValueExact() > 8) {
            valorOriginal -= valorOriginal * 0.1
        }

        return valorOriginal
    }
}
