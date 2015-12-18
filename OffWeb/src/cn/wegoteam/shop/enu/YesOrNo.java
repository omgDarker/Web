package cn.wegoteam.shop.enu;

public enum YesOrNo {
	YES("是"),NO("否");
	private final String name;
	
	private YesOrNo(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

}
