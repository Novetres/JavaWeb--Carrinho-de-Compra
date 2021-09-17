package model;

public class JavaBeans {
private String codigo;
private String item;
private String quantidade;
private String preco;
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getQuantidade() {
	return quantidade;
}
public void setQuantidade(String quantidade) {
	this.quantidade = quantidade;
}
public String getPreco() {
	return preco;
}
public void setPreco(String preco) {
	this.preco = preco;
}

public JavaBeans() {
	super();
}
public JavaBeans(String codigo, String item, String quantidade, String preco) {
	super();
	this.codigo = codigo;
	this.item = item;
	this.quantidade = quantidade;
	this.preco = preco;
}


}