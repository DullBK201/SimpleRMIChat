package chatrmi.client;
import java.rmi.Remote;
import java.rmi.RemoteException;



public interface ClientInt extends Remote{

  void fetchMessage(String message,int color) throws RemoteException;//retreive message
  String getClientName() throws RemoteException;
  int getClientID() throws RemoteException;

}
