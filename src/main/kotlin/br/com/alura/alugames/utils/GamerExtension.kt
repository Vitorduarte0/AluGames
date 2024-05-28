package br.com.alura.alugames.utils

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGame(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}