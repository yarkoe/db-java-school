package homework.lab1;

public class ArraySuperIntegerList implements SuperIntegerList {
    private int[] integers;
    private int currentLength, maxLength;
    final int INIT_MAX_LENGTH = 10;

    public ArraySuperIntegerList() {
        integers = new int[INIT_MAX_LENGTH];
        maxLength = INIT_MAX_LENGTH;
        currentLength = 0;
    }

    public static ArraySuperIntegerList of(int[] initIntegers) {
        if (initIntegers == null) {
            throw new IllegalArgumentException();
        }

        var arraySuperIntegerList = new ArraySuperIntegerList();

        for (int initInteger : initIntegers) {
            arraySuperIntegerList.add(initInteger);
        }

        return arraySuperIntegerList;
    }

    @Override
    public void add(int number) {
        currentLength++;
        if (currentLength >= maxLength) {
            maxLength *= 2;
            var integersWithAdd = new int[maxLength];
            System.arraycopy(integers, 0, integersWithAdd, 0, currentLength - 1);
            integers = integersWithAdd;
        }

        integers[currentLength - 1] = number;
    }

    @Override
    public void removeByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index >= currentLength) {
            return;
        }

        System.arraycopy(integers, index + 1, integers, index, currentLength - 1 - index);

        currentLength--;
    }

    @Override
    public void removeByValue(int value) {
        boolean isValueFound;

        do {
            // Remove all values that match the provided value
            isValueFound = false;

            for (int i = 0; i < currentLength; i++) {
                if (integers[i] == value) {
                    this.removeByIndex(i);
                    isValueFound = true;
                    break;
                }
            }
        } while (isValueFound);
    }

    @Override
    public int get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index >= currentLength) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return integers[index];
    }

    @Override
    public void printAll() {
        for (int i = 0; i < currentLength; i++) {
            System.out.print(integers[i] + " ");

        }
    }
}
