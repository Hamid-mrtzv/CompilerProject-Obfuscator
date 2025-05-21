# Mini-C Obfuscator

---

## Overview

This project is a source code obfuscator for the Mini-C language. Its goal is to transform clear, readable Mini-C code into a functionally equivalent but much harder to understand version.  
Key features include:

- Variable and function renaming  
- Dead code insertion  
- Expression complexity enhancement by rewriting simple expressions into more complex but semantically equivalent forms (e.g., converting `a = a * b` to `a *= b`, or `a = b + 1` to `a = b - (-1)`, and more)

---

## Implemented Steps

1. **Parsing Mini-C source code**  
   - Using ANTLR, the Mini-C grammar is defined, and a parser is generated.  
2. **Building the Abstract Syntax Tree (AST)** of the input code  
3. **Applying obfuscation transformations on the AST**  
   - Renaming variables and functions  
   - Inserting dead (unreachable) code snippets  
   - Enhancing expressions by rewriting them into more complex but semantically equivalent forms  
4. **Generating the obfuscated Mini-C code from the transformed AST**

---

## How to Run

### Prerequisites

- Java Development Kit (JDK) 11 or higher installed  
- Gradle installed or use the Gradle Wrapper included in the project

### Steps

1. Clone or download the project to your local machine.  
2. Choose one of examples or put your own MiniC code in input.mc  
3. Synchronize Gradle and build the project dependencies:

```bash
./gradlew build
```

(On Windows use `gradlew.bat build`)

4. Compile the obfuscator to transform `input.mc` into `output.mc`:

```bash
javac ./src/main/java/obfuscator/*.java
```

This command will compile java codes to convert input.mc to output.mc
5. **Performance Comparator**

To compare the performance of the original and obfuscated code, run the command below to compile the code :

```bash
javac ./src/main/java/performance_comparator/*.java
```

6. **Convert Input.mc to Output.mc**

```bash
java ./src/main/java/obfuscator/Main.java
```

This command converts the Mini-C code from `input.mc`, applies obfuscation, and writes the obfuscated code to `output.mc`.

7. **Compare Performance, Check Validation**

```bash
java ./src/main/java/performance_comparator/PerformanceComparator.java
```
This tool benchmarks execution time or other metrics to verify that obfuscation does not significantly degrade performance.

---

## Important Notes

- Ensure `input.mc` contains valid and tested Mini-C code before running the obfuscator.  
- The output file `output.mc` contains obfuscated but functionally equivalent code.  
- It is highly recommended to write unit tests for complex code to verify equivalence after obfuscation.

---

## Team Info

Hamidreza Mortazavi 

---

**Good luck and happy obfuscating!**
