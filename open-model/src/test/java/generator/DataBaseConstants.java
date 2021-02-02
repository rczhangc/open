package generator;

/**
 * @author barnak
 */
public interface DataBaseConstants {

    String JDBC_MYSQL_URL = "jdbc:mysql://localhost:3306/local_bsx_db?" +
            "serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";

    String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    String JDBC_USERNAME = "root";

    String JDBC_PASSWORD = "123456";
}
