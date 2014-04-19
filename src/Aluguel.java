import java.util.Date;


public class Aluguel {
	private Date dataAluguel;
	private double valorAluguel;
	private Carro carro;
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public void ativa(Carro carro){//-----------este método faz com q a data atual seja gravada, com que o carro alugado seja gravado e com que o valor do aluguel seja salvo
		this.carro = carro;
		valorAluguel = this.carro.getValorDiaria();
		dataAluguel = new Date(System.currentTimeMillis());
	}
	
	public double FecharConta(){//--------------------------faz o calculo do aluguel dias  * valor do aluguel
		Date dataAtual = new Date(System.currentTimeMillis());
		int qtdDias = dataAtual.getDay() - dataAluguel.getDay();
		double valor = qtdDias * valorAluguel;
		carro.setQuantidade(carro.getQuantidade()+1);
		desativar();
		return valor;
	}
	
	private void desativar(){//------------------------muda os valores do objeto para null para que quando o cliente queira alugar outro carro n haver problemas
		valorAluguel = 0;
		dataAluguel = null;
		carro = null;
	}
	
	
	
	
	//--------------------------------------------------------------------Gets e Seters
	public Date getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	//-----------------------------------------------------------------------------------------------
	
}
