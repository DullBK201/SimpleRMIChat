package chatrmi.client;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.Date;
import chatrmi.SharedTools;
import java.text.SimpleDateFormat;
import java.util.Random;
import chatrmi.server.ServerInt;

//ENNASRI MOUAD - simple RMI Chat application

public class ClientImp extends UnicastRemoteObject implements ClientInt, Runnable{

  public static final long serialVersionUID=2L;
  private static int MAX = 1000;//MAX number of Users ID

  private ServerInt chatServer;
  private String name=null;
  private int ClientID;

  protected ClientImp(String name,ServerInt server) throws RemoteException{//Constructor
    Random rand = new Random();

    this.ClientID = rand.nextInt(MAX) + 1;//Generate random ID for every new user
    this.name=name;
    this.chatServer=server;
    chatServer.addClient(this);//adding the actual client to the server list
    chatServer.selfMessage("Welcome "+ this.name +"@"+this.ClientID+" *O* type \\help? for HELP ",this.ClientID);

  }


  public void fetchMessage(String message,int color) throws RemoteException{//retreive message and print

    switch(color){
      case 0:
        System.out.println(SharedTools.ANSI_WHITE+""+message+""+SharedTools.ANSI_RESET);
      break;
      case 1:
        System.out.println(SharedTools.ANSI_RED+""+message+""+SharedTools.ANSI_RESET);
      break;
      case 2:
        System.out.println(SharedTools.ANSI_YELLOW+""+message+""+SharedTools.ANSI_RESET);
      break;
      case 3:
        System.out.println(SharedTools.ANSI_BLUE+""+message+""+SharedTools.ANSI_RESET);
      break;
      case 4:
        System.out.println(SharedTools.ANSI_GREEN+""+message+""+SharedTools.ANSI_RESET);
      break;
      default:
        System.out.println(SharedTools.ANSI_PURPLE+""+message+""+SharedTools.ANSI_RESET);
    }

  }
  public String getClientName() throws RemoteException{
    return this.name;
  }
  public int getClientID(){
    return this.ClientID;
  }

  @Override
  public void run(){//Run implementation (Runnable class)
    Scanner scanner=new Scanner(System.in);
    String message;

    Date dNow = new Date( );
     SimpleDateFormat ft =
     new SimpleDateFormat ("hh:mm:ss a ");//format date
    while(true){
      message=scanner.nextLine();//Read client input
      try{
      if(message.toLowerCase().contains("\\id@")){//if the message is of the form \ID@NAME then return the ID of the Client NAME
        for(Integer a: chatServer.getClientsIDByName(message.substring(4,message.length()))){//loop through all the clients with NAME
          chatServer.selfMessage(message.substring(4,message.length())+" ID is => "+a,this.ClientID);//print ID of each
        }
      }
      else if(message.toLowerCase().contains("\\private@")){//case of private message \private@ID MESSAGE
        chatServer.directMessage(message.substring(message.indexOf(' ')+1,message.length()), this.ClientID, Integer.parseInt(message.substring(message.indexOf('@')+1,message.indexOf(' '))));
      }else if(message.toLowerCase().contains("\\help?")){
        SharedTools.usage();
      }else if(message.toLowerCase().contains("\\online@")){
        for(ClientInt cl:chatServer.listOnlineUsers()){
          chatServer.selfMessage(cl.getClientName()+"@"+cl.getClientID(), this.ClientID);
        }
      }else{

        chatServer.broadcastMessage("("+ft.format(dNow)+") "+name + "@"+this.ClientID+" :" + message);//public message
      }
      }catch(RemoteException e){
          e.printStackTrace();
      }
    }


  }
}
