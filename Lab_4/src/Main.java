import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner( new File("/home/e/IdeaProjects/Lab_4/src/input.txt") );
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        String result = Delete_java_comments(text);
        //Pattern p = Pattern.compile("\\*");
        //Matcher m = p.matcher(text);
        StringBuilder result1 = new StringBuilder();
        //result = result.replace("*", "");
        Files.write( Paths.get("/home/e/IdeaProjects/Lab_4/src/output.txt"), result.getBytes());

    }


    public static String Delete_java_comments(String my_text) throws IOException {
        StringBuilder result = new StringBuilder();
        StringReader sr = new StringReader(my_text);
        boolean InnerComment = false;
        boolean LineComment = false;
        boolean tmp = true;

        int previous = sr.read();
        int current = sr.read();
        for (;current != - 1; current = sr.read()){
            if (previous == '*' && current == '/') {
                InnerComment = false;
                tmp = false;
            }
         else if (LineComment) {
            if (current == '\r') { //
                sr.mark(1);
                int next = sr.read();
                if (next != '\n') {
                    sr.reset();
                }
                LineComment = false;
                tmp = false;
            } else if (current == '\n') {
                LineComment = false;
                tmp = false;
            }
        }
            else {
                if (previous == '/' && current == '*') {
                    sr.mark(1);
                    int next = sr.read();
                    if (next != '*') {
                        InnerComment = true;
                    }
                    sr.reset();
                } else if (previous == '/' && current == '/') {
                    LineComment = true;
                } else if (tmp){
                    result.append((char)previous);
                } else {
                    tmp = true;
                }
            }
            previous = current;
        }
            if (previous != -1 && tmp && !LineComment) {
            result.append((char)previous);
        }

    return result.toString();
    }
}