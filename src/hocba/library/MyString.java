package hocba.library;



/**
 *
 * @author saga
 */
public class MyString {
    public static String typeSqlToJava(String str){
        
        if(str.equals("INT UNSIGNED") || str.equals("INT")){
            return "int";
        }
        if(str == "VARCHAR" || str == "CHAR" || str == "LONGVARCHAR"){
            return "String";
        }
        if(str == "SMALLINT" || str == "SMALLINT UNSIGNED"){
            return "short";
        }
        if(str == "TINYINT" || str == "TINYINT UNSIGNED"){
            return "byte";
        }
        if(str == "BIT"){
            return "boolean";
        }
        if(str == "BIGINT" || str == "BIGINT UNSIGNED"){
            return "long";
        }
        if(str == "FLOAT" || str == "FLOAT UNSIGNED")
            return "float";
        if(str == "DOUBLE" || str == "DOUBLE UNSIGNED"){
            return "double";
        }
        
        
        return "NULL";
    }
 
    public static String upCharHead(String str){
        StringBuffer rs = new StringBuffer(str);
        
      
       	
        char c = rs.charAt(0);
        c = Character.toUpperCase(c);  
        rs.replace(0, 1, Character.toString(c));
        return rs.toString();
    }
    
    public static String nameSqlToJava(String str){
        
        StringBuffer rs = new StringBuffer(str);
     	while(rs.indexOf("_") != -1 && rs.charAt(rs.indexOf("_") + 1) != Character.toUpperCase(rs.charAt(rs.indexOf("_") + 1)) ) {
       		int i = rs.indexOf("_");
       	
       		char tmp = Character.toUpperCase(rs.charAt(i+1));
       		rs.replace(i+1, i+2, Character.toString(tmp));
       		
       	}
        
        char c = str.charAt(3);
        c = Character.toUpperCase(c);
        rs.replace(0, 4, Character.toString(c));
        
        
        return rs.toString();
    }
}

