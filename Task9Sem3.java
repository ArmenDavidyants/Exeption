import java.io.IOException;

/* Создайте класс исключения, который будет выбрасываться при делении на 0. 
Исключение должно отображать понятное для пользователя сообщение об ошибке. 

Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа. 
Исключение должно отображать понятное для пользователя сообщение об ошибке 

Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл. 
Исключение должно отображать понятное для пользователя сообщение об ошибке.
*/

public class Task9Sem3 {

   public static void main(String[] args) {
      /*
       * try {
       * int q = 5/0;
       * } catch (RuntimeException e){
       * // e.getClass().getSimpleName() ;
       * throw new ZeroDivException();
       * }
       */

      Integer[] array = new Integer[] { 1, 2, 3, 4, 5, null, 6, 7 };
      try {
         for (int i = 0; i < array.length; i++)
            System.out.println(array[i] + 1);
      } catch (NullPointerException e) {
         // e.getClass().getSimpleName() ;
         throw new NullPointerArrayException();
      }

   }
}

class ZeroDivException extends ArithmeticException {
   public ZeroDivException() {
      System.out.println("Деление на 0 запрещено!!!");
   }
}

class NullPointerArrayException extends NullPointerException {
   public NullPointerArrayException() {
      System.out.println("Невозможно извлечь пустой элемент!!!");
   }
}

class OpenFileException extends IOException {
   public OpenFileException() {
      System.out.println("Файл не существует!!!");
   }
}
