package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String url = "jdbc:mysql://localhost:3306/db_conexao";
	private static final String usuario = "root";
	private static final String senha = "Sandra22@";
	
	public static Connection getConexao() throws SQLException {
		try {
			return DriverManager.getConnection(url, usuario, senha);
		}
		catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
