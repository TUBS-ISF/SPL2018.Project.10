import java.util.ArrayList;

public aspect ScaleHeight {
	declare precedence : OriginalCountry, ScaleLength, ScaleWidth, ScaleHeight, ScaleModellManufacturer, Scale, Name;
	after () returning (ScaleModell m):call(ScaleModell.new())  {
		m.newAttr("ScaleHeight");
	}
}