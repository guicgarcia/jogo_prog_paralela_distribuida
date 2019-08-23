package server;

import client.Aposta;
import client.QuantidaDePalitos;
import client.Jogo2;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client.Service;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl extends UnicastRemoteObject implements Service{

	protected ServiceImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;
        
        public int segundos;
        public int valorApotaRepetida;
        private int valorAposta = 0;
        QuantidaDePalitos qtdP = new QuantidaDePalitos();
        Aposta a = new Aposta();
        Jogo2 j2 = new Jogo2();

        ThreadTempo threadTempo = new ThreadTempo(segundos);
        
        ArrayList<QuantidaDePalitos> lista = new ArrayList<QuantidaDePalitos>();
        ArrayList<Aposta> listaAposta = new ArrayList<Aposta>();
        ArrayList<Jogo2> lista2 = new ArrayList<Jogo2>();
        ArrayList<Integer> listaQtdJogadores = new ArrayList<Integer>();
        
        @Override//Armazena somente a quantidade ed palitos
        public ArrayList<QuantidaDePalitos> armazenaPalitos(int qtd) throws RemoteException {
            qtdP = new QuantidaDePalitos(qtd);
            lista.add(qtdP);
            
            return lista;
        }
        
        @Override//Armazena somente a aposta
        public ArrayList<Aposta> armazenaAposta(int aposta) throws RemoteException {
            a = new Aposta(aposta);
            listaAposta.add(a);
            
            return listaAposta;
        }
        
        @Override //Adiciona valores no array lista
        public ArrayList<Jogo2> armazenaJogo(String nome, int qtd, int aposta) throws RemoteException {
            j2 = new Jogo2(nome, qtd, aposta);   
            lista2.add(j2);
                
            return lista2;
       }
        
        @Override 
        public ArrayList<Jogo2> VerArray() throws RemoteException {        
            return lista2;
        } 
        
        @Override //Faz a soma dos valores adicionados no array lista
        public int somarPalitosCliente() throws RemoteException {
                      
            int somaFinal = 0;  
            Object inter = 0;  
            String str_somaFinal = "";  
  
            for (int z = 0; z < lista.size(); z++){  
                inter = lista.get(z);  
                String str_inter = String.valueOf(inter);  
                int int_inter = Integer.parseInt(str_inter);  
                somaFinal = somaFinal + int_inter;  
                str_somaFinal = String.valueOf(somaFinal);  
            }                 
            return somaFinal;
        }
        
        @Override //Apenas retorna o valor apostado 
        public int apostar(int aposta) throws RemoteException {
            valorAposta = aposta;
            return valorAposta;  
        }

    @Override
    public String verificarVencedor() throws RemoteException {
        int valorSomaPalitos = somarPalitosCliente();
        if(valorAposta == valorSomaPalitos){
            return "Você Venceu !!!";
        }
        return "Você não acertou =[";
    }

    @Override
    public int verificaApostaRepetida() throws RemoteException {
        int count = 0;
        return count;
    }

    @Override
    public ArrayList<Aposta> VerArrayApostas() throws RemoteException {
            return listaAposta;    
    }

    @Override
    public int verificaTempo() throws RemoteException {
        ThreadTempo th0 = new ThreadTempo(segundos);
        Thread t0 = new Thread(new ThreadTempo(segundos));
        threadTempo.call();
        return segundos;
    }

    @Override
    public ArrayList<Integer> armazenaQtdJogadores(int qtdJogadores) throws RemoteException {
        listaQtdJogadores.add(qtdJogadores);
              
        return listaQtdJogadores;        
    }
    
    @Override
    public int verificaQuantidadeJogadores() throws RemoteException {
        Object inter = 0; 
        int count = 0;
        for (int i = 0; i < lista.size(); i++) {
            inter = lista.get(i);
            String str_inter = String.valueOf(inter);  
            int int_inter = Integer.parseInt(str_inter);  
            if(int_inter != 0){
                count++;
            }
        }
        return count;
    }

    
}