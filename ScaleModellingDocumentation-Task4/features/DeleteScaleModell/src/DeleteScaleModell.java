import java.util.ArrayList;

import Interfaces.iFile;
import Interfaces.iGui;
import Interfaces.iTask;
import main.ScaleModell;

public class DeleteScaleModell implements iTask{

	@Override
	public String getDisplayName() {
		return "delete";
	}

	@Override
	public Boolean task(iFile file, iGui gui, ArrayList<ScaleModell> list, ScaleModell modell) throws Exception {
		ScaleModell m = modell;
		if(m == null) 
			m = gui.delete();
		list.remove(m);
		file.delete(m);
		return null;
	}

}
