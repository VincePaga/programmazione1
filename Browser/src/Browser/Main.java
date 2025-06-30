package Browser;

public class Main {
	public static void main (String[] args) {
		Browser chrome = new Browser("www.google.com");
		
		chrome.visitPage("www.youtube.com");
		chrome.visitPage("www.instagram.com");
		chrome.visitPage("www.facebook.com");
		
		chrome.printHistory();
		System.out.println();
		try {
			chrome.goBack();
			chrome.goBack();
			/*chrome.goBack();
			chrome.goBack();*/
			System.out.print("Sito: ");
			chrome.printHistory();
		} catch (java.util.EmptyStackException e) {
			System.out.print("Errore: " + e);
		}
	}
}
