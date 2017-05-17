package tests;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Scanner;

import lang.ast.LangParser;
import lang.ast.LangScanner;
import lang.ast.Program;
import lang.ast.Function;
import lang.ast.FunctionId;

@SuppressWarnings("javadoc")
public class FunctionCollTests extends AbstractParameterizedTest {
	public FunctionCollTests() {
		super("testfiles", "testFunctionColl.lang");// where test input files are
	}
	
	@Test
	public void testFuncCalls() {
		Program p = null;
		try {
			p = (Program) parse(new File("testfiles", "testFunctionColl.lang"));
		} catch (Exception e) {
			fail("ALL KINDS OF SHIT EXCEPTION's" + e.getMessage());
		}
		StringBuilder sb = new StringBuilder();
		for (Function f: p.getFunctions()) {
			sb.append(f.getFunctionId().getID() + ":\n");
			for(FunctionId id : f.functionCalls()) {
				sb.append("\t" + id.getID() +"\n");
			}
		}
		File out = new File(testDirectory, "testFunctionColl.out");
		File expected = new File(testDirectory, "testFunctionColl.expected");
		compareOutput(sb.toString(), out, expected);
	}
	@Test
	public void testReachable() {
		Program p = null;
		try {
			p = (Program) parse(new File("testfiles", "testReachable.lang"));
		} catch (Exception e) {
			fail("ALL KINDS OF SHIT EXCEPTION's" + e.getMessage());
		}
		StringBuilder sb = new StringBuilder();
		for (Function f: p.getFunctions()) {
			sb.append(f.getFunctionId().getID() + ":\n");
			for(FunctionId id : f.reachable()){
				sb.append("\t" + id.getID() +"\n");
			}
		}
		File out = new File(testDirectory, "testReachable.out");
		File expected = new File(testDirectory, "testReachable.expected");
		compareOutput(sb.toString(), out, expected);
	}

}