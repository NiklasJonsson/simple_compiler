package lang;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import beaver.Parser.Exception;

import lang.ast.Program;
import lang.ast.LangParser;
import lang.ast.LangScanner;

/**
 * Parses a program and evaluates it
 */
public class Interpreter {
	/**
	 * Entry point
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				System.err.println(
						"You must specify a source file on the command line!");
				printUsage();
				System.exit(1);
				return;
			}

			String filename = args[0];
			LangScanner scanner = new LangScanner(new FileReader(filename));
			LangParser parser = new LangParser();
			Program program = (Program) parser.parse(scanner);
			if (program.errors().isEmpty()) {
				program.eval();
			} else {
				System.err.println("Compile time errors");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printUsage() {
		System.err.println("Usage: Interpreter FILE");
		System.err.println("  where FILE is the file to be parsed");
	}
}

