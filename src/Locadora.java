import java.util.InputMismatchException;
import java.util.List;


public class Locadora {
	//private Endereco endereco;
	private Carro[] carros;
	private Cliente[] clientes;

	public Locadora(int qtdCarros, int qtdClientes) {
		carros = new Carro[qtdCarros];
		clientes = new Cliente[qtdClientes];
	}

	public void receberCarro(String cpf, double dinheiro){//--------------------------------recebe o carro que estava alugado
		clientes[buscaIndiceCliente(cpf)].entregarCarro(dinheiro);;
	}

	public void alugarCarro(String cpf, int codigoCarro, int qtdAdicional){//------------------------faz o aluguel do carro
		int indice = buscaIndiceCarro(codigoCarro);
		if(carros[indice].getQuantidade() == 0){System.out.println("Modelo esgotado!!"); return;}
		Cliente cliente = clientes[buscaIndiceCliente(cpf)];
		Carro carro = carros[indice];
		carro.alugar(cliente);
		cliente.setDivida(cliente.getDivida() + (qtdAdicional * carro.getValorAdicional()));

	}


	public void aumentarQtdCarro(int cod, int quantidade){//--------------------aumenta a quantidade de determinado carro
		int indice = buscaIndiceCarro(cod);
		carros[indice].aumentarQtdCarro(quantidade);
	}
	public void diminuirQtdCarro(int cod, int quantidade){
		int indice = buscaIndiceCarro(cod);
		carros[indice].diminuirQtdCarro(quantidade);
	}

	public int buscaIndiceCliente(String cpf){//-----------------retorna o indice do cliente com o respectivo cpf
		int i = 0;
		while(i<carros.length){
			if(clientes[i] != null && clientes[i].getCpf().equals(cpf)){return i;}
			i++;
		}
		return 199;
	}
	public void removerCliente(String cpf){
		int i = 0;
		while(i < clientes.length){
			if(clientes[i] != null && clientes[i].getCpf().equalsIgnoreCase(cpf)){
				clientes[i] = null;
				return;
			}
			i++;
		}
	}
	public void removerCarro(int cod){
		int i = 0;
		while(i < carros.length){
			if(carros[i] != null && carros[i].getCodigo()==cod){
				carros[i] = null;
				return;
			}
			i++;
		}
	}

	public int buscaIndiceCarro(int cod){//----------------------retorna o indice do carro com o determinado codigo
		int i = 0;
		while(i<carros.length){
			if(carros[i].getCodigo() == cod){return i;}
			i++;
		}
		return 199;
	}

	public void registrarCarro(Carro carro) throws CarroNullException{
		int i = 0;
		
		if(carro == null){
			throw new CarroNullException();
		}
		while(carros[i] != null){
			i++;
		}
		carros[i] = carro;
	}

	public void registrarCliente(Cliente cliente) throws ClienteNullException{
		if(cliente == null){
			throw new ClienteNullException();
		}
		if(validaCPF(cliente.getCpf())){
			return;
		}
		int i = 0;
		while(clientes[i] != null){
			i++;
		}
		clientes[i] = cliente;
	}

	public void listarCarros(){
		for(Carro i: carros){
			if(i!=null)System.out.println(i.toString());
		}
	}

	public void listarClientes(){
		if(clientes.length>0){
			for(Cliente i: clientes){
				if(i!=null)System.out.println(i.toString());
			}
		}else System.out.println("Não existem clientes!");
	}

	public boolean validaCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11) || cpfExistente(CPF)){ return(true);}
		char dig10, dig11;
		int sm, i, r, num, peso;
		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)

		// Calculo do 1o.Digito Verificador
		sm = 0;
		peso = 10;
		for (i=0; i<9; i++) {
			// converte o i-esimo caractere do CPF em um numero:
			// por exemplo, transforma o caractere '0' no inteiro 0
			// (48 eh a posicao de '0' na tabela ASCII)
			num = (int)(CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}
		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)) dig10 = '0';
		else dig10 = (char)(r + 48);
		// converte no respectivo caractere numerico
		// Calculo do 2o. Digito Verificador
		sm = 0;
		peso = 11;
		for(i=0; i<10; i++) {
			num = (int)(CPF.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		} r = 11 - (sm % 11);
		if ((r == 10) || (r == 11)) dig11 = '0';
		else dig11 = (char)(r + 48);
		// Verifica se os digitos calculados conferem com os digitos informados.
		if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) return(false);
		else return(true);

	}

	public boolean cpfExistente(String cpf) {
		for(Cliente c : this.clientes){
			if(c != null){
				if(c.getCpf().equalsIgnoreCase(cpf)){
					return true;
				}
			}
		}
		return false;
	}

	//-----------------------------------------------------------getters and setters
	public Carro[] getCarros() {
		return carros;
	}

	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	public Carro[] getListaCarro() {
		return carros;
	}

	public void setListaCarro(Carro[] listaCarro) {
		this.carros = listaCarro;
	}

}
