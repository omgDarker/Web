package cn.wegoteam.shop.enu;

public enum FlagType5 {
//	NOETEFLAG=-1;//不可用
//	YESFLAG=1;//可用
//	ZHIDING=100;//置顶
//  2验证成功
//	3为通过实名制验证
	不可用("-1"),可用("1"),验证成功("2"),通过实名制验证("3");
	private final String name;
	
	private FlagType5(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
