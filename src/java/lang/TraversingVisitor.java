package lang;

import lang.ast.*;

/**
 * Traverses each node, passing the data to the children.
 * Returns the data unchanged.
 * Overriding methods may change the data passed and the data returned.
 */
public abstract class TraversingVisitor implements lang.ast.Visitor {

	protected Object visitChildren(ASTNode node, Object data) {
		for (int i = 0; i < node.getNumChild(); ++i) {
			node.getChild(i).accept(this, data);
		}
        return data;
	}

	public Object visit(List node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Opt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Program node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(MulExpr node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(DivExpr node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Numeral node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(DeclStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IdUse node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(AddExpr node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(SubExpr node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Stmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(WhileStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(IfStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(AssStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FunctionStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ReturnStmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Block node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Equal node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(NotEqual node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(GreaterEqual node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Greater node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Lesser node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(LesserEqual node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(BinaryExpr node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FunctionCall node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(ModExpr node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Function node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FunctionId node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Param node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Expr node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Condition node, Object data) {
		return visitChildren(node, data);
	}
}
