package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import klasa.Obuca;

public class JTableObuca extends AbstractTableModel {
	ArrayList<Obuca> lista;

	public JTableObuca(ArrayList<Obuca> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Obuca o = lista.get(r);
		switch(c) {
		case 0 : return o.getVrsta();
		case 1 : return o.isMuske();
		case 2 : return o.isZenske();
		case 3 : return o.isDjecije();
		case 4 : return o.getBrKomada();
		case 5 : return o.getCena();
		default: return "GRESKA";
		}
	}
	
	@Override
	public String getColumnName(int c) {
		switch(c) {
		case 0 : return "Vrsta";
		case 1 : return "Muske";
		case 2 : return "Zenske";
		case 3 : return "Djecije";
		case 4 : return "Broj komada";
		case 5 : return "Cena";
		default: return "Greska";
		}
	}

}
