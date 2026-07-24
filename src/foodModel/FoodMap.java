package src.foodModel;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class FoodMap
{
    private Map<FoodItem, Integer> foodMap;

    public FoodMap()
    {
        foodMap = new LinkedHashMap<>();
    }

    public void addFood(FoodItem food) 
    {
        if (foodMap.containsKey(food))
        {
            int quantity = foodMap.get(food);
            foodMap.put(food, quantity + 1);
        }
        else
        {
            foodMap.put(food, 1);
        } 
    }

    public void clearFood()
    {
        foodMap.clear();
    }

    public Map<FoodItem, Integer> getMap()
    {
        return this.foodMap;
    }

    public BigDecimal getPrice() 
    {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<FoodItem, Integer> entry : foodMap.entrySet()) 
        {
            totalPrice = totalPrice.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return totalPrice;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<FoodItem, Integer> entry : foodMap.entrySet())
        {
            sb.append(entry.getKey().toString()).append("\t" +entry.getValue() +"\n");
        }
        return sb.toString();
    }
}
