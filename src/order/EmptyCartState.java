package src.order;
import javax.swing.JOptionPane;

public class EmptyCartState extends BaseOrderState
{
    public EmptyCartState(OrderController context)
    {
        super(context);
    }

    @Override
    public void clearOrder() 
    {
        JOptionPane.showMessageDialog(null,"No items to clear", "Clear order", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void completeOrder() 
    {
        JOptionPane.showMessageDialog(null,"No items ordered", "Place order", JOptionPane.ERROR_MESSAGE);
    }
}
