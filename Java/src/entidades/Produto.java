package entidades;

public class Produto {
	private int id;
	private String descricao;
	private float preco;
	private float estoque;
	
	public Produto() {}

	public Produto(int id, String descricao, float preco, int estoque) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public Produto(int id, String descricao, float preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + descricao + ", preco=" + preco + ", estoque=" + estoque + "]";
	}
	
	
}
