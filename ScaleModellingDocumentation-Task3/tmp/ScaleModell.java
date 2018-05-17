package properties;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ScaleModell {
	public String _name = "";
	public int _scale;
	public ScaleModell (String name, int scale) {
		_name = name;
		_scale = scale;
	}
	public Boolean writeCSV(String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
			writer.write(_name + ";" + _scale);
			writer.newLine();
			writer.close();
			return true;
		} catch (IOException ioEx) {
			System.out.println(ioEx.getMessage());
			return false;
		}
	}
	public static ScaleModell readCSV(String line) {
		String[] spliLine = line.split(";");
		ScaleModell modell = new ScaleModell(spliLine[0], Integer.parseInt(spliLine[1]));
		return modell;
	}
}
