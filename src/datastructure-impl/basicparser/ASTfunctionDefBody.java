package basicparser;
/* Generated By:JJTree: Do not edit this line. ASTfunctionDefBody.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTfunctionDefBody extends SimpleNode {


	public ASTfunctionDefBody(int id) {
		super(id);
	}

	public ASTfunctionDefBody(BasicParser p, int id) {
		super(p, id);
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=a4df36c184cd582287e8c39172ffb402 (do not edit this line) */