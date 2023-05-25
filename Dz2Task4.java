import java.util.Scanner;

/* 
Разработайте программу, которая выбросит Exception, 
когда пользователь вводит пустую строку. 
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/

public class Dz2Task4 {
    public static void main(String[] args) {

        String line = talk();
        if (line.length() == 0) {
            throw new RuntimeException("пустые строки вводить нельзя");
        }
        System.out.println("ваш запрос принят");

    }

    // запрос строки
    public static String talk() {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.print("Введите  строку: ");
        String line = in.nextLine();
        in.close();

        return line;
    }

}
