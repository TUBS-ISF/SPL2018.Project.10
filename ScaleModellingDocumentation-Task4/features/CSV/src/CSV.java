import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Interfaces.iFile;
import Interfaces.iAttribute;
import main.ScaleModell;

public class CSV implements iFile{
	private String _path;
	@Override
	public Boolean write(ScaleModell modell) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(_path, true));
			iAttribute a = modell.getProperties().get(0);
			writer.write(a.getValue());
			for(int i = 1; i < modell.getProperties().size();i++) {
				writer.write(";" + a.getValue());
			}
			writer.newLine();
			writer.close();
			return true;
		} catch (IOException ioEx) {
			System.out.println(ioEx.getMessage());
			return false;
		}
	}

	public Boolean write(ArrayList<ScaleModell> modells) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(_path, false));
			writer.close();
			for(int i = 0; i < modells.size(); i++) {
				if(!write(modells.get(i)))
					return false;
			}
		} catch (IOException ioEx) {
			System.out.println(ioEx.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<ScaleModell> read() {
		ArrayList<ScaleModell> ret = new ArrayList<ScaleModell>();
		try {
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(_path));
			String line = br.readLine();
			while(line != null && !line.equals("")) { 
				String[] splitLine = line.split(";");
				ScaleModell modell = new ScaleModell(splitLine[0], splitLine[1]);
				for(int i = 2; i < splitLine.length; i++) {
					modell.getProperties().get(i).setValue(splitLine[i]);
				}
				ret.add(modell);
				line = br.readLine();
			}
			br.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());
			return null;
		}
		return ret;
	}
	@Override
	public Boolean delete(ScaleModell modell) {
		ArrayList<ScaleModell> list = read();
		int deleteIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(modell)) {
				deleteIndex = i;
				break;
			}
		}
		if (deleteIndex == -1) {
			return false;
		}
		list.remove(deleteIndex);
		return write(list);
	}
	@Override
	public void setPath(String path) {
		_path = path;
	}
}
