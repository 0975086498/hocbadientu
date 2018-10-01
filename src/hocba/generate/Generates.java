
package hocba.generate;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import hocba.library.*;
import hocba.*;
import hocba.ads.basic.*;

/**
 * @author Nguyen Manh Hung
 * @version 1.0 - 9/29/2018
 */
public class Generates {
	
	Basic basic;
	public Generates() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public static ArrayList<String> tableNames(Connection conn) throws SQLException{
        ArrayList<String> kq = new ArrayList<>();
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "%", null);
        
        
        while(rs.next()){
            if (rs.getString(4).equalsIgnoreCase("TABLE")) {
                kq.add(rs.getString(3));
                
            }
        }
        
        return kq;
    }
	
	/**
	 * 
	 * <p>Description: </p> 
	 * return files classObject mapped database
	 * vietsub : tráº£ vá»� nhiá»�u file objectclass Ã¡nh xáº¡ tá»« database
	 *
	 * <p>Copyright: Copyright (c) 2018</p>
	 *
	 * @author ManhHung
	 * @version 1.0 - 9/29/2018
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void GenerateObjectClass(String pathname , Boolean isSetGetContruc) throws SQLException, IOException {
		ConnectionPool cp = new ConnectionPoolImpl();
		Basic basic = new BasicImpl(cp, "GenerateObjectClass");
		
		
		//lay thong tin ten bang tu database
		ArrayList<String> tables = Generates.tableNames(cp.getConnection("Get table"));
		
		
		
		//Duyet toan bo cac bang
		for(String table : tables) {
			String sql = "SELECT * FROM " + table + " LIMIT 0 ;";
			System.out.println("sql : " + sql);
			ResultSet rs = null;
			rs = basic.get(sql,0);
			
			if(rs != null) {
				ResultSetMetaData rsm = (ResultSetMetaData)rs.getMetaData();
				// tao duong dan cho dau ra
				String pathnametable;
				if(pathname.equals("") || pathname == null){
					pathnametable = MyString.nameSqlToJava(table) + "Object.java";
					
		        }else{
		        	pathnametable = pathname +  "//" + MyString.nameSqlToJava(table) + "Object.java";
		        }
				System.out.println("path name : " + pathnametable);
				
				String dataObjectJava = "public class " + MyString.nameSqlToJava(table) + "Object{\r\n";
				
				int countcol = rsm.getColumnCount();
		        String []name = new String[countcol];
		        String []type = new String[countcol];
		                for(int i = 1; i <= countcol; i++){
		                    name[i-1] =rsm.getColumnName(i);
		                    type[i-1] = MyString.typeSqlToJava(rsm.getColumnTypeName(i));
		                    dataObjectJava += "\t";
		                    dataObjectJava += MyString.typeSqlToJava(rsm.getColumnTypeName(i)) + " " + rsm.getColumnName(i) + ";";
		                    dataObjectJava += "\r\n";
		                }
		                if(isSetGetContruc) {
		                	dataObjectJava += "\r\n\t/*Contructer*/";
			                dataObjectJava += "\r\n\tpublic " + MyString.nameSqlToJava(table) + "Object(){\r\n";
			                dataObjectJava += "\r\n\t}\r\n";
			             
			                dataObjectJava += "\r\n\t/*Contructer full attribute*/";
			                dataObjectJava += "\r\n\tpublic " + MyString.nameSqlToJava(table) + "Object(";
			                for(int i = 0; i < countcol; ++i){
			                    dataObjectJava+= type[i] + " " + name[i];
			                    if(i != countcol - 1){
			                        dataObjectJava += ",";
			                    }
			                }
			                dataObjectJava += "){\r\n";
			                
			                for(int i = 0; i < countcol; ++i){
			                    dataObjectJava += "\t\tthis." + name[i] + " = " + name[i] + ";\r\n";
			                }
			                dataObjectJava += "\r\n\t}\r\n";
			                
			                dataObjectJava += "\r\n\t/*seter*/\r\n";
			                for(int i = 0; i < countcol; ++i){
			                    dataObjectJava += "\tpublic "+ MyString.nameSqlToJava(table) +"Object set" + MyString.upCharHead(name[i]) + "(" + type[i] + " " + name[i] + "){\r\n";
			                    dataObjectJava += "\t\tthis." + name[i] + "=" + name[i] + ";\r\n";
			                    dataObjectJava += "\t\treturn this;\r\n";
			                    dataObjectJava += "\t}\r\n";
			                }
			                dataObjectJava += "\r\n\t/*geter*/\r\n";
			                for(int i = 0; i < countcol; ++i){
			                    dataObjectJava += "\tpublic " + type[i] + " get" + MyString.upCharHead(name[i]) + "(){\r\n";
			                    dataObjectJava += "\t\treturn this."+ name[i] + ";\r\n";
			                    dataObjectJava += "\t}\r\n";
			                }
		                }
		                
		                
		               
		                
		                
		                
		                
		                dataObjectJava += "}";
		                
		                MyFile.writeFile(pathnametable, dataObjectJava , false);
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<String> tables;
		
		
		
		try {
			tables = Generates.tableNames(new ConnectionPoolImpl().getConnection("test"));
			for(String v : tables) {
				System.out.println(v);
			}
			
			try {
				Generates.GenerateObjectClass("src//hocba//object",false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
