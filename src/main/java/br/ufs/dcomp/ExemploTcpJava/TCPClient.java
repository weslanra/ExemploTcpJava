/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            //IP e PORT do destino
            //Neste processo de criação de SOCKET o processo fica aguardando a conexão do servidor de destino
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            String msg = "Olá, DCOMP!!!";
            byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");
            
            byte[] bufReceive = new byte[20]; // buffer de recepção

            System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
            is.read(bufReceive); // Operação bloqueante (aguardando chegada de dados)
            System.out.println("[OK] ]");
            
            String msgReceive = new String(bufReceive); // Mapeando vetor de bytes recebido para String
            
            System.out.println("  Mensagem recebida: " + msgReceive);
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}