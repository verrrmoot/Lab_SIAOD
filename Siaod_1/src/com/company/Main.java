package com.company;
import java.util.*;
import java.lang.*;
import java.util.Arrays;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        matrout();

    }

    public static void matrout() {
        int rows, col, min, max;

        Scanner scan1 = new Scanner(System.in);

        System.out.println("Введите количество строк и столбцов: ");
        rows = scan1.nextInt();
        col = scan1.nextInt();
        int[][] a = new int[rows][col];
        System.out.println("Введите минимальное и максимальное значение: ");
        min = scan1.nextInt();
        max = scan1.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = (int) (Math.random() * (max - min + 1) + min);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        int[] b = vodnomern(a, rows, col);
        int low = 0;
        int high = b.length - 1;

        int[][] a1 = a;
        viborom(rows, col, a1);
        int[][] a2 = a;
        vstavkoy(rows, col, a2);
        int[][] a3 = a;
        obmenom(rows, col, a3);
        int[][] a4 = a;
        shellom(rows, col, a4);
        int[] b1 = b;
        pyramid(b1);
        System.out.println("Пирамидальная сортировка:");
        int[][] a5 = vdvumern(b1, rows, col);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a5[i][j] + " ");
            }
            System.out.println();
        }
        int[] b2 = b;
        quickSort(rows, col, b2, low, high);

        System.out.println("Сортировка методом быстрой сортировки:");
        int[][] a6 = vdvumern(b2, rows, col);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a6[i][j] + " ");
            }
            System.out.println();
        }

        int[] b3 = b;
        Sort(b3);

        System.out.println("Турнирная сортировка:");
        int[][] a7 = vdvumern(b3, rows, col);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a7[i][j] + " ");
            }
            System.out.println();
        }



    }

    public static int[] vodnomern(int[][] a, int rows, int col) {
        int[] b = new int[rows * col];
        int t = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                b[t] = a[i][j];
                t++;
            }
        }
        return b;
    }

    public static int[][] vdvumern(int[] b, int rows, int col) {
        int[][] a = new int[rows][col];
        int t = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = b[t];
                t++;
            }
        }
        return a;
    }

    public static void viborom(int rows, int col, int[][] a) {
        System.out.println("Сортировка выбором: ");

        int[] b = vodnomern(a, rows, col);

        for (int i = 0; i < rows * col; i++) {
            int pos = i;
            int min = b[i];
            for (int j = i + 1; j < rows * col; j++) {
                if (b[j] < min) {
                    pos = j;
                    min = b[j];
                }

            }
            b[pos] = b[i];
            b[i] = min;
        }

        a = vdvumern(b, rows, col);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        // System.out.print(Arrays.toString(a));

    }

    public static void vstavkoy (int rows, int col, int[][] a){
        System.out.println("Сортировка вставкой:");

        int[] b = vodnomern(a, rows, col);

        for (int i = 1; i < b.length; i++) {
            int current = b[i];
            int j = i - 1;
            while (j >= 0 && current < b[j]) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = current;
        }

        a = vdvumern(b, rows, col);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void obmenom(int rows, int col, int[][] a){
        System.out.println("Сортировка обменом:");

        int[] b = vodnomern(a, rows, col);

        for (int i = 0; i < b.length - 1; i++) {
            for (int j = b.length - 1; j > i; j--) {
                if (b[j - 1] > b[j]) {
                    int tmp = b[j - 1];
                    b[j - 1] = b[j];
                    b[j] = tmp;
                }
            }
        }

        a = vdvumern(b, rows, col);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void shellom(int rows, int col, int[][] a) {
        System.out.println("Сортировка методом Шелла:");

        int[] b = vodnomern(a, rows, col);

        int h = 0;


        while (h <= b.length / 3)
            h = 3 * h + 1;

        for (int k = h; k > 0; k = (k - 1) / 3) {
            for (int i = k; i < b.length; i++) {
                int temp = b[i];
                int j;
                for (j = i; j >= k; j -= k) {
                    if (temp < b[j - k])
                        b[j] = b[j - k];
                    else
                        break;
                }
                b[j] = temp;
            }
        }

        a = vdvumern(b, rows, col);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void quickSort(int rows, int col, int[] b, int low, int high){


        if (b.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = b[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (b[i] < opora) {
                i++;
            }

            while (b[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = b[i];
                b[i] = b[j];
                b[j] = temp;
                i++;
                j--;
            }
        }


        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(rows, col, b, low, j);

        if (high > i)
            quickSort(rows, col, b, i, high);


    }


    public static void pyramid(int arr[])
    {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    public static class Node
    {
        public int data;
        public int id;

        public Node()
        {

        }
        public Node(int _data, int _id)//
        {
            data = _data;
            id = _id;
        }
    }

    public static void Adjust(Node[] data, int idx)
    {
        while(idx != 0)
        {
            if(idx % 2 == 1)
            {
                if(data[idx].data < data[idx + 1].data)
                {
                    data[(idx - 1)/2] = data[idx];
                }
                else
                {
                    data[(idx-1)/2] = data[idx + 1];
                }
                idx = (idx - 1)/2;
            }
            else
            {
                if(data[idx-1].data < data[idx].data)
                {
                    data[idx/2 - 1] = data[idx-1];
                }
                else
                {
                    data[idx/2 - 1] = data[idx];
                }
                idx = (idx/2 - 1);
            }
        }
    }

    public static void Sort(int[] data)
    {

        int nNodes = 1;
        int nTreeSize;
        while(nNodes < data.length)
        {
            nNodes *= 2;
        }
        nTreeSize = 2 * nNodes - 1;

        Node[] nodes = new Node[nTreeSize];

        int i, j;
        int idx;
        for( i = nNodes - 1; i < nTreeSize; i++)
        {
            idx = i - (nNodes - 1);
            if(idx < data.length)
            {
                nodes[i] = new Node(data[idx], i);
            }
            else
            {
                nodes[i] = new Node(Integer.MAX_VALUE, -1);
            }

        }

        for( i = nNodes - 2; i >= 0; i--)
        {
            nodes[i] = new Node();
            if(nodes[i * 2 + 1].data < nodes[i * 2 + 2].data)
            {
                nodes[i] = nodes[i*2 + 1];
            }
            else
            {
                nodes[i] = nodes[i*2 + 2];
            }
        }
        for( i = 0; i < data.length; i++)
        {
            data[i] = nodes[0].data;
            nodes[nodes[0].id].data = Integer.MAX_VALUE;
            Adjust(nodes, nodes[0].id);

        }
    }

}

