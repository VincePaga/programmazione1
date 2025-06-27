package array_error;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	Array a = new Array(); 
        String[] array = a.array; 
    	System.out.println("Inserisci il numero associato:");
    	int n = scanner.nextInt();
    	try {
			System.out.println("Al numero" + " " + n + " è associato il nome " + array[n]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Al numero" + " " + n + " non è associato nessun nome.");
		} finally {
    		scanner.close();
		}
    }
}