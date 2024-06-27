package br.com.alura.alugames.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valor = gamer.plano.obterValor(this)
    var id = 0
    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.name} pelo o valor $valor)"
    }
}


