public aspect InsertScaleModell {
	boolean around (ScaleModell modell, ScaleModellList list):execution( boolean ScaleModellList.add(ScaleModell)) && args(modell) && target(list) && !within(DataFormat) {
		System.out.println("Add");
		boolean ret = list.addToList(modell);
		if(ret)
			return ret && list._format.write(modell);
		return false;
	}
	boolean around():execution(boolean ScaleModellList.isAdd()) {
		return true;
	}
}