package JavaAdvanced.Ss12;

public class DbConfig {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String HOST = "localhost";
    public static final int PORT = 3306;
    public static final String USER = "root";
    public static final String PASS = "Phq#1812";


    public static String getURL(String dbName) {
        return "jdbc:mysql://" + HOST + ":" + PORT + "/" + dbName +
                "?useSSL=false&allowPublicKeyRetrieval=true";
    }
}