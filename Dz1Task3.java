// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен частному элементов 
// двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя. 
// Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

public class Dz1Task3 {
    public static void main(String[] args) {
        int[] a = { 15, 2, 3, 4, 5 };
        int[] b = { 10, 11, 12, 13, 14 };
        double[] divArray = divArray(a, b);

        for (int i = 0; i < divArray.length; i++) {
            System.out.print(divArray[i] + " ");
        }
    }

    public static double[] divArray(int a[], int b[]) {
        if (a.length != b.length) {
            throw new RuntimeException("Массивы поделить нельзя");
        }
        double[] divArray = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            divArray[i] = Math.round(((double) a[i] / b[i])*100.0)/100.0;
        }

        return divArray;
    }

}
