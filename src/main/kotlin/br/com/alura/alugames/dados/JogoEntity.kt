package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity (
    val titulo: String = "bla",
    val capa: String = "bla",
    val descricao: String? = null,
    val preco: Double = 2.4,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
){
}