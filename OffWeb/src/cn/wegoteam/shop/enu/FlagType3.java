package cn.wegoteam.shop.enu;

public enum FlagType3 {
//	NOETEFLAG=-1;//不可用
//	YESFLAG=1;//可用
//	ZHIDING=100;//置顶
	促销活动("4"),不可用("-1"),可用("1"),置顶("100"),待审核("-2");
	private final String name;
	
	private FlagType3(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
