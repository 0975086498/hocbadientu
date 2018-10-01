package hocba.ads.accademic_year;

import hocba.object.Accademic_YearObject;

import java.sql.ResultSet;

public interface Accademic_Year {
	public boolean addAccademic_Year(Accademic_YearObject item);
    public boolean editAccademic_Year(Accademic_YearObject item);
    public boolean delAccademic_Year(Accademic_YearObject item);

    //Cac chuc nang truy van du lieu
    public ResultSet getAccademic_Year(int id);
    public ResultSet getAccademic_Years(Accademic_YearObject similar, int at, byte total);
}
