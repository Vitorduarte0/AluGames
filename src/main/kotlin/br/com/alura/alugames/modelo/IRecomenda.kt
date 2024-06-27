package br.com.alura.alugames.modelo

import java.math.BigDecimal

interface IRecomenda {
    val media: BigDecimal

    fun recomendar(nota: Int)}