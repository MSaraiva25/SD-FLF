package marioTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	private static ServerSocket servidor;
	
	public static void main(String args[]) throws Exception {
		
		String receberDados;
		String enviarDados;
		
		servidor = new ServerSocket(9876);
		
		while(true){
			System.out.println("Servidor Executando");
			Socket conexao = servidor.accept();
			BufferedReader dadosCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			
			DataOutputStream dadosServidor = new DataOutputStream(conexao.getOutputStream());
			
			receberDados = dadosCliente.readLine();
			enviarDados = receberDados.toUpperCase() + '\n';
			
			dadosServidor.writeBytes(enviarDados);
		}
		
	
		
	}
}
