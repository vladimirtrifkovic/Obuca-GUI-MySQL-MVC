package control;

import java.sql.SQLException;
import java.util.ArrayList;

import klasa.Obuca;
import model.RadSaBazom;

public class Kontrola {
	private static Kontrola kont;
	
	
	private Kontrola() {}
	
	
	public static Kontrola getInstanceOf() {
		if(kont == null) {
			kont = new Kontrola();
		}
		return kont;
	}
	
	
	public ArrayList<Obuca> listaObuce(){
		try {
			return RadSaBazom.getInstanceOf().vratiListuObuce();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Obuca> lsitMuskeObuce(){
		try {
			return RadSaBazom.getInstanceOf().vratiListuMuskeObuce();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Obuca> listaZenskeObuce(){
		try {
			return RadSaBazom.getInstanceOf().vratiListuZenskeObuce();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Obuca> listaDjecijeObuce(){
		try {
			return RadSaBazom.getInstanceOf().vratiListuDjecijeObuce();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void unesiUBazu(Obuca o) {
		try {
			RadSaBazom.getInstanceOf().unesiObucuUBazu(o);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
