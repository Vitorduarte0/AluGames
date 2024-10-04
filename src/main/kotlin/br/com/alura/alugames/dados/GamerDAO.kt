package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import javax.persistence.EntityManager

class GamerDAO(val manager: EntityManager) {
    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)

        return query.resultList.map { gamerEntity ->
            Gamer(
                gamerEntity.name,
                gamerEntity.email,
                gamerEntity.dataNascimento,
                gamerEntity.usuario,
                gamerEntity.idInterno
            )
        }
    }

    fun adicionaGamer(gamer: Gamer) {
        val gamerEntity = GamerEntity(gamer.name, gamer.email, gamer.dataNascimento, gamer.usuario)
        manager.transaction.begin()
        manager.persist(gamerEntity)
        manager.transaction.commit()
    }
}