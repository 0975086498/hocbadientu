package hocba.ads.subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hocba.ConnectionPool;
import hocba.ConnectionPoolImpl;
import hocba.ads.basic.BasicImpl;

import hocba.object.SubjectObject;

public class SubjectImpl extends BasicImpl implements Subject {

	public SubjectImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * @author Good_Boy
	 */
	public boolean addSubject(SubjectObject item) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tblsubject(";
        sql += "subject_name, subject_teacher_id, ";
        sql += "subject_term1_score_15, subject_term1_score_45_1, ";
        sql += "subject_term1_score_45_2, subject_term1_score_average, ";
        sql += "subject_term1_score_test, subject_term1_score_final, ";
        sql += "subject_term2_score_15, subject_term2_score_45_1, ";
        sql += "subject_term2_score_45_2, ";
        sql += "subject_term2_score_average, subject_term2_score_test, ";
        sql += "subject_term2_score_final, subject_accademic_year_id";
        sql += ") ";
        sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        //Bien dich
        try {
            PreparedStatement pre = this.conn.prepareStatement(sql);

            //Truyen gia tri
            pre.setString(1, item.getSubject_name());
            pre.setInt(2, item.getSubject_teacher_id());
            pre.setByte(3, item.getSubject_term1_score_15());
            pre.setByte(4, item.getSubject_term1_score_45_1());
            pre.setByte(5, item.getSubject_term1_score_45_2());
            pre.setInt(6, item.getSubject_term1_score_average());
            pre.setByte(7, item.getSubject_term1_score_test());
            pre.setByte(8, item.getSubject_term1_score_final());
            pre.setByte(9, item.getSubject_term2_score_15());
            pre.setByte(10, item.getSubject_term2_score_45_1());
            pre.setByte(11, item.getSubject_term2_score_45_2());
            pre.setByte(12, item.getSubject_term2_score_average());
            pre.setByte(13, item.getSubject_term2_score_test());
            pre.setByte(14, item.getSubject_term2_score_final());
            pre.setInt(15, item.getSubject_accademic_year_id());
            
          
          
            return this.add(pre);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean editSubject(SubjectObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delSubject(SubjectObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getSubject(int id) {
		String sql = "SELECT * FROM tblsubject ";
		sql += "WHERE subject_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getSubjects(SubjectObject similar, int at, byte total) {
		String sql = "SELECT * FROM tblsubject ";
		sql += "";
		sql += "";
		sql += "ORDER BY subject_id ASC ";
		sql += "LIMIT " + at +", " + total;
		return this.gets(sql);
	}
	
	public static void main(String[] args){
		ConnectionPoolImpl cp = new ConnectionPoolImpl();
		
		//ClassesObject item = new ClassesObject();
		SubjectObject item = new SubjectObject();
		item.setSubject_name("Toán cao cấp 1");
		SubjectImpl test = new SubjectImpl(cp, "Subeject");
		ResultSet rs = test.getSubjects(null, 0, (byte)10);
		if(rs != null){
			try {
				while(rs.next()){
					System.out.println("Subject_name: " + rs.getString("subject_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
