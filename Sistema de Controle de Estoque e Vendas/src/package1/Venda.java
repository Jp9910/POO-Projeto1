package package1;

public class Venda {

	private int codigo;
	private Cliente comprador;
	private String data;
	private Item[] itens;
	
	public Venda(int codigo, Cliente comprador, String data, Item[] itens) {
		this.codigo=codigo;
		this.comprador=comprador;
		this.data = data;
		this.itens = itens;
	}
}
