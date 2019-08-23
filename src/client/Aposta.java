package client;

import java.io.Serializable;

public class Aposta implements Serializable, Comparable<Aposta>{
    
    public int aposta;

    public Aposta() {
    }

    public Aposta(int aposta) {
        this.aposta = aposta;
    }

    @Override
    public String toString() {
        return ""+aposta;
    }
    
    

    @Override
    public int compareTo(Aposta o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
