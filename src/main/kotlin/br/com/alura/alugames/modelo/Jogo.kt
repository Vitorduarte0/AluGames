package br.com.alura.alugames.modelo

data class Jogo (val titulo: String, val capa: String): IRecomenda{
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
                "Preco:$preco \n" +
                "Descricao:$descricao"
    }
}

