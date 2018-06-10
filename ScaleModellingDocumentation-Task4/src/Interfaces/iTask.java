package Interfaces;

import java.util.ArrayList;

import main.ScaleModell;

public interface iTask {
	String getDisplayName();
	Boolean task(iFile file, iGui gui, ArrayList<ScaleModell> list, ScaleModell modell) throws Exception;
}
