package src.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.db.DatabaseConnection;

public class LoginModel
{
    private DatabaseConnection databaseConnection;
    private Connection connection;

    public LoginModel()
    {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    public boolean authenticateLogin(String username, String password)
    {
        try
        {
            connection = databaseConnection.getConnection();
            String query = "select username, password from LoginCreds";
            PreparedStatement prepared = connection.prepareStatement(query);
            ResultSet rs = prepared.executeQuery();
            String user = rs.getString("username");
            String pass = rs.getString("password");
            databaseConnection.closeConnection();
            return user.equals(username) && pass.equals(password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}