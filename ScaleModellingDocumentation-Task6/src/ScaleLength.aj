public aspect ScaleLength {
	declare precedence : OriginalCountry, ScaleLength, ScaleWidth, ScaleHeight, ScaleModellManufacturer, Scale, Name;
	after () returning (ScaleModell m):call(ScaleModell.new())  {
		m.newAttr("ScaleLength");
	}
}