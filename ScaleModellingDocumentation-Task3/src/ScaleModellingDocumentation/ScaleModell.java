package ScaleModellingDocumentation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO description
 */
public class ScaleModell {
	public String _name = "";
	public int _scale;
	//#ifdef ScaleModellManufacturer
//@	public String _ScaleModellManufacturer = "";
	//#endif
	
	public ScaleModell (String name, int scale) {
		_name = name;
		_scale = scale;
	}
	public Boolean writeCSV(String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
			writer.write(_name + ";" + _scale);
			//#ifdef ScaleModellManufacturer
//@			writer.write(";" + _ScaleModellManufacturer);
			//#endif
			writer.newLine();
			writer.close();
			return true;
		} catch (IOException ioEx) {
			System.out.println(ioEx.getMessage());
			return false;
		}
	}
	public static ScaleModell readCSV(String line) {
		String[] splitLine = line.split(";");
		ScaleModell modell = new ScaleModell(splitLine[0], Integer.parseInt(splitLine[1]));
		//#ifdef ScaleModellManufacturer
//@		modell._ScaleModellManufacturer = splitLine[2];
		//#endif
		return modell;
	}
}
