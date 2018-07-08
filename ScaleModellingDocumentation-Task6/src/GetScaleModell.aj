import java.util.ArrayList;

public aspect GetScaleModell {
	after (DataFormat format) returning (ScaleModellList newList):call(ScaleModellList.new(DataFormat)) && args(format) {
		ArrayList<ScaleModell> list = format.read();
		for (int i = 0; i < list.size(); i++)
			newList.addToList(list.get(i));
	}
	boolean around():execution( boolean ScaleModellList.isGet()) {
		return true;
	}
}