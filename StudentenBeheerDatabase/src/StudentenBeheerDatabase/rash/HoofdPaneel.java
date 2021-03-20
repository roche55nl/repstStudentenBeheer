package StudentenBeheerDatabase.rash;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class HoofdPaneel extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6928484565018689725L;
	/**
	 * Creëert nieuw form HoofdPaneel
	 */

	// Variabelenverklaring
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;

	private JLabel lbl;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel8;

	public HoofdPaneel() {
		initComponents();
		lbl =new JLabel();
		lbl.setIcon(new ImageIcon(getClass().getResource("/image/oranje1.jpg")));
		lbl.setBounds(0, 0, 800, 520);
		getContentPane().add(lbl);
	}

	private void initComponents() {
		

		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();

		setTitle("Beheer van studenten");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setPreferredSize(new Dimension(800, 520));
	
		jLabel3.setFont(new Font("Monotype Corsiva", 1, 26));
		jLabel3.setForeground(new Color(0, 0, 153));
		jLabel3.setText("  Thomas More");
		jLabel3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jLabel3.setBounds(30, 40, 220, 55);
		getContentPane().add(jLabel3);
		
		jLabel4.setFont(new Font("Monotype Corsiva", 0, 25));
		jLabel4.setForeground(new Color(204, 0, 0));
		jLabel4.setText("  Campus de Nayer");
		jLabel4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jLabel4.setBounds(30, 120, 220, 55);
		getContentPane().add(jLabel4);

		jLabel7.setFont(new Font("Times New Roman", 1, 34));
		jLabel7.setForeground(new Color(153, 0, 0));
		jLabel7.setText(" Studentenbeheer graduaat informatica (2019-2020)");
		jLabel7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, new Color(0, 0, 204),
				new Color(0, 0, 204), null));
		jLabel7.setBounds(30, 210, 770, 55);
		getContentPane().add(jLabel7);

		jLabel8.setFont(new Font("Monotype Corsiva", 3, 36));
		jLabel8.setForeground(new Color(153, 0, 0));
		jLabel8.setText(" Onthaal");
		jLabel8.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, new Color(0, 0, 204),
				new Color(0, 0, 204), null));
		jLabel8.setBounds(320, 460, 160, 55);
		getContentPane().add(jLabel8);

		jButton1.setFont(new Font("Times New Roman", 1, 17));
		jButton1.setForeground(Color.WHITE);
		jButton1.setIcon(new ImageIcon(getClass().getResource("/image/student.png")));
		jButton1.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton1.setText("     Studentenbeheer            ");
		jButton1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton1.setBounds(70, 290, 250, 55);
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);

		jButton2.setFont(new Font("Times New Roman", 1, 17));
		jButton2.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton2.setText("        Rapport                          ");
		jButton2.setForeground(Color.WHITE);
		jButton2.setIcon(new ImageIcon(getClass().getResource("/image/lat.png")));
		jButton2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton2.setBounds(70, 365, 250, 55);
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);

		jButton3.setFont(new java.awt.Font("Times New Roman", 1, 17));
		jButton3.setForeground(new Color(0, 0, 102));
		jButton3.setText("                      Exit                 ");
		jButton3.setForeground(Color.WHITE);
		jButton3.setIcon(new ImageIcon(getClass().getResource("/image/button.jpg")));
		jButton3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton3.setBounds(480, 365, 250, 55);
		jButton3.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton3);

		jButton4.setFont(new Font("Times New Roman", 1, 17));
		jButton4.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton4.setText("            Punten            ");
		jButton4.setIcon(new ImageIcon(getClass().getResource("/image/rapport.jpg")));
		jButton4.setForeground(Color.WHITE);
		jButton4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton4.setBounds(480, 290, 250, 55);
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
getContentPane().add(jButton4);

jLabel5.setIcon(new ImageIcon(getClass().getResource("/image/thomasm.jpg"))); 
jLabel5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
jLabel5.setBounds(250, 0, 550, 210);
getContentPane().add(jLabel5);

		pack();
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		// studentengegevens:
		Studenten st = new Studenten();
		st.setVisible(true);
		setVisible(false);
	}

	private void jButton4ActionPerformed(ActionEvent evt) {
		// puntenbeheer :
		Punten pb = new Punten();
		pb.setVisible(true);
		setVisible(false);
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		// exit
		Close cl= new Close();
		cl.setVisible(true);
	
		}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		
		 Rapport rp=new Rapport();

			 rp.setVisible(true);
			 setVisible(false);
		
	}
	

	public static void main(String args[]) throws Exception{

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(HoofdPaneel.class.getName()).log(Level.SEVERE, null, ex);

		}

		/*
		 * Maak en toon het formulier
		 * 
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HoofdPaneel().setVisible(true);
			}
		});
	}

}