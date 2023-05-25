import java.io.IOException;

/*
 Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1. 
 Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. 
 Подумайте, что должно происходить при закрытии этого ресурса? 
 Напишите метод для проверки, закрыт ли ресурс. 
 При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */

public class Task8Sem3 {

    public static void main(String[] args) {

        try (Count count = new Count()) {

            count.add();
            count.add();
            count.add();
            count.add();
            count.close();
            count.add();

        } catch (IOException e) {
            System.out.println("счетчик закрыт");
        }
    }
}

class Count implements AutoCloseable {
    boolean check = true;
    int i = 0;

    public void add() throws IOException {

        if (check) {
            i += 1;
            System.out.println(i);
        } else {
            throw new IOException("проброс");
        }

    }

    @Override
    public void close() {
        check = false;
    }

}
