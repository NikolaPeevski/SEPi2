package com.Clerver.domain.mediator;

import java.net.*;
import java.io.*;

public class ServerConnectionThread extends Thread
{
   private final int PORT = 2112;
   ServerModelManager serverModel;

   public ServerConnectionThread(ServerModelManager serverModel) throws IOException
   {
      this.serverModel = serverModel;
   }

   @SuppressWarnings("resource")
public void run()
   {
      ServerSocket welcomeSocket = null;
      try
      {
         welcomeSocket = new ServerSocket(PORT);
      }
      catch (IOException e1)
      {
         e1.printStackTrace();
      }
      while (true)
      {
         try
         {
            Socket connectionSocket = welcomeSocket.accept();
            @SuppressWarnings("unused")
			ServerCommunicationThread c = new ServerCommunicationThread(
                  connectionSocket, serverModel);

         }
         catch (IOException e)
         {
            System.out.println(e);
         }
      }
   }

}
