package hocba.ads.accout;

import hocba.ConnectionPool;
import hocba.object.AccoutObject;
import hocba.ads.basic.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class AccoutImpl extends BasicImpl implements Accout {

	public AccoutImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	/**
	 * @author Good_Boy
	 */
	public boolean addAccout(AccoutObject item) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tblaccout(";
		sql += "accout_name, accout_pass, ";
		sql += "accout_fullname, accout_mobilephone, ";
		sql += "accout_email, accout_address, ";
		sql += "accout_roles, accout_created_date, ";
		sql += "accout_permission, accout_nation, ";
		sql += "accout_religion";
		sql += ") ";
		sql += "VALUE(?, md5(?), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//Thuc thi cau lenh
		try {
			PreparedStatement pre = (PreparedStatement) this.conn.prepareStatement(sql);
			
			pre.setString(1, item.getAccout_name());
			pre.setString(2, item.getAccout_pass());
			pre.setString(3, item.getAccout_fullname());
			pre.setString(4, item.getAccout_mobilephone());
			pre.setString(5, item.getAccout_email());
			pre.setString(6, item.getAccout_address());
			pre.setString(7, item.getAccout_roles());
			pre.setDate(8, item.getAccout_created_date());
			pre.setByte(9, item.getAccout_permission());
			pre.setString(10, item.getAccout_nation());
			pre.setString(11, item.getAccout_religion());
			
			return this.add(pre);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

	@Override
	public boolean editAccout(AccoutObject item) {
		// TODO Auto-generated method stub
		
		
		
		
		
		return false;
	}

	@Override
	public boolean delAccout(AccoutObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * @author Good_Boy
	 */
	public ResultSet getAccout(int id) {
		String sql = "SELECT * FROM tblaccout WHERE accout_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getAccout(String accout_name, String accout_pass) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblaccout WHERE ";
        sql += "(accout_name) = ? AND (accout_pass) = md5(?)";
        return this.get(sql, accout_name, accout_pass);
		
	}

	@Override
	public ResultSet getAccouts(AccoutObject similar, int at, byte total) {
		String sql = "SELECT * FROM tblaccout ";
		sql += "";
		sql += "";
		sql += "ORDER BY accout_id DESC ";
		sql += "LIMIT " + at + ", " + total;
		return this.gets(sql);
	}

}
