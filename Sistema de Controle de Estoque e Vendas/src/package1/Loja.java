package package1;
import java.util.Scanner;
public class Loja {
	private static Scanner sc;
	public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
		int i,j,k,opcao,codigo,quant,quant1,cont1=0,qntProdutos=0,qntClientes=0,qntVendas=0; 
		String nome,data,nome1,condicaoSaida;
		Produto[] produtos = new Produto[50];
		Cliente[] clientes = new Cliente[50];
		Venda[] vendas = new Venda[50];
		do {
			System.out.println("*****O que deseja fazer? Digite o numero correspondente a opcao.*****");
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
				System.out.println("Cadastrando cliente.");
				System.out.print("Codigo: ");
				codigo=sc.nextInt();
				System.out.print("Nome: ");
				nome=sc.next();
				Cliente cliente = new Cliente(codigo,nome);
				clientes[qntClientes] = cliente;
				qntClientes++;
			}
			
			else if(opcao == 2) 
			{
				System.out.println("Cadastrando Produto.");
				System.out.print("Codigo: ");
				codigo=sc.nextInt();
				System.out.print("Nome: ");
				nome=sc.next();
				System.out.print("Quantidade em estoque: ");
				quant=sc.nextInt();
				System.out.print("Preco: ");
				Produto produto = new Produto(codigo,nome,quant,sc.nextDouble());
				produtos[qntProdutos] = produto;
				qntProdutos++;
			}
			
			else if(opcao == 3) 
			{
				System.out.println("Realizando venda.");
				System.out.print("Codigo: ");
				codigo=sc.nextInt();
				System.out.print("Nome do cliente: ");
				nome=sc.next();
				System.out.print("Data da venda: ");
				data=sc.next();
				System.out.print("Quantidade de produtos diferentes: ");
				quant=sc.nextInt();
				Item[] itens = new Item[quant];
				cont1 = 0;
				for(i=0;i<quant;i++) 
				{
					System.out.print("Nome do produto "+i+": ");
					nome1=sc.next();
					System.out.print("Quantidade: ");
					quant1=sc.nextInt();
					for(j=0;j<qntProdutos;j++) 
					{
						if(nome1.equalsIgnoreCase(produtos[j].getNome())) 
						{
							produtos[j].vender(quant1);
							itens[cont1] = new Item(produtos[j].getCodigo(),nome1,produtos[j].getQntEmEstoque(),produtos[j].getPreco(),quant1);
							cont1++;
							break;
						}
					}
				}
				for(i=0;i<qntClientes;i++) 
				{
					if(nome.equalsIgnoreCase(clientes[i].getNome())) 
					{
						Venda venda = new Venda(codigo,clientes[i],data,itens,quant);
						clientes[i].Comprar(venda);
						vendas[qntVendas] = venda;
						qntVendas++;
						break;
					}
				}
			}
			
			else if(opcao == 4) 
			{
				System.out.println("Aumentando estoque de um produto.");
				System.out.println("Nome do produto: ");
				nome = sc.next();
				System.out.println("Quantidade adicionada: ");
				quant = sc.nextInt();
				for(j=0;j<qntProdutos;j++) 
				{
					if(nome.equalsIgnoreCase(produtos[j].getNome())) 
					{
						produtos[j].qntEmEstoque += quant;
						break;
					}
				}
			}
			
			else if(opcao == 5) 
			{
				System.out.println("Lista de clientes: ");
				for(i=0;i<qntClientes;i++) 
				{
					System.out.print("\t"+clientes[i].getNome());
					System.out.println("--> Quantidade de compras: "+clientes[i].getQntCompras());
				}
			}
			
			else if(opcao == 6) 
			{
				System.out.println("Lista de produtos: ");
				for(i=0;i<qntProdutos;i++) 
				{
					System.out.print("\t"+produtos[i].getNome());
					System.out.println("--> Codigo: "+produtos[i].getCodigo()+". Quantidade em estoque: "+produtos[i].getQntEmEstoque()+". Preco: "+produtos[i].getPreco());
				}
			}
			
			else if(opcao == 7) 
			{
				System.out.println("Lista de produtos em estoque: ");
				for(i=0;i<qntProdutos;i++) 
				{
					if(produtos[i].getQntEmEstoque() > 0) 
					{
						System.out.print("\t"+produtos[i].getNome());
						System.out.println("--> Codigo: "+produtos[i].getCodigo()+". Quantidade em estoque: "+produtos[i].getQntEmEstoque()+". Preco: "+produtos[i].getPreco());
					}
				}
			}
			else if (opcao == 8) 
			{
				System.out.println("Lista de produtos esgotados: ");
				for(i=0;i<qntProdutos;i++) 
				{
					if(produtos[i].getQntEmEstoque() < 1) 
					{
						System.out.print("\t"+produtos[i].getNome());
						System.out.println("--> Codigo: "+produtos[i].getCodigo()+". Quantidade em estoque: (Esgotado). Preco: "+produtos[i].getPreco());
					}
				}
			}
			else if (opcao == 9) 
			{
				System.out.println("Quantidade de vendas realizadas: "+qntVendas);
				System.out.println("Lista de vendas realizadas: ");
				for(i=0;i<qntVendas;i++) 
				{
					Item[] itensAux = vendas[i].getItens();
					System.out.println("Venda de Codigo "+vendas[i].getCodigo());
					System.out.println("\tComprador: "+vendas[i].getComprador().getNome());
					System.out.println("\tData: "+vendas[i].getData());
					System.out.println("\tProdutos vendidos: ");
					for(j=0;j<vendas[i].getQntProdutosDiferentes();j++) 
					{
						System.out.print("\t\t"+itensAux[j].getNome());
						System.out.print("-> quantidade: ");
						System.out.println(itensAux[j].getQntVendida());
					}
				}
			}
			else if (opcao == 10) 
			{
				System.out.print("Nome do cliente: ");
				nome = sc.next();
				for(i=0;i<qntClientes;i++) 
				{
					if(nome.equalsIgnoreCase(clientes[i].getNome())) 
					{
						System.out.println("Numero de compras:"+clientes[i].getQntCompras());
						System.out.println("Lista de compras: ");
						for(j=0;j<clientes[i].getQntCompras();j++) 
						{
							System.out.println("Compra de codigo: "+clientes[i].getCompras()[j].getCodigo());
							System.out.println("\tData:"+clientes[i].getCompras()[j].getData());
							System.out.println("\tProdutos:");
							for(k=0;k<clientes[i].getCompras()[j].getQntProdutosDiferentes();k++) 
							{
								System.out.print("\t\t"+clientes[i].getCompras()[j].getItens()[k].getNome());
								System.out.println("--> quantidade:"+clientes[i].getCompras()[j].getItens()[k].getQntVendida());
							}
						}
					}
				}
			}
			System.out.println("Deseja Continuar?");
			condicaoSaida = sc.next();
		} while(!("sair".equalsIgnoreCase(condicaoSaida)) && !("nao".equalsIgnoreCase(condicaoSaida)) && !("não".equalsIgnoreCase(condicaoSaida)));
	}
	
	public void listarProdutosEmEstoque() {
		
	}
	public void listarProdutosEsgotados() {
		
	}
	public void listarVendas() {
		
	}
	public void listarVendasCliente(Cliente cliente) {
		
	}
}
