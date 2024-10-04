package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "gamer")
class GamerEntity(
    val name: String = "",
    val email: String = "",
    val dataNascimento: String? = null,
    val usuario: String? = null,
    val idInterno: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {
}