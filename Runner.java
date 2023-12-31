import java.util.List;

public class Runner {

	public static void main(String[] args) {
		try {
			List<Token> results = LexicalAnalyser.analyse("public class Test { public static void main(String[] args){ for ( ; 5 ;) {; } }}");
			System.out.println(results);
			ParseTree tree = SyntacticAnalyser.parse(results);
			System.out.println(tree);
			List<TreeNode> children = tree.getRoot().getChildren();
			// System.out.println(children.get(i++));
		} catch (LexicalException e) {
			e.printStackTrace();
		} catch (SyntaxException e) {
			e.printStackTrace();
		}

	}

}
