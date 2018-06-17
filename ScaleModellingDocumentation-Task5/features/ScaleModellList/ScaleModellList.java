import java.util.ArrayList;
public class ScaleModellList extends ArrayList<ScaleModell> {
	public DataFormat _format;
	public ScaleModellList(DataFormat format) {
		_format = format;
	}
	@Override
	public boolean add(ScaleModell modell) {
		return false;
	}
	public boolean isAdd() {
		return false;
	}
	@Override
	public boolean remove(Object modell) {
		return false;
	}
	public boolean isRemove() {
		return false;
	}
	@Override
	public ScaleModell remove(int index) {
		return null;
	}
	@Override
	public ScaleModell get(int index) {
		return null;
	}
	public boolean isGet() {
		return false;
	}
	public ArrayList<String> getTasks() {
		return new ArrayList<String>();
	}
	public boolean importFile(String path) {
		return false;
	}
	public boolean isImport() {
		return false;
	}
}