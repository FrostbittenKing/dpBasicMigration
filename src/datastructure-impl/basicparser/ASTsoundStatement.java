package basicparser;
/* Generated By:JJTree: Do not edit this line. ASTsoundStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTsoundStatement extends SimpleNode {
	public int tone;

	public ASTsoundStatement(int id) {
		super(id);
	}

	public ASTsoundStatement(BasicParserGEN p, int id) {
		super(p, id);
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=064f1334ba7c4012ee8c20991ae48328 (do not edit this line) */
