/* Generated By:JJTree: Do not edit this line. ASTParameterDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTParameterDeclaration extends SimpleNode {
  public ASTParameterDeclaration(int id) {
    super(id);
  }

  public ASTParameterDeclaration(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=27a72e65bceec2f0266b595ad2525d90 (do not edit this line) */