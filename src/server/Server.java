package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server{

	public static void main(String[] args) {
		try {
			//Cria um novo serviço
			ServiceImpl service = new ServiceImpl();
			
			//Define o nome do objeto servidor que será utilizado por clientes
			String loc = "//localhost/service";
			
			//Registra o serviço no servidor, passando por parâmetro 
			//o nome do serviço a ser disponibilizado, e o objeto remoto
			Naming.rebind(loc, service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}