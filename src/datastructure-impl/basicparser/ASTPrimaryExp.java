/* Generated By:JJTree: Do not edit this line. ASTPrimaryExp.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTPrimaryExp extends SimpleNode {
  public ASTPrimaryExp(int id) {
    super(id);
  }

  public ASTPrimaryExp(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=e1e8fa7c12669a6d6592109e31595f0f (do not edit this line) */