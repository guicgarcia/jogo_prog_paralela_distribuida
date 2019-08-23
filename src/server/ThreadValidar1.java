
package server;

import java.io.IOException;

public class ThreadValidar1 implements Runnable{
    
    public String nome;
    public int quantidePalitos;
    
    public boolean flag1 = false;
    boolean flag2 = false;

    public ThreadValidar1(String nome, int quantidePalitos) {
        this.nome = nome;
        this.quantidePalitos = quantidePalitos;
    }
    
    
    //@Override
    public boolean call() {
        if(this.quantidePalitos < 0){
            System.out.println();
            flag1 = true;
        }
        return this.flag1;
    }

    @Override
    public void run() {    
        call(); 
    }

}
