import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctFiles = 0;

        while (true) {
            System.out.println("Введите путь к файлу (или 'exit' для выхода):");
            String path = scanner.nextLine().trim();

            if (path.equalsIgnoreCase("exit")) {
                System.out.println("Программа завершена");
                break;
            }

            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();


            if (!fileExists) {
                System.out.println("Файл не существует");
                continue;
            }

            if (isDirectory) {
                System.out.println("Указанный путь ведёт к папке");
                continue;
            }

            // Если оба условия пройдены
            correctFiles++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + correctFiles);
        }
        scanner.close();
    }
}