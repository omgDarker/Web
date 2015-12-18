package cn.crap.base;

public enum FlagType {
	删除("-100"),通话故障("-3"),待审核("-2"),不可用("-1"),可用("1"),验证成功("2"),通过实名制验证("3"),主叫已接通("4"),安卓可用("6"),苹果可用("7"),故障已解决("8"),置顶("100");
	private final String name;
	
	private FlagType(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public static String getFlagName(int flag){
		switch(flag){
			case -3:
				return "通话故障";
			case -2:
				return "待审核";
			case -1:
				return "不可用";
			case 1:
				return "可用";
			case 2:
				return "验证成功";
			case 3:
				return "通过实名制验证";
			case 4:
				return "主叫已接通";
			case 6:
				return "安卓可用";
			case 7:
				return "苹果可用";
			case 8:
				return "故障已解决";
			case 100:
				return "置顶";
			case -100:
				return "已删除";
			default:
				return "未知";
		}
	}
}
