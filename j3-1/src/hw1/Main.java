package hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 1)
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("1)\nBefore: " + Arrays.toString(intArray));
        Swapper<Integer> s1 = new Swapper<>();
        s1.swapElements(1, 2, intArray);
        System.out.println("After: " + Arrays.toString(intArray));

        String[]strArray = {"s1", "s2", "s3", "s4", "s5"};
        System.out.println("Before: " + Arrays.toString(strArray));
        Swapper<String> s2 = new Swapper<>();
        s2.swapElements(0, 4, strArray);
        System.out.println("After: " + Arrays.toString(strArray));

        // 2)
        String[] array = {"a1", "a2", "a3"};
        System.out.println("2)\nBefore: " + Arrays.toString(array));
        SomeArray<String> sa = new SomeArray(array);
        System.out.println("After: " + sa.toArrayList().toString());

        // 3)
        System.out.println("3)");
        Box<Orange> box1 = new Box(1);
        box1.addFruits(new Orange(),10);
        System.out.println("Вес (коробка " + box1.getId() + "): " + box1.getWeight());

        Box<Apple> box2 = new Box(2);
        box2.addFruits(new Apple(),5);
        System.out.println("Вес (коробка " + box2.getId() + "): " + box2.getWeight());

        // сравниваем вес коробок
        compOut(box1, box2);

        box2.addFruits(new Apple(),10);
        System.out.println("Вес (коробка " + box2.getId() + "): " + box2.getWeight());
        compOut(box1, box2);

        // пересыпаем из одной коробки в другую
        Box<Orange> box3 = new Box(3);
        box3.addFruits(new Orange(),1);
        System.out.println("\nВес (коробка " + box3.getId() + "): " + box3.getWeight());
        box1.toBox(box3);
        System.out.println("Вес (коробка " + box3.getId() + "): " + box3.getWeight());
        System.out.println("Вес (коробка " + box1.getId() + "): " + box1.getWeight());
    }

    private static void compOut(Box<?> box1, Box<?> box2) {
        if (box1.compare(box2)) {
            System.out.println("Вес коробок " + box1.getId() + " и " + box2.getId() +  " равен.");
        } else {
            System.out.println("Вес коробок " + box1.getId() + " и " + box2.getId() + " НЕ равен.");
        }
    }
}

class SomeArray<T> {
    private T[] array;

    SomeArray(T[] array) {
        this.array = array;
    }

    ArrayList<?> toArrayList() {
        return new ArrayList<>(Arrays.asList(array));
    }
}

class Swapper<T> {

    void swapElements(int i1, int i2, T[] array) {
        T elem;

        elem = array[i2];
        array[i2] = array[i1];
        array[i1] = elem;
    }
}
