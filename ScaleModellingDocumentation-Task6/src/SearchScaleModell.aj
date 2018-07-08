
public aspect SearchScaleModell {
	boolean around():execution(boolean ScaleModellList.isSearch()) {
		return true;
	}
	ScaleModell around(String name, ScaleModellList list):execution(ScaleModell ScaleModellList.search(String)) && args(name) && target(list) {
		for(int i = 0; i < list.size();i++) {
			if(list.get(i).getAttributes().get(0)[1].equals(name))
				return list.get(i);
		}
		return null;
	}
}
