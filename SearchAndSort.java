package NewOne;

import java.util.ArrayList;

public class SearchAndSort {
    public static void merge(ArrayList<DishItem> dishItems) {
        if (dishItems.size() <= 1) {
            return;
        }
        int midValue = dishItems.size() / 2;
        ArrayList<DishItem> firstDishItem = new ArrayList<>(midValue);
        ArrayList<DishItem> secondDishItem = new ArrayList<>(dishItems.size() - midValue);
        for (int i = 0; i < midValue; i++) {
            firstDishItem.add(dishItems.get(i));
        }

        for (int i = 0; i < (dishItems.size() - midValue); i++) {
            secondDishItem.add(dishItems.get(i + midValue));
        }

        merge(firstDishItem);
        merge(secondDishItem);
        mergeSort(firstDishItem, secondDishItem, dishItems);
    }

    public static void mergeSort(ArrayList<DishItem> leftArr, ArrayList<DishItem> rightArr, ArrayList<DishItem> arr) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i).getPrice() < rightArr.get(j).getPrice()) {
                arr.set(k, leftArr.get(i));
                i++;
            } else {
                arr.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }

        while (i < leftArr.size()) {
            arr.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while (j < rightArr.size()) {
            arr.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }

    public static int binarySearch(ArrayList<DishItem> a, int low, int high, int value) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid).getPrice() == value) {
                return mid;
            } else if (a.get(mid).getPrice() < value) {
                return binarySearch(a, mid + 1, high, value);
            } else {
                return binarySearch(a, low, mid - 1, value);
            }
        } else {
            return -1;
        }
    }
}

