package com.pszypau.SweetBusinessChat.TCPClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Lenovo on 2018-03-24.
 */
public class TCPClient {
    public static String tcpSend(String ip, int port, int timeout, String content)
    {
        String sentence;
        String modifiedSentence;
        Socket clientSocket;
        try
        {
            clientSocket = new Socket(ip, port);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(content + '\n');
            clientSocket.setSoTimeout(timeout);
            modifiedSentence = inFromServer.readLine();
            clientSocket.close();
            outToServer.close();
            inFromServer.close();
        }
        catch (Exception exc)
        {
            modifiedSentence = "";
        }
        return modifiedSentence;
    }
}
