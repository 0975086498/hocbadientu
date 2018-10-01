package hocba.ads.teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hocba.ConnectionPool;
import hocba.ConnectionPoolImpl;
import hocba.ads.basic.BasicImpl;

import hocba.object.TeacherObject;

public class TeacherImpl extends BasicImpl implements Teacher {

	public TeacherImpl(ConnectionPool cp, String objectName) {
		super(cp, "Teacher");
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public boolean addTeacher(TeacherObject item) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tblteacher(";
        sql += "teacher_accout_id, teacher_notes, ";
        sql += "teacher_permisson";
        sql += ") ";
        sql += "VALUES(?, ?, ?)";

        //Bien dich
        try {
            PreparedStatement pre = this.conn.prepareStatement(sql);

            //Truyen gia tri
            pre.setInt(1, item.getTeacher_accout_id());
            pre.setString(2, item.getTeacher_notes());
            pre.setByte(3, item.getTeacher_permisson());
            
          
          
            return this.add(pre);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean editTeacher(TeacherObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delTeacher(TeacherObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getTeacher(int id) {
		String sql = "SELECT * FROM tblteacher ";
		sql += "LEFT JOIN tblaccout ON teacher_accout_id = accout_id ";
		sql += "WHERE teacher _id = ? ";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getTeachers(TeacherObject similar, int at, byte total) {
		String sql = "SELECT * FROM tblteacher ";
		sql += "LEFT JOIN tblaccout ON teacher_accout_id = accout_id ";
		sql += "";
		sql += "";
		sql += "ORDER BY teacher_id ASC ";
		sql += "LIMIT " + at +", " + total;
		return this.gets(sql);
	}
	
	public static void main(String[] args){
		ConnectionPoolImpl cp = new ConnectionPoolImpl();
		
		//TeacherObject item = new TeacherObject();
		
		
		
		TeacherImpl test = new TeacherImpl(cp, "teacher");
		ResultSet rs = test.getTeachers(null, 0, (byte)10);
		if(rs != null){
			try {
				while(rs.next()){
					System.out.println("Teacher: " + rs.getString("teacher_id") + rs.getString("accout_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
