package hw1;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private int id; // номер коробки
    private List<T> fruits = new ArrayList<>();

    Box(int id) {
        this.id  = id;
    }

    int getId() {
        return id;
    }

    void addFruits(T fruit, int n) {
        for (int i = 0; i < n; i++) {
            fruits.add(fruit);
        }
        System.out.println("В коробку " + id + " добавлено " + n + " фруктов (" + fruit.getFruitName() + ").");
    }

    double getWeight() {
        double weight = 0;

        for (Fruit fruit: fruits) {
            weight += fruit.getWeight();
            //System.out.println(weight);
        }
        return weight;
    }

    boolean compare(Box<?> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001;
    }

    void toBox(Box<T> box) {
        if (fruits.size() > 0) {
            box.addFruits(fruits.get(0), fruits.size());
            fruits.clear();
        }
    }
}
