package package1;
import java.util.Scanner;
public class Loja {
	
	private static Scanner sc;
	private int qntClientes,qntProdutos, qntVendas;
	Produto[] produtos = new Produto[500];
	Cliente[] clientes = new Cliente[500];
	Venda[] vendas = new Venda[500];
	
	public void ProdutosClientesEVendasPreCadastrados() {
		Cliente cliente1 = new Cliente(447,"Bob");
		clientes[qntClientes] = cliente1;
		qntClientes++;
		Cliente cliente2 = new Cliente(557,"Ana");
		clientes[qntClientes] = cliente2;
		qntClientes++;
		Produto produto1 = new Produto(91,"Leite",15,4.5);
		produtos[qntProdutos] = produto1;
		qntProdutos++;
		Produto produto2 = new Produto(92,"Pao",30,1);
		produtos[qntProdutos] = produto2;
		qntProdutos++;
		Produto produto3 = new Produto(93,"Manteiga",0,4.2);
		produtos[qntProdutos] = produto3;
		qntProdutos++;
		Item[] itens = new Item[2];
		produtos[0].vender(3);
		itens[0] = new Item(produtos[0].getCodigo(),"Leite",produtos[0].getQntEmEstoque(),produtos[0].getPreco(),3);
		produtos[1].vender(6);
		itens[1] = new Item(produtos[1].getCodigo(),"Pao",produtos[1].getQntEmEstoque(),produtos[1].getPreco(),6);
		Venda venda1 = new Venda(741,clientes[0],"19/07/2019",itens,2);
		clientes[0].Comprar(venda1);
		vendas[qntVendas] = venda1;
		qntVendas++;
	}
	
