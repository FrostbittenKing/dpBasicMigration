/* Generated By:JJTree: Do not edit this line. ASTStringIdentifier.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTStringIdentifier extends SimpleNode {
	public String value;

	public ASTStringIdentifier(int id) {
		super(id);
	}

	public ASTStringIdentifier(BasicParser p, int id) {
		super(p, id);
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=f1f3f88ced878855a16445e055d716a1 (do not edit this line) */