package basicparser;
/* Generated By:JJTree: Do not edit this line. ASTlineStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTlineStatement extends SimpleNode {
	public int first;
	public int last;

	public ASTlineStatement(int id) {
		super(id);
	}

	public ASTlineStatement(BasicParser p, int id) {
		super(p, id);
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=6f17921c67512be91d4b144c7693e99a (do not edit this line) */