package client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Service extends Remote {
    
    public ArrayList<Aposta> armazenaAposta(int aposta) throws RemoteException;
    public ArrayList<QuantidaDePalitos> armazenaPalitos(int qtd) throws RemoteException;
    public ArrayList<Jogo2> armazenaJogo(String nome, int qtd, int aposta) throws RemoteException;
    public ArrayList<Jogo2> VerArray() throws RemoteException;
    public ArrayList<Aposta> VerArrayApostas() throws RemoteException;
    public int somarPalitosCliente() throws RemoteException;
    public int apostar(int aposta) throws RemoteException;
    public String verificarVencedor() throws RemoteException;
    public int verificaApostaRepetida() throws RemoteException;
    public int verificaTempo() throws RemoteException;
    public ArrayList<Integer> armazenaQtdJogadores(int qtdJogadores) throws RemoteException;
    public int verificaQuantidadeJogadores() throws RemoteException;   
}