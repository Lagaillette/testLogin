import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Accueil extends JFrame {
	private JPanel container = new JPanel();
	private JButton btnCo;
	private JButton btnIns;
	private BufferedImage logo;
	
	public Accueil() {
		// titre
		this.setTitle("Accueil");
		// taille
		this.setSize(800,800);
		// positionne au milieu
		this.setLocationRelativeTo(null);
		// termine le processus quand on clique sur la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// redimensionnement impossible
		this.setResizable(false);
		
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		
		// panel logo
		JPanel panLogo = new JPanel();
		panLogo.setLayout(new BoxLayout(panLogo, BoxLayout.PAGE_AXIS));
		try {
			logo = ImageIO.read(new File("./logo_gris.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel labelLogo = new JLabel(new ImageIcon(logo));
		panLogo.add(labelLogo);
		panLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		//panel boutons
		JPanel panBtn = new JPanel();
		panBtn.setLayout(new BoxLayout(panBtn, BoxLayout.LINE_AXIS));
		btnCo = new JButton("Connexion");
		btnIns = new JButton("Inscription");
		panBtn.add(btnCo);
		panBtn.add(btnIns);
		panBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		 
        // pour lancer dialog connexion si clique sur connexion
		btnCo.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Login login = new Login();
                        login.setVisible(true);
                        setVisible(false);
                    }

                });
		
		
		container.add(panLogo);
		container.add(panBtn);
        
		// container devient notre contentPane pour le JFrame
		this.setContentPane(container);
		// rendre visible
		this.setVisible(true);
	}
}
