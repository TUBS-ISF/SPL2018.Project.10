public class UserInterface {
	public ScaleModellList _list;
	public void Show(ScaleModellList list) {
		_list = list;
		System.out.println(list.size());
	}
}