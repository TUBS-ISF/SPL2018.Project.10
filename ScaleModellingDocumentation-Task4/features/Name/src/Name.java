import Interfaces.iAttribute;
public class Name implements iAttribute{
	private String _name;
	@Override
	public String getDisplayname() {
		// TODO Auto-generated method stub
		return "Name";
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