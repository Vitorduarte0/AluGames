package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.InfoJogo
import br.com.alura.alugames.utils.HttpRequestUteis
import com.google.gson.Gson

class ConsumoApi {
        fun buscaJogoPorId(id: String):InfoJogo {
            val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
            val response = HttpRequestUteis().httpGet(endereco)
            val json = response.body()
            val gson = Gson()
            return gson.fromJson(json, InfoJogo::class.java)
    }

}