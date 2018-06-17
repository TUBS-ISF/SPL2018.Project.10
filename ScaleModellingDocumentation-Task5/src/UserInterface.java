import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 


public   class  UserInterface {
	
	public String _path;

	
	public ScaleModellList _list  ;

	
	 private void  show__wrappee__UI  (ScaleModellList list) {
		_list = list;
	}

	
	public void show(ScaleModellList list) {
		show__wrappee__UI(list);
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

	
	public static BufferedReader scanner;

	
	public void insert() throws IOException {

		ScaleModell modell = new ScaleModell();
		String[] attrs = new String[modell.getAttributes().size()];
		for(int i = 0; i < modell.getAttributes().size(); i++) {
			String[] attr = modell.getAttributes().get(i);
			System.out.print(attr[0] + ": ");
			attrs[i] = scanner.readLine();
		}
		modell.setAttributes(attrs);
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
		return _list.remove(name) != null;
	}

	
	public void importFile() throws IOException {
		System.out.println("FilePath: ");
		String path = scanner.readLine();
		_list.importFile(path);
	}


}
