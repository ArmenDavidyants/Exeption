/*
Если необходимо, исправьте данный код
  try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
  } catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
  }
 */
public class Dz2Task2 {
  public static void main(String[] args) {

    int [] intArray = new int[] {1,2,3,4,5,6,7,8,9}; // исправление 1: задали массив

    try {
      int d = 0;
      double catchedRes1 = intArray[10] / d;
      System.out.println("catchedRes1 = " + catchedRes1);
     } catch (ArithmeticException e) {
      System.out.println("Catching exception: " + e);
     } catch (IndexOutOfBoundsException e) {        // исправление 2: добавили исключение
      System.out.println("Catching exception: " + e);
     } 
  }    
}
