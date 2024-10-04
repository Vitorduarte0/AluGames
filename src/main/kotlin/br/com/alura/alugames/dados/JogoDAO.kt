package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogoDAO(val manager: EntityManager) {
    fun getJogos(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { jogoEntity ->
            Jogo(jogoEntity.titulo, jogoEntity.capa, jogoEntity.descricao, jogoEntity.preco, jogoEntity.id)
        }
    }

    fun adicionaJogo(jogo: Jogo) {
        val entity = JogoEntity(jogo.titulo, jogo.capa, jogo.descricao, jogo.preco)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}