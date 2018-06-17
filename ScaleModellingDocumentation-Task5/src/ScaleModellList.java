import java.util.ArrayList; 

public   class  ScaleModellList  extends ArrayList<ScaleModell> {
	
	public DataFormat _format  ;

	
	public ScaleModellList  (DataFormat format) {
		_format = format;
	
		_format = format;
		ArrayList<ScaleModell> list = _format.read();
		for (int i = 0; i < list.size(); i++)
			super.add(list.get(i));
	}

	
	@Override
	public boolean add(ScaleModell modell) {
		boolean bAdd = super.add(modell);
		boolean fAdd = _format.write(modell, true);
		return bAdd && fAdd;
	}

	
	public boolean isAdd  () {
		return true;
	}

	
	@Override
	public boolean remove(Object modell) {
		ScaleModell m = (ScaleModell)modell;
		boolean fDelete = _format.delete(m);
		return fDelete && super.remove(m);
	}

	
	public boolean isRemove  () {
		return true;
	}

	
	@Override
	public ScaleModell remove(int index) {
		boolean fDelete = _format.delete(super.get(index));
		if(fDelete)
			return super.remove(index);
		else
			return null;
	}

	
	@Override
	public ScaleModell get(int index) {
		return super.get(index);
	}

	
	public boolean isGet  () {
		return true;
	}

	
	 private ArrayList<String>  getTasks__wrappee__ScaleModellList  () {
		return new ArrayList<String>();
	}

	
	 private ArrayList<String>  getTasks__wrappee__InsertScaleModell  () {
		ArrayList<String> ret = getTasks__wrappee__ScaleModellList();
		ret.add("Insert");
		return ret;
	}

	
	 private ArrayList<String>  getTasks__wrappee__DeleteScaleModell  () {
		ArrayList<String> ret = getTasks__wrappee__InsertScaleModell();
		ret.add("Delete");
		return ret;
	}

	
	 private ArrayList<String>  getTasks__wrappee__GetScaleModell  () {
		ArrayList<String> ret = getTasks__wrappee__DeleteScaleModell();
		ret.add("Get");
		return ret;
	}

	
	public ArrayList<String> getTasks() {
		ArrayList<String> ret = getTasks__wrappee__GetScaleModell();
		ret.add("Import");
		return ret;
	}

	
	public boolean importFile  (String path) {
		DataFormat f = new DataFormat();
		f.setPath(path);
		ArrayList<ScaleModell> impList = f.read();
		for(int i = 0; i < impList.size(); i++)
			this.add(impList.get(i));
		return true;
	}

	
	public boolean isImport  () {
		return true;
	}

	
	public ScaleModell remove(String attr0) {
		int index = -1;
		for(int i = 0; i < this.size(); i++) {
			ArrayList<String[]> attrs = this.get(i).getAttributes();
			if(attrs.get(0)[1].equals(attr0)) {
				index = i;
				break;
			}
		}
		if(index != -1)
			return remove(index);
		return null;
	}


}
