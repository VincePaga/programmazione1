package Browser;

public class Main {
	public static void main (String[] args) {
		Browser chrome = new Browser("www.google.com");
		
		chrome.visitPage("www.youtube.com");
		chrome.visitPage("www.instagram.com");
		chrome.visitPage("www.facebook.com");
		
		chrome.printHistory();
		
		chrome.goBack();
		chrome.goBack();

		chrome.printHistory();
	}
}
