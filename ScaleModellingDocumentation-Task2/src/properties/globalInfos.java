package properties;

public class globalInfos {
	private Boolean _isInsert, _isRead;
	private static globalInfos instance;
	private globalInfos() {
		_isInsert = PropertyManager.getProperty("InsertScaleModell");
		_isRead = PropertyManager.getProperty("GetScaleModell");
	}
	public static globalInfos getInstance() {
		if (instance == null) 
			instance = new globalInfos();
		return instance;
	}
	public static Boolean getIsInsert() {
		return instance._isInsert;
	}
	public static Boolean getIsRead() {
		return instance._isRead;
	}
}
