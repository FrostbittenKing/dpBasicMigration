all:	BasicParser

BasicParser:	 BasicParserJJT ./java-gen/BasicParser.jj
	javacc java-gen/BasicParser.jj

BasicParserJJT:	BasicParser.jjt
	cp ./datastructure-impl/*.java java-gen
	jjtree BasicParser.jjt