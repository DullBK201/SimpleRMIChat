package chatrmi.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.Date;
import chatrmi.SharedTools;
import java.text.SimpleDateFormat;
import chatrmi.client.ClientInt;
import java.rmi.NotBoundException;

//ENNASRI Mouad simple rmi chat application
public class Server{


  public static void main(String[] args) throws RemoteException,MalformedURLException,NotBoundException{
    ServerImp masterServer= new ServerImp();
    Date dNow = new Date( );
    SimpleDateFormat ft =
    new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");//format date
    Naming.rebind("RMIChatServer", masterServer);//Define remote object 
    System.out.println(SharedTools.ANSI_GREEN+"Simple RMI chat app / ENNASRI Mouad"+SharedTools.ANSI_RESET);
    System.out.println(SharedTools.ANSI_GREEN+"Server Started at "+ft.format(dNow)+""+SharedTools.ANSI_RESET);
    SharedTools.printAlien();
    System.out.println(SharedTools.ANSI_RED+"============================"+SharedTools.ANSI_RESET);




  }
}
