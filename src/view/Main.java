package view;

import java.util.concurrent.Semaphore;

import controller.ControleIngresso;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int permissoes = 1;   // quantas Threads podem usar simultaneamente
		Semaphore semaforo = new Semaphore(permissoes);  // instanceamento

		for (int idT = 0; idT < 5; idT ++) {
			Thread IDT = new ControleIngresso(idT, semaforo);
				IDT.start();
			}  // fim for
	} // fim main
} // fim classe



