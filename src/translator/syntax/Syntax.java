package translator.syntax;

public interface Syntax {
    String intro();

    String conclusion();

    int initialIndent();

    String changeIndexBy(int diff);

    String changeValueBy(int diff);

    String valueNotEqualToZero();

    String printValue();

    String readValue();

    String lineEnding();

    String indent();

    String cycle(String expression);

    String blockStart();

    String blockEnd();

    String fileExtension();
}
