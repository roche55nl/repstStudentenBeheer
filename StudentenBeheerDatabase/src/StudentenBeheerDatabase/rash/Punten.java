package StudentenBeheerDatabase.rash;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author rash
 */
public class Punten extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Variabelenverklaring
	private JButton btnTerug;
	private JButton btnBijwerken;
	private JComboBox<Object> cmbModule;
	private JLabel jLabel1;
	private JLabel lbl;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblModule;
	private JTable tblePunt;

	Connect conn = new Connect();
	Statement stm;
	ResultSet Rs;
	DefaultTableModel model = new DefaultTableModel();


	/**
	 * Maakt een nieuw formulier Punten
	 */
	public Punten() {
		
		initComponents();

		lbl =new JLabel();
		lbl.setIcon(new ImageIcon(getClass().getResource("/image/oranje1.jpg")));
		lbl.setBounds(0, 50, 800, 520);
		getContentPane().add(lbl);

		
		tblePunt.setColumnSelectionAllowed(true);
		model.addColumn("Nr");
		model.addColumn("Naam");
		model.addColumn("Voornaam");
		model.addColumn("Module");
		model.addColumn("Punt");

		try {
			stm = conn.connection.createStatement();
			ResultSet Rs = stm.executeQuery("SELECT * FROM student ");
			while (Rs.next()) {
				model.addRow(new Object[] { Rs.getString("nr"), Rs.getString("naam"), Rs.getString("voornaam"),
						Rs.getString("module"), Rs.getString("punt") });
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	/**
	 * Deze methode wordt vanuit de constructor aangeroepen om het formulier te
	 * initialiseren.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jLabel1 = new JLabel();
		jPanel1 = new JPanel();
	
		tblePunt = new JTable();
		lblModule = new JLabel();
		cmbModule = new JComboBox();
		jScrollPane1 = new JScrollPane();
		btnBijwerken = new JButton();
		btnTerug = new JButton();

		sorter = new TableRowSorter<DefaultTableModel>(model);
		tblePunt.setModel(model);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Puntentabel");
		getContentPane().setLayout(null);
		getContentPane().setPreferredSize(new Dimension(800, 520));
		
		jPanel1.setBounds(0,0,800, 50);
		jPanel1.setBackground(new Color(0, 153, 204));
		jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		jScrollPane1.setBounds(270, 100, WIDTH, HEIGHT);
		jScrollPane1.setBounds(15, 150, 750, 290);
		tblePunt.setRowSorter(sorter);
		
		jLabel1.setFont(new Font("Times New Roman", 1, 26));
		jLabel1.setText("Puntentabel (2019-2020)");
		jPanel1.add(jLabel1);

		JLabel background = new JLabel();
		background.setLayout( new BorderLayout() );
		background.setBounds(510, 50, 254, 100);
		background.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		background.setIcon(new ImageIcon(getClass().getResource("/image/csm.png"))); 
		getContentPane().add(background);
		
		lblModule.setFont(new java.awt.Font("Times New Roman", 1, 18));
		lblModule.setText("Module");
		lblModule.setBounds(230, 60, 200, 60);
		
		lblModule.setBackground(Color.getColor("", Color.DARK_GRAY));
		
		cmbModule.setFont(new Font("Tahoma", 0, 18));
		cmbModule.setForeground(new Color(0, 0, 102));
		cmbModule.setBackground(Color.getColor("", Color.DARK_GRAY));
		cmbModule.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "Programmeren", "Analyse", "IT Organisatie" }));
		cmbModule.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		cmbModule.setBounds(320, 70, 160, 40);
		cmbModule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmbModuleActionPerformed(e);

			}
		});
		getContentPane().add(lblModule);
		getContentPane().add(cmbModule);
		getContentPane().add(btnTerug);
		getContentPane().add(btnBijwerken);
		getContentPane().add(jPanel1);
		getContentPane().add(jScrollPane1);

		jScrollPane1.setViewportView(tblePunt);
		jScrollPane1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		btnBijwerken.setFont(new Font("Tahoma", 1, 15));
		btnBijwerken.setForeground(new Color(0, 0, 153));
		btnBijwerken.setBackground(Color.getColor("", Color.DARK_GRAY));
		btnBijwerken.setText("Bijwerken");
		btnBijwerken.setForeground(Color.WHITE);
		btnBijwerken.setIcon(new ImageIcon(getClass().getResource("/image/bijwerken.png")));
		btnBijwerken.setBounds(270, 450, 120, 50);
		btnBijwerken.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		btnBijwerken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			UpdateData();
			}
		});
		tblePunt.getCellEditor();
		
		btnTerug.setFont(new Font("Tahoma", 1, 15));
		btnTerug.setForeground(new Color(0, 0, 153));
		btnTerug.setBackground(Color.getColor("", Color.DARK_GRAY));
		btnTerug.setText("Terug");
		btnTerug.setForeground(Color.WHITE);
		btnTerug.setIcon(new ImageIcon(getClass().getResource("/image/5.JPG")));
		btnTerug.setBounds(400, 450, 120, 50);
		btnTerug.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnTerug.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				btnTerugActionPerformed(evt);
			}

			private void btnTerugActionPerformed(ActionEvent evt) {
				HoofdPaneel hp = new HoofdPaneel();
				hp.setVisible(true);
				setVisible(false);
			}
		});
		
		pack();
	}

	private void cmbModuleActionPerformed(ActionEvent evt) {
		RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter(cmbModule.getSelectedItem().toString());
		sorter.setRowFilter(rf);
	}


	private void UpdateData() {
		int selectedRowIndex = tblePunt.getSelectedRow();
		

		try {
			String punt = tblePunt.getValueAt(selectedRowIndex, 4).toString();
			if( Integer.parseInt(punt)>=0&&Integer.parseInt(punt)<=20) {
			if (JOptionPane.showConfirmDialog(null, "Weet u het zeker?", null, JOptionPane.YES_NO_OPTION) == JOptionPane
					.showConfirmDialog(null, "Bijgewerkt!", null, JOptionPane.YES_OPTION)) {

				stm.executeUpdate("UPDATE student SET punt='" + tblePunt.getValueAt(selectedRowIndex, 4).toString()
						+ "' WHERE naam= '" + tblePunt.getValueAt(selectedRowIndex, 1)+"'   ");}
			
	}else {
				
				JOptionPane.showMessageDialog(null, "Punt moet tussen 0 en 20 zijn!");
				tblePunt.setValueAt("", selectedRowIndex, 4);
			}
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Geen punt ingegeven!");
			
		}
	}

	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {
			System.out.println("Waarde bijgewerkt: " + e.toString());

		}
	}
	}
