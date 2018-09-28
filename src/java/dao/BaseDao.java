package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public abstract class BaseDao {

    public final String DB = "flightsystem";
    // public final String HOST = "localhost:3306";
    // public final String USERNAME = "root";
    // public final String PASSWORD = "";
    
    public final String HOST = "flightsystem.czis7piqcxqi.ap-southeast-2.rds.amazonaws.com:3306";
    public final String USERNAME = "maxmauts";
    public final String PASSWORD = "SEP02SEP!";
    

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DB + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false", USERNAME, PASSWORD);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
