package ScaleModellingDocumentation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TODO description
 */
public class ScaleModellArrayList extends ArrayList<ScaleModell> {
	private String _path;
	public ScaleModellArrayList(String path) {
		_path = path;
	}
	//#ifdef InsertScaleModell
	@Override
	public boolean add(ScaleModell modell) {
		if(!modell.writeCSV(_path))
			return false;
		return super.add(modell);
	}
	//#endif
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
	//#ifdef DeleteScaleModell
	public boolean remove(String modellName) {
		int deleteIndex = -1;
		for (int i = 0; i < this.size(); i++) {
			if(this.get(i)._name.equals(modellName)) {
				deleteIndex = i;
				break;
			}
		}
		if (deleteIndex != -1) {
			this.remove(deleteIndex);
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(_path));
				writer.close();
				for (int i = 0; i < this.size(); i++) {
					this.get(i).writeCSV(_path);
				}
				return true;
			} catch (IOException ioEx) {
				System.out.println(ioEx.getMessage());
				return false;
			}
		}
		return false;
	}
	//#endif
	//#ifdef !GetScaleModell
//@	@Override
//@	public ScaleModell get(int index) {
//@		return null;
//@	}
	//#endif
}
