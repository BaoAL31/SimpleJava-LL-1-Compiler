import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class SyntacticAnalyser {

	public static List<Symbol> stringToSymbols(String string) {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		String[] splittedString = string.split(" ");
		System.out.println(Arrays.toString(splittedString));

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

			else if (word.equals("public"))
				symbolList.add(Token.TokenType.PUBLIC);
			else if (word.equals("class"))
				symbolList.add(Token.TokenType.CLASS);
			else if (word.equals("<<ID>>"))
				symbolList.add(Token.TokenType.ID);

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






			// Labels
			else if (word.equals("<<los>>"))
				symbolList.add(TreeNode.Label.los);

		}

		return symbolList;
	}

	public static ParseTree parse(List<Token> tokens) throws SyntaxException {
		HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> parseTable = new HashMap<>();
		List<Symbol> RHS = new ArrayList<>();
		RHS = stringToSymbols("public class <<ID>> { public static void main ( String[] args ) { <<los>> } }");

		System.out.println(RHS);

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
