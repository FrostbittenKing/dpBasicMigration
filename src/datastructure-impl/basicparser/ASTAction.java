/* Generated By:JJTree: Do not edit this line. ASTAction.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTAction extends SimpleNode {
  public ASTAction(int id) {
    super(id);
  }

  public ASTAction(BasicParserGEN p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ff61986744d2e3d529e3ee10afcb8b3b (do not edit this line) */
