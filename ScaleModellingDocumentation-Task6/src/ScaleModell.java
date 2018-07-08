import java.util.ArrayList;
public class ScaleModell {
	private ArrayList<String[]> attributes = new ArrayList<>();
	public void newAttr(String name) {
		String []attr = {name, ""};
		attributes.add(attr);
	}
	public ArrayList<String[]> getAttributes() {
		return attributes;
	}
	public boolean setAttributes(String[] values, int index) {
		return true;
	}
	public boolean setAttributes(String[] values) {
		for(int i = 0; i < attributes.size() && i < values.length;i++) {
			attributes.get(i)[1] = values[i];
		}
		return true;
	}
	public boolean setAttribute(String name, String value) {
		for(int i = 0; i < attributes.size();i++) {
			if(attributes.get(i)[0].equals(name)) {
				attributes.get(i)[1] = value;
				return true;
			}
		}
		return false;
	}
	public boolean equals(String name) {
		for(int i = 0; i < attributes.size(); i++) {
			if(attributes.get(i)[0].equals("Name"))
				return attributes.get(i)[1].equals(name);
		}
		return false;
	}
	public boolean equals(Object obj) {
		ScaleModell m = (ScaleModell)obj;
		ArrayList<String[]> attrsThis = getAttributes();
		ArrayList<String[]> attrsOther = m.getAttributes();
		
		return attrsThis.get(0)[1].equals(attrsOther.get(0)[1]);
	}
}