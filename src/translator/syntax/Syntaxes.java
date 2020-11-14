package translator.syntax;

public final class Syntaxes {
    public static final Syntax PYTHON = new PythonSyntax(false);
    public static final Syntax PYTHON_DEBUG = new PythonSyntax(true);
    public static final Syntax C_LANG = new CLangSyntax();
}
