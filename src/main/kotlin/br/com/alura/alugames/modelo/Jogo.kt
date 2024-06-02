package br.com.alura.alugames.modelo

data class Jogo (val titulo: String, val capa: String){
    var descricao: String? = null
    var preco: Double = 0.0

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

