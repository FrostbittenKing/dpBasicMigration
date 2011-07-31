package basicparser;
/* Generated By:JJTree: Do not edit this line. ASTtxStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTtxStatement extends SimpleNode {
	public int foreground;
	public int fontSize;
	public boolean blinking;

	public ASTtxStatement(int id) {
		super(id);
	}

	public ASTtxStatement(BasicParserGEN p, int id) {
		super(p, id);
	}

	public void setBlinking(int blinking) {
		this.blinking = blinking != 0;
	}


	/**
	 * Accept the visitor. *
	 */
	public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=90f14e7b245d2d87542482b065801fc1 (do not edit this line) */
