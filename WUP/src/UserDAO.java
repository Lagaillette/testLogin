import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.pept.transport.Connection;

public class UserDAO extends DAO<User> {
	
	

	public UserDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(User obj) {
		return false;
	}

	public boolean delete(User obj) {
		return false;
	}

	public boolean update(User obj) {
		return false;
	}

	public boolean find(User obj) {
		User user = new User();  
		int exist=0;
		String l=user.getlogin();
		String p=user.getPwd();

		boolean connected = false;
		try {
		
		Statement state = ((java.sql.Connection) connect).createStatement();
		
		
		ResultSet name=state.executeQuery("Select Count(*) as nb from test where name='"+l+"' and password='"+p+"';");   
		while(name.next())
			exist = name.getInt("nb");
			System.out.println(exist);

		if(exist==0){
			connected= false;
		}
		else{
			connected = true;
			/*HttpSession maSession = name.getSession(true);
			maSession.setAttribute("login",login);
			maSession.setAttribute("pwd",pwd);*/
		}
		}catch  (Exception e){
			e.printStackTrace();
		}
		return connected;

	}
	
}

