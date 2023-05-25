// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен разности элементов 
// двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

public class Dz1Task2 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 10, 11, 12, 13, 14 };
        int[] minArray = minArray(a, b);

        for (int i = 0; i < minArray.length; i++) {
            System.out.print(minArray[i] + " ");
        }

    }

    public static int[] minArray(int a[], int b[]) {
        if (a.length != b.length) {
            throw new RuntimeException("Массивы вычесть нельзя");
        }
        int[] minArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            minArray[i] = a[i] - b[i];
        }

        return minArray;
    }
}
