import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import Token.TokenType;


public class SyntacticAnalyser {

	public static List<Symbol> stringToSymbols(String string) {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		String[] splittedString = string.split(" ");

		for (String word : splittedString) {

			//TokenTypes
			if (word.equals("+"))
				symbolList.add(Token.TokenType.PLUS);
			else if (word.equals("-"))
				symbolList.add(Token.TokenType.MINUS);
			else if (word.equals("*"))
				symbolList.add(Token.TokenType.TIMES);
			else if (word.equals("/"))
				symbolList.add(Token.TokenType.DIVIDE);
			else if (word.equals("%"))
				symbolList.add(Token.TokenType.MOD);
			else if (word.equals("="))
				symbolList.add(Token.TokenType.ASSIGN);
			else if (word.equals("=="))
				symbolList.add(Token.TokenType.EQUAL);
			else if (word.equals("!="))
				symbolList.add(Token.TokenType.NEQUAL);
			else if (word.equals("<"))
				symbolList.add(Token.TokenType.LT);
			else if (word.equals("<="))
				symbolList.add(Token.TokenType.LE);
			else if (word.equals(">"))
				symbolList.add(Token.TokenType.GT);
			else if (word.equals(">="))
				symbolList.add(Token.TokenType.GE);
			else if (word.equals("("))
				symbolList.add(Token.TokenType.LPAREN);
			else if (word.equals(")"))
				symbolList.add(Token.TokenType.RPAREN);
			else if (word.equals("{"))
				symbolList.add(Token.TokenType.LBRACE);
			else if (word.equals("}"))
				symbolList.add(Token.TokenType.RBRACE);
			else if (word.equals("&&"))
				symbolList.add(Token.TokenType.AND);
			else if (word.equals("||"))
				symbolList.add(Token.TokenType.OR);
			else if (word.equals(";"))
				symbolList.add(Token.TokenType.SEMICOLON);
			else if (word.equals("public"))
				symbolList.add(Token.TokenType.PUBLIC);
			else if (word.equals("class"))
				symbolList.add(Token.TokenType.CLASS);
			else if (word.equals("static"))
				symbolList.add(Token.TokenType.STATIC);
			else if (word.equals("void"))
				symbolList.add(Token.TokenType.VOID);
			else if (word.equals("main"))
				symbolList.add(Token.TokenType.MAIN);
			else if (word.equals("String[]"))
				symbolList.add(Token.TokenType.STRINGARR);
			else if (word.equals("args"))
				symbolList.add(Token.TokenType.ARGS);
			else if (word.equals("int") || word.equals("boolean") || word.equals("char"))
				symbolList.add(Token.TokenType.TYPE);
			else if (word.equals("System.out.println"))
				symbolList.add(Token.TokenType.PRINT);
			else if (word.equals("while"))
				symbolList.add(Token.TokenType.WHILE);
			else if (word.equals("for"))
				symbolList.add(Token.TokenType.FOR);
			else if (word.equals("if"))
				symbolList.add(Token.TokenType.IF);
			else if (word.equals("else"))
				symbolList.add(Token.TokenType.ELSE);
			else if (word.equals("\""))
				symbolList.add(Token.TokenType.DQUOTE);
			else if (word.equals("\'"))
				symbolList.add(Token.TokenType.SQUOTE);
			else if (word.equals("<<ID>>"))
				symbolList.add(Token.TokenType.ID);
			else if (word.equals("<<num>>"))
				symbolList.add(Token.TokenType.NUM);
			else if (word.equals("<<char>>"))
				symbolList.add(Token.TokenType.CHARLIT);
			else if (word.equals("args"))
				symbolList.add(Token.TokenType.ARGS);
			else if (word.equals("true"))
				symbolList.add(Token.TokenType.TRUE);
			else if (word.equals("false"))
				symbolList.add(Token.TokenType.FALSE);
			else if (word.equals("<<string lit>>"))
				symbolList.add(Token.TokenType.STRINGLIT);

			// Labels
			else if (word.equals("<<prog>>"))
				symbolList.add(TreeNode.Label.prog);
			else if (word.equals("<<los>>"))
				symbolList.add(TreeNode.Label.los);
			else if (word.equals("<<stat>>"))
				symbolList.add(TreeNode.Label.stat);
			else if (word.equals("<<while>>"))
				symbolList.add(TreeNode.Label.whilestat);
			else if (word.equals("<<for>>"))
				symbolList.add(TreeNode.Label.forstat);
			else if (word.equals("<<for start>>"))
				symbolList.add(TreeNode.Label.forstart);
			else if (word.equals("<<for arith>>"))
				symbolList.add(TreeNode.Label.forarith);
			else if (word.equals("<<if>>"))
				symbolList.add(TreeNode.Label.ifstat);
			else if (word.equals("<<elseif>>"))
				symbolList.add(TreeNode.Label.elseifstat);
			else if (word.equals("<<else?if>>"))
				symbolList.add(TreeNode.Label.elseorelseif);
			else if (word.equals("<<poss if>>"))
				symbolList.add(TreeNode.Label.possif);
			else if (word.equals("<<assign>>"))
				symbolList.add(TreeNode.Label.assign);
			else if (word.equals("<<decl>>"))
				symbolList.add(TreeNode.Label.decl);
			else if (word.equals("<<poss assign>>"))
				symbolList.add(TreeNode.Label.possassign);
			else if (word.equals("<<print>>"))
				symbolList.add(TreeNode.Label.print);
			else if (word.equals("<<type>>"))
				symbolList.add(TreeNode.Label.type);
			else if (word.equals("<<expr>>"))
				symbolList.add(TreeNode.Label.expr);
			else if (word.equals("<<while>>"))
				symbolList.add(TreeNode.Label.whilestat);
			else if (word.equals("<<char expr>>"))
				symbolList.add(TreeNode.Label.charexpr);
			else if (word.equals("<<bool expr>>"))
				symbolList.add(TreeNode.Label.boolexpr);
			else if (word.equals("<<bool op>>"))
				symbolList.add(TreeNode.Label.boolop);
			else if (word.equals("<<bool eq>>"))
				symbolList.add(TreeNode.Label.booleq);
			else if (word.equals("<<bool log>>"))
				symbolList.add(TreeNode.Label.boollog);
			else if (word.equals("<<rel expr>>"))
				symbolList.add(TreeNode.Label.relexpr);
			else if (word.equals("<<rel expr\'>>"))
				symbolList.add(TreeNode.Label.relexprprime);
			else if (word.equals("<<rel op>>"))
				symbolList.add(TreeNode.Label.relop);
			else if (word.equals("<<arith expr>>"))
				symbolList.add(TreeNode.Label.arithexpr);
			else if (word.equals("<<arith expr\'>>"))
				symbolList.add(TreeNode.Label.arithexprprime);
			else if (word.equals("<<term>>"))
				symbolList.add(TreeNode.Label.term);
			else if (word.equals("<<term\'>>"))
				symbolList.add(TreeNode.Label.termprime);
			else if (word.equals("<<factor>>"))
				symbolList.add(TreeNode.Label.factor);
			else if (word.equals("<<print expr>>"))
				symbolList.add(TreeNode.Label.printexpr);
		}

		return symbolList;
	}

