package tests;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ParseTests extends AbstractTestSuite {
	public ParseTests() {
		super("testfiles/ast");// where test input files are
	}
	
	@Test
	public void testReturn() {
		testValidSyntax("testReturn.lang");
	}
	
	@Test
	public void testAdd() {
		testValidSyntax("testAdd.lang");
	}
	@Test
	public void testMul() {
		testValidSyntax("testMul.lang");
	}
	@Test
	public void testArit() {
		testValidSyntax("testArit.lang");
	}

	@Test
	public void testDeclStmt() {
		testValidSyntax("testDeclStmt.lang");
	}
	@Test
	public void testAssStmt() {
		testValidSyntax("testAssStmt.lang");
	}
	@Test
	public void testIfStmt() {
		testValidSyntax("testIfStmt.lang");
	}
	@Test
	public void testWhileStmt() {
		testValidSyntax("testWhileStmt.lang");
	}	
	@Test
	public void testNumeral() {
		testValidSyntax("testNumeral.lang");
	}
	@Test
	public void testFunCall() {
		testValidSyntax("testFunCall.lang");
	}
	@Test
	public void superTest() {
		testValidSyntax("superTest.lang");
	}

}
