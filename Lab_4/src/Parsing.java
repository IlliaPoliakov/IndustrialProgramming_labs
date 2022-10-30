import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("/home/e/IdeaProjects/Lab_4/src/input.txt"));
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        String result = change(text);
//        int ind = result.indexOf("println");
//        result = insertString(result, "\"/*dfsdf*////****/**//**Hello\", \\'world!\\\"", ind + 7);
        Files.write( Paths.get("/home/e/IdeaProjects/Lab_4/src/output.txt"), result.getBytes());
    }

    public static String insertString(
            String originalString,
            String stringToBeInserted,
            int index)
    {


        String newString = new String();

        for (int i = 0; i < originalString.length(); i++) {


            newString += originalString.charAt(i);

            if (i == index) {


                newString += stringToBeInserted;
            }
        }


        return newString;
    }

    public static String get(String text) {
        Map<String, String> replacements = new HashMap<String, String>();
        String reg = "";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        replacements.put("\\/\\/\\*\\", "1");
        return p.toString();

    }

//    public static String parse() {
//        enum States {START, STR_BODY, UN_STR_BODY, SUSP_COM, COM, ONE_STR_COM, CHR_BODY, SPC_BODY}
//        String line = " ";
//        List<String> parse = new ArrayList<>();
//        var state = States.START;
//        List<String> result = new ArrayList<>();
//        StringBuilder fieldValue = new StringBuilder();
//        for (var c : line.toCharArray()) {
//            switch (state) {
//                case START:
//                    if (c == " ") {
//
//
//                    }
//                case STR_BODY:
//                    if (k)
//                case UN_STR_BODY:
//                case SUSP_COM:
//                case COM:
//                case ONE_STR_COM:
//                case CHR_BODY:
//                case SPC_BODY
//            }
//        }
//        result.add(fieldValue.toString());
//        return result.toString();
//    }


    public static String change(String t){
        return t.replaceAll("(//[[ \t]|\\S]*)|(\".*//[[ \t]|\\S]*.*?\")" +
                "|(/\\*[\\S\\s]*?\\*/)|(\".*/\\*[\\S\\s]*?\\*/.*?\")", "");
    }

}
