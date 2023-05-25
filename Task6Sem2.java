/*
Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла
и сохраняет в двумерный массив (либо HashMap, если
студенты с ним знакомы). В отдельном методе нужно
будет пройти по структуре данных, если сохранено значение ?,
заменить его на соответствующее число.Если на каком-то месте
встречается символ, отличный от числа или ?, бросить подходящее
исключение.Записать в тот же файл данные с замененными символами ?.
 */

// package ExceptionsCourse.Task6Sem2;

import java.io.*;
import java.util.*;

public class Task6Sem2 {

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();

        // читаем файл в HashMap
        String[] param;
        String fileName = "./ExceptionsCourse/seminar2/lesson/Task1/file.txt";
        String fileNameRes = "./ExceptionsCourse/seminar2/lesson/Task1/fileRes.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String fileString = reader.readLine();
        while (fileString != null) {
            param = fileString.split("=");
            map.put(param[0], param[1]);
            // считываем остальные строки в цикле
            fileString = reader.readLine();
        }
        reader.close();

        System.out.println(map);
        map = updateValues(map);
        System.out.println(map);

        FileWriter writer = new FileWriter(fileNameRes);
        for (var item : map.entrySet()) {
            writer.write(item.getKey() + "=" + item.getValue() + "\n");
        }
        writer.close();
    }

    public static Map<String, String> updateValues(Map<String, String> map) {
        for (var item : map.entrySet()) {
            if (!(isNumeric(item.getValue()) || item.getValue().equals("?"))) {
                throw new RuntimeException("элемент не является числом или ?");
            } else if (item.getValue().equals("?")) {
                int len = item.getKey().length();
                item.setValue(Integer.toString(len));
            }
        }

        return map;
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if (string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
