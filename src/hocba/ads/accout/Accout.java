package hocba.ads.accout;
import hocba.object.*;
import java.sql.*;
public interface Accout {
	//Cac chuc nang cap nhat
    public boolean addAccout(AccoutObject item);
    public boolean editAccout(AccoutObject item);
    public boolean delAccout(AccoutObject item);

    //Cac chuc nang truy van du lieu
    public ResultSet getAccout(int id);
    public ResultSet getAccout(String accout_name, String accout_pass);
    public ResultSet getAccouts(AccoutObject similar, int at, byte total);
}
