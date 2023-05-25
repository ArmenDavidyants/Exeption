import java.util.Scanner;

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
// я это поняла, как то, что нужно просто написать абстрактный код, где используются 3 исключения 
// написала программу сложения и деления чисел 

public class Dz1Task1 {
    public static void main(String[] args) {
        int a = Integer.parseInt(talk("a"));
        int b = Integer.parseInt(talk("b"));
        int divNumber = div(a, b);
        System.out.println("Результат деления: " + divNumber);
        int sumNumber = sum(a, divNumber);
        System.out.println("Итоговый резульат " + sumNumber);

    }

    public static String talk(String x) {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.print("Введите  число " + x + " = ");
        String inString = in.nextLine();

        if (!inString.matches("[-+]?\\d+")) {
            throw new RuntimeException("Вы ввели не число!");
        }

        
        return inString;
    }

    public static int div(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Делить на ноль нельзя!");
        }
        return a / b;
    }

    public static int sum(int a, int b) {
        if (a + b > 100) {
            throw new RuntimeException("Результат суммы не подходит под условие!");
        }
        return a + b;
    }

}
