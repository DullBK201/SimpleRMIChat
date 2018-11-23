package chatrmi.client;
import chatrmi.server.ServerInt;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

//ENNASRI Mouad simple rmi chat application
public class Client{


  public static void main(String[] args) throws RemoteException,MalformedURLException,NotBoundException{
    String chatServerURL="rmi://localhost/RMIChatServer";
    ServerInt chatServer = (ServerInt)Naming.lookup(chatServerURL);//retreiving server remote object
    new Thread (new ClientImp(args[0],chatServer)).start();//start clients threads





  }

}
