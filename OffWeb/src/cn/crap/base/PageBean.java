package cn.crap.base;

public class PageBean {
    private int size = 3;//每页显示的大小
    private int totalPage=0;//总的页数
    private int currentPage=1;//当前页数
    private int allRow;//总的记录数
    public PageBean(){
    	
    }
    public PageBean(int size){
    	this.size=size;
    }
    public int countTotalPage(final int allRow,final int pageSize){
    	return allRow%pageSize==0?allRow/pageSize:allRow/pageSize+1;
    }
    public int countTotalPage(){
    	return countTotalPage(allRow,size);
    }
    public int countOffSet(){
    	return size*(currentPage-1);
    }
    //计算每次分页显示时的起始游标
    public int countOffSet(final int pageSize,final int currentPage){
    	return pageSize*(currentPage-1);
    }
    /***********************set()和get()方法*************************/
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		//action 中重新设置pageSize会有bug，因为currentPage，allRow，totalPage赋值的顺序不一样
//		if(totalPage>0&&currentPage>totalPage){
//			this.currentPage=totalPage;
//		}else
			this.currentPage = currentPage>0?currentPage:1;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
		this.totalPage=countTotalPage(this.allRow,this.size);
	}
    
    
}
