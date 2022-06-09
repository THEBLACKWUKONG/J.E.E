package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.question;

public class daoques {
	private static Connection cnx=null;
	
	public static void StartConnection () {
		try {
			Class.forName("com.mysql.jbdc.Driver");
			cnx = DriverManager.getConnection("jbdc:mysql:localhost://3306/qcm","root","");
		}catch (Exception e) {System.out.println(e);}
	}
	 public static List<question> getQuest(int id_form){
		 List<question> lquest = new  ArrayList<question>();
		 
		 try {
			 StartConnection();
			 String sql = "select * from question where id_form=?";
			 PreparedStatement s = cnx.prepareStatement(sql);
			 s.setInt(1,id_form);
			 ResultSet rs = s.executeQuery();
			 while (rs.next()) {
				 question q = new question();
				 
				 q.setid_form(rs.getInt(1));
				 q.setid_question(rs.getInt(2));
				 q.setlib_question(rs.getString(3));
				 
				 lquest.add(q);}
				 
			 }catch ( Exception e) {System.out.println(e);
		 }
		
		return lquest;
		 
	 }

}
