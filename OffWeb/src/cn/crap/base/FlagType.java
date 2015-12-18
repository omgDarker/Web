package cn.crap.base;

public enum FlagType {
	ɾ��("-100"),ͨ������("-3"),�����("-2"),������("-1"),����("1"),��֤�ɹ�("2"),ͨ��ʵ������֤("3"),�����ѽ�ͨ("4"),��׿����("6"),ƻ������("7"),�����ѽ��("8"),�ö�("100");
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
				return "ͨ������";
			case -2:
				return "�����";
			case -1:
				return "������";
			case 1:
				return "����";
			case 2:
				return "��֤�ɹ�";
			case 3:
				return "ͨ��ʵ������֤";
			case 4:
				return "�����ѽ�ͨ";
			case 6:
				return "��׿����";
			case 7:
				return "ƻ������";
			case 8:
				return "�����ѽ��";
			case 100:
				return "�ö�";
			case -100:
				return "��ɾ��";
			default:
				return "δ֪";
		}
	}
}
