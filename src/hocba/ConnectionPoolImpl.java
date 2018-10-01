package hocba;

import hocba.ads.accout.AccoutImpl;
import hocba.ads.teacher.*;
import hocba.object.AccoutObject;








import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

/**
 * <p>Title: JP1802</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * <p>Company: </p>
 *
 * @author ManhHung
 * @version 1.0
 */
public class ConnectionPoolImpl implements ConnectionPool{
	
    //Trinh dieu khien lam viec voi co so du lieu
    private String driver;

    //Duong Dan thuc thi (mySQL)
    private String url;


    //Tai Khoan Dang Nhap Co So Du Lieu
    private String username;
    private String password;

    private Stack<Connection> pool;


    public ConnectionPoolImpl(){
        
        this.username = "root";
        this.password = "123";
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/hocbadientu_data";
        try {
            Class.forName(this.driver).newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }


        //Khoi tao doi tuong luu chu
        this.pool = new Stack<Connection>();
    }




    /**
     * this method to get Connection from Stack  - Nguyen Manh Hung
     * @version 01-29/9/2018
     *
     * @param objectName String
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection(String objectName) throws SQLException {
        //Kiem tra co ket noi
        if(this.pool.isEmpty()){
            System.out.println(objectName + " have created new Connection.");
            return DriverManager.getConnection(this.url,this.username, this.password);

        }else{
            //Lay ket noi da ton tai
            System.out.print(objectName + " have poped the Connection");
            return (Connection) this.pool.pop();
        }



    }


    /**
     * this method release Connection for Stack
     * @param conn Connection
     * @param objectName String
     * @throws SQLException
     */
    public void releaseConnection(Connection conn, String objectName) throws SQLException {
        //Yeu cau tra lai ket noi
        System.out.println(objectName + " Have pushed the Connection.");
        this.pool.push(conn);


    }

    protected void finalize() throws Throwable{
        this.pool.clear();
        this.pool = null;

        super.finalize();
        System.out.println("CP is closed");
    }

   
   /**
    * 
    *@autthor: Good_Boy
    *5:07:02 PM - Oct 1, 2018
    *@param args
    *
    */
	public static void main(String[] args){
        ConnectionPool cp = new ConnectionPoolImpl();
        
//        try {
//			Connection con = cp.getConnection("test");
//			if(con != null) {
//				System.out.println("Thanh cong");
//			}else {
//				System.out.println("fail");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        AccoutObject item = new AccoutObject();
		LocalDate date = LocalDate.now();
		
		
		
		
		
        item.setAccout_created_date(Date.valueOf(date));
        item.setAccout_email("haideptrai@gmail.com");
        item.setAccout_name("haidz");
        item.setAccout_pass("123456");
        item.setAccout_fullname("Nguyễn Trọng Hải");
        
        String sql = "SELECT accout_created_date FROM hocbadientu_data.tblaccout WHERE accout_id = ?";
        
		try {
			Connection con = null;
			con = cp.getConnection("Accout");
			PreparedStatement pre = null;
			pre = con.prepareStatement(sql);
			pre.setInt(1, 4);
			
			ResultSet rs = pre.executeQuery();
			if(rs != null){
				if(rs.next()){
					item.setAccout_created_date(rs.getDate("accout_created_date"));
				}
			}
			
			
			System.out.println("Date now: " + date);
			System.out.println("Accout Date : " + item.getAccout_created_date());
			
			date = item.getAccout_created_date().toLocalDate();
			
			System.out.println("Year: " + date.getYear() + ", Month: " + date.getMonthValue() + ", Day: " + date.getDayOfMonth());
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		AccoutImpl test = new AccoutImpl(cp, "Accout");
		ResultSet rs = test.getAccouts(null, 0, (byte)10);
		if(rs != null){
			try {
				while(rs.next()){
					System.out.println("Accout_name: " + rs.getString("accout_name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

    }





}
