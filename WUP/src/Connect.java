

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

//CTRL + SHIFT + O pour générer les imports
public class Connect {

	public static Connection  conn;
	
	private static String url = "jdbc:postgresql://localhost:5400/login";
	
	private static String user = "postgres";
	
	private static String passwd = "wup";
	
	public static Connection load(){
		if (conn == null){
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver O.K.");

			
			conn= DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return conn; 
	}

	public static boolean log_in(String login, String pwd){
		//Création d'un objet Statement
		boolean connected = false;
		try {
		
		Statement state = conn.createStatement();
		
		int exist=0;
		String l=login;
		String p=pwd;
		ResultSet name=state.executeQuery("Select Count(*) as nb from test where name='"+l+"' and password='"+p+"';");   
		while(name.next())
			exist = name.getInt("nb");

		if(exist==0){
			connected= false;
		}
		else{
			connected = true;
			
		}
		}catch  (Exception e){
			e.printStackTrace();
		}
		return connected;

		
			
		}
}
