import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Interfaces.iAttribute;
import Interfaces.iFile;
import Interfaces.iGui;
import Interfaces.iTask;
import main.ScaleModell;

public class CMD implements iGui {

	private ArrayList<iTask> _tasks = new ArrayList<iTask>();
	public ArrayList<iTask> getProperties() {
		return _tasks;
	}
	public static BufferedReader scanner;
	public ArrayList<ScaleModell> _list = new ArrayList<ScaleModell>();
	public iFile _file;
	private int nextReadIndex = 0;
	@Override
	public void show() {
		List<iTask> list = loader.PluginLoader.load(iTask.class);
			
		for (iTask t: list)
			_tasks.add(t);
		_file = loader.PluginLoader.load(iFile.class).get(0);
		System.out.println("Welcome to this mega scale modelling management tool.");
		//Only for creating an Object of globalInfos
		String input = "";
		scanner  = new BufferedReader(new InputStreamReader(System.in));
		_list = _file.read();
		do {
			System.out.println("Write exit to close this application.");
			for(int i = 0; i < _tasks.size(); i++) {
				System.out.println("Write " + i + " to " + _tasks.get(i).getDisplayName());
			}
			try {
				input = scanner.readLine();
				try {
					int index = Integer.parseInt(input);
					_tasks.get(index).task(_file, this, _list, null);
				} catch(Exception ex) { }
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!input.toLowerCase().equals("exit") );
		try {
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("Exit.");
	}
	@Override
	public ScaleModell delete() throws IOException {
		System.out.println("Name: ");
		String name = scanner.readLine();
		for(int i = 0; i < _list.size(); i++) {
			if(_list.get(i).equals(name))
				return _list.get(i);
		}
		return null;
	}
	@Override
	public ScaleModell add() throws IOException {
		System.out.println("Name: ");
		String name = scanner.readLine();
		System.out.println("Scale: ");
		String scale = scanner.readLine();
		ScaleModell modell = new ScaleModell(name, scale);
		for (int i = 0; i < modell.getProperties().size(); i++) {
			iAttribute attr = modell.getProperties().get(i);
			System.out.println( attr.getDisplayname() + ": ");
			String value = scanner.readLine();
			attr.setValue(value);
		}
		return modell;
	}
	@Override
	public void getScaleModell() {
		ScaleModell modell = _list.get(nextReadIndex);
		nextReadIndex = (nextReadIndex + 1) % _list.size();
		System.out.println("Name: " + modell.getName());
		System.out.println("Scale: " + modell.getScale());
		for(int i = 0; i < modell.getProperties().size(); i++) {
			iAttribute attr = modell.getProperties().get(i);
			System.out.println( attr.getDisplayname() + ": " + attr.getValue());
		}
	}
}
