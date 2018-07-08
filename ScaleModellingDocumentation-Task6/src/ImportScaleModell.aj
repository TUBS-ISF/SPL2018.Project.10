import java.util.ArrayList;

public aspect ImportScaleModell {
	public DataFormat _format;
	boolean around(String path, ScaleModellList list):execution(boolean importFile(String)) && args(path) && target(list) {
		DataFormat f = new DataFormat();
		f.setPath(path);
		ArrayList<ScaleModell> impList = f.read();
		for(int i = 0; i < impList.size(); i++)
			list.add(impList.get(i));
		return true;
	}
	boolean around():execution( boolean ScaleModellList.isImport()) {
		return true;
	}
}