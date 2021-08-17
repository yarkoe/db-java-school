package homework.lab1;

public class Main {
    public static void main(String[] args) {
        SuperIntegerList superIntegerList = ArraySuperIntegerList.of(new int[]{1, 2, 3});

        superIntegerList.printAll(); // should be 1 2 3

        System.out.println();

        superIntegerList.removeByIndex(1);
        superIntegerList.add(5);
        superIntegerList.add(6);
        superIntegerList.printAll(); // should be 1 3 5 6

        System.out.println();

        superIntegerList.add(6);
        superIntegerList.removeByValue(6);
        superIntegerList.printAll(); // should be 1 3 5

        System.out.println();

        superIntegerList.removeByIndex(0);
        superIntegerList.removeByIndex(0);
        System.out.println(superIntegerList.get(0)); // should be 5

        try {
            superIntegerList.removeByIndex(-5);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Can't remove by negative index");
        }

        try {
            superIntegerList.get(10);
        } catch (ArrayIndexOutOfBoundsException boundsException) {
            System.out.println("Can't get value that out of bounds");
        }

        System.out.println();

        SuperIntegerList bigSuperIntegerList = ArraySuperIntegerList.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        bigSuperIntegerList.printAll(); // should be 1..11

        System.out.println();

        bigSuperIntegerList.removeByIndex(10);
        bigSuperIntegerList.printAll();

        System.out.println();

        for (int i = 0; i < 20; i++) {
            bigSuperIntegerList.add(i);
        }
        bigSuperIntegerList.printAll(); // should be 1..11 0 1 .. 19
    }
}
