package NewOne.model;

import NewOne.DishItem;

import java.util.ArrayList;

// Singleton class.
public class DishItemFileSystem {
    private static DishItemFileSystem ourInstance = new DishItemFileSystem();
    private ArrayList<DishItem> dishItemArrayList = new ArrayList<>();

    public static DishItemFileSystem getOurInstance() {
        return ourInstance;
    }

    private DishItemFileSystem() {
    }

    public ArrayList<DishItem> getDishItemArrayList() {
        return dishItemArrayList;
    }

    public void AddDishItems(DishItem dishItem) {
        this.dishItemArrayList.add(dishItem);
    }


}
