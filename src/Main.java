import translator.BrainfuckTranslator;
import translator.syntax.Syntax;
import translator.syntax.Syntaxes;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BrainfuckTranslator brainfuckTranslator = new BrainfuckTranslator();
        Syntax syntax = Syntaxes.PYTHON;
        InputStream in = System.in;

//        OutputStream outputStream = new FileOutputStream("result." + syntax.fileExtension());
        PrintStream out = System.out;
        System.out.print("Input your code: ");

        Scanner scanner = new Scanner(in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            String line = scanner.next();
            if ("!stop".equals(line)) {
                break;
            }
            sb.append(line);
        }
        scanner.close();

        String res = brainfuckTranslator.translate(sb.toString(), syntax);
        out.println(res);
        out.close();
    }
}
