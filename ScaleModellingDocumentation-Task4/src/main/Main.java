package main;

import Interfaces.iGui;

public class Main {

	public static void main(String[] args) {
		iGui gui = loader.PluginLoader.load(iGui.class).get(0);
		gui.show();
	}

}
