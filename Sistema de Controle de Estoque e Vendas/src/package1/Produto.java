package package1;

public class Produto {

	private int codigo;
	private String nome;
	private int qntEmEstoque;
	private double preco;
	
	public Produto(int codigo, String nome1, int qntEmEstoque1, double preco1) {
		this.codigo = codigo;
		nome = nome1;
		qntEmEstoque = qntEmEstoque1;
		preco = preco1;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public int getQntEmEstoque() {
		return qntEmEstoque;
	}
	public double getPreco() {
		return preco;
	}
	public void setCodigo(int codigo1) {
		codigo = codigo1;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setQntEmEstoque(int qntEmEstoque) {
		this.qntEmEstoque = qntEmEstoque;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
