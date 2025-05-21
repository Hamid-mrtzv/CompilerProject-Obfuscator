package performance_comparator;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PerformanceComparator {

    static final String INPUT_MC = "src/resources/input.mc";
    static final String OUTPUT_MC = "src/resources/output.mc";
    static final String INPUT_C = "src/resources/input.c";
    static final String OUTPUT_C = "src/resources/output.c";
    static final String INPUT_EXEC = "input_exec";
    static final String OUTPUT_EXEC = "output_exec";

    public static void main(String[] args) throws Exception {
        convertMcToC(INPUT_MC, INPUT_C);
        convertMcToC(OUTPUT_MC, OUTPUT_C);

        prepareCFile(INPUT_C);
        prepareCFile(OUTPUT_C);

        compileC(INPUT_C, INPUT_EXEC);
        compileC(OUTPUT_C, OUTPUT_EXEC);

        double inputTime = measureTime("./" + INPUT_EXEC);
        double outputTime = measureTime("./" + OUTPUT_EXEC);

        String inputOutput = runAndCaptureOutput("./" + INPUT_EXEC);
        String outputOutput = runAndCaptureOutput("./" + OUTPUT_EXEC);

        System.out.println("🔍 Output For Input.mc: " + inputOutput);
        System.out.println("🔍 Output For Output.mc: " + outputOutput);

        boolean isEqual = inputOutput.equals(outputOutput);
        String color = isEqual ? "\u001B[32m" : "\u001B[31m";
        String result = isEqual ? "TRUE" : "FALSE";
        System.out.println("🔍 Output Equal: " + color + result + "\u001B[0m");

        System.out.println("⏱ Average Time (Original): " + inputTime + " ms");
        System.out.println("⏱ Average Time (Obfuscated): " + outputTime + " ms");
        System.out.printf("🚀 Difference: %.2f ms\n", (outputTime - inputTime));
    }

    private static void convertMcToC(String mcPath, String cPath) throws IOException {
        Files.copy(Paths.get(mcPath), Paths.get(cPath), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void prepareCFile(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        boolean hasInclude = lines.stream().anyMatch(line -> line.contains("#include <stdio.h>"));
        if (!hasInclude) {
            lines.add(0, "#include <stdio.h>");
            Files.write(Paths.get(path), lines);
        }
    }

    private static void compileC(String cFile, String outFile) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("gcc", "-w", cFile, "-o", outFile);
        Process process = pb.inheritIO().start();
        int exitCode = process.waitFor();
        if (exitCode != 0) throw new RuntimeException("Compile error: " + cFile);
    }

    private static double measureTime(String exec) throws IOException, InterruptedException {
        int runs = 5;
        long total = 0;
        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            Process p = new ProcessBuilder(exec).start();
            p.waitFor();
            total += (System.nanoTime() - start);
        }
        return total / 1_000_000.0 / runs;
    }

    private static String runAndCaptureOutput(String exec) throws IOException, InterruptedException {
        Process process = new ProcessBuilder(exec).redirectErrorStream(true).start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) result.append(line).append("\n");
        process.waitFor();
        return result.toString().trim();
    }
}