package Browser;

import java.util.Stack;

public class Browser {
	public String url;

	public Browser(String url) {
		super();
		this.url = url;
	}
	Stack<String> pila = new Stack<>();
	
	public void visitPage(String url) {
		pila.add(url);
	}
	public void goBack() {
		pila.pop();
	}
	public void printHistory() {
		for (String string : pila) {
			System.out.println(string);
		}
	}
}
