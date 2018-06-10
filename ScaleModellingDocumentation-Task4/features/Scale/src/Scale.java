import Interfaces.iAttribute;
public class Scale implements iAttribute{
	private String _scale;
	@Override
	public String getDisplayname() {
		return "Scale";
	}

	@Override
	public void setValue(String value) {
		_scale = value;
	}

	@Override
	public String getValue() {
		return _scale;
	}
}