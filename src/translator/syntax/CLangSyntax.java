package translator.syntax;

class CLangSyntax implements Syntax {
    @Override
    public String intro() {
        return "int main() { \n" +
                "    char memory[30000];\n" +
                "    memset(memory, 0, sizeof(memory));\n" +
                "    int p = 0;\n";
    }

    @Override
    public String conclusion() {
        return "    return 0;\n" +
                "}";
    }

    @Override
    public int initialIndent() {
        return 1;
    }

    @Override
    public String changeIndexBy(int diff) {
        if (diff >= 0) {
            return "p += " + diff;
        }
        return "p -= " + -diff;
    }

    @Override
    public String changeValueBy(int diff) {
        if (diff > 0) {
            return "memory[p] += " + diff;
        }
        return "memory[p] -= " + -diff;
    }

    @Override
    public String valueNotEqualToZero() {
        return "memory[p]";
    }

    @Override
    public String printValue() {
        return "putchar(memory[p])";
    }

    @Override
    public String readValue() {
        return "memory[p]= getchar()";
    }

    @Override
    public String lineEnding() {
        return ";";
    }

    @Override
    public String indent() {
        return "    ";
    }

    @Override
    public String cycle(String expression) {
        return "while (" + expression + ")";
    }

    @Override
    public String blockStart() {
        return "{";
    }

    @Override
    public String blockEnd() {
        return "}";
    }

    @Override
    public String fileExtension() {
        return "c";
    }
}
