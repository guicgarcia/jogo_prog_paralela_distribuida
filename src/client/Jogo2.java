package client;

import java.io.Serializable;

public class Jogo2 implements Serializable, Comparable<QuantidaDePalitos>{
    
    public String nome;
    public int qtdPalito;
    public int aposta;

    public Jogo2() {
    }
    
    public Jogo2(String nome, int qtdPalito, int aposta) {
        this.nome = nome;
        this.qtdPalito = qtdPalito;
        this.aposta = aposta;
    }

    @Override
    public String toString() {
        return "Nome: "+nome+" QtdPalitos: "+qtdPalito+" Aposta: "+aposta;
    }
    
    @Override
    public int compareTo(QuantidaDePalitos o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
