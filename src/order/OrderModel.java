package src.order;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import src.db.DatabaseConnection;
import src.db.DateTimeProvider;
import src.foodModel.FoodItem;
import src.foodModel.FoodMap;

public class OrderModel
{
    private FoodMap menu, order;
    private DatabaseConnection databaseConnection;
    private Connection connection;
    private DateTimeProvider dateTimeProvider;

    public OrderModel()
    {
        this.databaseConnection = DatabaseConnection.getInstance();
        order = new FoodMap();
        this.dateTimeProvider = new DateTimeProvider();
    }

    public FoodMap getMenu()
    {
        return menu;
    }

    public void populateMenu(FoodMap menu)
    {
        this.menu = menu;
    }

    public FoodMap getOrder()
    {
        return order;
    }

    public void addItemtoOrder(FoodItem food)
    {
        order.addFood(food);
    }

    public void clearOrder()
    {
        order.clearFood();
    }

    public FoodMap readMenuFromDatabase()
    {
        try
        {
            connection = databaseConnection.getConnection();
            String query = "select item_id, name, price from MenuItems";
            FoodMap foodMap = new FoodMap();
            PreparedStatement prepared = connection.prepareStatement(query);
            ResultSet rs = prepared.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("item_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                BigDecimal priceAsBigDecimal = new BigDecimal(price).divide(new BigDecimal(100)).setScale(2);
                
                FoodItem foodItem = new FoodItem(name, priceAsBigDecimal, id);
                foodMap.addFood(foodItem);
            }
            databaseConnection.closeConnection();
            return foodMap;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void insertOrderToDatabase()
    {
        try
        {
            connection = databaseConnection.getConnection();
            String insertOrderQuery = "insert into Orders (order_date, total_price) values (?, ?)";
            PreparedStatement insertOrderStatement = connection.prepareStatement(insertOrderQuery);
            insertOrderStatement.setString(1, dateTimeProvider.getCurrentDateTimeAsString());
            insertOrderStatement.setInt(2, order.getPrice().multiply(BigDecimal.valueOf(100)).intValue());
            insertOrderStatement.executeUpdate();

            ResultSet generatedKeys = insertOrderStatement.getGeneratedKeys();
            int orderId = -1;
            
            if (generatedKeys.next())
            {
                orderId = generatedKeys.getInt(1);
            }
            else
            {
                throw new SQLException("Failed to retrieve auto-generated order ID.");
            }

            String insertOrderItemQuery = "insert into OrderItems (order_id, item_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement insertOrderItemStatement = connection.prepareStatement(insertOrderItemQuery);
            Map<FoodItem, Integer> orderMap = getOrder().getMap();
            for (Map.Entry<FoodItem, Integer> entry: orderMap.entrySet())
            {
                FoodItem foodItem = entry.getKey();
                int quantity = entry.getValue();
                insertOrderItemStatement.setInt(1, orderId);
                insertOrderItemStatement.setInt(2, foodItem.getFoodId());
                insertOrderItemStatement.setInt(3, quantity);
                insertOrderItemStatement.executeUpdate();
            }
            insertOrderStatement.close();
            insertOrderItemStatement.close();
            databaseConnection.closeConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
