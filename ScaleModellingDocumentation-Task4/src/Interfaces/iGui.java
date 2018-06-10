package Interfaces;

import java.io.IOException;

import main.ScaleModell;

public interface iGui {
	void show();
	ScaleModell delete() throws IOException;
	ScaleModell add() throws IOException;
	void getScaleModell();
}
