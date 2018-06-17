import java.util.ArrayList;

public class ScaleModellList extends ArrayList<ScaleModell> {
	public DataFormat _format;
	@Override
	public boolean add(ScaleModell modell) {
		boolean bAdd = super.add(modell);
		boolean fAdd = _format.write(modell, true);
		return bAdd && fAdd;
	}
	public boolean isAdd() {
		return true;
	}
	public ArrayList<String> getTasks() {
		ArrayList<String> ret = original();
		ret.add("Insert");
		return ret;
	}
}