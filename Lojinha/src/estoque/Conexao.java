package estoque;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
// This class is only for the connection on SGBD
public class Conexao {
	 public static Connection getConnection() {
		 // Default code for connection on SGBDs
		 
		 
		 // just to hide the user and password of SQL. Its simple but this app doesn't need to much security
		 String user = null;
		 String pass = null;
		 List<String> linhas = null;
			try {
				linhas = Files.readAllLines(Paths.get("C:\\Users\\juann\\PROJETO BD\\Lojinha\\src\\senha.txt"));
				user = linhas.get(0);
				pass = linhas.get(1);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	    try
	       {Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojinha", user, pass);
	    	 // System.out.println("DEU CERTO");
	    	return con;
	
	    	}
	        catch(Exception e)
	        {
	            e.printStackTrace();
	       return null;
	        }
		
		
		
	    }  
}
