
public class Carro {
	//----------------------------------------------Atributos
	private String marca;
	private String modelo;
	private String cor;
	private int ano;
	private int codigo;
	private double valorDiaria;
	private int quantidade;
	private double valorAdicional;
	private static int atribuidorDeCodigo = 0;
	
	public Carro(String marca, String modelo, String cor, int ano, double valorDiaria, int quantidade, double adicional) {//--------------construtor
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.valorDiaria = valorDiaria;
		this.quantidade = quantidade;
		this.valorAdicional = adicional;
		this.codigo = atribuidorDeCodigo;
		atribuidorDeCodigo++;
	}
	public String toString(){//-------------------------mostra os atributos do objeto em forma de texto
		String temp = "";
		temp += "Cod.: "+codigo + " - ";
		temp += marca + " ";
		temp += modelo + " ";
		temp += ano + " ";
		temp += "Cor: "+cor + " - ";
		temp += "Valor: R$ "+valorDiaria + " - ";
		if(quantidade > 0)temp += " Disponível("+quantidade+")";
		else temp += " Indisponível("+quantidade+")";
		temp += "\n-----------------------------------------";
		return temp;
	}
	
	public void alugar(Cliente cliente){//------------------------------------diminui a quantidade de carros disponíveis e ativa o objeto aluguel do cliente
		this.quantidade--;
		cliente.getAluguel().ativa(this);
		
	}
	
	public boolean equals(Carro carro){
		if(
				this.ano == carro.getAno() &&
				this.codigo == carro.getCodigo() &&
				this.cor.equalsIgnoreCase(carro.getCor()) &&
				this.marca.equalsIgnoreCase(carro.getMarca()) &&
				this.modelo.equalsIgnoreCase(carro.getModelo()) &&
				this.quantidade == carro.getQuantidade() &&
				this.valorDiaria == carro.getValorDiaria() &&
				this.valorAdicional == carro.getValorAdicional()
		){
			
					return true;
		}
		return false;
	}
	
	public void aumentarQtdCarro(int qtd){//-----------------------aumenta a quantidade dos carros deste objeto
		this.quantidade += qtd;
	}
	
	//-----------------------------------------------Geters e Seters
	public static void setAtribuidorDeCodigo(int atribuidorDeCodigo) {
		Carro.atribuidorDeCodigo = atribuidorDeCodigo;
	}
	public void devolver(){
		this.quantidade++;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public double getValorAdicional() {
		return valorAdicional;
	}
	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
	public void diminuirQtdCarro(int quantidade2) {
		if(quantidade2 > quantidade){
			quantidade = 0;
			return;
		}
		quantidade -= quantidade2;
		
	}
	

}
