package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.*
import br.com.alura.alugames.utils.HttpRequestUteis
import br.com.alura.alugames.utils.criaGame
import br.com.alura.alugames.utils.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConsumoApi {

    fun buscaJogoPorId(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = HttpRequestUteis().httpGet(endereco)
        val gson = Gson()
        return gson.fromJson(json, InfoJogo::class.java)
    }

    fun buscaJogos(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = HttpRequestUteis().httpGet(endereco)

        val gson = Gson()
        val jogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type

        val listaDejogos: List<InfoJogoJson> = gson.fromJson(json, jogoTipo)

        val listaDeJogosConvertidas = listaDejogos.map { infoJogoJson ->
            infoJogoJson.criaJogo()
        }

        return listaDeJogosConvertidas
    }

    fun buscaGamers(): List<Gamer> {
        val endero = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = HttpRequestUteis().httpGet(endero)
        val gson = Gson()

        val gamerTipo =  object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, gamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson ->
            infoGamerJson.criaGame()
        }

        return listaGamerConvertida
    }

}