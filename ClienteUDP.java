package mario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
	
	public static void main(String args[]) throws Exception {
		BufferedReader dadosUsuario = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket cliente = new DatagramSocket();
		InetAddress ipAdress = InetAddress.getByName("localhost");		
		
		System.out.println("Digite o Nome do Aquivo");

		byte[] enviarDados = new byte[1024];
		byte[] receberDados = new byte[1024];
		String nomeArquivo = dadosUsuario.readLine();
		enviarDados = nomeArquivo.getBytes();
		
		DatagramPacket enviarDataGrama = new DatagramPacket(
				enviarDados, enviarDados.length, ipAdress, 9876);
		cliente.send(enviarDataGrama);
	
		
		DatagramPacket receberDataGrama = new DatagramPacket(receberDados, receberDados.length);
		cliente.receive(receberDataGrama);
	    String retorno = new String(receberDataGrama.getData());
	    
		if(!retorno.trim().equals("")){
			System.out.println(retorno);
		}else{
			byte[] t = receberDataGrama.getData();
			
			File file = new File("C:/Users/mario/Documents");
					
			FileOutputStream out = new FileOutputStream(file);
			out.write(t);
		}
		cliente.close();
	}

}
