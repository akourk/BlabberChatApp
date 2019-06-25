/**
 * CLASS:       CS410 Software Engineering
 * ASSIGNMENT:  Development Phase 1
 * TEAM:        Brandae Grein, Michael Thomas, Alex Kourkoumelis, Matthew Clark, Jordi Monterrubio
**/

// Package Main.
package BlabberVMichaels;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.io.PrintWriter;

public class Server
{
    private ServerSocket server;
    private HashMap<Socket, PrintWriter> outStreams = new HashMap<>();

    public Server(int port)
    {
        int count = 1;
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server is ready!");
            while(true)
            {
                Socket socket = server.accept();
                PrintWriter outStream = new PrintWriter(socket.getOutputStream());
                System.out.println("Blabber application successfully connected to server! Instance " + count + ".");
                outStreams.put(socket, outStream);
                ServerThread serverThread = new ServerThread(this, socket);
                serverThread.start();
                count++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void broadcast(String message)
    {
        for(Iterator iterator = outStreams.keySet().iterator(); iterator.hasNext();)
        {
            Socket socket = (Socket) iterator.next();
            PrintWriter outStream = outStreams.get(socket);
            outStream.println(message);
            outStream.flush();
        }
    }

    public static void main(String[] args)
    {
        Server server = new Server(1234);
    }
}