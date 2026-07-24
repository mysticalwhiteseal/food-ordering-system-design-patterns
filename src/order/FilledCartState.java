package src.order;
import javax.swing.JOptionPane;

public class FilledCartState extends BaseOrderState
{
    public FilledCartState(OrderController context)
    {
        super(context);
    }

    @Override
    public void clearOrder() 
    {
        context.getOrderModel().clearOrder();
        context.getOrderView().clearSelectedItems();
        context.setState(new EmptyCartState(context));
    }
    
    @Override
    public void completeOrder() 
    {
        context.getOrderModel().insertOrderToDatabase();
        JOptionPane.showMessageDialog(null, "Order has been logged and sent to the kitchen", "Place order", JOptionPane.INFORMATION_MESSAGE);
        clearOrder();
    }
}
