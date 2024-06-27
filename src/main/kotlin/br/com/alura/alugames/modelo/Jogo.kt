package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose

data class Jogo (@Expose val titulo: String, @Expose val capa: String): IRecomenda{
    var descricao: String? = null
    var preco: Double = 0.0
    private val listaNotaJogo = mutableListOf<Int>()
    override val media: Double
        get() = listaNotaJogo.average()

    override fun recomendar(nota: Int) {
        listaNotaJogo.add(nota)
    }

    constructor(titulo: String, capa: String, descricao: String, preco: Double): this(titulo, capa) {
        this.descricao = descricao
        this.preco = preco
    }

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa:$capa \n" +
                "Preco:${String.format("%.2f", preco)} \n" +
                "Reputação:${String.format("%.2f", media )} \n" +
                "Descricao:$descricao"
    }
}

