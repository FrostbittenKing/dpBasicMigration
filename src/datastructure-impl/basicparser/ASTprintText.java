/* Generated By:JJTree: Do not edit this line. ASTprintText.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTprintText extends SimpleNode {
  public ASTprintText(int id) {
    super(id);
  }

  public ASTprintText(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=fa247748d22390ae3708f125f5b42a69 (do not edit this line) */