/* Generated By:JJTree: Do not edit this line. ASTComparisonExp.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTComparisonExp extends SimpleNode {
  public ASTComparisonExp(int id) {
    super(id);
  }

  public ASTComparisonExp(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=b2ab783983d7df83ae9d054ef07bb160 (do not edit this line) */