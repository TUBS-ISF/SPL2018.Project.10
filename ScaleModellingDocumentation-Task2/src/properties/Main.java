package properties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static BufferedReader scanner;
	public static void main(String[] args) {
		System.out.println("Welcome to this mega scale modelling management tool.");
		//Only for creating an Object of globalInfos
		globalInfos gl = globalInfos.getInstance();
		String input = "";
		int nextReadIndex = 0;
		scanner  = new BufferedReader(new InputStreamReader(System.in));
		ScaleModellArrayList list = new ScaleModellArrayList("ScaleModellFile.csv");
		if (globalInfos.getIsRead()) {
			try {
				list.read();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		do {
			System.out.println("Write exit to close this application.");
			if (globalInfos.getIsInsert())
				System.out.println("Write 1 to insert a modell");
			if (globalInfos.getIsRead())
				System.out.println("Write 2 to read the next modell.");
			try {
				input = scanner.readLine();
				if (input.equals("1") && globalInfos.getIsInsert()) 
					list.add(insert());
				else if (input.equals("2") && globalInfos.getIsRead()) {
					get(list.get(nextReadIndex));
					nextReadIndex = (nextReadIndex + 1) % list.size();
				}
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
	public static ScaleModell insert() throws IOException {
		System.out.println("Name: ");
		String name = scanner.readLine();
		System.out.print("Scale as an Int: ");
		String scale = scanner.readLine();
		ScaleModell modell = new ScaleModell(name, Integer.parseInt(scale));
		return modell;
	}
	public static void get(ScaleModell modell) {
		System.out.println("Name: " + modell._name);
		System.out.println("Scale: " + modell._scale);
	}

}
