import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task7Sem3 {
    public static void main(String[] args) {
        Path pathRead = Paths.get("Task4Sem2.txt");
        Path pathWrite = Paths.get("2.txt");
        try {
        rwLine(pathRead, pathWrite);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Пустой объект");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка ввода-вывода: ");
        }
    }
    public static void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try(BufferedReader in = Files.newBufferedReader(pathRead);
            BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
                out.write(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка ввода-вывода.");
        }
    }
}
