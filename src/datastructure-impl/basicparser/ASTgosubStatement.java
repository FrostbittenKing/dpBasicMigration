/* Generated By:JJTree: Do not edit this line. ASTgosubStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTgosubStatement extends SimpleNode {
  public ASTgosubStatement(int id) {
    super(id);
  }

  public ASTgosubStatement(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=315313ac5ef6a92d6b3ae24d49c137f9 (do not edit this line) */