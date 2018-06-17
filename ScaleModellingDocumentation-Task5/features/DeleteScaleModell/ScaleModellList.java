import java.util.ArrayList;

public class ScaleModellList extends ArrayList<ScaleModell> {

	public DataFormat _format;
	@Override
	public boolean remove(Object modell) {
		ScaleModell m = (ScaleModell)modell;
		boolean fDelete = _format.delete(m);
		return fDelete && super.remove(m);
	}
	@Override
	public ScaleModell remove(int index) {
		boolean fDelete = _format.delete(super.get(index));
		if(fDelete)
			return super.remove(index);
		else
			return null;
	}
	public ScaleModell remove(String attr0) {
		int index = -1;
		for(int i = 0; i < this.size(); i++) {
			ArrayList<String[]> attrs = this.get(i).getAttributes();
			if(attrs.get(0)[1].equals(attr0)) {
				index = i;
				break;
			}
		}
		if(index != -1)
			return remove(index);
		return null;
	}
	public boolean isRemove() {
		return true;
	}
	public ArrayList<String> getTasks() {
		ArrayList<String> ret = original();
		ret.add("Delete");
		return ret;
	}
}