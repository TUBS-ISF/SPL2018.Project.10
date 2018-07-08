
public aspect DeleteScaleModell {
	ScaleModell around(int index, ScaleModellList list):execution( ScaleModell ScaleModellList.remove(int)) && args(index) && this(list) {
		ScaleModell m = list.get(index);
		boolean ret = list._format.delete(index);
		if(ret)
			list.remove(m);
		return m;
	}
	boolean around():execution(boolean ScaleModellList.isRemove()) {
		return true;
	}
}