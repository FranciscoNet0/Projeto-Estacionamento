public class Cliente {
	private String nome;
	private String cpf;
	private double divida;
	private Aluguel aluguel;
	
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.aluguel = new Aluguel();
		
	}
	public void entregarCarro(double valor){//-----------------------faz o calculo da divida do cliente referente ao aluguel do carro
		divida += aluguel.FecharConta();
		pagarDivida(valor);
		
	}
	public boolean equals(Cliente cliente){
		if(
				cliente.getNome().equalsIgnoreCase(nome) &&
				cliente.getCpf().equalsIgnoreCase(cpf) &&
				cliente.getDivida() == divida){
			return true;
		}
		return false;
	}
	public void pagarDivida(double valor){//--------------------recebe um vaor e diminui da dividada do cliente
		divida -= valor;
	}
	
	public String toString(){//-----------------------mostra os atributos do objeto em forma de texto
		String temp = "";
		temp += "Nome: "+nome + " - ";
		temp += "CPF: "+cpf + " - ";
		temp += "\n-----------------------------------------";
		return temp;
	}
	
	//----------------------------------------------------getters and setters
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
	public double getDivida() {
		return divida;
	}
	public void setDivida(double divida) {
		this.divida = divida;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
