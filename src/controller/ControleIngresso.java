package controller;

import java.util.concurrent.Semaphore;

public class ControleIngresso extends Thread {
	
	private int idThread;
	private Semaphore semaforo;
	private static int ingressototal;
	
	public ControleIngresso ( int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	} // fim metodo
	
	public void run() {
		login();
		compra();
		try {
			semaforo.acquire();
			validação();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void login() {
		int tempo = 0;
		tempo = (int)(Math.random() * 1951 + 50);
		if ( tempo > 1000) {
			try {
				sleep(2000 - tempo);
				System.out.println("A compra não poderá ser realizada por nao ter realizado o Login");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} System.out.println("login realizado");
		} // fim if
	} // final da classe
		
	public void compra() {
		int tempoi =0;
		tempoi = (int) (Math.random() * 2000 + 1000 );
		if (tempoi > 2500) {
			try {
				sleep(3000 - tempoi);
				System.out.println("Estourou o tempo da seção, não poderá fazer a compra");
			} catch (Exception e) {
			}  
		} // fim if
	} // fim classe compra
	
	public void validação() {
		int ingresso = 0;
		ingresso = (int)(Math.random() *41) / 10;
		if (ingressototal - ingresso >= 0 ) {
			ingressototal -= ingresso;
			System.out.println("Ingressos Comprados" + ingresso + "Ingresso disponiveis" + ingressototal );
		}
		System.out.println(" Infelizmente não foi possível compras os ingressos");
	} // fim da classe
	
} // fim classe