	public void cadastrarCliente() 
	{
		sc = new Scanner(System.in);
		System.out.println("*****Cadastrando cliente*****");
		System.out.print("Codigo do cliente: ");
		int codigo=sc.nextInt();
		System.out.print("Nome: ");
		String nome=sc.next();
		Cliente cliente = new Cliente(codigo,nome);
		clientes[qntClientes] = cliente;
		qntClientes++;
		System.out.println("**************************************");
	}
	
	
	public void cadastrarProduto() 
	{
		sc = new Scanner(System.in);
		System.out.println("*****Cadastrando Produto*****");
		System.out.print("Codigo do produto: ");
		int codigo=sc.nextInt();
		System.out.print("Nome: ");
		String nome=sc.next();
		System.out.print("Quantidade em estoque: ");
		int quant=sc.nextInt();
		System.out.print("Preco: ");
		Produto produto = new Produto(codigo,nome,quant,sc.nextDouble());
		produtos[qntProdutos] = produto;
		qntProdutos++;
		System.out.println("**************************************");
	}
	
	
	public void realizarVenda() 
	{
		sc = new Scanner(System.in);
		System.out.println("*****Realizando venda*****");
		System.out.print("Codigo da venda: ");
		int codigo=sc.nextInt();
		System.out.print("Nome do cliente: ");
		String nome=sc.next();
		System.out.print("Data da venda: ");
		String data=sc.next();
		System.out.print("Quantidade de produtos diferentes: ");
		int quant=sc.nextInt();
		Item[] itens = new Item[quant];
		int cont1 = 0;
		for(int i=0;i<quant;i++) 
		{
			int test = 0;
			while(test==0 || test==2) 
			{
				System.out.print("Nome do produto "+i+": ");
				String nome1=sc.next();
				if(nome1.equalsIgnoreCase("cancelar")) {
					System.out.println("Venda cancelada.");
					return;
				}
				System.out.print("Quantidade: ");
				int quant1=sc.nextInt();
				for(int j=0;j<qntProdutos;j++) 
				{
					if(nome1.equalsIgnoreCase(produtos[j].getNome())) 
					{
						test = 1;
						if(produtos[j].getQntEmEstoque() < quant1) 
						{
							System.out.println(">ERRO: Quantidade em estoque deste produto eh insuficiente para a venda.");
							System.out.println(">Digite o produto novamente ou digite \"Cancelar\" para cancelar a operacao de venda.");
							test = 2;
							break;
						}
						else
						{
							produtos[j].vender(quant1);
							itens[cont1] = new Item(produtos[j].getCodigo(),nome1,produtos[j].getQntEmEstoque(),produtos[j].getPreco(),quant1);
							cont1++;
						}
					}
				}
				if(test==0)
				{
					System.out.println(">ERRO: Produto Invalido.");
					System.out.println(">Digite o produto novamente ou digite \"Cancelar\" para cancelar a operacao de venda.");
				}
			}
		}
		int test = 0;
		while(test == 0) 
		{
			for(int i=0;i<qntClientes;i++) 
			{
				if(nome.equalsIgnoreCase(clientes[i].getNome())) 
				{
					test = 1;
					Venda venda = new Venda(codigo,clientes[i],data,itens,quant);
					clientes[i].Comprar(venda);
					vendas[qntVendas] = venda;
					qntVendas++;
					break;
				}
			}
			if(test == 0) 
			{
				System.out.println(">ERRO: Cliente inserido invalido.");
				System.out.println(">Digite o nome novamente ou digite \"Cancelar\" para cancelar a operacao de venda.");
				nome=sc.next();
				if(nome.equalsIgnoreCase("cancelar")) {
					System.out.println("Venda cancelada.");
					return;
				}
			}
		}
		System.out.println("**************************************");
	}
	
	
	public void aumentarQuantidadeEmEstoque() 
	{
		sc = new Scanner(System.in);
		System.out.println("*****Aumentando estoque de um produto*****");
		System.out.println("Nome do produto: ");
		boolean test = false;
		String nome = sc.next();
		System.out.println("Quantidade adicionada: ");
		int quant = sc.nextInt();
		for(int j=0;j<qntProdutos;j++) 
		{
			if(nome.equalsIgnoreCase(produtos[j].getNome())) 
			{
				test = true;
				produtos[j].qntEmEstoque += quant;
				break;
			}
		}
		if(test == false) 
		{
			System.out.println("ERRO: Produto Invalido");
		}
		System.out.println("**************************************");
	}
	
	
	public void listarClientes() 
	{
		System.out.println("**************************************");
		System.out.println("Lista de clientes: ");
		for(int i=0;i<qntClientes;i++) 
		{
			System.out.print("\t"+clientes[i].getNome());
			System.out.println("--> Quantidade de compras: "+clientes[i].getQntCompras());
		}
		System.out.println("**************************************");
	}
	
	
	public void listarProdutos() 
	{
		System.out.println("**************************************");
		System.out.println("Lista de produtos: ");
		for(int i=0;i<qntProdutos;i++) 
		{
			System.out.print("\t"+produtos[i].getNome());
			System.out.println("--> Codigo: "+produtos[i].getCodigo()+". Quantidade em estoque: "+produtos[i].getQntEmEstoque()+". Preco: "+produtos[i].getPreco());
		}
		System.out.println("**************************************");
	}
	
	
	public void listarProdutosEmEstoque() 
	{
		System.out.println("**************************************");
		System.out.println("Lista de produtos em estoque: ");
		for(int i=0;i<qntProdutos;i++) 
		{
			if(produtos[i].getQntEmEstoque() > 0) 
			{
				System.out.print("\t"+produtos[i].getNome());
				System.out.println("--> Codigo: "+produtos[i].getCodigo()+". Quantidade em estoque: "+produtos[i].getQntEmEstoque()+". Preco: "+produtos[i].getPreco());
			}
		}
		System.out.println("**************************************");
	}
	
	
	public void listarProdutosEsgotados() 
	{
		System.out.println("**************************************");
		System.out.println("Lista de produtos esgotados: ");
		for(int i=0;i<qntProdutos;i++) 
		{
			if(produtos[i].getQntEmEstoque() < 1) 
			{
				System.out.print("\t"+produtos[i].getNome());
				System.out.println("--> Codigo: "+produtos[i].getCodigo()+". Quantidade em estoque: (Esgotado). Preco: "+produtos[i].getPreco());
			}
		}
		System.out.println("**************************************");
	}
	
	
	public void listarVendas() 
	{
		System.out.println("**************************************");
		System.out.println("Quantidade de vendas realizadas: "+qntVendas);
		System.out.println("Lista de vendas realizadas: ");
		for(int i=0;i<qntVendas;i++) 
		{
			Item[] itensAux = vendas[i].getItens();
			System.out.println(">Venda de Codigo "+vendas[i].getCodigo()+"<");
			System.out.println("\tComprador: "+vendas[i].getComprador().getNome());
			System.out.println("\tData: "+vendas[i].getData());
			System.out.println("\tProdutos vendidos: ");
			for(int j=0;j<vendas[i].getQntProdutosDiferentes();j++) 
			{
				System.out.print("\t\t"+itensAux[j].getNome());
				System.out.print("-> quantidade: ");
				System.out.println(itensAux[j].getQntVendida());
			}
		}
		System.out.println("**************************************");
	}
	
	
	public void listarVendasCliente() 
	{
		System.out.println("**************************************");
		sc = new Scanner(System.in);
		System.out.print("Nome do cliente: ");
		String nome = sc.next();
		boolean test = false;
		for(int i=0;i<qntClientes;i++) 
		{
			if(nome.equalsIgnoreCase(clientes[i].getNome())) 
			{
				test = true;
				System.out.println("Numero de compras:"+clientes[i].getQntCompras());
				System.out.println("Lista de compras ");
				for(int j=0;j<clientes[i].getQntCompras();j++) 
				{
					System.out.println(">Compra de codigo: "+clientes[i].getCompras()[j].getCodigo()+"<");
					System.out.println("\tData:"+clientes[i].getCompras()[j].getData());
					System.out.println("\tProdutos:");
					for(int k=0;k<clientes[i].getCompras()[j].getQntProdutosDiferentes();k++) 
					{
						System.out.print("\t\t"+clientes[i].getCompras()[j].getItens()[k].getNome());
						System.out.println("--> quantidade:"+clientes[i].getCompras()[j].getItens()[k].getQntVendida());
					}
				}
			}
		}
		if(test == false)
		{
			System.out.println("ERRO: Cliente Invalido.");
		}
		System.out.println("**************************************");
	}
	
}
