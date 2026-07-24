package src.order;
import java.util.List;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.foodModel.FoodItem;
import src.login.LoginObserver;

public class OrderController implements LoginObserver
{
    private final OrderModel orderModel;
    private final OrderView orderView;
    private OrderState currentState;

    public OrderController(OrderModel orderModel, OrderView orderView)
    {
        this.orderModel = orderModel;
        this.orderView = orderView;
        this.currentState = new EmptyCartState(this);
        initModel();
        initView();
    }

    public OrderModel getOrderModel()
    {
        return orderModel;
    }

    public OrderView getOrderView()
    {
        return orderView;
    }

    public OrderState getState()
    {
        return currentState;
    }

    public void setState(OrderState state)
    {
        this.currentState = state;
    }

    @Override
    public void onLoginSuccess()
    {
        orderView.setVisible(true);
    }

    private void initModel()
    {
        orderModel.populateMenu(orderModel.readMenuFromDatabase());
    }

    private void initView()
    {
        orderView.updateItemButtons(orderModel.getMenu());
        initListeners();
    }

    private void initListeners()
    {
        initItemButtonListener();
        initClearOrderButtonListener();
        initCompleteOrderButtonListener();
    }

    private void initItemButtonListener()
    {
        List<JButton> itemButtons = orderView.getListOfItemButtons();
        for (FoodItem key: orderModel.getMenu().getMap().keySet())
        {
            JButton button = findButtonByKey(itemButtons, key);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    currentState.addItem(key);
                }
            });
        }
    }

    private void initClearOrderButtonListener()
    {
        orderView.getClearOrderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                currentState.clearOrder();
            }
        });
    }


    private void initCompleteOrderButtonListener()
    {
        orderView.getCompleteOrderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                currentState.completeOrder();
            }
        });
    }


    private JButton findButtonByKey(List<JButton> buttons, FoodItem key)
    {
        for (JButton button: buttons)
        {
            if (button.getText().equals(key.getName()))
            {
                return button;
            }
        }
        return null;
    }
}
