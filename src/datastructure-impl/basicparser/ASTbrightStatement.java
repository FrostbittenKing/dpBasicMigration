package basicparser;
/* Generated By:JJTree: Do not edit this line. ASTbrightStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTbrightStatement extends SimpleNode {
	public int brightness;

	public ASTbrightStatement(int id) {
		super(id);
	}

	public ASTbrightStatement(BasicParserGEN p, int id) {
		super(p, id);
	}

	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=eaad8c7819f8f7714adfad50000e61a4 (do not edit this line) */
