package hocba.ads.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hocba.ConnectionPool;
import hocba.ConnectionPoolImpl;
import hocba.ads.basic.BasicImpl;
import hocba.object.ClassesObject;

public class ClassesImpl extends BasicImpl implements Classes {

	public ClassesImpl(ConnectionPool cp, String objectName) {
		super(cp, "Classes");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addClasses(ClassesObject item) {
		String sql = "INSERT INTO tblclasses(";
        sql += "class_name, class_mainteacher_id, ";
        sql += "class_course, class_student_count ";
        sql += ") ";
        sql += "VALUES(?, ?, ?, ?)";

        //Bien dich
        try {
            PreparedStatement pre = this.conn.prepareStatement(sql);

            //Truyen gia tri
            pre.setString(1, item.getClass_name());
            pre.setInt(2, item.getClass_mainteacher_id());
            pre.setByte(3, item.getClass_course());
            pre.setByte(4, item.getClass_student_count());
          
        
            return this.add(pre);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		
		
		return false;
	}

	@Override
	public boolean editClasses(ClassesObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delClasses(ClassesObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getClasses(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT *FROM tblclasses ";
		sql += "WHERE class_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getClassess(ClassesObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblclasses ";
		sql += "";
		sql += "";
		sql += "ORDER BY class_name ASC ";
		sql += "LIMIT " + at + ", " + total;
		return this.gets(sql);
	}
	
	
	public static void main(String[] args){
		ConnectionPoolImpl cp = new ConnectionPoolImpl();
		
		//ClassesObject item = new ClassesObject();
		
		ClassesImpl test = new ClassesImpl(cp, "Classes");
		ResultSet rs = test.getClassess(null, 0, (byte)5);
		if(rs != null){
			try {
				while(rs.next()){
					System.out.println("Classes: " + rs.getString("class_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
