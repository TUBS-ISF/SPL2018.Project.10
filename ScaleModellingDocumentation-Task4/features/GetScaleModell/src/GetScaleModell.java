
import Interfaces.iFile;
import Interfaces.iTask;
import Interfaces.iGui;
import main.ScaleModell;

import java.util.ArrayList;
public class GetScaleModell implements iTask{

	@Override
	public String getDisplayName() {
		return "to read the next modell.";
	}
	@Override
	public Boolean task(iFile file, iGui gui, ArrayList<ScaleModell> list, ScaleModell modell) {
		gui.getScaleModell();
		return true;
	}
}
