package main;
import java.util.ArrayList;

import Interfaces.iFile;

public class ScaleModellArrayList extends ArrayList<ScaleModell>{
	private iFile _file;
	public ScaleModellArrayList(iFile file) {
		_file = file;
	}
}
