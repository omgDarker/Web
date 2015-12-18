package cn.wegoteam.shop.enu;
/*
 * 性别类型
 */
public enum SexType {
   MALE("男"),FEMALE("女");
   private final String name;
   private SexType(String name){
	   this.name=name;
   }
   public String getName(){
	   return name;
   }
}
