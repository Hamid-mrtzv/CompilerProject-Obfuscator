package obfuscator;

public class Obfuscator {
    public String obfuscate(String code) {
        code = ExpressionComplexer.complexify(code);
        code = VariableRenamer.rename(code);
        code = DeadCodeInserter.insert(code);
        return code;
    }
}