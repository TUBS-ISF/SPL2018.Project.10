import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public aspect CMD {
	public ScaleModellList _list;
	public static BufferedReader scanner;
	after(ScaleModellList list): execution(void UserInterface.Show(ScaleModellList))  && args(list) {
		_list = list;
		System.out.println("Welcome to this mega scale modelling management tool.");
		String input = "";
		int nextReadIndex = 0;
		scanner  = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("Write exit to close this application.");
			if(_list.isAdd())
				System.out.println("Write 1 to insert a modell");
			if(_list.isGet())
				System.out.println("Write 2 to read the next modell.");
			if(_list.isRemove())
				System.out.println("Write 3 to delete a modell.");
			if(_list.isImport())
				System.out.println("Write 4 to import a file.");
			if(_list.isSearch())
				System.out.println("Write 5 to search a modell.");
			try {
				input = scanner.readLine();
				if (input.equals("1") && _list.isAdd()) 
					insert();
				if (input.equals("2") && _list.isGet()) {
					get(_list.get(nextReadIndex));
					nextReadIndex = (nextReadIndex + 1) % _list.size();
				}
				if (input.equals("3") && _list.isRemove()) {
					remove();
				}
				if (input.equals("4") && _list.isImport()) {
					importFile();
				}
				if (input.equals("5") && _list.isSearch()) {
					search();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!input.toLowerCase().equals("exit") );
		try {
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Exit.");
	}
	public void insert() throws IOException {

		ScaleModell modell = new ScaleModell();
		for(int i = 0; i < modell.getAttributes().size(); i++) {
			String[] attr = modell.getAttributes().get(i);
			System.out.print(attr[0] + ": ");
			String value = scanner.readLine();
			modell.setAttribute(attr[0], value);
		}
		_list.add(modell);
	}
	public void get(ScaleModell modell) {
		for(int i = 0; i < modell.getAttributes().size(); i++) {
			String[] attr = modell.getAttributes().get(i);
			System.out.println(attr[0] + ": " + attr[1]);
		}
	}
	public boolean remove() throws IOException {
		System.out.println("Name: ");
		String name = scanner.readLine();
		int index = -1;
		for (int i = 0; i < _list.size(); i++) {
			if(_list.get(i).equals(name)) {
				index = i;
				break;
			}
		}
		if(index == -1)
			return false;
		return _list.remove(index) != null;
	}
	public void importFile() throws IOException {
		System.out.println("FilePath: ");
		String path = scanner.readLine();
		_list.importFile(path);
	}
	public void search() throws IOException {
		System.out.println("Name: ");
		String name = scanner.readLine();
		ScaleModell m = _list.search(name);
		for(int i = 0; i < m.getAttributes().size(); i++) {
			String[] attr = m.getAttributes().get(i);
			System.out.println(attr[0] + ": " + attr[1]);
		}
	}
}