package package1;

public class Item {

	private int codigo;
	private Produto produto;
	private int qntVendida;
	
	public Item(int codigo1, Produto produto1, int qntVendida1) {
		codigo = codigo1;
		produto = produto1;
		qntVendida = qntVendida1;
		produto.setQntEmEstoque(produto.getQntEmEstoque() - qntVendida);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public Produto getProduto() {
		return produto;
	}
	public int getQntVendida() {
		return qntVendida;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setQntVendida(int qntVendida) {
		this.qntVendida = qntVendida;
	}
}
