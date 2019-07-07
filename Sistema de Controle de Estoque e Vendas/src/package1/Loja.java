package package1;
import java.util.Scanner;
public class Loja {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int opcao,codigo; String nome;
		do {
			System.out.println("O que deseja fazer?");
			opcao=sc.nextInt();
			if(opcao == 1) {
				System.out.println("Cadastrando cliente.");
				System.out.print("Codigo: ");
				codigo=sc.nextInt();
				System.out.print("Nome: ");
				nome=sc.next();
				cadastrarCliente(codigo,nome);
			}
			else if(opcao == 2) {
				System.out.println("Cadastrando venda.");
				
			}
		} while(!("sair".equalsIgnoreCase(sc.next())));
	}

	public static void cadastrarVenda(int codigo, Cliente comprador, String data, Item[] itens) {
		Venda venda = new Venda(codigo,comprador,data,itens);
	}
	public static void cadastrarCliente(int codigo,String nome) {
		Cliente cliente = new Cliente(codigo,nome);
	}
	public void listarProdutos() {
		
	}
	public void listarClientes() {
		
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
