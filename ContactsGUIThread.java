package BlabberVMichaels;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStreamReader;

public class ContactsGUIThread extends Thread
{
    private ContactsGUI contactsGUI;
    private Socket socket;

    public ContactsGUIThread(ContactsGUI contactsGUI, Socket socket)
    {
        this.contactsGUI = contactsGUI;
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true)
            {
                try
                {
                    String message = in.readLine();
                    contactsGUI.updateView(message);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
    }
}