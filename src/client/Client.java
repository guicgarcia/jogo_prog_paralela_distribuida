package client;

import server.ThreadTempo;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import server.ThreadValidar1;

public class Client {

	public static void main(String[] args) {
		
		try {
			String loc = "//localhost/service";
			Service service = (Service) Naming.lookup(loc);
			Scanner teclado = new Scanner(System.in);
                        QuantidaDePalitos j = new QuantidaDePalitos();
                        
                        int op = 0;
                        int segundos = 0;
                        String nome = "";
                        int qtd = 0;
                        int aposta = 0;
                        int verificaAposta = 0;
                        int count = 0;
                        int qtdJogadores = 0;
                        int verificaQtdJogadores = 0;
                        boolean bloqueiaAposta = false;
                        boolean testeCliente = false;
                        
                        Thread t0 = new Thread(new ThreadTempo(segundos));
                        ThreadTempo th0 = new ThreadTempo(segundos);
                        t0.start();                       
                        
                        System.out.println("Quantas pessoas irão jogar ? ");
                        qtdJogadores = teclado.nextInt();
                        service.armazenaQtdJogadores(qtdJogadores);
                        
                        System.out.println("-------------------------------------");
                        System.out.println("-----------------JOGO----------------");
                        
                        do{
                            System.out.println("1 - Escolher quantidade Palitos: ");
                            System.out.println("2 - Ver qtd de palitos armazenada");
                            System.out.println("3 - Sair");
                            op = teclado.nextInt();
                                             
                            if(op == 1){
                                verificaQtdJogadores = service.verificaQuantidadeJogadores();                               
                                if(verificaQtdJogadores > qtdJogadores){
                                    System.out.println("ERRO - NÚMERO MÁXIMO DE JOGADORES !");
                                    System.exit(0);
                                }else{
                                    System.out.print("Seu nome: ");
                                    nome = teclado.next();
                                    do{
                                    System.out.print("Quantidade de palitos (Max: 3): ");
                                    qtd = teclado.nextInt();
                                    }while(qtd > 3);
                                    service.armazenaPalitos(qtd);
                                }
                                Thread t1 = new Thread(new ThreadValidar1(nome,qtd));
                                ThreadValidar1 th1 = new ThreadValidar1(nome, qtd);

                                t1.start();
                                th1.call();
                                                              
                                if(th1.flag1 == true){
                                    System.out.println("Erro - Você digitou um número negativo !");
                                    op = 1;
                                }else{
                                    op = 3;
                                }
                            }
                            if(op == 2){
                                System.out.println(service.VerArray());
                            }
                            
                        }while(op != 3);

                        
                        System.out.println("-------------------------------------");
                        
                        
                        System.out.println("Quantidade de Jogadores: "+service.verificaQuantidadeJogadores());
                                           
                        System.out.print("Faça sua aposta: ");
                        aposta = teclado.nextInt();
                            
                        service.armazenaJogo(nome, qtd, aposta);
                        
                        System.out.println("--------------RESULTADO--------------");
                        
                        System.out.println("Sua aposta foi: "+service.apostar(aposta));
                        
                        System.out.println("Total da soma Palitos: "+service.somarPalitosCliente());
                        
                        System.out.println(service.verificarVencedor());
                        
                        System.out.println("Tempo: "+th0.call());
                        t0.stop();
                        
			teclado.close();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
                
	}
        
}