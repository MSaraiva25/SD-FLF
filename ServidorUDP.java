package mario;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
	
	private static DatagramSocket servidor;

	public static void main(String args[]) throws Exception {
		servidor = new DatagramSocket(9876);
		String retorno = "";

		
	while(true){
			System.out.println("Servidor Executando ");
			byte[] receberDados = new byte[1024];
			byte[] enviarDados = new byte[1024];
			DatagramPacket receberDataGrama = new DatagramPacket(receberDados, receberDados.length);
			servidor.receive(receberDataGrama);

			String nomeArquivo = new String(receberDataGrama.getData());
			StringBuilder caminho = new StringBuilder();
			caminho.append("c:/testeUDP/").append(nomeArquivo.trim()).append(".txt");
			
			File arquivo = new File(String.valueOf(caminho));
			InputStream arquivoEnviar = null;
			
			if(arquivo.exists()){
				 arquivoEnviar = new FileInputStream(arquivo);
				 enviarDados = new byte[arquivoEnviar.available()];
			}else{
				retorno = "Arquivo Não Encontrado";
				enviarDados = retorno.getBytes();
			}
			
			
			InetAddress ipAdress = receberDataGrama.getAddress();
			int porta = receberDataGrama.getPort();			
			
			DatagramPacket enviarDataGrama = new DatagramPacket(enviarDados, enviarDados.length, ipAdress, porta);
			servidor.send(enviarDataGrama);

		}

		
	}

}
