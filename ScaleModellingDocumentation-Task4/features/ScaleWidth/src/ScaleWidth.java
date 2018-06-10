import Interfaces.iAttribute;
public class ScaleWidth implements iAttribute{
	private String _name;
	@Override
	public String getDisplayname() {
		return "Scale Width";
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