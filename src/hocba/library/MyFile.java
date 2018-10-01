package hocba.library;

import java.io.*;

/**
 *
 * <p>Title: Hoc Ba Dien Tu</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * <p>Company: </p>
 *
 * @author Nguyen Manh Hung
 * @version 1.0
 */



public class MyFile {

    public MyFile() {
    }
    
   
    public static void writeFile(String pathname, String data, boolean isDe) throws
            IOException {



        File f = new File(pathname);

        if (!f.exists()) {
            f.createNewFile();
        }

        FileWriter fw = new FileWriter(f, isDe);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(data);

        bw.close();
        fw.close();


    }



    public int a(int a) {
    	return a;
    }



}
