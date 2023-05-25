/*
Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
*/

public class Task10Sem3 {
    public static void main(String[] args) {
        String[][] arr = new String[][] { { "1", "2", "3", "4" }, { "1", "f", "3", "4" }, { "1", "2", "3", "4" },
                { "1", "2", "3", "4" } };
        try {
            checkArray(arr);
            System.out.println(sumArray(arr));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumArray(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].matches("[-+]?\\d+")) {
                    sum += Integer.parseInt(arr[i][j]);
                } else {
                    // System.out.printf("Строка: %d, столбец: %d\n", i, j);
                    throw new MyArrayDataException("Элемент в строке " + i + " столбце " + j + " не является числом!");
                }
            }
        }
        return sum;
    }

    public static void checkArray(String[][] arr) throws MyArraySizeException {
        for (int index = 0; index < arr.length; index++) {
            if (arr.length != 4 || arr[index].length != 4) {
                throw new MyArraySizeException("Массив не 4х4!");
            }
        }
    }
    
}

class MyArraySizeException extends Exception {

    public MyArraySizeException(String message) {
        super(message);
    }
}


class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}