package hocba.ads.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hocba.ConnectionPool;
import hocba.ConnectionPoolImpl;
import hocba.ads.basic.BasicImpl;

import hocba.object.StudentObject;

public class StudentImpl extends BasicImpl implements Student {

	public StudentImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addStudent(StudentObject item) {
		String sql = "INSERT INTO tblstudent(";
        sql += "student_sex, student_nation, ";
        sql += "student_birthday, student_birthplace, ";
        sql += "student_address, student_phone, ";
        sql += "student_hobbis, ";
        sql += "student_family_note, student_father_name, ";
        sql += "student_father_birthday, student_father_job, ";
        sql += "student_father_phone, student_mother_name, ";
        sql += "student_mother_birthday, ";
        sql += "student_mother_job, student_mother_phone, ";
        sql += "student_name, student_class_id, ";
        sql += "student_accademic_year_id";
        
        sql += ") ";
        sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        //Bien dich
        try {
            PreparedStatement pre = this.conn.prepareStatement(sql);

            //Truyen gia tri
            pre.setByte(1, item.getStudent_sex());
            pre.setString(2, item.getStudent_nation());
            pre.setDate(3, item.getStudent_birthday());
            pre.setString(4, item.getStudent_birthplace());
            pre.setString(5, item.getStudent_address());
            pre.setString(6, item.getStudent_phone());
            pre.setString(7, item.getStudent_hobbis());
            pre.setString(8, item.getStudent_family_note());
            pre.setString(9, item.getStudent_father_name());
            pre.setDate(10, item.getStudent_father_birthday());
            pre.setString(11, item.getStudent_father_job());
            pre.setString(12, item.getStudent_father_phone());
            pre.setString(13, item.getStudent_mother_name());
            pre.setDate(14, item.getStudent_mother_birthday());
            pre.setString(15, item.getStudent_mother_job());
            pre.setString(16, item.getStudent_mother_phone());
            pre.setString(17, item.getStudent_name());
            pre.setInt(18, item.getStudent_id());
            pre.setInt(19, item.getStudent_accademic_year_id());
          
          
            return this.add(pre);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return false;
		
	}

	@Override
	public boolean editStudent(StudentObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delStudent(StudentObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT *FROM tblstudent ";
		sql += "LEFT JOIN ON tblclasses student_classes_id = classes_id";
		sql += "WHERE student_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getStudents(StudentObject similar, int at, byte total) {
		String sql = "SELECT *FROM tblstudent ";
		sql += "LEFT JOIN ON tblclasses student_classes_id = classes_id";
		sql += "ORDER BY student_id ";
		sql += "LIMIT " + at + ", " + total;
		return this.gets(sql);
	}
	
	public static void main(String[] args){
		ConnectionPoolImpl cp = new ConnectionPoolImpl();
		
		//ClassesObject item = new ClassesObject();
		
		StudentImpl test = new StudentImpl(cp, "Student");
		ResultSet rs = test.getStudents(null, 0, (byte)10);
		if(rs != null){
			try {
				while(rs.next()){
					System.out.println("Student: " + rs.getString("student_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
