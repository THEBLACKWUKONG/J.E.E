package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.reponse;

public class daoRep {
	
	public static Connection cnx = null;
	
	public static void StartConnection() {
		try {
		Class.forName("com.mysql.jbdc.Driver");
		cnx = DriverManager.getConnection("jbdc:mysql:localhost://3306/qcm","root","");
	}catch (Exception e){System.out.println(e);}
		
	}
	 
	public static List<reponse> getResp(int id_question){
		 List <reponse> lrep = new ArrayList<reponse>();
		 try {
				String sql = " select * from reponse where id_question=?";
				PreparedStatement PS= cnx.prepareStatement(sql);
				PS.setInt(1,id_question);
				ResultSet rs = PS.executeQuery();
				while (rs.next()) {
					reponse r = new reponse();
					
					
					r.setid_reponse(rs.getInt(1));
					r.setid_reponse(rs.getInt(2));
					r.setlib_reponse(rs.getString(3));
					
					lrep.add(r);}
					
				}catch ( Exception e) {
					System.out.println (e);
				}
				
				
		 
				

			 
			 
			 
		 
		
		
		
		return lrep;
	}
}
