package basicparser;
/* Generated By:JJTree: Do not edit this line. ASTcursorXStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTcursorXStatement extends SimpleNode {
	public int x;

	public ASTcursorXStatement(int id) {
		super(id);
	}

	public ASTcursorXStatement(BasicParserGEN p, int id) {
		super(p, id);
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=e67ae711152e3dddc8be5c869825d222 (do not edit this line) */
