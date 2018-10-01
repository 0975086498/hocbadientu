package hocba.ads.basic;

import java.sql.*;
import hocba.*;
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



public interface Basic extends ShareControl{

    //cau lenh preparedStatement pre
    //da dupc bien dich + da duoc truyen gia tri

    public boolean add(PreparedStatement pre);
    public boolean edit(PreparedStatement pre);
    public boolean del(PreparedStatement pre);

    public ResultSet get(String sql,int value);
    public ResultSet get(String sql,String name, String passs);
    public ResultSet gets(String sql);
    public ResultSet[] gets(String sqls[]);


    //Pt dieu khuyen bo ket noi



}
