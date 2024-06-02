package br.com.alura.alugames.utils

import br.com.alura.alugames.modelo.InfoJogoJson
import br.com.alura.alugames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.descricao, this.preco)
}