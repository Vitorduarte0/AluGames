package br.com.alura.alugames.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valor = jogo.preco * periodo.emDias
    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.name} pelo o valor $valor)"
    }
}

