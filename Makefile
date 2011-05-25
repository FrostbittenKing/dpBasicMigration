all:	BasicParser

BasicParser:	 BasicParserJJT BasicParserJJ java-gen/BasicParser.java
	if ! test -d build; then mkdir build; fi
	javac -d build/ java-gen/*.java

BasicParserJJT: src/BasicParser.jjt
	if ! test -d java-gen; then mkdir java-gen; fi
	cp ./src/datastructure-impl/*.java java-gen
	jjtree ./src/BasicParser.jjt

BasicParserJJ:	 ./java-gen/BasicParser.jj
	javacc java-gen/BasicParser.jj

run:	build/
	java -cp build/ BasicParser

clean:	
	rm -rf java-gen/BasicParser.jj java-gen/ build/