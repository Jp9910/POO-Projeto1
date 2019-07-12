package package1;

public class Item extends Produto{

	private int qntVendida;
	
	public Item(int codigo1, String nome1, int qntEmEstoque1, double preco1, int qntVendida1) {
		super(codigo1,nome1,qntEmEstoque1,preco1);
		qntVendida = qntVendida1;
		this.qntEmEstoque = this.qntEmEstoque - qntVendida;
	}
	
	public int getQntVendida() {
		return qntVendida;
	}
	public void setQntVendida(int qntVendida) {
		this.qntVendida = qntVendida;
	}
}
