public class Room {
    private String name;
    private float basePrice;

    public Room(String name, float basePrice){
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }
}
