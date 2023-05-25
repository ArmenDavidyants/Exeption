import java.util.Scanner;

/* 
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/

public class Dz2Task1 {

    public static void main(String[] args) {
        boolean check = false;

        do {
            try {
                float number = talk();
                check = true;
                System.out.println("Вы ввели дробное число " + number);
            } catch (RuntimeException e) {
                System.out.println("упс!!!  " + e);

            }

        } while (check == false);

    }

    // запрос числа
    public static float talk() {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.print("Введите  дробное число: ");
        float number = in.nextFloat();
        in.close();

        return number;
    }

}
