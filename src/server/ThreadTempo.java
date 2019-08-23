package server;

import static java.lang.System.console;

public class ThreadTempo implements Runnable{
    
    public int segundos;

    public ThreadTempo(int segundos) {
        this.segundos = segundos;
    }
    
    public int call() {
        while(true){
            try {Thread.sleep(200); } catch (Exception e) {}           
            segundos++;
            return this.segundos; 
        }        
    }
    
    @Override
    public void run() {
        call();
    }
      
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
   }  
    
}
