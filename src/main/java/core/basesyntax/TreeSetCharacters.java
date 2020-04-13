package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        Set<String> set = new TreeSet<>();
        try {
            String line = Files.readString(Paths.get(fileName));
            String[] lineList = line
                    .toLowerCase()
                    .replaceAll("[^a-z]", "")
                    .split("");
            for (String symbol : lineList) {
                set.add(symbol);
            }
        } catch (IOException e) {
            throw new FileNotFoundException(fileName + " Was Not Find");
        }
        StringBuilder symbolList = new StringBuilder();
        int count = 1;
        for (String i: set) {
            symbolList.append(i);
            if (count == 5) {
                break;
            }
            count++;
        }
        return symbolList.toString();
    }
}
