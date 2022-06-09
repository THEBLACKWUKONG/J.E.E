package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.form;

public class daoform {

	
 private static Connection cnx = null;
 
 private static void Startconnection() {
	 try {
	 Class.forName("com.mysql.jbdc.driver");
	 cnx = DriverManager.getConnection("jbdc:mysql://localhost:3306/qcm", "root", "");
	 
	 }catch(Exception e) {System.out.println(e);}
 }
 
 public  static List<form> getform(int id_question){
	 List <form> lform= new ArrayList<form>();
	 
	 try {
		 Startconnection();
		 String  sql = "select * FROM form";
		 ResultSet rs =cnx.prepareStatement(sql).executeQuery();
		 while (rs.next()) {
			 form fo = new form();
			  fo.setid_form(rs.getInt(1));
			  fo.setlib_form(rs.getString(2));
			  
			  lform.add(fo);
			  
		 }
		 cnx.close();
		 
	 }catch (Exception e) {System.out.println(e);}
	return lform;
	 
 }
 
}
