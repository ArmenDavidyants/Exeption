import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*  
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. 
Если количество не совпадает с требуемым, вернуть код ошибки, 
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
Можно использовать встроенные типы java и создать свои. 
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.
*/

public class Dz3Task1 {
    public static void main(String[] args) {
        String inString = request(); // запрос данных у пользователя

        try {
            String[] splitString = splitString(inString); 

            String dataBirthday = splitString[3];
            String phoneNumber = splitString[4];
            String gender = splitString[5];

            isDateValid(dataBirthday);
            checkphoneNumber(phoneNumber);
            checkGender(gender);

            write(splitString);

            System.out.println("Данные успешно записаны");

        } catch (InData e) {
            System.out.println(e.getMessage()); // проверка количества введенных данных
        } catch (ParseException e) {
            System.out.println("Вы ввели неправильный формат даты рождения"); // проверка валидности даты рождения
        } catch (Birthday e) {
            System.out.println(e.getMessage()); // проверка валидности даты рождения
        } catch (PhoneNumber e) {
            System.out.println(e.getMessage()); // проверка номера телефона
        } catch (Gender e) {
            System.out.println(e.getMessage()); // проверка пола
        } catch (IOException e) {
            e.printStackTrace();     // проверка записи в файл
        }

    }

    // метод запроса данных
    public static String request() {

        Scanner in = new Scanner(System.in, "cp866");
        System.out.println(
                "Введите  данные через пробел  (ФИО, дата рождения, номер телефона, пол ) в формате:");
        System.out.println(
                "     ФИО - фамилия имя очество \n     дата рождения - dd.mm.yyyy \n" +
                        "     номер телефона - 89265838782 \n     пол - f или m");

        String inString = in.nextLine();
        in.close();

        return inString;
    }

    // метод обработки входящей строки
    public static String[] splitString(String inString) throws InData {
        String[] splitString = inString.split(" ");
        if (splitString.length < 6) {
            throw new InData("Вы ввели меньше данных, чем требуется");
        }
        if (splitString.length > 6) {
            throw new InData("Вы ввели больше данных, чем требуется");
        }

        return splitString;
    }

    // метод проверки даты рождения
    public static void isDateValid(String strDate) throws ParseException, Birthday {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");

        String[] temp = strDate.split("\\.");

        if (strDate.length() != 10 || !temp[2].matches("[-+]?\\d+")) {
            throw new Birthday("Вы ввели неверный формат данных");
        }
        try {
            Date date = myFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Формат даты не соответствует требуемому формату");
        }
    }

    // метод проверки номера телефона
    public static void checkphoneNumber(String phoneNumber) throws PhoneNumber {
        if (!phoneNumber.matches("[-+]?\\d+") || phoneNumber.length() != 11) {
            throw new PhoneNumber("Вы ввели некорректный номер телефона");
        }

    }

    // метод проверки пола
    public static void checkGender(String gender) throws Gender {
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new Gender("Вы неправильно указали свой пол");
        }
    }

    // метод записи в файл
    public static void write(String[] splitString) throws IOException {

        String name = splitString[0];
        String fileName = name + ".txt";
        String text = "<" + splitString[0] + ">" + "<"
                + splitString[1] + ">" + "<" + splitString[2] + ">"
                + "<" + splitString[3] + ">" + "<" + splitString[4]
                + ">" + "<" + splitString[5] + ">";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// исключение для количества введенных данных
class InData extends Exception {

    public InData(String message) {
        super(message);
    }
}

// исключение для даты рождения
class Birthday extends Exception {

    public Birthday(String message) {
        super(message);
    }
}

// исключение для номера теелфона
class PhoneNumber extends Exception {

    public PhoneNumber(String message) {
        super(message);
    }
}

// исключение для пола
class Gender extends Exception {

    public Gender(String message) {
        super(message);
    }
}
