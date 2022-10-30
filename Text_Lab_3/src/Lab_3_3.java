//В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А вместо О. Внести исправления в текст.


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Lab_3_3 {
    public static void main(String[] args) throws IOException {
        String a = get_from_file_thread();

        change(a);
    }

    public static void change(String text) throws IOException {

        StringBuffer txt = new StringBuffer(text);


        char ch = 'Р';

        int index = text.indexOf(ch);
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        while (index != -1) {
            indexes.add(index);
            index = text.indexOf(ch, index + 1);
        }
        if (indexes.isEmpty()) {
            System.out.println("NOTHING TO CHANGE!");
            return;
        }
        for (var ind : indexes) {
            if (txt.charAt(ind + 1) == 'А') {
                txt.replace(ind + 1, ind + 2, "О");
            }

        }


        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/e/IdeaProjects/Text_Lab_3/src/new.txt"));
        writer.write(txt.toString());

        writer.close();


    }

    public static String get_from_file_thread() {
        Path filePath = Path.of("/home/e/IdeaProjects/Text_Lab_3/src/my_text.txt");
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream
                     = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {
            //Read the content with Stream
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
