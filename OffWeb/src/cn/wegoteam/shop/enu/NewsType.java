package cn.wegoteam.shop.enu;

public enum NewsType {
	//新闻类型：通知（INFOR）
		INFOR("新闻"),PAGE("网站页面");
	private final String name;
	
	private NewsType(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
