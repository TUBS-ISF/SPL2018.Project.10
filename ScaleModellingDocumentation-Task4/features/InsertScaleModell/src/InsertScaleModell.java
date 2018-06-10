
import java.util.ArrayList;

import Interfaces.iFile;
import Interfaces.iGui;
import Interfaces.iTask;
import main.ScaleModell;

public class InsertScaleModell implements iTask {

	@Override
	public String getDisplayName() {
		return "insert";
	}
	
	@Override
	public Boolean task(iFile file, iGui gui, ArrayList<ScaleModell> list, ScaleModell modell) throws Exception {
		ScaleModell m = modell;
		if(m == null) 
			m = gui.add();
		list.add(m);
		return file.write(m);
	}
	
}
