package daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Produto;
import interfaces.ICrud;
import util.Conexao; 

public class DaoProduto implements ICrud<Produto>{
	private Connection con;
	
	public static List<Produto> listaProdutos = new ArrayList<>();
	
	@Override
	public void salvar() throws SQLException {
		try {
			con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement("INSERT INTO tb_produtos (descricao, preco, estoque) VALUES (?,?,?)");
			
			for (Produto produto : listaProdutos) {
		        stm.setString(1, produto.getDescricao());
		        stm.setFloat(2, produto.getPreco());
		        stm.setFloat(3, produto.getEstoque());
		        stm.execute();
			}
			
			listaProdutos.clear();
			System.out.println("--> Produtos inseridos com sucesso!");
			System.out.println();
		}
		catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}	
	}
	
	@Override
	public void delete(int id) throws SQLException {
		try {	
			con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement("DELETE FROM tb_produtos WHERE id = " + id);
		    stm.execute();
		    
			System.out.println("--> Produto removido com sucesso!");		
		}
		catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	public void resetarLista() throws SQLException {
		try {	
			con = Conexao.getConexao();
			PreparedStatement checkStm = con.prepareStatement("SELECT COUNT(*) FROM tb_produtos");
	        ResultSet rs = checkStm.executeQuery();
	        rs.next();

	        if (rs.getInt(1) == 0) {
	            System.out.println();
	            System.out.println("--> A lista já está vazia. Nada foi removido.");
	            System.out.println();
	            return;
	        }			
			
			PreparedStatement stm = con.prepareStatement("DELETE FROM tb_produtos");
		    stm.execute();
		    
			System.out.println();
			System.out.println("--> Lista resetada com sucesso!");	
			System.out.println();
		}
		catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	@Override
	public void alterar(Produto p, int id) throws SQLException {
		try {
			con = Conexao.getConexao();
			PreparedStatement stm = con.prepareStatement("UPDATE tb_produtos SET descricao = ?, preco = ?, estoque = ? WHERE id = " + id);
	        stm.setString(1, p.getDescricao());
	        stm.setFloat(2, p.getPreco());
	        stm.setFloat(3, p.getEstoque());
	        stm.execute();
			
	        System.out.println("--> Produto alterado com sucesso!");
			System.out.println();
		}
		catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	@Override
	public void consultar() throws SQLException {
	    try {
			System.out.println();
	        con = Conexao.getConexao();
	        String sql = "SELECT * FROM tb_produtos";
	        PreparedStatement stm = con.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();

	        boolean temResultados = false;

	        while (rs.next()) {
	            temResultados = true;
	            System.out.println("id: " + rs.getInt(1)
	                + " | Descricao: " + rs.getString(2)
	                + " | Preco: " + rs.getFloat(3)
	                + " | Estoque: " + rs.getFloat(4));
	        }

	        if (!temResultados) {
	            System.out.println("--> Lista vazia");
	        }
			System.out.println();
	    } 
	    catch (SQLException e) {
	        throw new SQLException(e.getMessage());
	    }
	}
	
	@Override
	public boolean existeProdutoPorId(int id) throws SQLException {
	    try {
	        con = Conexao.getConexao();
	        String sql = "SELECT * FROM tb_produtos WHERE id = " + id;
	        PreparedStatement stm = con.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();

	        if (rs.next()) {
	            return true;
	        } else {
	            return false;
	        }
	    } catch (SQLException e) {
	        throw new SQLException(e.getMessage());
	    }
	}
}