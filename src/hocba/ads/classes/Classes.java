package hocba.ads.classes;

import hocba.object.ClassesObject;

import java.sql.ResultSet;

public interface Classes {
	public boolean addClasses(ClassesObject item);
    public boolean editClasses(ClassesObject item);
    public boolean delClasses(ClassesObject item);

    //Cac chuc nang truy van du lieu
    public ResultSet getClasses(int id);
    public ResultSet getClassess(ClassesObject similar, int at, byte total);
}
