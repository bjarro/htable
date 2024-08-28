
# HTML Tables Compiler

## Description
- Developed a custom compiler (lexer and parser for school project, syntax highlighter and annotations for the latest version) for HTML tables that integrates with IntelliJ IDE using Psiviewer and Grammar-kit
- Defined the BNF according to specs and then generated the lexer and parser classes using Grammar-kit
- Implemented additional classes and functions needed to perform to parse the raw HTML into a csv file.


## Examples:

### Syntax Highlighter

![HTable Syntax Highlighting](https://github.com/user-attachments/assets/97ba32c0-9ce3-4679-9436-a8059ad0a541)


### Sample Annotation (HTML Tags)

![HTable Tags Annotator](https://github.com/user-attachments/assets/c17466e9-bab1-42de-97ef-a3b4789d3293)


## Lexer and Parser Specs:
 - https://github.com/bjarro/htable/blob/19f988b4d689945592b74b870e81f3915cd2f81a/cs130Proj2019.doc

## Recent Changes:
- Removed old tests, cleaned up project (lexer and parser jars untested)
- Implemented Syntax Highlighter
- Implemented sample annotation (HTML Tags)

## Rationale for revisiting:
 - Interested in solving ARC
	 - Related to DSLs
	 - Similar concepts to  NLP

## Relevant Learnings:
 - Methods:
	 - Syntax highlighting / Syntactic analysis
	 - Annotation / Semantic analysis

## Other Learnings:
 - How to test and build IntelliJ Plugins (use gradle instead of maven)
 - Technologies:
	 - Gradle
	 - Psiviewer


# CS130 (Old Readme)

## Project Part 1: Lexer

Run Main method of lexer.LexerMain

Program Arguments:

##### pathFileToBeLexed destPathResults

## Project Part 2: Parser

Run Main method of lexer.ParserMain

Program Arguments:

##### pathFileToBeParsed destPathResults
