package main;
import Interfaces.iAttribute;
import java.util.ArrayList;
import java.util.List;
public class ScaleModell {
	private String _name, _scale;
	private ArrayList<iAttribute> _properties = new ArrayList<iAttribute>();
	public ArrayList<iAttribute> getProperties() {
		return _properties;
	}
	public void setAttributeValue(int index, String value) {
		_properties.get(index).setValue(value);
	}
	public ScaleModell(String name, String scale) {
		setName(name);
		setScale(scale);
		List<iAttribute> list = loader.PluginLoader.load(iAttribute.class);
			
		for (iAttribute attr: list)
			_properties.add(attr);
	}
	public Boolean equals(ScaleModell s) {
		for(int i = 0; i < this.getProperties().size(); i++) {
			if(!this.getProperties().get(i).getValue().equals(s.getProperties().get(i).getValue()))
				return false;
		}
		return true;
	}
	public Boolean equals(String name) {
		return _name.equals(name);
	}
	public String getScale() {
		return _scale;
	}
	public void setScale(String _scale) {
		this._scale = _scale;
	}
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
}
