/*
Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
 (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти 
 по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
 Если на каком-то месте встречается символ, отличный от числа или ?, 
 бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.attribute.HashDocAttributeSet;



public class Task5Sem2 {
    public static void main(String[] args) {
        var hm = readFile("C:/Users/alexl/Desktop/Java_sem/Exceptions/file.txt");
        System.out.println(hm);
    }

    public static HashMap<String, Integer> readFile(String fileName) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        File file = new File(fileName);
        Scanner sc = null;
        FileWriter fw = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] strMas = str.split("=");
                if (strMas[1].equals('?')) {
                    hm.putIfAbsent(strMas[0], Integer.parseInt(strMas[1]));
                } else {
                    try {
                        hm.putIfAbsent(strMas[0], strMas[0].length());
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный формат числа! Ошибка: " + e.getClass().getSimpleName());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        try {
            fw = new FileWriter(file);
            for (var item : hm.entrySet()) {
                fw.write(item.getKey() + "=" + item.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("IOExeption на FileWriter");
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                System.out.println("IOExeption на FileWriter");
            }
        }
        return hm;
    }
}
    

