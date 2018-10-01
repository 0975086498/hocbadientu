package hocba;

import java.sql.*;


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
public interface ConnectionPool {

    public Connection getConnection(String objectName) throws SQLException;


    public void releaseConnection(Connection conn, String objectName) throws SQLException;


}
