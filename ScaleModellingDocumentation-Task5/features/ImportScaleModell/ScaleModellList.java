import java.util.ArrayList;

public class ScaleModellList extends ArrayList<ScaleModell> {
	public DataFormat _format;
	public boolean importFile(String path) {
		DataFormat f = new DataFormat();
		f.setPath(path);
		ArrayList<ScaleModell> impList = f.read();
		for(int i = 0; i < impList.size(); i++)
			this.add(impList.get(i));
		return true;
	}
	public boolean isImport() {
		return true;
	}
	public ArrayList<String> getTasks() {
		ArrayList<String> ret = original();
		ret.add("Import");
		return ret;
	}
}