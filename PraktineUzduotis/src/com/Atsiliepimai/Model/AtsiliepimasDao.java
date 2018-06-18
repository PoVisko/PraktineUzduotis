package com.Atsiliepimai.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;

public class AtsiliepimasDao {
	
	public void addAtsiliepimas(Atsiliepimas atsiliepimas)
	{
		String url = "jdbc:mysql://localhost:3306/db";
		String query = "INSERT INTO atsiliepimai SET vardas=?, miestas=?, pastas=?, atsiliepimas=?";
		try
		{
			Connection conn = DriverManager.getConnection(url, "root", "");
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, atsiliepimas.getVardas());
			st.setString(2, atsiliepimas.getMiestas());
			st.setString(3, atsiliepimas.getPastas());
			st.setString(4, atsiliepimas.getAtsiliepimas());
			st.executeUpdate();
			st.close();
			System.out.println("Inserted successfully");	
		}
		catch (SQLException e)
		{
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
	
	public void showAtsiliepimai(ObservableList<Atsiliepimas> data) {
		String url = "jdbc:mysql://localhost:3306/db";
		String query = "SELECT * FROM atsiliepimai";
		try
		{
			Connection conn = DriverManager.getConnection(url, "root", "");
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				data.add(new Atsiliepimas (
				rs.getInt("id"), 
				rs.getString("miestas"),
				rs.getString("vardas"),
				rs.getString("pastas"),
				rs.getString("atsiliepimas")));
			}
		}
		catch (SQLException e)
		{
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
	
	public void editAtsiliepimas (Atsiliepimas atsiliepimas)
	{
		String url = "jdbc:mysql://localhost:3306/db";
		String query = "UPDATE atsiliepimai SET vardas=?, miestas=?, pastas=?, atsiliepimas=? WHERE id=?";
		try
		{
			Connection conn = DriverManager.getConnection(url, "root", "");
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, atsiliepimas.getVardas());
			st.setString(2, atsiliepimas.getMiestas());
			st.setString(3, atsiliepimas.getPastas());
			st.setString(4, atsiliepimas.getAtsiliepimas());
			st.setInt(5, atsiliepimas.getId());
			st.executeUpdate();
			st.close();
			System.out.println("Updated successfully");	
		}
		catch (SQLException e)
		{
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
	
	
	public void deleteAtsiliepimas(int id)
	{
		String url = "jdbc:mysql://localhost:3306/db";
		String query = "DELETE FROM atsiliepimai WHERE id=" + id;
		try
		{
			Connection conn = DriverManager.getConnection(url, "root", "");
			PreparedStatement st = conn.prepareStatement(query);
			st.executeUpdate();
			st.close();
			System.out.println("Deleted successfully");	
		}
		catch (SQLException e)
		{
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
}
