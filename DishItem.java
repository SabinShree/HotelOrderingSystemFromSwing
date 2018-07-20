package NewOne;

public class DishItem {
    private int dishNumber;
    private String category;
    private String dishName;
    private int spicinessName;
    private int price;

    public DishItem(int dishNumber, String dishName, String category, int spicinessName, int price) {
        this.dishNumber = dishNumber;
        this.category = category;
        this.dishName = dishName;
        this.spicinessName = spicinessName;
        this.price = price;
    }

    public int getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(int dishNumber) {
        this.dishNumber = dishNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getSpicinessName() {
        switch (spicinessName) {
            case 0:
                return "Very Hot";
            case 1:
                return "Medium Hot";
            default:
                return "Mild Hot";
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}


