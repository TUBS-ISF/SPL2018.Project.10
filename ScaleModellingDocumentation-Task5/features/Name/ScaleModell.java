import java.util.ArrayList;

public class ScaleModell {
	public String _name;
	public ArrayList<String[]> getAttributes() {
		String[] attr = new String[2];
		attr[0] = "Name";
		attr[1] = _name;
		ArrayList<String[]> ret = original();
		ret.add(attr);
		return ret;
	}
	public boolean setAttributes(String[] values, int index) {
		if(index < 0)
			return false;
		_name = values[index];
		return original(values, index - 1);
	}
}