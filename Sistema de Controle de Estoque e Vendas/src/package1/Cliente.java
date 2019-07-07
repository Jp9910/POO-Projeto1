package package1;

public class Cliente {

	private int codigo;
	private String nome;
	private Venda[] compras;
	
	public Cliente(int codigo,String nome) {
		this.codigo=codigo;
		this.nome=nome;
		compras = null;
	}
}
