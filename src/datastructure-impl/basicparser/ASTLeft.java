/* Generated By:JJTree: Do not edit this line. ASTLeft.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTLeft extends SimpleNode {
  public ASTLeft(int id) {
    super(id);
  }

  public ASTLeft(BasicParserGEN p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=9f154c687447dc3eec7dcaa6766d5d3d (do not edit this line) */
