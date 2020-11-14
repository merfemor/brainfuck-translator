package translator.syntax;

class PythonSyntax implements Syntax {
    private final boolean addAsserts;

    PythonSyntax(boolean addAsserts) {
        this.addAsserts = addAsserts;
    }

    @Override
    public String intro() {
        return "import sys # for reading from stdin\n" +
                "\n" +
                "memory = [0] * 30000\n" +
                "p = 0";
    }

    @Override
    public String conclusion() {
        return null;
    }

    @Override
    public int initialIndent() {
        return 0;
    }

    @Override
    public String changeIndexBy(int diff) {
        final String line;
        if (diff >= 0) {
            line = "p += " + diff;
        } else {
            line = "p -= " + -diff;
        }
        if (addAsserts) {
            return line + "; assert 0 <= memory[p] < 256";
        }
        return line;
    }

    @Override
    public String changeValueBy(int diff) {
        final String line;
        if (diff > 0) {
            line = "memory[p] = (memory[p] + " + diff + ") % 256";
        } else {
            line = "memory[p] = (memory[p] + 256 - " + -diff + ") % 256";
        }
        if (addAsserts) {
            return line + "; assert 0 <= p < 30000";
        }
        return line;
    }

    @Override
    public String valueNotEqualToZero() {
        return "memory[p] != 0";
    }

    @Override
    public String printValue() {
        return "print(chr(memory[p]), end='')";
    }

    @Override
    public String readValue() {
        return "memory[p] = ord(sys.stdin.read(1))";
    }

    @Override
    public String lineEnding() {
        return "";
    }

    @Override
    public String indent() {
        return "    ";
    }

    @Override
    public String cycle(String expression) {
        return "while " + expression;
    }

    @Override
    public String blockStart() {
        return ":";
    }

    @Override
    public String blockEnd() {
        return null;
    }

    @Override
    public String fileExtension() {
        return "py";
    }
}
