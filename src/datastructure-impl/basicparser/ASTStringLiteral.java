/* Generated By:JJTree: Do not edit this line. ASTStringLiteral.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTStringLiteral extends SimpleNode {
    public String stringValue;

  public ASTStringLiteral(int id) {
    super(id);
  }

  public ASTStringLiteral(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f743301d4118adf295af1dcefe1c9643 (do not edit this line) */