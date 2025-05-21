package obfuscator;

public class ExpressionComplexer {

    public static String complexify(String line) {
        line = line.replaceAll("(\\w+)\\s*=\\s*\\1\\s*\\*\\s*(\\w+);", "$1 *= $2;");
        line = line.replaceAll("(\\w+)\\s*=\\s*\\1\\s*\\+\\s*(\\w+);", "$1 += $2;");
        line = line.replaceAll("(\\w+)\\s*=\\s*\\1\\s*-\\s*(\\w+);", "$1 -= $2;");
        line = line.replaceAll("(\\w+)\\s*=\\s*\\1\\s*/\\s*(\\w+);", "$1 /= $2;");
        line = line.replaceAll("(\\w+)\\s*=\\s*\\1\\s*%\\s*(\\w+);", "$1 %= $2;");

        line = line.replaceAll("(\\w+)\\s*=\\s*(\\w+)\\s*\\+\\s*(\\d+);", "$1 = $2 - (-$3);");
        line = line.replaceAll("(\\w+)\\s*=\\s*(\\w+)\\s*-\\s*(\\d+);", "$1 = $2 + (-$3);");

        line = line.replaceAll("(\\w+)\\s*=\\s*(\\w+)\\s*\\*\\s*2;", "$1 = $2 + $2;");

        line = line.replaceAll("(\\w+)\\s*=\\s*(\\w+)\\s*/\\s*2;", "$1 = $2 * 0.5;");

        line = line.replaceAll("(\\w+)\\s*=\\s*(\\w+)\\s*\\+\\s*0;", "$1 = $2 - 0;");

        line = line.replaceAll("(\\w+)\\s*=\\s*(\\w+)\\s*\\*\\s*1;", "$1 = $2 / 1;");

        line = line.replaceAll("(\\w+)\\s*=\\s*(\\w+)\\s*\\+\\s*(\\w+);", "$1 = $2 - (-$3);");

        return line;
    }
}