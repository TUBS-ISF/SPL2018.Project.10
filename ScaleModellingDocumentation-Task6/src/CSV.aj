import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public aspect CSV {
	public String _path = "";
	void around(String path):execution( void setPath(String)) && args(path) {
		_path = path;
	}
	boolean around(ScaleModell modell):execution(boolean DataFormat.write(ScaleModell)) && args(modell) {
		return write(modell, true);
	}
	ArrayList<ScaleModell> around():execution(ArrayList<ScaleModell> DataFormat.read()) {
		return read();
	}
	boolean around(int index):execution( boolean DataFormat.delete(int)) && args(index) {
		ArrayList<ScaleModell> list = read();
		ScaleModell m = list.get(index);
		if (m == null)
			return false;
		boolean ret = list.remove(m);
		write(list.get(0), false);
		for(int i = 1; i < list.size(); i++)
			write(list.get(i), true);
		return ret;
	}
	public boolean write(ScaleModell modell, boolean append) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(_path, append));
			ArrayList<String[]> attrs = modell.getAttributes();
			String[] a = attrs.get(0);
			writer.write(a[1]);
			for(int i = 1; i < attrs.size();i++) {
				writer.write(";" + attrs.get(i)[1]);
			}
			writer.newLine();
			writer.close();
			return true;
		} catch (IOException ioEx) {
			System.out.println(ioEx.getMessage());
			return false;
		}
	}
	public ArrayList<ScaleModell> read() {
		ArrayList<ScaleModell> ret = new ArrayList<ScaleModell>();
		try {
			BufferedReader br = null;
			br = new BufferedReader(new FileReader(_path));
			String line = br.readLine();
			while(line != null && !line.equals("")) { 
				String[] splitLine = line.split(";");
				ScaleModell modell = new ScaleModell();
				//modell.setAttributes(splitLine, splitLine.length - 1);
				modell.setAttributes(splitLine);
				ret.add(modell);
				line = br.readLine();
			}
			br.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());
			return new ArrayList<ScaleModell>();
		}
		return ret;
	}
	boolean around(ScaleModell modell):execution( boolean DataFormat.delete(ScaleModell)) && args(modell) {
		ArrayList<ScaleModell> list = read();
		ScaleModell m = null;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(modell)) {
				m = modell;
				break;
			}
		}
		if (m == null)
			return false;
		boolean ret = list.remove(m);
		write(list.get(0), false);
		for(int i = 1; i < list.size(); i++)
			write(list.get(i), true);
		return ret;
	}
}