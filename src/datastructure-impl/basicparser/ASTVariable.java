/* Generated By:JJTree: Do not edit this line. ASTVariable.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTVariable extends SimpleNode {
  public ASTVariable(int id) {
    super(id);
  }

  public ASTVariable(BasicParserGEN p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=b0e7332b2fba79d4b038412d7b303a13 (do not edit this line) */
