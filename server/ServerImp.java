package chatrmi.server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import chatrmi.client.ClientInt;
import java.util.ArrayList;

//ENNASRI Mouad Simple rmi chat application

public class ServerImp extends UnicastRemoteObject implements ServerInt{

  public static final long serialVersionUID=1L;

  private ArrayList<ClientInt> chatClients;

  protected ServerImp() throws RemoteException{//Constructor (default)
    chatClients = new ArrayList<ClientInt>();
  }


  public synchronized void addClient(ClientInt client)throws RemoteException{//Add client to the list
    this.chatClients.add(client);
  }

  public void listClients() throws RemoteException{//list all clients
    for (ClientInt a: chatClients){
      a.getClientName();
    }
  }


  public synchronized void broadcastMessage(String message)throws RemoteException{//send message to all clients
    int i=0;

    while(i<chatClients.size()){
      chatClients.get(i++).fetchMessage(message,2);
    }

  }

  /*public int getClientIDByName(String name)throws RemoteException{//get id of a client using his name (Obsolete) clients can have the same name
      for (ClientInt cl : chatClients){
        if(cl.getClientName().equals(name.trim()))return cl.getClientID();
      }
      return -15;
  }*/

  public ArrayList<Integer> getClientsIDByName(String name)throws RemoteException{//get list of all ClientsID having NAME
    ArrayList<Integer> _IDClients=new ArrayList<Integer>();
    for (ClientInt cl : chatClients){
      Integer id = Integer.valueOf(cl.getClientID());

      if(cl.getClientName().equals(name.trim()))_IDClients.add(id);
    }
    return _IDClients;
  }


  public void directMessage(String message,int _IDSender,int _IDReceiver) throws RemoteException{//send direct Message sender -> Receiver

    String sender="";

    for(ClientInt cl: chatClients){
      if(cl.getClientID() == _IDSender){
        sender = cl.getClientName();
      }
    }

    for(ClientInt cl: chatClients){
      if(cl.getClientID() == _IDReceiver){
        cl.fetchMessage("(Private) From "+sender+"@"+_IDSender+" : "+message,1);
      }
    }

  }

  public void selfMessage(String message,int _IDSender) throws RemoteException{//display message for the same client
    for(ClientInt cl: chatClients){
      if(cl.getClientID() == _IDSender){
        cl.fetchMessage(message,4);
      }
    }
  }

  public void removeClient(int ID) throws RemoteException{
    for(ClientInt cl: chatClients){
      if(cl.getClientID() == ID){
        this.chatClients.remove(cl);
      }
    }
  }

  public ArrayList<ClientInt> listOnlineUsers()throws RemoteException{
    return this.chatClients;
  }


}
