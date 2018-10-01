package hocba.ads.teacher;

import hocba.object.TeacherObject;

import java.sql.ResultSet;

public interface Teacher {
	public boolean addTeacher(TeacherObject item);
    public boolean editTeacher(TeacherObject item);
    public boolean delTeacher(TeacherObject item);

    //Cac chuc nang truy van du lieu
    public ResultSet getTeacher(int id);
    public ResultSet getTeachers(TeacherObject similar, int at, byte total);
}
