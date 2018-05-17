package ScaleModellingDocumentation;

/**
 * TODO description
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static BufferedReader scanner;
	private static ScaleModellArrayList _list = new ScaleModellArrayList("ScaleModellFile.csv");
	public static void main(String[] args) {
		System.out.println("Welcome to this mega scale modelling management tool.");
		//Only for creating an Object of globalInfos
		String input = "";
		int nextReadIndex = 0;
		scanner  = new BufferedReader(new InputStreamReader(System.in));
		//#ifdef GetScaleModell
		try {
			_list.read();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//#endif
		do {
			System.out.println("Write exit to close this application.");
			//#ifdef InsertScaleModell
				System.out.println("Write 1 to insert a modell");
			//#endif
			//#ifdef GetScaleModell
				System.out.println("Write 2 to read the next modell.");
			//#endif
			//#ifdef DeleteScaleModell
				System.out.println("Write 3 to delete a modell.");
			//#endif
			try {
				input = scanner.readLine();
				//#ifdef InsertScaleModell
				if (input.equals("1")) 
					_list.add(insert());
				//#endif
				//#ifdef GetScaleModell
				if (input.equals("2")) {
					get(_list.get(nextReadIndex));
					nextReadIndex = (nextReadIndex + 1) % _list.size();
				}
				//#endif
				//#ifdef DeleteScaleModell
				if (input.equals("3")) {
					remove();
				}
				//#endif
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!input.toLowerCase().equals("exit") );
		try {
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Exit.");
	}
	//#ifdef InsertScaleModell
	public static ScaleModell insert() throws IOException {
		System.out.println("Name: ");
		String name = scanner.readLine();
		System.out.print("Scale as an Int: ");
		String scale = scanner.readLine();
		ScaleModell modell = new ScaleModell(name, Integer.parseInt(scale));
		//#ifdef ScaleModellManufacturer
//@		System.out.println("Scale Modell Manufacturer: ");
//@		modell._ScaleModellManufacturer = scanner.readLine();
		//#endif
		return modell;
	}
	//#endif
	//#ifdef GetScaleModell
	public static void get(ScaleModell modell) {
		System.out.println("Name: " + modell._name);
		System.out.println("Scale: " + modell._scale);
		//#ifdef ScaleModellManufacturer
//@		System.out.println("Scale Modell Manufacturer: " + modell._ScaleModellManufacturer);
		//#endif
	}
	//#endif
	//#ifdef DeleteScaleModell
	public static boolean remove() throws IOException {
		System.out.println("Name: ");
		String name = scanner.readLine();
		return _list.remove(name);
	}
	//#endif
}
