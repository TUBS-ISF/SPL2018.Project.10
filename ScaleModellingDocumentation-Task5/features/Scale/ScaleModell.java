import java.util.ArrayList;

public class ScaleModell {
	public String _scale;
	public ArrayList<String[]> getAttributes() {
		String[] attr = new String[2];
		attr[0] = "Scale";
		attr[1] = _scale;
		ArrayList<String[]> ret = original();
		ret.add(attr);
		return ret;
	}
	public boolean setAttributes(String[] values, int index) {
		if(index < 0)
			return false;
		_scale = values[index];
		return original(values, index - 1);
	}
}