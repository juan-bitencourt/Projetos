package estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Comandos {
	
// essa classe foi criada inicialmente com os comandos do CRUD
// por�m eu vi que n�o tinha necessidade e mantive apenas o a List que seleciona a tabela inteira
// cada comando j� est� dentro de sua respectiva GUI

	public List<Categorias> ver() {
		
		Connection con = Conexao.getConnection();
		String sql = "SELECT * FROM PRODUTOS";
		// lista para armazenar os dados que ser�o recebidos do BD
		List<Categorias> results = new ArrayList<Categorias>();
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// o rs retorna todos os dados de 1 linha, o .next leva para a pr�xima linha
			// por isso o uso do while, quando n�o tiver mais a pr�xima linha, acaba
			while(rs.next()) {
			// objeto categoria para manipular as v�riaveis que est�o na classe Categorias	
			Categorias categoria = new Categorias();
			// setter usados para dar o valor retornado do banco de dados para as v�riaveis
			categoria.setId(rs.getInt("id"));
			categoria.setSetor(rs.getString("setor"));
			categoria.setModelo(rs.getString("modelo"));
			categoria.setTamanho(rs.getString("tamanho"));
			categoria.setCor(rs.getString("cor"));
			categoria.setPreco(rs.getFloat("preco"));
			categoria.setEstoque(rs.getInt("estoque"));
			// adiciona cada linha na arraylist results
			results.add(categoria);
			
			 }
			con.close();
			st.close();
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return results; 
		
		
		
		}
				
	}

