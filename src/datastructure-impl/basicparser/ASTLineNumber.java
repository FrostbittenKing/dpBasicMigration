package basicparser;
/* Generated By:JJTree: Do not edit this line. ASTLineNumber.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTLineNumber extends SimpleNode {
	public int lineNumber;

	public ASTLineNumber(int id) {
		super(id);
	}

	public ASTLineNumber(BasicParserGEN p, int id) {
		super(p, id);
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=7aba05bca0cff9d373a5236128a46b98 (do not edit this line) */
