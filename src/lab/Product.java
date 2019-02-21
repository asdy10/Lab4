package lab;

public class

Product {

    private float cost;
    private int count;
    private String name;
    private int marketId;
    public Product(String name){
        this.name = name;
    }

    public Product(String name, int marketId, int count, float cost){
        this.name = name;
        this.marketId = marketId;
        this.count = count;
        this.cost = cost;
    }
    public float getCost() { return cost; }

    public int getCount() { return count; }

    public String getName() { return name; }

    public int getMarketId() { return marketId; }

    @Override
    public String toString() {
        return name + "," + marketId + "," + count + "," + cost + ",";
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public void setCount(int count){
        this.count += count;
    }

    public void setMarket(int marketId){ this.marketId = marketId; }


}
