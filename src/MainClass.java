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
        Task1(arr100, arr1000, arr1000000);

        //Быстрая сортировка.
        Task2(arr100, arr1000, arr1000000);
    }

    //Быстрая сортировка.
    private static void Task2(int[] a1, int[] a2, int[] a3) {

    }

    //Сортировка подсчетом.
    private static void Task1(int[] a1, int[] a2, int[] a3) {

        long start = System.currentTimeMillis();
        CountSort(a1);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(a1));
        long sortTime = end - start;
        System.out.println(sortTime);

        start = System.currentTimeMillis();
        CountSort(a2);
        end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(a2));
        sortTime = end - start;
        System.out.println(sortTime);

        start = System.currentTimeMillis();
        CountSort(a3);
        end = System.currentTimeMillis();
        sortTime = end - start;
        System.out.println(sortTime);
    }

    private static void CountSort(int[] arr) {
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
