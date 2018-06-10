import Interfaces.iAttribute;
public class ScaleHeight implements iAttribute{
	private String _name;
	@Override
	public String getDisplayname() {
		return "Scale Height";
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