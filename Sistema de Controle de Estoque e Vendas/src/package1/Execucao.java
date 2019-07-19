package package1;

import java.util.Scanner;

public class Execucao {

	private static Scanner sc;
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		Loja loja = new Loja();
		loja.ProdutosClientesEVendasPreCadastrados();
		int opcao;
		do {
			System.out.println("\n*****O que deseja fazer? Digite o numero correspondente a opcao.*******");
			System.out.println("0. Sair da Loja.");
			System.out.println("1.Cadastrar cliente.");
			System.out.println("2.Cadastrar produto.");
			System.out.println("3.Realizar venda.");
			System.out.println("4.Aumentar estoque de um produto.");
			System.out.println("5.Listar clientes cadastrados.");
			System.out.println("6.Listar produtos cadastrados.");
			System.out.println("7.Listar produtos em estoque.");
			System.out.println("8.Listar produtos esgotados.");
			System.out.println("9.Listar vendas realizadas.");
			System.out.println("10.Listar compras realizadas por um cliente.");
			System.out.println("**********************************************************************");
			opcao=sc.nextInt();
			
			if(opcao == 1) 
			{
				loja.cadastrarCliente();
			}
			
			else if(opcao == 2) 
			{
				loja.cadastrarProduto();
			}
			
			else if(opcao == 3) 
			{
				loja.realizarVenda();
			}
			
			else if(opcao == 4) 
			{
				loja.aumentarQuantidadeEmEstoque();
			}
			
			else if(opcao == 5) 
			{
				loja.listarClientes();
			}
			
			else if(opcao == 6) 
			{
				loja.listarProdutos();
			}
			
			else if(opcao == 7) 
			{
				loja.listarProdutosEmEstoque();
			}
			else if (opcao == 8) 
			{
				loja.listarProdutosEsgotados();
			}
			else if (opcao == 9) 
			{
				loja.listarVendas();
			}
			else if (opcao == 10) 
			{
				loja.listarVendasCliente();
			}
			else if (opcao == 0) 
			{
				System.out.println(">Loja Encerrada<");
				System.exit(0);
			}
			System.out.println("\n>Digite qualquer coisa para continuar.<");
			sc.next();
		} while(true);
	}
}

//while(!("sair".equalsIgnoreCase(condicaoSaida)) && !("nao".equalsIgnoreCase(condicaoSaida)) && !("não".equalsIgnoreCase(condicaoSaida)));