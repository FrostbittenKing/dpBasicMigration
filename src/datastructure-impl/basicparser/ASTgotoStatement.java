/* Generated By:JJTree: Do not edit this line. ASTgotoStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTgotoStatement extends SimpleNode {
  public ASTgotoStatement(int id) {
    super(id);
  }

  public ASTgotoStatement(BasicParserGEN p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=e3c22f95a3a33d7a821ae6163f67c333 (do not edit this line) */
