// дан двуменрый массив. найти сумму элементов. Исключения: массив дрлжен быть квадратный, в ячейках должны быть 1 или 0

public class Task2 {
    public static void main(String[] args) {
        int[][] arr = new int[][] { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1} };
        System.out.println(simEl(arr));
    }

    public static int simEl(int[][] arr) {
        for (int index = 0; index < arr.length; index++) {
            if (arr.length != arr[index].length) {
                throw new RuntimeException("Массив не квадратный!");
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1) {
                    throw new RuntimeException("В ячейках должны быть 1 или 0!");
                }
                sum += arr[i][j];
            }
        }
        return sum;
    }

}
