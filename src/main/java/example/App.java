package example;


import example.ipcounter.IpCounter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Optional;

import static example.ipcounter.Utils.EMPTY_STRING;

public class App {

    public static void main(String[] args) {
        if (args.length < 2 | args[1] == null) {
            System.err.println("Неправильный формат команды. " +
                    "Введите java -jar target/codereviewipcounter-1.0-jar-with-dependencies.jar -f file-path");
            return;
        }

        Optional<String> fileName = Optional.of(args[1]);
        if (!Files.exists(Paths.get(fileName.orElse(EMPTY_STRING)))) {
            System.err.println("Не удается найти файл: " + fileName.get());
            return;
        }

        IpCounter ipCounter = new IpCounter();
        ipCounter.counting(fileName.orElse(EMPTY_STRING));
        System.out.println("Количество уникальных адресов: " + ipCounter.getResult());
    }

}
