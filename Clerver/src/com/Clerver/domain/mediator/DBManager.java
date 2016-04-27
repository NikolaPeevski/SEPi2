package com.Clerver.domain.mediator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Clerver.controller.Utility;

public class DBManager {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	/**
	 * Standard database manager constructor.
	 * NOTE: it needs com.mysql.jdbc.Driver to work!! (it's included in the project).
	 * In chance of database name or location replace getConnection(-Location of the database-, -Username-, -password-);
	 */
	public DBManager(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clerver", "root", "");
				st = con.createStatement();
			}catch(Exception e){
				e.printStackTrace();
			};
	}
	/**
	 * Compiles the username from the other methods.
	 */
	public String genitemName(){
		return getFront() + " " + getMiddle() + " " + getEnd();
	}
	/**
	 * Gets the size of the culums, makes it dynamic so you can add more itesm, without changing the code.
	 */
	private int getSizeOfFront(){
		try{
			String query = "SELECT COUNT(Front) FROM itemName";
			rs = st.executeQuery(query);
			rs.next();
			return Integer.parseInt(rs.getString("COUNT(Front)"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	private int getSizeOfMiddle(){
		try{
			String query = "SELECT COUNT(middle) FROM itemName";
			rs = st.executeQuery(query);
			rs.next();
			return Integer.parseInt(rs.getString("COUNT(middle)"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	private int getSizeOfEnd(){
		try{
			String query = "SELECT COUNT(end) FROM itemName";
			rs = st.executeQuery(query);
			rs.next();
			return Integer.parseInt(rs.getString("COUNT(end)"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * Returns the preffix of the name based on random number generation. It generates the number of the row and then using rs.next() it moves the cursor to the desired row. Returns the row's value into String.
	 */
	public String getFront(){
		try{
			String query = "Select Front from itemName;";
			int size = getSizeOfFront();
			rs = st.executeQuery(query);
			rs.next();
			for(int i = 0;i<Utility.randInt(1, size)-1;i++){
				rs.next();
			}
			return rs.getString("Front");
		}catch(Exception e){
			
		}
		return "";
	}
	/**
	 * Returns the word stem of the name based on random number generation. It generates the number of the row and then using rs.next() it moves the cursor to the desired row. Returns the row's value into String.
	 */
	public String getMiddle(){
		try{
			String query = "Select middle from itemName;";
			int size = getSizeOfMiddle();
			rs = st.executeQuery(query);
			rs.next();
			for(int i = 0;i<Utility.randInt(1, size)-1;i++){
				rs.next();
			}
			return rs.getString("middle");
		}catch(Exception e){
			
		}
		return "";
	}

	/**
	 * Returns the suffix of the name based on random number generation. It
	 * generates the number of the row and then using rs.next() it moves the
	 * cursor to the desired row. Returns the row's value into String.
	 */
	public String getEnd(){
		try{
			String query = "Select end from itemName;";
			int size = getSizeOfEnd();
			rs = st.executeQuery(query);
			rs.next();
			for(int i = 0;i<Utility.randInt(1, size)-1;i++){
				rs.next();
			}
			return rs.getString("end");
		}catch(Exception e){
			
		}
		return "";
	}
}
