package src;

import src.login.LoginController;
import src.login.LoginModel;
import src.login.LoginView;
import src.order.OrderController;
import src.order.OrderModel;
import src.order.OrderView;

public class FoodOrderingSystemClient 
{
    public static void main(String[] args)
    {
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginModel, loginView);

        OrderModel orderModel = new OrderModel();
        OrderView orderView = new OrderView();
        OrderController orderController = new OrderController(orderModel, orderView);

        loginController.addObserver(orderController);
    }    
}