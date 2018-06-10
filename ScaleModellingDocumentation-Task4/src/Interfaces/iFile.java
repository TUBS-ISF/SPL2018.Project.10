package Interfaces;

import java.util.ArrayList;
import main.ScaleModell;

public interface iFile{
	void setPath(String path);
	Boolean write(ScaleModell modell);
	ArrayList<ScaleModell> read();
	Boolean delete(ScaleModell modell);
}
