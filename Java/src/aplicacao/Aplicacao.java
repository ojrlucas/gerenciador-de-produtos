package aplicacao;
import java.sql.SQLException;
import java.util.Scanner;

import daos.DaoProduto;
import entidades.Produto;

public class Aplicacao {
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);    
	    Produto p = new Produto();
	    DaoProduto dao = new DaoProduto();
	    
	    System.out.println("--- Gerenciador de Produtos ---");
	    System.out.println();

	    while (true) {
	        try {
	            System.out.println("1 - Consultar | 2 - Adicionar | 3 - Alterar | 4 - Remover | 0 - Sair");
	            System.out.print("Informe a opção: ");
	            int opcao = sc.nextInt();
	            sc.nextLine();

	            switch (opcao) {
	                case 1:
	                    dao.consultar();
	                    break;
	                case 2:
	                    inserirProdutos(sc, dao);
	                    break;
	                case 3:
	                    alterarProdutos(sc, p, dao);
	                    break;
	                case 4:
	                    removerProdutos(sc, dao);
	                    break;
	                case 0:
	                    System.out.println("Saindo...");
	                    sc.close();
	                    return;
	                default:
	                    System.out.println("--> Opção informada é inválida\n");
	            }
	        } catch (Exception e) {
	            System.out.println("Erro: " + e.getMessage());
	            sc.nextLine(); 
	            System.out.println();
	        }
	    }
	}

	public static void inserirProdutos(Scanner sc, DaoProduto dao) {
		try {
			System.out.println();
			System.out.print("Quantos produtos você deseja guardar? ");
			int n = sc.nextInt();
			
			for (int i = 1; i <= n; i++) {
				Produto p = new Produto();
				
				System.out.println();
				System.out.println("Produto #" + i);
				
				System.out.print("Nome: ");
				sc.nextLine();
				p.setDescricao(sc.nextLine());
				System.out.print("Preço: ");
				p.setPreco(sc.nextFloat());
				System.out.print("Estoque: ");
				p.setEstoque(sc.nextInt());
				DaoProduto.listaProdutos.add(p);
			}
			
				dao.salvar();
				return;
			} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void removerProdutos(Scanner sc, DaoProduto dao) throws SQLException {
		try {
			dao.consultar();
			
			System.out.print("Qual o id do produto que deseja remover? ");
			int id = sc.nextInt();
			
			if (!dao.existeProdutoPorId(id)) {
				System.out.println();
				System.out.println("--> Produto não encontrado");
				System.out.println();
				return;
			}
			
			dao.delete(id);	
			System.out.println();
			return;
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void alterarProdutos(Scanner sc, Produto p, DaoProduto dao) throws SQLException {
		try {
			System.out.println();
			dao.consultar();
			System.out.println();
			
			System.out.print("Qual o id do produto que deseja alterar? ");
			int id = sc.nextInt();
			
			if (!dao.existeProdutoPorId(id)) {
				System.out.println("--> Produto não encontrado");
				System.out.println();
				return;
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			p.setDescricao(sc.nextLine());
			System.out.print("Preço: ");
			p.setPreco(sc.nextFloat());
			System.out.print("Estoque: ");
			p.setEstoque(sc.nextInt());
			
			dao.alterar(p, id);
			return;
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
