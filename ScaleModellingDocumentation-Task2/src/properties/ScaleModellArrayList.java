package properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ScaleModellArrayList extends ArrayList<ScaleModell>{
	private String _path;
	public ScaleModellArrayList(String path) {
		_path = path;
	}
	@Override
	public boolean add(ScaleModell modell) {
		if(!modell.writeCSV(_path))
			return false;
		return super.add(modell);
	}
	public void read() throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(_path));
		String line = br.readLine();
		while(line != null && !line.equals("")) { 
			super.add(ScaleModell.readCSV(line));
			line = br.readLine();
		}
		br.close();
	}
}
