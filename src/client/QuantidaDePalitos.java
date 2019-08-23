package client;

import java.io.Serializable;

public class QuantidaDePalitos implements Serializable, Comparable<QuantidaDePalitos>{
    
    public int qtdPalito;

    public QuantidaDePalitos(){
    }
    
    public QuantidaDePalitos(int qtdPalito) {
        this.qtdPalito = qtdPalito;
    }

    @Override
    public String toString() {
        return ""+qtdPalito;
    }
    
    @Override
    public int compareTo(QuantidaDePalitos o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
