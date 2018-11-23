package chatrmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import chatrmi.client.ClientInt;
import java.util.ArrayList;

public interface ServerInt extends Remote{

  void addClient(ClientInt client)throws RemoteException;
  void broadcastMessage(String message)throws RemoteException;
  //int getClientIDByName(String name)throws RemoteException;
  ArrayList<Integer> getClientsIDByName(String name)throws RemoteException;
  void directMessage(String message,int _IDSender,int _IDReceiver) throws RemoteException;
  void selfMessage(String message,int _IDSender) throws RemoteException;
  void removeClient(int ID) throws RemoteException;
   ArrayList<ClientInt> listOnlineUsers()throws RemoteException;
}
