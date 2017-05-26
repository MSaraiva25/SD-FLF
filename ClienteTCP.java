package marioTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP {

public static void main(String args[]) throws Exception {
		
		String caracteres;
		String caracteresMaiusculos;
		
		BufferedReader receberCaracteres = 	new BufferedReader(new InputStreamReader(System.in));
		
		Socket cliente = new Socket("localhost", 9876);
		DataOutputStream enviarDados = 	new DataOutputStream(cliente.getOutputStream());
		
		BufferedReader receberDados = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		System.out.println("Digite Alguma Coisa");
		
		caracteres = receberCaracteres.readLine();
		enviarDados.writeBytes(caracteres + '\n');
		caracteresMaiusculos = receberDados.readLine();
		
		System.out.println("Reposta do Servidor: " + caracteresMaiusculos);
		cliente.close();
		
		
	}
}
