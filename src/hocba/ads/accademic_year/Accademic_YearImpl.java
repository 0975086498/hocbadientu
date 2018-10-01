package hocba.ads.accademic_year;

import hocba.ConnectionPool;
import hocba.ConnectionPoolImpl;
import hocba.ads.basic.BasicImpl;
import hocba.object.Accademic_YearObject;

import java.sql.*;


public class Accademic_YearImpl extends BasicImpl implements Accademic_Year{

	public Accademic_YearImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * @author Good_Boy
	 * 
	 */
	public boolean addAccademic_Year(Accademic_YearObject item) {
		String sql = "INSERT INTO tblaccademic_year(";
        sql += "accademic_year_student_id, accademic_year_status, ";
        sql += "accademic_year_notes, accademic_year_score_final, ";
        sql += "accademic_year_score_term_1, accademic_year_score_term_2";
        
        sql += ") ";
        sql += "VALUES(?, ?, ?, ?, ?, ?)";

        //Bien dich
        try {
            PreparedStatement pre = this.conn.prepareStatement(sql);

            //Truyen gia tri
            pre.setInt(1, item.getAccademic_year_student_id());
            pre.setShort(2, item.getAccademic_year_status());
            pre.setString(3, item.getAccademic_year_notes());
            pre.setByte(4, item.getAccademic_year_score_final());
            pre.setByte(5, item.getAccademic_year_score_term_1());
            pre.setByte(6, item.getAccademic_year_score_term_2());
          
          
            return this.add(pre);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return false;
	}

	
	@Override
	public boolean editAccademic_Year(Accademic_YearObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delAccademic_Year(Accademic_YearObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getAccademic_Year(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblaccademic_year ";
		sql += "WHERE accademic_year_id = ? ";
		return this.get(sql, id);
	}

	@Override
	/**
	 * @author Good_Boy
	 */
	public ResultSet getAccademic_Years(Accademic_YearObject similar, int at,
			byte total) {
		String sql = "SELECT * FROM tblaccademic_year ";
		sql += "";
		sql += "";
		sql += "ORDER BY accademic_year_id ASC ";
		sql += "LIMIT " + at +", " + total;
		return this.gets(sql);
	}
	
	
	public static void main(String[] args) {
		ConnectionPoolImpl cp = new ConnectionPoolImpl();
		
		Accademic_YearObject item = new Accademic_YearObject();
		item.setAccademic_year_student_id(1);
		Accademic_YearImpl test = new Accademic_YearImpl(cp, "Accademic_year");
		ResultSet rs = test.getAccademic_Years(null, 0, (byte)10);
		if(rs != null){
			try {
				while(rs.next()){
					System.out.println("Accademic_year : " + rs.getInt("accademic_year_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
