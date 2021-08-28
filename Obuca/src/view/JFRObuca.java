package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Kontrola;
import klasa.Obuca;
import model.JTableObuca;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class JFRObuca extends JFrame {

	private JPanel contentPane;
	private JTextField txtCena;
	private JTextField txtBrojKomada;
	private JTable table;
	private JRadioButton rdbtnMuske = new JRadioButton("Muske");
	private JRadioButton rdbtnZenske = new JRadioButton("Zenske");
	private JRadioButton rdbtnDjecije = new JRadioButton("Djecije");
	private ButtonGroup grupa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFRObuca frame = new JFRObuca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFRObuca() {
		grupa = new ButtonGroup();
		grupa.add(rdbtnMuske);
		grupa.add(rdbtnZenske);
		grupa.add(rdbtnDjecije);
		rdbtnMuske.setSelected(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Obuca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 420, 458);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblVrsta = new JLabel("Vrsta:");
		lblVrsta.setBounds(22, 42, 45, 13);
		panel.add(lblVrsta);

		JLabel lblCena = new JLabel("Cena: ");
		lblCena.setBounds(22, 84, 45, 13);
		panel.add(lblCena);

		JLabel lblBrojKomada = new JLabel("Broj komada:");
		lblBrojKomada.setBounds(22, 124, 81, 13);
		panel.add(lblBrojKomada);

		JComboBox comboxVrstaObuce = new JComboBox();
		comboxVrstaObuce.setModel(new DefaultComboBoxModel(new String[] { "Cizme", "Cipele" }));
		comboxVrstaObuce.setBounds(166, 38, 163, 21);
		panel.add(comboxVrstaObuce);

		txtCena = new JTextField();
		txtCena.setBounds(164, 81, 165, 19);
		panel.add(txtCena);
		txtCena.setColumns(10);

		txtBrojKomada = new JTextField();
		txtBrojKomada.setBounds(166, 121, 163, 19);
		panel.add(txtBrojKomada);
		txtBrojKomada.setColumns(10);

		JButton btnUnos = new JButton("Unos");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String vrsta = comboxVrstaObuce.getSelectedItem().toString();
					String cenaS = txtCena.getText().trim();
					String brKomadaS = txtBrojKomada.getText().trim();
					
					boolean muske = rdbtnMuske.isSelected();
					boolean zenske = rdbtnZenske.isSelected();
					boolean djecije = rdbtnDjecije.isSelected();

					double cenaP = Double.parseDouble(cenaS);
					int brKomada = Integer.parseInt(brKomadaS);
					double cena = cenaP * brKomada;

					Obuca o = new Obuca(vrsta, muske, zenske, djecije, brKomada, cena);

					Kontrola.getInstanceOf().unesiUBazu(o);

					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste unjeli obucu");
					
					ArrayList<Obuca> listaObuce = Kontrola.getInstanceOf().listaObuce();
					JTableObuca model = new JTableObuca(listaObuce);
					table.setModel(model);
					clean();


				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), "Greska! " + e2.getMessage());
				}
			}
		});

		btnUnos.setBounds(117, 304, 85, 21);
		panel.add(btnUnos);

		rdbtnMuske.setBounds(22, 176, 103, 21);
		panel.add(rdbtnMuske);

		rdbtnZenske.setBounds(22, 199, 103, 21);
		panel.add(rdbtnZenske);

		rdbtnDjecije.setBounds(22, 222, 103, 21);
		panel.add(rdbtnDjecije);

		JButton btnPrikaziMuskuObucu = new JButton("Prikazi musku obucu");
		btnPrikaziMuskuObucu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Obuca> listaMuskeObuce = Kontrola.getInstanceOf().lsitMuskeObuce();
				JTableObuca model = new JTableObuca(listaMuskeObuce);
				table.setModel(model);
			}
		});
		
		btnPrikaziMuskuObucu.setBounds(83, 478, 206, 21);
		contentPane.add(btnPrikaziMuskuObucu);

		JButton btnPrikaziZenskuObucu = new JButton("Prikazi zensku obucu");
		btnPrikaziZenskuObucu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Obuca> listaZenskeObuce = Kontrola.getInstanceOf().listaZenskeObuce();
				JTableObuca model = new JTableObuca(listaZenskeObuce);
				table.setModel(model);
			}
		});
		
		btnPrikaziZenskuObucu.setBounds(83, 520, 206, 21);
		contentPane.add(btnPrikaziZenskuObucu);

		JButton btnPrikaziDjecijuObucu = new JButton("Prikazi djeciju obucu");
		btnPrikaziDjecijuObucu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Obuca> listaDjecijeObuce = Kontrola.getInstanceOf().listaDjecijeObuce();
				JTableObuca model = new JTableObuca(listaDjecijeObuce);
				table.setModel(model);
			}
		});
		
		btnPrikaziDjecijuObucu.setBounds(83, 562, 206, 21);
		contentPane.add(btnPrikaziDjecijuObucu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 55, 538, 552);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Vrsta", "Muske", "Zenske", "Djecije", "Broj komada", "Cena" }));
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Obuca> listaObuce = Kontrola.getInstanceOf().listaObuce();
				JTableObuca model = new JTableObuca(listaObuce);
				table.setModel(model);
			}
		});
		
		btnRefresh.setBounds(466, 24, 85, 21);
		contentPane.add(btnRefresh);
	}
	
	private void clean() {
		rdbtnMuske.setSelected(true);
		rdbtnZenske.setSelected(false);
		rdbtnDjecije.setSelected(false);
		txtCena.setText("");
		txtBrojKomada.setText("");
	}
}
