import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив 
(либо HashMap, если студенты с ним знакомы). 
В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?, 
заменить его на соответствующее число.Если на каком-то месте встречается символ, отличный от числа или ?, 
бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
*/

public class Task4Sem2 {

    public static void main(String[] args) {
        try {
            int count = countStrings();
            String arrayLines[] = ReadWrite(count);
            slpit (arrayLines);
            
        } catch (IOException e) {
            System.out.println("упс");
        }
    }

    // метод подсчета строк в файле с логами
    static int countStrings() throws IOException {
        
        FileReader inFile = new FileReader("Task4Sem2.txt");
        Scanner file = new Scanner(inFile);

        int count = 0;
        while (file.hasNextLine()) {
            file.nextLine();
            count = count + 1;
        }
        file.close();
        return count;
    }

    // Метод записи файла с логами в массив строк
    public static String[] ReadWrite(int count) throws IOException {
        FileReader inFile = new FileReader("Task4Sem2.txt");
        Scanner file = new Scanner(inFile);

        String arrayLines[] = new String[count];
        int i = 0;

        while (file.hasNextLine()) {
            String temp = file.nextLine();
            arrayLines[i] = temp;
            // System.out.println(arrayLines[i]);
            i++;
        }
        file.close();
        return arrayLines;
    }

    // метод замены
    public static void slpit (String arrayLines[]){
        for (int i = 0; i < arrayLines.length; i++) {
            String temp = arrayLines[i];
            String [] tempSplit = temp.split("=");
            if (!tempSplit[1].equals("?") && !tempSplit[1].matches ("[-+]?\\d+")) {
                throw new RuntimeException ("Объект неопознан");
            }
            if (tempSplit[1].equals("?")) {
                tempSplit[1] = "999";
            }

            temp = tempSplit[0] + "=" + tempSplit[1];
            arrayLines[i] = temp;            
            
            System.out.println(arrayLines[i]);
        }
    }
}
