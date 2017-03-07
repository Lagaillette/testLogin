
public class FaçadeConnexion {
	
	public static boolean log_in(String login,String pwd){
		return User.log_in(login,pwd);
	}
}
