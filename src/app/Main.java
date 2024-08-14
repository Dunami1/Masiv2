package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[15];


        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100) + 1;
        }


        System.out.println("Початковий масив: " + Arrays.toString(array));

        insertionSort(array);

        System.out.println("Відсортований масив: " + Arrays.toString(array) );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int key = scanner.nextInt();

        int index = binarySearch(array, key);
        if (index != -1) {
            System.out.println("Число " + key + " знайдено на індексі: " + index);
        } else {
            System.out.println("Число " + key + " не знайдено в масиві.");
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == key) {
                return middle;
            }

            if (array[middle] < key) {
                left = middle + 1;
            } else {

                right = middle - 1;
            }
        }

        return -1;
    }
}
