package interfaces;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entidades.Produto;

public interface ICrud<T> { //generic
	void salvar() throws SQLException;
	void delete(int id) throws SQLException;
	void consultar() throws SQLException;
	boolean existeProdutoPorId(int id) throws SQLException;
	void alterar(Produto p, int id) throws SQLException;
}
