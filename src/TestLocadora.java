import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;



import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestLocadora {
	private Cliente cliente1, cliente2, cliente3, cliente4;
	private Carro carro1, carro2, carro3, carro4;
	private Locadora loc;
	
	@Before
	public void beforeLocadora() throws ClienteNullException, CarroNullException{
		cliente1 = new Cliente("Carlos","08585827670");
		cliente2 = new Cliente("Marcos","86499881805");
		cliente3 = new Cliente("Carla","47762560530");
		cliente4 = new Cliente("Maria","79527593530");
		loc = new Locadora(100,100);
		carro1 = new Carro("fiat", "uno", "azul", 2000, 50.50, 5, 20.50);
		carro2 = new Carro("ford", "k", "prata", 2010, 20.40, 20, 10.30);
		carro3 = new Carro("ferrari", "001", "vermelha", 1999, 100.00, 2, 50.00);
		carro4 = new Carro("wolksvagem", "gol", "branco", 2004, 30.20, 0, 20.50);
		loc.registrarCliente(cliente1);
		loc.registrarCliente(cliente2);	
		loc.registrarCliente(cliente3);
		loc.registrarCliente(cliente4);
		loc.registrarCarro(carro1);
		loc.registrarCarro(carro2);
		loc.registrarCarro(carro3);
		loc.registrarCarro(carro4);
		Carro.setAtribuidorDeCodigo(0);
	}
	
	@Test
	public void newCarro(){
		
		Assert.assertEquals(carro1.getMarca(), "fiat");
		Assert.assertEquals(carro1.getModelo(), "uno");
		Assert.assertEquals(carro1.getAno(), 2000);
		Assert.assertEquals(carro1.getCodigo(), 0);
		Assert.assertEquals(carro1.getCor(), "azul");
		Assert.assertEquals(carro1.getQuantidade(), 5);
		Assert.assertEquals(carro1.getValorAdicional(), 20.50);
		Assert.assertEquals(carro1.getValorDiaria(), 50.50);
		
		Assert.assertEquals(carro2.getMarca(), "ford");
		Assert.assertEquals(carro2.getModelo(), "k");
		Assert.assertEquals(carro2.getAno(), 2010);
		Assert.assertEquals(carro2.getCodigo(), 1);
		Assert.assertEquals(carro2.getCor(), "prata");
		Assert.assertEquals(carro2.getQuantidade(), 20);
		Assert.assertEquals(carro2.getValorAdicional(), 10.30);
		Assert.assertEquals(carro2.getValorDiaria(), 20.40);
		
		Assert.assertEquals(carro3.getMarca(), "ferrari");
		Assert.assertEquals(carro3.getModelo(), "001");
		Assert.assertEquals(carro3.getAno(), 1999);
		Assert.assertEquals(carro3.getCodigo(), 2);
		Assert.assertEquals(carro3.getCor(), "vermelha");
		Assert.assertEquals(carro3.getQuantidade(), 2);
		Assert.assertEquals(carro3.getValorAdicional(), 50.00);
		Assert.assertEquals(carro3.getValorDiaria(), 100.00);
		
		Assert.assertEquals(carro4.getMarca(), "wolksvagem");
		Assert.assertEquals(carro4.getModelo(), "gol");
		Assert.assertEquals(carro4.getAno(), 2004);
		Assert.assertEquals(carro4.getCodigo(), 3);
		Assert.assertEquals(carro4.getCor(), "branco");
		Assert.assertEquals(carro4.getQuantidade(), 0);
		Assert.assertEquals(carro4.getValorAdicional(), 20.50);
		Assert.assertEquals(carro4.getValorDiaria(), 30.20);
	
	}
	
	@Test
	public void newCliente(){
		Assert.assertEquals(cliente1.getNome(), "Carlos");
		Assert.assertEquals(cliente1.getCpf(), "08585827670");
		Assert.assertEquals(cliente2.getNome(), "Marcos");
		Assert.assertEquals(cliente2.getCpf(), "86499881805");
		Assert.assertEquals(cliente3.getNome(), "Carla");
		Assert.assertEquals(cliente3.getCpf(), "47762560530");
		Assert.assertEquals(cliente4.getNome(), "Maria");
		Assert.assertEquals(cliente4.getCpf(), "79527593530");
	}
	
	@Test
	public void newAluguel(){
		Aluguel aluguel1 = new Aluguel();
		Aluguel aluguel2 = new Aluguel();
		
		aluguel1.ativa(carro1);
		Date d1 = new Date(System.currentTimeMillis());
		aluguel2.ativa(carro2);
		Date d2 = new Date(System.currentTimeMillis());
		Assert.assertTrue(carro1.equals(aluguel1.getCarro()));
		Assert.assertEquals(aluguel1.getDataAluguel(), d1);
		Assert.assertEquals(carro1.getValorDiaria(), aluguel1.getValorAluguel());
		Assert.assertTrue(carro2.equals(aluguel2.getCarro()));
		Assert.assertEquals(aluguel2.getDataAluguel(), d2);
		Assert.assertEquals(carro1.getValorDiaria(), aluguel1.getValorAluguel());
	}
	@Test
	public void newLocadora(){
		Assert.assertEquals(loc.getCarros().length, 100);
		Assert.assertEquals(loc.getClientes().length, 100);
	}
	
	@Test
	public void adicionarCliente(){

		Assert.assertTrue(loc.getClientes()[0].equals(cliente1));
		Assert.assertTrue(loc.getClientes()[1].equals(cliente2));
		Assert.assertTrue(loc.getClientes()[2].equals(cliente3));
		Assert.assertTrue(loc.getClientes()[3].equals(cliente4));
	}
	@Test(expected = ClienteNullException.class)
	public void registrarClienteNullo() throws ClienteNullException{
		loc.registrarCliente(null);
	}
	@Test
	public void registrarCarro(){

		Assert.assertTrue(loc.getCarros()[0].equals(carro1));
		Assert.assertTrue(loc.getCarros()[1].equals(carro2));
		Assert.assertTrue(loc.getCarros()[2].equals(carro3));
		Assert.assertTrue(loc.getCarros()[3].equals(carro4));	
	}
	@Test(expected = CarroNullException.class)
	public void registrarCarroNullo() throws CarroNullException{
		loc.registrarCarro(null);
	}
	@Test
	public void cpfExistente(){
		Assert.assertTrue(loc.cpfExistente("08585827670"));
		Assert.assertTrue(loc.cpfExistente("86499881805"));
		Assert.assertTrue(loc.cpfExistente("47762560530"));
		Assert.assertTrue(loc.cpfExistente("79527593530"));
	}
	
	@Test
	public void numeracaoErradaCPF(){
		
		Assert.assertTrue(loc.validaCPF("00000000000"));
		Assert.assertTrue(loc.validaCPF("11111111111"));
		Assert.assertTrue(loc.validaCPF("22222222222"));
		Assert.assertTrue(loc.validaCPF("33333333333"));
		Assert.assertTrue(loc.validaCPF("44444444444"));
		Assert.assertTrue(loc.validaCPF("55555555555"));
		Assert.assertTrue(loc.validaCPF("66666666666"));
		Assert.assertTrue(loc.validaCPF("77777777777"));
		Assert.assertTrue(loc.validaCPF("88888888888"));
		Assert.assertTrue(loc.validaCPF("99999999999"));	
		Assert.assertTrue(loc.validaCPF("076171890556"));
		Assert.assertTrue(loc.validaCPF("076143"));
		Assert.assertFalse(loc.validaCPF("56020201600"));
	}
	
	@Test
	public void alugarCarro(){
		
		loc.alugarCarro("86499881805", 0, 2);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), 4);
		loc.alugarCarro("79527593530", 2, 3);
		Assert.assertEquals(loc.getCarros()[2].getQuantidade(), 1);
		loc.alugarCarro("47762560530", 0, 3);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), 3);	
	}
	@Test
	public void adicionarQtdCarro(){
		int temp1 = loc.getCarros()[0].getQuantidade();
		int temp2 = loc.getCarros()[1].getQuantidade();
		int temp3 = loc.getCarros()[2].getQuantidade();
		int temp4 = loc.getCarros()[3].getQuantidade();
		int add1 = 2;
		int add2 = 3;
		int add3 = 4;
		int add4 = 5;
		loc.aumentarQtdCarro(0, add1);
		loc.aumentarQtdCarro(1, add2);
		loc.aumentarQtdCarro(2, add3);
		loc.aumentarQtdCarro(3, add4);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), temp1 + add1);
		Assert.assertEquals(loc.getCarros()[1].getQuantidade(), temp2 + add2);
		Assert.assertEquals(loc.getCarros()[2].getQuantidade(), temp3 + add3);
		Assert.assertEquals(loc.getCarros()[3].getQuantidade(), temp4 + add4);
		loc.aumentarQtdCarro(0, add1);
		loc.aumentarQtdCarro(3, add4);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), temp1 + (2 * add1));
		Assert.assertEquals(loc.getCarros()[3].getQuantidade(), temp4 + (2 * add4));
	}
	@Test
	public void diminuirQtdCarro(){
		int temp1 = loc.getCarros()[0].getQuantidade();
		int temp2 = loc.getCarros()[1].getQuantidade();
		int temp3 = loc.getCarros()[2].getQuantidade();
		int temp4 = loc.getCarros()[3].getQuantidade();
		int dim1 = 2;
		int dim2 = 3;
		int dim3 = 4;
		int dim4 = 5;
		loc.diminuirQtdCarro(0, temp1);
		loc.diminuirQtdCarro(1, 1);
		loc.diminuirQtdCarro(2, temp3);
		loc.diminuirQtdCarro(3, temp4);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), 0);
		Assert.assertEquals(loc.getCarros()[1].getQuantidade(), temp2-1);
		Assert.assertEquals(loc.getCarros()[2].getQuantidade(), 0);
		Assert.assertEquals(loc.getCarros()[3].getQuantidade(), 0);
		loc.aumentarQtdCarro(2, 3);
		loc.aumentarQtdCarro(3, 4);
		loc.diminuirQtdCarro(2, 2);
		loc.diminuirQtdCarro(3, 2);
		Assert.assertEquals(loc.getCarros()[2].getQuantidade(), 1);
		Assert.assertEquals(loc.getCarros()[3].getQuantidade(), 2);
	}
	
	@Test
	public void removerCarro() throws CarroNullException{
		int cod = 0;
		loc.removerCarro(cod++);
		Assert.assertEquals(loc.getCarros()[0], null);
		loc.removerCarro(cod++);
		Assert.assertEquals(loc.getCarros()[1], null);
		loc.removerCarro(cod++);
		Assert.assertEquals(loc.getCarros()[2], null);
		loc.removerCarro(cod++);
		Assert.assertEquals(loc.getCarros()[3], null);
		loc.registrarCarro(carro1);
		Assert.assertTrue(carro1.equals(loc.getCarros()[0]));
	}
	@Test
	public void removerCliente() throws CarroNullException, ClienteNullException{
		int cod = 0;
		loc.removerCliente(cliente1.getCpf());
		Assert.assertEquals(loc.getClientes()[0], null);
		loc.removerCliente(cliente2.getCpf());
		Assert.assertEquals(loc.getClientes()[1], null);
		loc.removerCliente(cliente3.getCpf());
		Assert.assertEquals(loc.getClientes()[2], null);
		loc.removerCliente(cliente4.getCpf());
		Assert.assertEquals(loc.getClientes()[3], null);
		
		loc.registrarCliente(cliente1);
		Assert.assertTrue(cliente1.equals(loc.getClientes()[0]));
	}
	
	@Test
	public void testValorAdicional(){
		loc.alugarCarro("08585827670", 1, 3);
		loc.alugarCarro("86499881805", 0, 2);
		loc.alugarCarro("47762560530", 2, 4);
		loc.alugarCarro("79527593530", 2, 5);
	
		Assert.assertEquals(loc.getClientes()[0].getDivida(), carro2.getValorAdicional() * 3);
		Assert.assertEquals(loc.getClientes()[1].getDivida(), carro1.getValorAdicional() * 2);
		Assert.assertEquals(loc.getClientes()[2].getDivida(), carro3.getValorAdicional() * 4);
		Assert.assertEquals(loc.getClientes()[3].getDivida(), carro3.getValorAdicional() * 5);
	}
	
	@Test
	public void testBuscaCliente(){
		
		Assert.assertEquals(loc.buscaIndiceCliente("47762560530"), 2);
		Assert.assertEquals(loc.buscaIndiceCliente("86499881805"), 1);
		Assert.assertEquals(loc.buscaIndiceCliente("08585827670"), 0);
		Assert.assertEquals(loc.buscaIndiceCliente("79527593530"), 3);
	}
	
	@Test
	public void testBuscaCarro() throws CarroNullException{
		
		Assert.assertEquals(1, loc.getCarros()[1].getCodigo());
		Assert.assertEquals(3, loc.getCarros()[3].getCodigo());
		Assert.assertEquals(0, loc.getCarros()[0].getCodigo());
		Assert.assertEquals(2, loc.getCarros()[2].getCodigo());
	}
	
	@Test
	public void receberCarro() throws CarroNullException{

		loc.alugarCarro("86499881805", 0, 2);	
		loc.alugarCarro("79527593530", 2, 3);
		loc.alugarCarro("47762560530", 0, 3);
		loc.alugarCarro("08585827670", 1, 5);
		
		Assert.assertEquals(loc.getClientes()[3].getDivida(), 150.0);
		loc.receberCarro("79527593530", 150.00);
		Assert.assertEquals(loc.getCarros()[2].getQuantidade(), 2);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), 3);
		Assert.assertEquals(loc.getClientes()[3].getDivida(), 0.0);
		
		Assert.assertEquals(loc.getClientes()[2].getDivida(), 61.50);
		loc.receberCarro("47762560530", 60.50);
		Assert.assertEquals(loc.getClientes()[2].getDivida(), 1.0);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), 4);
		
		Assert.assertEquals(loc.getClientes()[0].getDivida(), 51.50);
		loc.receberCarro("08585827670", 40.00);
		Assert.assertEquals(loc.getClientes()[0].getDivida(), 11.50);
		Assert.assertEquals(loc.getCarros()[1].getQuantidade(), 20);
		
		Assert.assertEquals(loc.getClientes()[1].getDivida(), 41.00);
		loc.receberCarro("86499881805", 41.00);
		Assert.assertEquals(loc.getClientes()[1].getDivida(), 0.0);
		Assert.assertEquals(loc.getCarros()[0].getQuantidade(), 5);
	}
}