	public static HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> getParseTable() {
		HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> parseTable = new HashMap<>();
		List<Symbol> RHS = new ArrayList<>();
		
		List<Symbol> epsilon = new ArrayList<>();
		epsilon.add(TreeNode.Label.epsilon);

		// 1
		RHS = stringToSymbols("public class <<ID>> { public static void main ( String[] args ) { <<los>> } } ");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.prog, Token.TokenType.PUBLIC), RHS);
		// 2.1
		RHS = stringToSymbols("<<stat>> <<los>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.SEMICOLON), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.TYPE), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.PRINT), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.FOR), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.IF), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.WHILE), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.ID), RHS);
		// 2.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.los, Token.TokenType.RBRACE), epsilon);
		// 3.1
		RHS = stringToSymbols("<<while>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.stat, Token.TokenType.WHILE), RHS);
		// 3.2
		RHS = stringToSymbols("<<for>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.stat, Token.TokenType.FOR), RHS);
		// 3.3
		RHS = stringToSymbols("<<if>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.stat, Token.TokenType.IF), RHS);
		// 3.4
		RHS = stringToSymbols("<<assign>> ;");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.stat, Token.TokenType.ID), RHS);
		// 3.5
		RHS = stringToSymbols("<<decl>> ;");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.stat, Token.TokenType.TYPE), RHS);
		// 3.6
		RHS = stringToSymbols("<<print>> ;");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.stat, Token.TokenType.PRINT), RHS);
		// 3.7
		RHS = stringToSymbols(";");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.stat, Token.TokenType.SEMICOLON), RHS);
		// 4
		RHS = stringToSymbols("while ( <<rel expr>> <<bool expr>> ) { <<los>> } ");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.whilestat, Token.TokenType.WHILE), RHS);
		// 5
		RHS = stringToSymbols("for ( <<for start>> ; <<rel expr>> <<bool expr>> ; <<for arith>> ) { <<los>> } ");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forstat, Token.TokenType.FOR), RHS);
		// 6.1
		RHS = stringToSymbols("<<decl>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forstart, Token.TokenType.TYPE), RHS);
		// 6.2
		RHS = stringToSymbols("<<assign>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forstart, Token.TokenType.ID), RHS);
		// 6.3
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forstart, Token.TokenType.SEMICOLON), epsilon);
		// 7.1
		RHS = stringToSymbols("<<arith expr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.LPAREN), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.ID), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.NUM), RHS);
		// 7.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.NUM), epsilon);





		return parseTable;
	}

	public static void addToStack(Deque<Symbol> stack, List<Symbol> symbols) {

	} 

	public static ParseTree parse(List<Token> tokens) throws SyntaxException {
		HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> parseTable = getParseTable();
		
		
		Deque<Symbol> stack = new ArrayDeque<Symbol>();
		stack.addLast(TreeNode.Label.terminal);
		stack.addLast(TreeNode.Label.prog);

		int inputIdx = 0;
		tokens.get(inputIdx);

		while (!stack.isEmpty()) {
			Symbol topOfStack = stack.pop();
			if (!topOfStack.isVariable()) {

			}
			else {
			}
			
			Pair<TreeNode.Label, Token.TokenType> testPair = new Pair<>((TreeNode.Label) topOfStack, tokens.get(inputIdx).getType());
			System.out.println(parseTable.get(testPair));


		}

		return new ParseTree();
	}

}

// The following class may be helpful.

class Pair<A, B> {
	private final A a;
	private final B b;

	public Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A fst() {
		return a;
	}

	public B snd() {
		return b;
	}

	@Override
	public int hashCode() {
		return 3 * a.hashCode() + 7 * b.hashCode();
	}

	@Override
	public String toString() {
		return "{" + a + ", " + b + "}";
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Pair<?, ?>)) {
			Pair<?, ?> other = (Pair<?, ?>) o;
			return other.fst().equals(a) && other.snd().equals(b);
		}

		return false;
	}

}
