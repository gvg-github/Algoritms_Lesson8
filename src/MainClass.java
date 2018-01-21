/* Гурьевских ВГ
(Task1) 1. Реализовать сортировку подсчетом.
(Task2) 2. Реализовать быструю сортировку.
Проанализировать время работы каждого из вида сортировок для 100, 10000, 1000000 элементов.
 */

import java.util.Arrays;

public class MainClass {

    private static int k = 1000; // Максимальное возможное значение
    private static int a1 = 100;
    private static int a2 = 1000;
    private static int a3 = 1000000;

    public static void main(String[] args) {

        //Подготовка массивов для тестирования
        int[] arr100 = new int[a1];
        int[] arr1000 = new int[a2];
        int[] arr1000000 = new int[a3];

        int x = 0;
        for (int i = 0; i < a3; i++) {
            x = (int) (Math.random() * k);

            if (i < a1) arr100[i] = x;
            if (i < a2) arr1000[i] = x;
            arr1000000[i] = x;
        }

        //Сортировка подсчетом.
        task1(arr100, arr1000, arr1000000);

        //Быстрая сортировка.
        task2(arr100, arr1000, arr1000000);
    }

    //Быстрая сортировка.
    private static void task2(int[] a1, int[] a2, int[] a3) {
        System.out.println("Quick sort:");
        long start = System.currentTimeMillis();
        quickSort(a1, 0, a1.length - 1);
        long end = System.currentTimeMillis();
        long sortTime = end - start;
        System.out.println(Arrays.toString(a1));
        System.out.printf("%012d \n", sortTime);

        start = System.currentTimeMillis();
        quickSort(a2, 0, a2.length - 1);
        end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(a2));
        sortTime = end - start;
        System.out.printf("%012d \n", sortTime);

        start = System.currentTimeMillis();
        quickSort(a3, 0, a3.length - 1);
        end = System.currentTimeMillis();
        sortTime = end - start;
        System.out.printf("%012d \n", sortTime);
    }

    //Быстрая сортировка.
    private static void quickSort(int[] arr, int first, int last) {

        int i = first;
        int j = last;
        int x = arr[(first + last) / 2];
        do {
            while (arr[i] < x) i++;
            while (arr[j] > x) j--;
            if (i <= j) {
                if (arr[i] > arr[j]) {
                    int y = arr[i];
                    arr[i] = arr[j];
                    arr[j] = y;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last) {
            quickSort(arr, i, last);
        }
        if (first < j) {
            quickSort(arr, first, j);
        }
    }

    //Сортировка подсчетом.
    private static void task1(int[] a1, int[] a2, int[] a3) {
        System.out.println("Count sort:");
        long start = System.currentTimeMillis();
        countSort(a1);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(a1));
        long sortTime = end - start;
        System.out.printf("%012d \n", sortTime);

        start = System.currentTimeMillis();
        countSort(a2);
        end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(a2));
        sortTime = end - start;
        System.out.printf("%012d \n", sortTime);

        start = System.currentTimeMillis();
        countSort(a3);
        end = System.currentTimeMillis();
        sortTime = end - start;
        System.out.printf("%012d \n", sortTime);
    }

    //Сортировка подсчетом.
    private static void countSort(int[] arr) {
        int[] c = new int[k];
        for (int i = 0; i < arr.length; i++) {
            c[arr[i]]++;
            arr[i] = 0;
        }

        int b = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < c[i]; j++) {
                arr[b++] = i;
            }
        }
    }
}
