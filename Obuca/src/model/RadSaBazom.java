package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import klasa.Obuca;

public class RadSaBazom {
	private static RadSaBazom rsb;
	
	private RadSaBazom() {}
	
	public static RadSaBazom getInstanceOf() {
		if(rsb == null) {
			rsb = new RadSaBazom();
		}
		return rsb;
	}
	

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/obuca", "root", "");
	}

	
	public ArrayList<Obuca> vratiListuObuce() throws ClassNotFoundException, SQLException {
		ArrayList<Obuca> lista = new ArrayList<Obuca>();

		connect();
		preparedStatement = connect.prepareStatement("select * from obuce");
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			String vrsta = resultSet.getString("vrsta");
			boolean muske = resultSet.getBoolean("muske");
			boolean zenske = resultSet.getBoolean("zenske");
			boolean djecije = resultSet.getBoolean("djecije");
			int brKomada = resultSet.getInt("brKomada");
			double cena = resultSet.getDouble("cena");
			
			Obuca o = new Obuca(vrsta, muske, zenske, djecije, brKomada, cena);

			lista.add(o);
		}
		
		close();
		return lista;
	}
	
	public ArrayList<Obuca> vratiListuMuskeObuce() throws ClassNotFoundException, SQLException {
		ArrayList<Obuca> lista = new ArrayList<Obuca>();

		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM `obuce` WHERE muske=1");
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			String vrsta = resultSet.getString("vrsta");
			boolean muske = resultSet.getBoolean("muske");
			boolean zenske = resultSet.getBoolean("zenske");
			boolean djecije = resultSet.getBoolean("djecije");
			int brKomada = resultSet.getInt("brKomada");
			double cena = resultSet.getDouble("cena");
			
			Obuca o = new Obuca(vrsta, muske, zenske, djecije, brKomada, cena);

			lista.add(o);
		}
		
		close();
		return lista;
	}
	
	public ArrayList<Obuca> vratiListuZenskeObuce() throws ClassNotFoundException, SQLException {
		ArrayList<Obuca> lista = new ArrayList<Obuca>();

		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM `obuce` WHERE zenske=1");
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			String vrsta = resultSet.getString("vrsta");
			boolean muske = resultSet.getBoolean("muske");
			boolean zenske = resultSet.getBoolean("zenske");
			boolean djecije = resultSet.getBoolean("djecije");
			int brKomada = resultSet.getInt("brKomada");
			double cena = resultSet.getDouble("cena");
			
			Obuca o = new Obuca(vrsta, muske, zenske, djecije, brKomada, cena);

			lista.add(o);
		}
		
		close();
		return lista;
	}
	
	public ArrayList<Obuca> vratiListuDjecijeObuce() throws ClassNotFoundException, SQLException {
		ArrayList<Obuca> lista = new ArrayList<Obuca>();

		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM `obuce` WHERE djecije=1");
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while (resultSet.next()) {
			String vrsta = resultSet.getString("vrsta");
			boolean muske = resultSet.getBoolean("muske");
			boolean zenske = resultSet.getBoolean("zenske");
			boolean djecije = resultSet.getBoolean("djecije");
			int brKomada = resultSet.getInt("brKomada");
			double cena = resultSet.getDouble("cena");
			
			Obuca o = new Obuca(vrsta, muske, zenske, djecije, brKomada, cena);

			lista.add(o);
		}
		
		close();
		return lista;
	}
	
	public void unesiObucuUBazu(Obuca o) throws ClassNotFoundException, SQLException {
		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `obuce`(`vrsta`, `muske`, `zenske`, `djecije`, `brKomada`, `cena`) VALUES (?, ?, ?, ?, ?, ?)");
		preparedStatement.setString(1, o.getVrsta());
		preparedStatement.setBoolean(2, o.isMuske());
		preparedStatement.setBoolean(3, o.isZenske());
		preparedStatement.setBoolean(4, o.isDjecije());
		preparedStatement.setInt(5, o.getBrKomada());
		preparedStatement.setDouble(6, o.getCena());
		preparedStatement.execute();
		
		close();
	}

	

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
