import java.util.Scanner;

// Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение. 
// Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
// если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
// если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
// если вместо массива пришел null, метод вернет -3
// придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
// Напишите метод, в котором реализуйте взаимодействие с пользователем. 
//То есть, этот метод запросит искомое число у пользователя, 
//вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю. 
//Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.

public class Task1 {


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        Scanner in = new Scanner(System.in, "cp866");
        System.out.print("Введите натуральное число N = ");
        int n = in.nextInt();
        in.close();
        // int[] array = new int[5];
        int result = findNumber(array, n, 4);
        talk(result);

    }

    public static int findNumber(int[] array, int number, int min) {
        if (array == null) {
            return -3;
        } else if (array.length < min) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -2;
    }

    public static void talk (int number){
        if (number == -1) System.out.println("Длина масива меньше заданого минимума");
        else if (number == -2) System.out.println("Нет искомого элемента");
        else if (number == -3) System.out.println("Нет массива");
        else System.out.println("Искомый элемент находится на позиции " + number);
    }

}

