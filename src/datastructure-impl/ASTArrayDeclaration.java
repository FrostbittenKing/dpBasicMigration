/* Generated By:JJTree: Do not edit this line. ASTArrayDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTArrayDeclaration extends SimpleNode {
	public int length;
        public String name;

	public ASTArrayDeclaration(int id) {
		super(id);
	}

	public ASTArrayDeclaration(BasicParser p, int id) {
		super(p, id);
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=5d87f5e72b94ac6247151ce0b47f4879 (do not edit this line) */
