package StudentenBeheerDatabase.rash;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
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

public class Rapport extends JFrame {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1732116035709865578L;
	
private JPanel jPanel;
	private JButton btnterug;
	private JButton btnUpdate;
	private JComboBox<Object> cmbModule;
	private JScrollPane jScrollPane;
	private TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblSorter;
	private JLabel lbl;
	private JLabel lbl1;
	private JTable tble;
	boolean flag = true;
	Connect conn = new Connect();
	Statement stm;
	ResultSet Rs;
	DefaultTableModel model = new DefaultTableModel();

	public Rapport() {
		initComponents();
		lbl =new JLabel();
		lbl.setIcon(new ImageIcon(getClass().getResource("/image/oranje1.jpg")));
		lbl.setBounds(0, 50, 800, 520);
		getContentPane().add(lbl);
	}
	@SuppressWarnings("unchecked")
	private void initComponents() {
		jPanel = new JPanel();
		jPanel.setBounds(0,0,800, 50);
		jPanel.setBackground(new Color(0, 153, 204));
		jPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		lbl1=new JLabel();
		lbl1.setFont(new Font("Times New Roman", 1, 26));
		lbl1.setText("Rapport");
		
		jPanel.add(lbl1);
		tble = new JTable();
		
		lblSorter = new JLabel();
		cmbModule = new JComboBox();
		jScrollPane = new JScrollPane();
		btnterug = new JButton();
		btnUpdate = new JButton();
		sorter = new TableRowSorter<DefaultTableModel>(model);
		tble.setModel(model);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Rapport");
		getContentPane().setLayout(null);
		getContentPane().setPreferredSize(new Dimension(800, 520));
		jScrollPane.setBounds(15, 120, 750, 290);
		tble.setRowSorter(sorter);
		
		lblSorter.setFont(new java.awt.Font("Times New Roman", 1, 18));
		lblSorter.setText("klik om te sorteren:");
		lblSorter.setBounds(150, 40, 200, 60);
		
		
		cmbModule.setFont(new Font("Tahoma", 0, 18));
		cmbModule.setForeground(new Color(0, 0, 102));
		cmbModule.setBackground(Color.getColor("", Color.DARK_GRAY));
		cmbModule.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "Onvoldoende", "Voldoende", "Goed", "Zeer goed" }));
		cmbModule.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		cmbModule.setBounds(320, 50, 150, 40);
		cmbModule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cmbModuleActionPerformed(e);

			}

		});
		

		getContentPane().add(cmbModule);
		getContentPane().add(btnterug);
		getContentPane().add(btnUpdate);
		getContentPane().add(lblSorter);
		getContentPane().add(jScrollPane);
		getContentPane().add(jPanel);

		jScrollPane.setViewportView(tble);
		jScrollPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	
		tble.setColumnSelectionAllowed(true);

		model.addColumn("Naam");
		model.addColumn("Voornaam");
		model.addColumn("Punt");
		model.addColumn("Vermelding");
		try {
			stm = conn.connection.createStatement();
			ResultSet Rs = stm.executeQuery("SELECT * FROM student ");
			while (Rs.next()) {
				model.addRow(new Object[] {  Rs.getString("naam"), Rs.getString("voornaam"),Rs.getString("punt"),
						Rs.getString("vermelding")
						
  });
								
 }	
}
		catch (Exception e) {
			System.err.println(e);
		}
 
	btnUpdate.setFont(new Font("Tahoma", 0, 18));
	btnUpdate.setText("  Update    ");
	btnUpdate.setForeground(Color.WHITE);
	btnUpdate.setBackground(Color.getColor("", Color.DARK_GRAY));
	btnUpdate.setIcon(new ImageIcon(getClass().getResource("/image/bijwerken.png")));
	btnUpdate.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	btnUpdate.setBounds(170, 430, 140, 40);
	btnUpdate.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent evt) {
			btnUpdateActionPerformed(evt);
		}

		private void btnUpdateActionPerformed(ActionEvent evt) {
	
			for(int i=0;i<tble.getRowCount();i++){
				try {
					 if((Integer.parseInt(tble.getValueAt(i, 2).toString()))<10 ) {
				         tble.setValueAt("Onvoldoende",i,3);
				 }
					 
					 else	     if((Integer.parseInt(tble.getValueAt(i, 2).toString()))>=10 && (Integer.parseInt(tble.getValueAt(i, 2).toString()))<=12) {
					         tble.setValueAt("Voldoende",i,3);
					       
				}
					     
					 else	     if((Integer.parseInt(tble.getValueAt(i, 2).toString()))>12 && (Integer.parseInt(tble.getValueAt(i, 2).toString()))<16 ) {
					         tble.setValueAt("Goed", i, 3);
				}
					     
	else	     if((Integer.parseInt(tble.getValueAt(i, 2).toString()))>=16) {
					         tble.setValueAt("Zeer goed",i, 3);     
					}
						System.out.println(tble.getValueAt(i, 2).toString());
				}
						catch (Exception e) {
							System.err.println(e);
						}
	
			}
			int i=0;  
			System.out.println(model.getRowCount());
		for(i=0; i<=model.getRowCount(); i++) {
			while (flag) {
			try{
			stm.executeUpdate("UPDATE student SET vermelding ='" + tble.getValueAt(i, 3).toString() + "'  WHERE naam= '" + model.getValueAt(i, 0)+ "' ");
			  System.out.println("i = "+ i++);
			 
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null, "Database bijgewerkt!");
				flag = false;
		
			}
			}
		}
		}
	
	});
	pack();

		btnterug.setFont(new Font("Tahoma", 0, 18));
		btnterug.setText("  Terug ");
		btnterug.setForeground(Color.WHITE);
		btnterug.setBackground(Color.getColor("", Color.DARK_GRAY));
		btnterug.setIcon(new ImageIcon(getClass().getResource("/image/5.JPG")));
		btnterug.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnterug.setBounds(320, 430, 140, 40);
		btnterug.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				btnTerugActionPerformed(evt);
			}

			private void btnTerugActionPerformed(ActionEvent evt) {
				HoofdPaneel hp = new HoofdPaneel();
				hp.setVisible(true);
				setVisible(false);

			}
		});
	}
	
	private void cmbModuleActionPerformed(ActionEvent evt) {
		RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter(cmbModule.getSelectedItem().toString());
		sorter.setRowFilter(rf);
	
 }
}
