package src.order;
import src.foodModel.FoodItem;

public abstract class BaseOrderState implements OrderState 
{
    protected OrderController context;

    public BaseOrderState(OrderController context)
    {
        this.context = context;
    }

    @Override
    public void addItem(FoodItem food)
    {
        context.getOrderModel().addItemtoOrder(food);
        context.getOrderView().refreshPanel(food, context.getOrderModel().getOrder());
        context.setState(new FilledCartState(context));
    }

    public abstract void clearOrder();
    public abstract void completeOrder();
}
