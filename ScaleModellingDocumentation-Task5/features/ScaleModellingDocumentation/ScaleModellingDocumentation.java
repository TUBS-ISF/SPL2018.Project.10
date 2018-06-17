public class ScaleModellingDocumentation {
	public static void main(String[] args) {
		DataFormat format = new DataFormat();
		format.setPath("ScaleModellFile.csv");
		ScaleModellList list = new ScaleModellList(format);
		UserInterface ui = new UserInterface();
		ui.show(list);
	}
}