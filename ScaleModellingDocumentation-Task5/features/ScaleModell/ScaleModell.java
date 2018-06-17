
import java.util.ArrayList;
public class ScaleModell {
	public ArrayList<String[]> getAttributes() {
		return new ArrayList<String[]>();
	}
	public boolean setAttributes(String[] values, int index) {
		return true;
	}
	public boolean setAttributes(String[] values) {
		return setAttributes(values, getAttributes().size() - 1);
	}
	public boolean equals(Object obj) {
		ScaleModell m = (ScaleModell)obj;
		ArrayList<String[]> attrsThis = getAttributes();
		ArrayList<String[]> attrsOther = m.getAttributes();
		
		return attrsThis.get(0)[1].equals(attrsOther.get(0)[1]);
	}
}