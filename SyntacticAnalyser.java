import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

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
			else if (word.equals("<<stringlit>>"))
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
			else if (word.equals("<<forstart>>"))
				symbolList.add(TreeNode.Label.forstart);
			else if (word.equals("<<forarith>>"))
				symbolList.add(TreeNode.Label.forarith);
			else if (word.equals("<<if>>"))
				symbolList.add(TreeNode.Label.ifstat);
			else if (word.equals("<<elseif>>"))
				symbolList.add(TreeNode.Label.elseifstat);
			else if (word.equals("<<else?if>>"))
				symbolList.add(TreeNode.Label.elseorelseif);
			else if (word.equals("<<possif>>"))
				symbolList.add(TreeNode.Label.possif);
			else if (word.equals("<<assign>>"))
				symbolList.add(TreeNode.Label.assign);
			else if (word.equals("<<decl>>"))
				symbolList.add(TreeNode.Label.decl);
			else if (word.equals("<<possassign>>"))
				symbolList.add(TreeNode.Label.possassign);
			else if (word.equals("<<print>>"))
				symbolList.add(TreeNode.Label.print);
			else if (word.equals("<<type>>"))
				symbolList.add(TreeNode.Label.type);
			else if (word.equals("<<expr>>"))
				symbolList.add(TreeNode.Label.expr);
			else if (word.equals("<<while>>"))
				symbolList.add(TreeNode.Label.whilestat);
			else if (word.equals("<<charexpr>>"))
				symbolList.add(TreeNode.Label.charexpr);
			else if (word.equals("<<boolexpr>>"))
				symbolList.add(TreeNode.Label.boolexpr);
			else if (word.equals("<<boolop>>"))
				symbolList.add(TreeNode.Label.boolop);
			else if (word.equals("<<booleq>>"))
				symbolList.add(TreeNode.Label.booleq);
			else if (word.equals("<<boollog>>"))
				symbolList.add(TreeNode.Label.boollog);
			else if (word.equals("<<relexpr>>"))
				symbolList.add(TreeNode.Label.relexpr);
			else if (word.equals("<<relexpr\'>>"))
				symbolList.add(TreeNode.Label.relexprprime);
			else if (word.equals("<<relop>>"))
				symbolList.add(TreeNode.Label.relop);
			else if (word.equals("<<arithexpr>>"))
				symbolList.add(TreeNode.Label.arithexpr);
			else if (word.equals("<<arithexpr\'>>"))
				symbolList.add(TreeNode.Label.arithexprprime);
			else if (word.equals("<<term>>"))
				symbolList.add(TreeNode.Label.term);
			else if (word.equals("<<term\'>>"))
				symbolList.add(TreeNode.Label.termprime);
			else if (word.equals("<<factor>>"))
				symbolList.add(TreeNode.Label.factor);
			else if (word.equals("<<printexpr>>"))
				symbolList.add(TreeNode.Label.printexpr);
		}

		return symbolList;
	}

	public static HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> getParseTable() {
		HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> parseTable = new HashMap<>();
		List<Symbol> RHS = new ArrayList<>();
		
		List<Symbol> epsilon = new ArrayList<>();
		epsilon.add(TreeNode.Label.epsilon);
		List<Symbol> type = new ArrayList<>();
		type.add(Token.TokenType.TYPE);

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
		RHS = stringToSymbols("while ( <<relexpr>> <<boolexpr>> ) { <<los>> } ");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.whilestat, Token.TokenType.WHILE), RHS);
		// 5
		RHS = stringToSymbols("for ( <<forstart>> ; <<relexpr>> <<boolexpr>> ; <<forarith>> ) { <<los>> } ");
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
		RHS = stringToSymbols("<<arithexpr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.LPAREN), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.ID), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.NUM), RHS);
		// 7.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.forarith, Token.TokenType.RPAREN), epsilon);
		// 8
		RHS = stringToSymbols("if ( <<relexpr>> <<boolexpr>> ) { <<los>> } <<elseif>> ");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.ifstat, Token.TokenType.IF), RHS);
		// 9.1
		RHS = stringToSymbols("<<else?if>> { <<los>> } <<elseif>> ");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.ELSE), RHS);
		// 9.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.WHILE), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.FOR), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.IF), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.ID), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.TYPE), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.PRINT), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.SEMICOLON), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.ID), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseifstat, Token.TokenType.RBRACE), epsilon);
		//10
		RHS = stringToSymbols("else <<possif>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.elseorelseif, Token.TokenType.ELSE), RHS);
        //11.1
		RHS = stringToSymbols("if ( <<relexpr>> <<boolexpr>> )");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.possif, Token.TokenType.IF), RHS);
		// 11.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.possif, Token.TokenType.LBRACE), epsilon);
		//12
		RHS = stringToSymbols("<<ID>> = <<expr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.assign, Token.TokenType.ID), RHS);
		// 13
		RHS = stringToSymbols("<<type>> <<ID>> <<possassign>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.decl, Token.TokenType.TYPE), RHS);
		//14.1
		RHS = stringToSymbols("= <<expr>> ");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.possassign, Token.TokenType.ASSIGN), RHS);
        //14.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.possassign, Token.TokenType.SEMICOLON), epsilon);
        // 15
		RHS = stringToSymbols("System.out.println ( <<printexpr>> )");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.print, Token.TokenType.PRINT), RHS);
		//16
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.type, Token.TokenType.TYPE), type);
		// 17.1
		RHS = stringToSymbols("<<relexpr>> <<boolexpr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.expr, Token.TokenType.LPAREN), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.expr, Token.TokenType.TRUE), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.expr, Token.TokenType.FALSE), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.expr, Token.TokenType.ID), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.expr, Token.TokenType.NUM), RHS);
		// 17.2
		RHS = stringToSymbols("<<charexpr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.expr, Token.TokenType.SQUOTE), RHS);
		//18
		RHS = stringToSymbols("' <<char>> '");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.charexpr, Token.TokenType.SQUOTE), RHS);
		//19.1
		RHS = stringToSymbols("<<boolop>> <<relexpr>> <<boolexpr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolexpr, Token.TokenType.EQUAL), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolexpr, Token.TokenType.NEQUAL), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolexpr, Token.TokenType.AND), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolexpr, Token.TokenType.OR), RHS);
		//19.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolexpr, Token.TokenType.RPAREN), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolexpr, Token.TokenType.SEMICOLON), epsilon);
        //20.1
		RHS = stringToSymbols("<<booleq>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolop, Token.TokenType.EQUAL), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boolop, Token.TokenType.NEQUAL), RHS);
		//20.2
		RHS = stringToSymbols("<<boollog>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boollog, Token.TokenType.AND), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boollog, Token.TokenType.OR), RHS);
		//21.1
		RHS = stringToSymbols("==");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.booleq, Token.TokenType.EQUAL), RHS);
		//21.2
		RHS = stringToSymbols("!=");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.booleq, Token.TokenType.NEQUAL), RHS);
		//22.1
		RHS = stringToSymbols("&&");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boollog, Token.TokenType.AND), RHS);
		//22.2
		RHS = stringToSymbols("||");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.boollog, Token.TokenType.OR), RHS);
		//23.1
		RHS = stringToSymbols("<<arithexpr>> <<relexpr'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexpr, Token.TokenType.LPAREN), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexpr, Token.TokenType.ID), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexpr, Token.TokenType.NUM), RHS);
		//23.2
		RHS = stringToSymbols("true");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexpr, Token.TokenType.TRUE), RHS);
		//23.3
		RHS = stringToSymbols("false");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexpr, Token.TokenType.FALSE), RHS);
		//24.1
		RHS = stringToSymbols("<<relop>> <<arithexpr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.LE), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.LT), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.GE), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.GT), RHS);
		//24.2
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.EQUAL), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.NEQUAL), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.RPAREN), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.AND), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.OR), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relexprprime, Token.TokenType.SEMICOLON), epsilon);
        //25.1
		RHS = stringToSymbols("<");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relop, Token.TokenType.LT), RHS);
		//25.2
		RHS = stringToSymbols("<=");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relop, Token.TokenType.LE), RHS);
		//25.3
		RHS= stringToSymbols(">");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relop, Token.TokenType.GT), RHS);
		//25.4
		RHS = stringToSymbols(">=");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.relop, Token.TokenType.GE), RHS);
		//26
		RHS = stringToSymbols("<<term>> <<arithexpr'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexpr, Token.TokenType.LPAREN), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexpr, Token.TokenType.ID), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexpr, Token.TokenType.NUM), RHS);
		//27.1
		RHS = stringToSymbols(" + <<term>> <<arithexpr'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.PLUS), RHS);
        //27.2
		RHS = stringToSymbols(" - <<term>> <<arithexpr'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.MINUS), RHS);
        //27.3
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.EQUAL), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.NEQUAL), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.RPAREN), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.AND), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.OR), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.arithexprprime, Token.TokenType.SEMICOLON), epsilon);
        //28
		RHS = stringToSymbols("<<factor>> <<term'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.term, Token.TokenType.LPAREN), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.term, Token.TokenType.ID), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.term, Token.TokenType.NUM), RHS);
		//29.1
		RHS = stringToSymbols("* <<factor>> <<term'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.TIMES), RHS);
		//29.2
		RHS = stringToSymbols("/ <<factor>> <<term'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.DIVIDE), RHS);
        //29.3
		RHS = stringToSymbols("% <<factor>> <<term'>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.MOD), RHS);
        //29.4
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.PLUS), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.MINUS), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.EQUAL), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.NEQUAL), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.RPAREN), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.AND), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.OR), epsilon);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.termprime, Token.TokenType.SEMICOLON), epsilon);
        //30.1
		RHS = stringToSymbols("( <<arithexpr>> )");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.factor, Token.TokenType.LPAREN), RHS);
		//30.2
		RHS = stringToSymbols("<<ID>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.factor, Token.TokenType.ID), RHS);
		//30.3
		RHS = stringToSymbols("<<num>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.factor, Token.TokenType.NUM), RHS);
		//31.1
		RHS = stringToSymbols("<<relexpr>> <<boolexpr>>");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.printexpr, Token.TokenType.LPAREN), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.printexpr, Token.TokenType.ID), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.printexpr, Token.TokenType.NUM), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.printexpr, Token.TokenType.TRUE), RHS);
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.printexpr, Token.TokenType.FALSE), RHS);
		//31.2
		RHS = stringToSymbols("\" <<stringlit>> \"");
		parseTable.put(new Pair<TreeNode.Label, Token.TokenType>(TreeNode.Label.printexpr, Token.TokenType.DQUOTE), RHS);

		// for (Map.Entry<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> entry : parseTable.entrySet()) {
		// 	System.out.println(entry.getKey() + " = " + entry.getValue());
		// }

		return parseTable;
	}

	static int inputIdx = 0;
	public static void treeRecursion(List<Token> tokens, TreeNode parent, HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> parseTable) throws SyntaxException {

		Pair<TreeNode.Label, Token.TokenType> pair = new Pair<>((TreeNode.Label) parent.getLabel(), tokens.get(inputIdx).getType());
		List<Symbol> symbols = parseTable.get(pair);
		// System.out.println("\n-----------------------\n New Step \n");
		// System.out.println("Current node: " + parent);
		// System.out.println("Symbols: " + symbols);
		if (symbols.size() == 0)
			return;
		for (Symbol symbol : symbols) {
			Token currentInput = tokens.get(inputIdx);
			System.out.println("Symbols: " + symbols);
			System.out.println(inputIdx);
			System.out.println("Current tree: " + parseTree);
			System.out.println("Current symbol: " + symbol);
			System.out.println("Current input: " + currentInput);
			System.out.println(currentInput.getType());
			if (symbol.isVariable()) {
				TreeNode newParent = new TreeNode((TreeNode.Label) symbol, parent);
				parent.addChild(newParent);
				if (!((TreeNode.Label) symbol == TreeNode.Label.epsilon)) {
					treeRecursion(tokens, newParent, parseTable);
					System.out.println("Finished one step");
				}
			}
			else {
				if ((Token.TokenType) symbol == currentInput.getType()) {
						TreeNode leaf = new TreeNode(TreeNode.Label.terminal, currentInput, parent);
						parent.addChild(leaf);
						inputIdx++;
						// System.out.println("+1");
						// System.out.println(inputIdx);
					}
				else
					throw new SyntaxException("Incorrect Syntax");
			}
			System.out.println("End of iteration\n");
		}

	} 

	static ParseTree parseTree = null;
	public static ParseTree parse(List<Token> tokens) throws SyntaxException {
		// try {
			inputIdx = 0;
			HashMap<Pair<TreeNode.Label, Token.TokenType>, List<Symbol>> parseTable = getParseTable();
			TreeNode currentParent = new TreeNode(TreeNode.Label.prog, null);
			parseTree = new ParseTree(currentParent);
			treeRecursion(tokens, currentParent, parseTable);
			return parseTree;
		// } catch (Exception e) {
		// 	throw new SyntaxException("Incorrect Syntax");
		// }
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
