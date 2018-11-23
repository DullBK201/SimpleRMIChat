package chatrmi;


public class SharedTools{
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

public static void printAlien(){
System.out.println(ANSI_CYAN+"      o o         "+ANSI_RESET);
System.out.println(ANSI_CYAN+"      | |         "+ANSI_RESET);
System.out.println(ANSI_CYAN+"     _L_L_        "+ANSI_RESET);
System.out.println(ANSI_CYAN+"  }\\/__-__\\/{     "+ANSI_RESET);
System.out.println(ANSI_CYAN+"  }(|~o.o~|){     "+ANSI_RESET);
System.out.println(ANSI_CYAN+"  }/ \\`-'/ \\{     "+ANSI_RESET);
System.out.println(ANSI_CYAN+"    _/`U'\\_       "+ANSI_RESET);
System.out.println(ANSI_CYAN+"   ( .   . )      "+ANSI_RESET);
System.out.println(ANSI_CYAN+"  / /     \\ \\     "+ANSI_RESET);
System.out.println(ANSI_CYAN+"  \\ |  ,  | /     "+ANSI_RESET);
System.out.println(ANSI_CYAN+"   \\|=====|/      "+ANSI_RESET);
System.out.println(ANSI_CYAN+"    |_.^._|       "+ANSI_RESET);
System.out.println(ANSI_CYAN+"    | |\"| |       "+ANSI_RESET);
System.out.println(ANSI_CYAN+"    ( ) ( )       "+ANSI_RESET);
System.out.println(ANSI_CYAN+"    |_| |_|       "+ANSI_RESET);
System.out.println(ANSI_CYAN+"_.-' _j L_ '-._   "+ANSI_RESET);
System.out.println(ANSI_CYAN+"(___.'     '.___) "+ANSI_RESET);


}


public static void usage(){
System.out.println(ANSI_PURPLE+"------Usage"+ANSI_RESET);
System.out.println(ANSI_PURPLE+"Get User ID By Name -> \\ID@NAME"+ANSI_RESET);
System.out.println(ANSI_PURPLE+"Send Private Message-> \\PRIVATE@IDRECEIVER"+ANSI_RESET);
System.out.println(ANSI_PURPLE+"List Online Users -> \\ONLINE@"+ANSI_RESET);

}

}
