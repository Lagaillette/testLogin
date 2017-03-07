import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Login extends JDialog {
	private JPanel container = new JPanel();
	private JTextField login;
	private JPasswordField pass;
	private JLabel mail;
	private JLabel password;
	private JButton btnCo;
	private BufferedImage logo;

	
	public Login() {
		// titre
		this.setTitle("Connexion");
		// taille
		this.setSize(800,800);
		// positionne au milieu
		this.setLocationRelativeTo(null);
		// termine le processus quand on clique sur la croix
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		// redimensionnement impossible
		this.setResizable(false);

		// panel pour le login
		JPanel form = new JPanel();
		form.setLayout(new BoxLayout(form, BoxLayout.PAGE_AXIS));
		
		// Logo
		try {
			logo = ImageIO.read(new File("./logo_gris.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel labelLogo = new JLabel(new ImageIcon(logo));
		form.add(labelLogo);
		
		// Formulaire
		mail = new JLabel("Email");
		mail.setFont(new Font("Arial", Font.BOLD, 20));
		form.add(mail);
		
		login = new JTextField();
		login.setPreferredSize(new Dimension(50,50));
		login.setFont(new Font("Arial", Font.PLAIN, 30));
		form.add(login);
		
		password = new JLabel("Mot de passe");
		password.setFont(new Font("Arial", Font.BOLD, 20));
		form.add(password);
		
		pass = new JPasswordField();
		pass.setPreferredSize(new Dimension(50,50));
		pass.setFont(new Font("Arial", Font.PLAIN, 30));
		form.add(pass);
		
		btnCo = new JButton("Connexion");
		form.add(btnCo);
		
		container.add(form);
		btnCo.addActionListener(new ConnexionListener());
		
		// container devient notre contentPane pour le JFrame
		this.setContentPane(container);
		// rendre visible
		this.setVisible(true);
	}
	class ConnexionListener extends JFrame implements ActionListener{
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	            ActionEvent a;
	            try {
	                 String log = login.getText();
	                 String pwd= pass.getText();
	                 if(log.length()!=0 && pwd.length()!=0){
	                 if (FaçadeConnexion.log_in(log, pwd)){
	                	 JOptionPane.showMessageDialog(this, "connection réussie!");
	                	 Accueil accueil = new Accueil();
	                     accueil.setVisible(true);
	                     setVisible(false);
	                 }
	                 else{
	                	 JOptionPane.showMessageDialog(this,"login ou mdp incorrects");
	                 }
	                 }
	                 else{
	                	 JOptionPane.showMessageDialog(this,"veuillez remplir tous les champs s'il vous plaît");
	                 }
	            } catch (Exception e2) {
	                 
	            }
	    }

		
	     
	}
}


