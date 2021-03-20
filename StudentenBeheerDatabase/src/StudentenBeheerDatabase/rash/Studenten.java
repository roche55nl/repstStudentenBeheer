package StudentenBeheerDatabase.rash;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rash
 */
public class Studenten extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7281927073722399868L;
	
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JButton jButton7;
	private JLabel jLabel;
	private JLabel lbl;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JScrollPane jScrollPane1;
	private JTable tble;
	private JComboBox txtmod;
	private JComboBox dag;
	private JComboBox maand;
	private JComboBox jaar;
	private JComboBox cmbZoe;
	private JTextField txtnr;
	private JTextField txtnaa;
	private JTextField txtvrn;
	private JTextField txtzoe;

	Statement stmn;

	Connect conn = new Connect();
	ResultSet Rs;
	DefaultTableModel model = new DefaultTableModel();
	public Studenten() {
		initComponents();
		lbl = new JLabel();
		lbl.setIcon(new ImageIcon(getClass().getResource("/image/oranje1.jpg")));
		lbl.setBounds(0, 50, 800, 520);
		getContentPane().add(lbl);
		model.addColumn("nr");
		model.addColumn("naam");
		model.addColumn("voornaam");
		model.addColumn("module");
		model.addColumn("geboortejaar");
		try {
			stmn = conn.connection.createStatement();
			ResultSet res = stmn.executeQuery("Select * from student");
			while (res.next()) {
				model.addRow(new Object[] { res.getString("nr"), res.getString("Naam"), res.getString("voornaam"),
						res.getString("module"), res.getString("gdatum") });
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		tble.setModel(model);
	}

	public void ToonGegevens() {
		try {
			model.setRowCount(0);
			stmn = conn.connection.createStatement();
			ResultSet res = stmn.executeQuery("Select * from student");
			while (res.next()) {
				model.addRow(new Object[] { res.getInt("nr"), res.getString("Naam"), res.getString("voornaam"),
						res.getString("module"), res.getString("gdatum") });

			}
		} catch (Exception e) {
			System.err.println(e);
		}
		tble.setModel(model);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jLabel = new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		txtvrn = new JTextField();
		txtnaa = new JTextField();
		txtnr = new JTextField();
		txtmod = new JComboBox();
		txtmod.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		dag = new JComboBox();
		dag.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		maand = new JComboBox();
		maand.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jaar = new JComboBox();
		jaar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		cmbZoe = new JComboBox();
		int i = 0;
		// dagenlijst initialiseren
		for (i = 1; i <= 31; i++) {
			dag.addItem("" + String.format("%02d", i));

		}
		// definieer het standaard geselecteerde element (het 1e element)
		dag.setSelectedIndex(0);
		// maandenlijst initialiseren
		for (i = 1; i <= 12; i++) {
			maand.addItem("" + String.format("%02d", i));
		}
		// definieer het standaard geselecteerde element (het 1e element)
		maand.setSelectedIndex(0);

		// jarenlijst initialiseren
		for (i = 1970; i <= 2020; i++) {
			jaar.addItem("" + i);
		}
		jaar.setSelectedIndex(16);

		jPanel2 = new JPanel();
		jPanel2.setBounds(0, 0, 800, 50);
		jPanel2.setBackground(new Color(0, 153, 204));
		jScrollPane1 = new JScrollPane();
		tble = new JTable();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jButton5 = new JButton();
		jButton6 = new JButton();
		jButton7 = new JButton();
		txtzoe = new JTextField();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setPreferredSize(new Dimension(800, 480));

		jLabel.setFont(new Font("Times New Roman", 1, 24));
		jLabel.setText("             Studentenbeheer: (2019/2020)");
		jLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jLabel.setBounds(0, 0, 800, 50);
		jPanel2.add(jLabel);

		jPanel1.setLayout(null);
		jLabel1.setFont(new Font("Times New Roman", 1, 14));
		jLabel1.setText("Voornaam    :");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(10, 110, 90, 30);

		jLabel2.setFont(new Font("Times New Roman", 1, 14));
		jLabel2.setText("Module         :");
		jPanel1.add(jLabel2);
		jLabel2.setBounds(10, 170, 90, 30);

		jLabel3.setFont(new Font("Times New Roman", 1, 14));
		jLabel3.setText("Geboortejaar:");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(10, 230, 90, 30);

		jLabel4.setFont(new Font("Times New Roman", 1, 14));
		jLabel4.setText("Nr                 :");
		jPanel1.add(jLabel4);
		jLabel4.setBounds(10, 10, 90, 30);

		txtvrn.setFont(new Font("Tahoma", 0, 14));
		jPanel1.add(txtvrn);
		txtvrn.setBounds(136, 110, 165, 30);

		txtnaa.setFont(new Font("Tahoma", 0, 14));
		jPanel1.add(txtnaa);
		txtnaa.setBounds(136, 60, 165, 30);

		jLabel5.setFont(new Font("Times New Roman", 1, 14));
		jLabel5.setText("Naam           :");
		jPanel1.add(jLabel5);
		jLabel5.setBounds(10, 60, 100, 30);

		txtnr.setFont(new Font("Tahoma", 0, 14));
		txtnr.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				txtnrActionPerformed(evt);
			}
		});
		jPanel1.add(txtnr);
		jPanel1.setBackground(new Color(0, 153, 204));
		jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		txtnr.setBounds(136, 10, 165, 30);

		txtmod.setModel(new DefaultComboBoxModel(new String[] { "Programmeren ", "Analyse", "IT Organisatie" }));
		jPanel1.add(txtmod);
		txtmod.setBounds(136, 170, 165, 30);

		jPanel1.add(dag);
		dag.setBounds(136, 230, 52, 30);
		jPanel1.add(maand);
		maand.setBounds(187, 230, 52, 30);
		jPanel1.add(jaar);
		jaar.setBounds(238, 230, 65, 30);

		getContentPane().add(jPanel1);

		jPanel1.setBounds(20, 50, 320, 290);

		tble.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tbleMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tble);

		getContentPane().add(jLabel);
		getContentPane().add(jPanel2);
		jScrollPane1.setBounds(350, 50, 425, 290);
		getContentPane().add(jScrollPane1);
		jButton2.setFont(new java.awt.Font("Times New Roman", 1, 17));
		jButton2.setBounds(20, 350, 150, 50);
		jButton2.setText("Toevoegen");
		jButton2.setForeground(Color.WHITE);
		jButton2.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton2.setIcon(new ImageIcon(getClass().getResource("/image/add.png")));
		jButton2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);

		jButton3.setBounds(180, 350, 150, 50);
		jButton3.setFont(new Font("Times New Roman", 1, 17));
		jButton3.setText("Bijwerken");
		jButton3.setForeground(Color.WHITE);
		jButton3.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton3.setIcon(new ImageIcon(getClass().getResource("/image/bijwerken.png")));
		jButton3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}

		});
		getContentPane().add(jButton3);

		jButton4.setFont(new java.awt.Font("Times New Roman", 1, 17));
		jButton4.setText("Verwijderen");
		jButton4.setBounds(180, 410, 150, 50);
		jButton4.setForeground(Color.WHITE);
		jButton4.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton4.setIcon(new ImageIcon(getClass().getResource("/image/verwijder.png")));
		jButton4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton4);

		jButton5.setFont(new java.awt.Font("Times New Roman", 1, 17));
		jButton5.setText("Updaten");
		jButton5.setBounds(20, 410, 150, 50);
		jButton5.setForeground(Color.WHITE);
		jButton5.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton5.setIcon(new ImageIcon(getClass().getResource("/image/update.png")));
		jButton5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton5);

		jButton6.setFont(new Font("Times New Roman", 1, 17));
		jButton6.setText("      Terug");
		jButton6.setBounds(492, 410, 150, 50);
		jButton6.setForeground(Color.WHITE);
		jButton6.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton6.setIcon(new ImageIcon(getClass().getResource("/image/5.JPG")));
		jButton6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton6);

		jButton7.setFont(new Font("Times New Roman", 1, 17));
		jButton7.setText("Zoeken ");
		jButton7.setBounds(630, 350, 150, 30);
		jButton7.setForeground(Color.WHITE);
		jButton7.setBackground(Color.getColor("", Color.DARK_GRAY));
		jButton7.setIcon(new ImageIcon(getClass().getResource("/image/zoeken.png")));
		jButton7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton7);

		cmbZoe.setFont(new Font("Times New Roman", 0, 17));
		cmbZoe.setForeground(new Color(0, 0, 102));
		cmbZoe.setBackground(Color.getColor("", Color.DARK_GRAY));
		cmbZoe.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "Nr", "Naam", "Voornaam", "G-jaar" }));
		cmbZoe.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		cmbZoe.setBounds(350, 350, 150, 30);
		getContentPane().add(cmbZoe);

		txtzoe.setFont(new Font("Times New Roman", 1, 20));
		txtzoe.setBounds(500, 348, 130, 33);

		
		getContentPane().add(txtzoe);
		pack();
	}

	private void HaalGegevens(int i) {
		try { // i verwijst naar de gekozen rij

			txtnr.setText(model.getValueAt(i, 0).toString());
			txtnaa.setText(model.getValueAt(i, 1).toString());
			txtvrn.setText(model.getValueAt(i, 2).toString());
			txtmod.setSelectedItem(model.getValueAt(i, 3).toString());
			dag.setSelectedItem(model.getValueAt(i, 4).toString().substring(0, 2));
			maand.setSelectedItem(model.getValueAt(i, 4).toString().substring(3, 5));
			jaar.setSelectedItem(model.getValueAt(i, 4).toString().substring(6, 10));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fout bij het ophalen van gegevens! " + e.getMessage());
		}
	}

	private void jButton2ActionPerformed(ActionEvent evt) {

		String nr = txtnr.getText();
		String naam = txtnaa.getText();
		String voornaam = txtvrn.getText();
		String module = txtmod.getSelectedItem().toString();
		String da = dag.getSelectedItem().toString().concat(".");
		String maa = maand.getSelectedItem().toString();
		String jaa = jaar.getSelectedItem().toString();
		String gdatum = da.concat(maa).concat(".").concat(jaa).toString();
		try {
			String sql = "SELECT * FROM student WHERE nr = '" + nr + "'";
			ResultSet rs = stmn.executeQuery(sql);
			if (!rs.next()) {
				String sql1 = "INSERT INTO student(nr,Naam,voornaam,module,gdatum)VALUES('" + nr + "','" + naam + "','"
						+ voornaam + "','" + module + "','" + gdatum + "')";
				stmn.executeUpdate(sql1);
				JOptionPane.showMessageDialog(null, "Student correct opgeslagen.");
				txtnaa.setText("");
				txtvrn.setText("");
				txtmod.setSelectedItem(2);

			} else {
				JOptionPane.showMessageDialog(null, "Nr bestaat al");
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	private void jButton5ActionPerformed(ActionEvent evt) {
		ToonGegevens();
	}

	// bij het kiezen van een student op het tabel verschijnen zijn gegevens op
	// fieldtext
	private void tbleMouseClicked(MouseEvent evt) {
		try {
			int i = tble.getSelectedRow();
			HaalGegevens(i);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fout" + e.getMessage());
		}
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		try {
			if (JOptionPane.showConfirmDialog(null, "Weet u het zeker?", "Bijwerken",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
				String da = dag.getSelectedItem().toString().concat(".");
				String maa = maand.getSelectedItem().toString();
				String jaa = jaar.getSelectedItem().toString();
				String gdatum = da.concat(maa).concat(".").concat(jaa).toString();
				stmn.executeUpdate("UPDATE student SET naam='" + txtnaa.getText() + "' , voornaam='" + txtvrn.getText()
						+ "'  , module='" + txtmod.getSelectedItem().toString() + "', gdatum='" + gdatum
						+ "' WHERE nr= '" + txtnr.getText() + "' ");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bewerking mislukt");
			System.err.println(e);
		}
	}

	private void txtnrActionPerformed(ActionEvent evt) {
		txtnr.setEnabled(false);
	}

	private void jButton4ActionPerformed(ActionEvent evt) {
		try {
			if (JOptionPane.showConfirmDialog(null,
					"U staat op het punt om het student te verwijderen. Weet u het zeker?", "Verwijder student",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)

				if (txtnr.getText().length() != 0) {
					stmn.executeUpdate("Delete From student where nr = " + txtnr.getText());
				} // studentenlijst
				else {
					JOptionPane.showMessageDialog(null, "klik op een student Aub!");
				}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fout bij het verwijderen" + e.getMessage());
		}

	}

	private void jButton6ActionPerformed(ActionEvent evt) {
		HoofdPaneel hp = new HoofdPaneel();
		hp.setVisible(true);
	}

	private void jButton7ActionPerformed(ActionEvent evt) {

		try {
			// lijst leegmaken
			model.setRowCount(0);
			{
				System.out.println(cmbZoe.getItemAt(cmbZoe.getSelectedIndex()).equals("Voornaam"));
				if (cmbZoe.getItemAt(cmbZoe.getSelectedIndex()).equals("Naam")) {
					Rs = stmn.executeQuery("SELECT * From student WHERE naam = '" + txtzoe.getText() + "'");

				} else {
					if (cmbZoe.getItemAt(cmbZoe.getSelectedIndex()).equals("Voornaam")) {
						Rs = stmn.executeQuery("SELECT * From student WHERE voornaam = '" + txtzoe.getText() + "'");
					} else {
						if (cmbZoe.getItemAt(cmbZoe.getSelectedIndex()).equals("Nr")) {
							Rs = stmn.executeQuery("SELECT * From student WHERE nr = '" + txtzoe.getText() + "'");
						} else {
							if (cmbZoe.getItemAt(cmbZoe.getSelectedIndex()).equals("G-jaar")) {
								Rs = stmn.executeQuery(
										"SELECT * From student WHERE gdatum = '" + txtzoe.getText() + "'");

							}
						}
					}
				}
				txtzoe.setText("");

			}
			while (Rs.next()) {

				Object[] student = { Rs.getString(2), Rs.getString(3), Rs.getString(4), Rs.getString(5),
						Rs.getString(6) };
				model.addRow(student);
			}
			if (model.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Student bestaat niet");

			} else {
				int i = 0;
				HaalGegevens(i);

			}
		} catch (Exception e) {
			System.err.println(e);
			JOptionPane.showMessageDialog(null, "Fout");
		}
	}

}
