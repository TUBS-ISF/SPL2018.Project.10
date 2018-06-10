import Interfaces.iAttribute;
public class ScaleModellManufacturer implements iAttribute {
	private String _name;
	@Override
	public String getDisplayname() {
		return "Scale Modell Manufacturer";
	}

	@Override
	public void setValue(String value) {
		_name = value;
	}

	@Override
	public String getValue() {
		return _name;
	}
}
