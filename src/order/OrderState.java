package src.order;
import src.foodModel.FoodItem;

public interface OrderState 
{
    public void addItem(FoodItem food);
    public void clearOrder();
    public void completeOrder();
}
