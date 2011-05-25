all:	BasicParser

BasicParser:	 BasicParserJJT BasicParserJJ java-gen/BasicParser.java
	if test -d bin; then rm -rf bin/*; else mkdir bin; fi
	javac -d bin/ java-gen/*.java

BasicParserJJT:	BasicParser.jjt
	cp ./datastructure-impl/*.java java-gen
	jjtree BasicParser.jjt

BasicParserJJ:	 ./java-gen/BasicParser.jj
	javacc java-gen/BasicParser.jj

run:	bin/
	java -cp bin/ BasicParser

clean:	
	rm -rf java-gen/BasicParser.jj java-gen/*.java bin/