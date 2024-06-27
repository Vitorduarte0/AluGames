package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo

class JogoDAO {
    fun getJogos(): List<Jogo> {
        val querySql = "SELECT * FROM JOGOS"
        val jogos = mutableListOf<Jogo>()

        val conexao = Banco.obterConexao() //Criando a conexao com o banco

        if (conexao != null) {
            try {
                val statement = conexao.createStatement() //criando um statement para realizar uma operacao de banco
                val resultado = statement.executeQuery(querySql) // realizando a operacao do statament q é execultar query, navegando na linha

                while (resultado.next()) {
                    val id = resultado.getInt(1)
                    val capa = resultado.getString(2)
                    val descricao = resultado.getString(3)
                    val preco = resultado.getDouble(4)
                    val titulo = resultado.getString(5)

                    val jogo = Jogo(titulo, capa, descricao, preco, id)
                    jogos.add(jogo)
                }

                statement.close()
            }finally {
                conexao.close()
            }
        }


        return jogos
    }

    fun adicionaJogo(jogo: Jogo) {
        val conexao = Banco.obterConexao()
        val insertSQl = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"

        if (conexao != null) {
            try {
                val prepareStatament = conexao.prepareStatement(insertSQl)
                prepareStatament.setString(1, jogo.titulo)
                prepareStatament.setString(2, jogo.capa)
                prepareStatament.setDouble(3, jogo.preco)
                prepareStatament.setString(4, jogo.descricao)

                prepareStatament.executeUpdate()
                prepareStatament.close()
            }finally {
                conexao.close()
            }
        }
    }
}