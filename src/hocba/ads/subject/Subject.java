package hocba.ads.subject;

import hocba.object.SubjectObject;

import java.sql.ResultSet;

public interface Subject {
	public boolean addSubject(SubjectObject item);
    public boolean editSubject(SubjectObject item);
    public boolean delSubject(SubjectObject item);

    //Cac chuc nang truy van du lieu
    public ResultSet getSubject(int id);
    public ResultSet getSubjects(SubjectObject similar, int at, byte total);
}
