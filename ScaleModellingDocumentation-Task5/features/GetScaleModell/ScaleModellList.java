import java.util.ArrayList;

public class ScaleModellList extends ArrayList<ScaleModell> {
	public DataFormat _format;
	public ScaleModellList(DataFormat format) {
		_format = format;
		ArrayList<ScaleModell> list = _format.read();
		for (int i = 0; i < list.size(); i++)
			super.add(list.get(i));
	}
	@Override
	public ScaleModell get(int index) {
		return super.get(index);
	}
	public boolean isGet() {
		return true;
	}
	public ArrayList<String> getTasks() {
		ArrayList<String> ret = original();
		ret.add("Get");
		return ret;
	}
}