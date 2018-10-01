package hocba.ads.student;

import hocba.object.StudentObject;

import java.sql.ResultSet;

public interface Student {
	public boolean addStudent(StudentObject item);
    public boolean editStudent(StudentObject item);
    public boolean delStudent(StudentObject item);

    //Cac chuc nang truy van du lieu
    public ResultSet getStudent(int id);
    public ResultSet getStudents(StudentObject similar, int at, byte total);
}
