import java.util.ArrayList;

public class ScaleModell {
	public String _scaleLength;

	public ArrayList<String[]> getAttributes() {
		String[] attr = new String[2];
		attr[0] = "ScaleLength";
		attr[1] = _scaleLength;
		ArrayList<String[]> ret = original();
		ret.add(attr);
		return ret;
	}
	public boolean setAttributes(String[] values, int index) {
		if(index < 0)
			return false;
		_scaleLength = values[index];
		return original(values, index - 1);
	}
}