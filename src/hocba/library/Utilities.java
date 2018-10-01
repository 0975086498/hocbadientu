package hocba.library;
import net.htmlparser.jericho.*;
import javax.servlet.*;
public class Utilities {
    public Utilities() {

    }

    public static String encode(String strUni){
        return CharacterReference.encode(strUni);
    }

    public static String decode(String strUni){
        return CharacterReference.decode(strUni);
    }


    public static int getIntParameter(ServletRequest request, String name){
        int value = -1;
        String strValue = request.getParameter(name);
        System.out.println("str id = " + strValue);
        if(strValue != null && !strValue.equals("")){
            try{
                value = Integer.parseInt(strValue);
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        return value;
    }


    public static byte getByteParameter(ServletRequest request, String name){
       byte value = -1;
       String strValue = request.getParameter(name);
       if(strValue != null && !strValue.equals("")){
           value = Byte.parseByte(strValue);
       }

       return value;
   }


   public static short getShortParameter(ServletRequest request, String name){
       short value = -1;
       String strValue = request.getParameter(name);
       if(strValue != null && !strValue.equals("")){
           value = Short.parseShort(strValue);
       }

       return value;
   }

   public static String getValue(String str){

       return str != null? str.trim() : "";
   }


}
