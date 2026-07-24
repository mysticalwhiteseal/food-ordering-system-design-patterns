package src.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private static DatabaseConnection instance;
    private Connection connection;
    
    private DatabaseConnection() {}

    public static synchronized DatabaseConnection getInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:./db/restaurant.db");
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
