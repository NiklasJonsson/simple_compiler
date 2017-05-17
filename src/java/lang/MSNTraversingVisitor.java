package lang;

import lang.ast.*;

/**
 * Traverses each node, passing the data to the children.
 * Returns the data unchanged.
 * Overriding methods may change the data passed and the data returned.
 */
public class MSNTraversingVisitor extends TraversingVisitor {
	private static int maxDepth = 0;

	public static int msn(ASTNode n) {
        	MSNTraversingVisitor v = new MSNTraversingVisitor();
        	n.accept(v, new Integer(0));
        	return maxDepth;
    	}

	private Integer depth(int depth){
		maxDepth = depth > maxDepth ? depth : maxDepth;
		return new Integer(depth);
	}

	public Object visit(WhileStmt node, Object data) {
		return visitChildren(node, depth(((Integer) data).intValue() + 1));
	}

	public Object visit(IfStmt node, Object data) {
		return visitChildren(node, depth(((Integer) data).intValue() + 1));
	}

	public Object visit(Function node, Object data) {
		return visitChildren(node, depth(((Integer) data).intValue() + 1));
	}
}
