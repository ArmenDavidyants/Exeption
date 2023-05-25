import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

// Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив. 
// Метод должен пройтись по каждому элементу и проверить что он не равен null. 
// А теперь реализуйте следующую логику:
// Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
// Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

public class Task3 {

    public static boolean checkArray(Integer[] arr) {
        boolean check = true;
        List<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == null) {
                lst.add(i);
                check = false;
            }
        if (check == false) {
            String str = " В данном массиве на позициях:" + lst + " значения равны NULL";

            throw new RuntimeErrorException(null, str);
        }
        return check;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] { 1, 2, 1, null, 5, 6, 7, null };
        if (checkArray(array)) {
            System.out.println("Array is good");
        }
    }

}
