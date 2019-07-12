package package1;
import java.util.Scanner;
public class Loja {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int i,j,opcao,codigo,quant,quant1,cont1=0,qntProdutos=0,qntClientes=0,qntVendas=0; 
		String nome,data,nome1;
		Produto[] produtos = new Produto[50];
		Cliente[] clientes = new Cliente[50];
		Venda[] vendas = new Venda[50];
		do {
			System.out.println("O que deseja fazer?");
			System.out.println("1.Cadastrar cliente.");
			System.out.println("2.Cadastrar produto.");
			System.out.println("3.Realizar venda.");
			System.out.println("4.Aumentar estoque de um produto.");
			System.out.println("5.Listar clientes cadastrados.");
			System.out.println("6.Listar produtos cadastrados.");
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
				for(i=0;i<quant;i++) {
					System.out.print("Nome do produto "+i+": ");
					nome1=sc.next();
					System.out.print("Quantidade: ");
					quant1=sc.nextInt();
					for(j=0;j<qntProdutos;j++) {
						if(nome1.equalsIgnoreCase(produtos[j].getNome())) {
							produtos[j].vender(quant1);
							itens[cont1] = new Item(produtos[j].getCodigo(),nome1,produtos[j].getQntEmEstoque(),produtos[j].getPreco(),quant1);
							cont1++;
							break;
						}
					}
				}
				for(i=0;i<qntClientes;i++) {
					if(nome.equalsIgnoreCase(clientes[i].getNome())) {
						Venda venda = new Venda(codigo,clientes[i],data,itens);
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
				for(j=0;j<qntProdutos;j++) {
					if(nome.equalsIgnoreCase(produtos[j].getNome())) {
						produtos[j].qntEmEstoque += quant;
						break;
					}
				}
			}
			
			else if(opcao == 5) 
			{
				System.out.println("Lista de clientes: ");
				for(i=0;i<qntClientes;i++) {
					System.out.print(clientes[i].getNome());
					System.out.println(". Quantidade de compras: "+clientes[i].getQntCompras());
				}
			}
			
			else if(opcao == 6) 
			{
				System.out.println("Lista de produtos: ");
				for(i=0;i<qntProdutos;i++) {
					System.out.print(produtos[i].getNome());
					System.out.println("Codigo: "+produtos[i].getCodigo()+". Quantidade em estoque: "+produtos[i].getQntEmEstoque()+". Preco: "+produtos[i].getPreco());
				}
			}
			
		} while(!("sair".equalsIgnoreCase(sc.next())));
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
