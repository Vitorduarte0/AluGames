package br.com.alura.alugames.modelo

class PlanoAvulso(tipoDoPlano: String): Plano(tipoDoPlano) {
    override fun obterValor(aluguel: Aluguel): Double {
        return super.obterValor(aluguel)
    }
}
