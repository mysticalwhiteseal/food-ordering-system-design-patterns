package src.foodModel;
import java.math.BigDecimal;

public class FoodItem
{
	private String name;
	private BigDecimal price;
	private int foodId;
	
	public FoodItem(String name, BigDecimal price, int foodId) 
	{
		this.name = name;
		this.price = price;
		this.foodId = foodId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public BigDecimal getPrice()
	{
		return price;
	}

	public int getFoodId()
	{
		return foodId;
	}

	@Override
	public String toString()
	{
		return name + " \nRM" + price;
	}	
}


