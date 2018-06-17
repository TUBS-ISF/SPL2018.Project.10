import java.util.ArrayList; 

public   class  ScaleModell {
	
	 private ArrayList<String[]>  getAttributes__wrappee__ScaleModell  () {
		return new ArrayList<String[]>();
	}

	
	 private ArrayList<String[]>  getAttributes__wrappee__Name  () {
		String[] attr = new String[2];
		attr[0] = "Name";
		attr[1] = _name;
		ArrayList<String[]> ret = getAttributes__wrappee__ScaleModell();
		ret.add(attr);
		return ret;
	}

	
	 private ArrayList<String[]>  getAttributes__wrappee__Scale  () {
		String[] attr = new String[2];
		attr[0] = "Scale";
		attr[1] = _scale;
		ArrayList<String[]> ret = getAttributes__wrappee__Name();
		ret.add(attr);
		return ret;
	}

	

	 private ArrayList<String[]>  getAttributes__wrappee__ScaleModellManufacturer  () {
		String[] attr = new String[2];
		attr[0] = "ScaleModellManufacturer";
		attr[1] = _scaleModellManufacturer;
		ArrayList<String[]> ret = getAttributes__wrappee__Scale();
		ret.add(attr);
		return ret;
	}

	
	 private ArrayList<String[]>  getAttributes__wrappee__ScaleHeight  () {
		String[] attr = new String[2];
		attr[0] = "ScaleHeight";
		attr[1] = _scaleHeight;
		ArrayList<String[]> ret = getAttributes__wrappee__ScaleModellManufacturer();
		ret.add(attr);
		return ret;
	}

	
	public ArrayList<String[]> getAttributes() {
		String[] attr = new String[2];
		attr[0] = "ScaleWidth";
		attr[1] = _scaleWidth;
		ArrayList<String[]> ret = getAttributes__wrappee__ScaleHeight();
		ret.add(attr);
		return ret;
	}

	
	 private boolean  setAttributes__wrappee__ScaleModell  (String[] values, int index) {
		return true;
	}

	
	 private boolean  setAttributes__wrappee__Name  (String[] values, int index) {
		if(index < 0)
			return false;
		_name = values[index];
		return setAttributes__wrappee__ScaleModell(values, index - 1);
	}

	
	 private boolean  setAttributes__wrappee__Scale  (String[] values, int index) {
		if(index < 0)
			return false;
		_scale = values[index];
		return setAttributes__wrappee__Name(values, index - 1);
	}

	
	 private boolean  setAttributes__wrappee__ScaleModellManufacturer  (String[] values, int index) {
		if(index < 0)
			return false;
		_scaleModellManufacturer = values[index];
		return setAttributes__wrappee__Scale(values, index - 1);
	}

	
	 private boolean  setAttributes__wrappee__ScaleHeight  (String[] values, int index) {
		if(index < 0)
			return false;
		_scaleHeight = values[index];
		return setAttributes__wrappee__ScaleModellManufacturer(values, index - 1);
	}

	
	public boolean setAttributes(String[] values, int index) {
		if(index < 0)
			return false;
		_scaleWidth = values[index];
		return setAttributes__wrappee__ScaleHeight(values, index - 1);
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

	
	public String _name;

	
	public String _scale;

	
	public String _scaleModellManufacturer;

	
	public String _scaleHeight;

	
	public String _scaleWidth;


}
