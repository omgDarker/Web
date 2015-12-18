package cn.wegoteam.shop.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.inject.Inject;

@Controller
public class FileUploadAction implements Action ,ServletRequestAware{
	//http://zqshop.oss-cn-beijing.aliyuncs.com
	private File imgFile;
	private String dir;
	private String imgFileFileName;
    private HttpServletRequest request;
	private HashMap<String, String> extMap = new HashMap<String, String>();
	private String maxsize;
	public FileUploadAction(){
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,pdf,htm,html,txt,zip,rar,gz,bz2");	
	}
	public String execute() throws Exception {
		System.out.println(request.getParameter("type"));
		System.out.println(request.getParameter("dir"));
		//文件保存目录路径
		String savePath = ServletActionContext.getServletContext().getRealPath("/")+"/attached/";
		//文件保存目录URL
		String saveUrl  ="attached/";
		String fileDir;
		if(dir==null||imgFileFileName==null) {
			if(request.getParameter("type")!=null){
				 outErrorMsg("您没有选择文件","true");
			}else{
				outErrorMsg("您没有选择文件");
			}
			return null;
		}
		if (imgFile==null){
			if(request.getParameter("type")!=null){
				outErrorMsg("请选择要上传文件","true");
			}else{
				outErrorMsg("请选择要上传文件");
			}
			return null;
		}
		if(dir.equals("image")){
			fileDir="images/";
			if(imgFile.length()>1024*1024){
				if(request.getParameter("type")!=null){
					outErrorMsg("图片大小超过最大限制，请上传小于1M的图片","true");
				}else{
					outErrorMsg("图片大小超过最大限制，请上传小于1M的图片");
				}
				return null;
			}
			
		}else if (dir.equals("file")||dir.equals("media")){
			fileDir="file/";
		}else {
			if(request.getParameter("type")!=null){
				outErrorMsg("文件不被支持","true");
			}else{
				outErrorMsg("文件不被支持");
			}
			return null;
		}
		//检查扩展名
		String fileExt = imgFileFileName.substring(imgFileFileName.lastIndexOf(".") + 1).toLowerCase();
		System.out.println(fileExt);
		if(!Arrays.<String>asList(extMap.get(dir).split(",")).contains(fileExt)){
			if(request.getParameter("type")!=null){
				outErrorMsg("上传文件扩展名是不允许的扩展名，\n只允许" + extMap.get(dir) + "格式。","true");
			}else{
				outErrorMsg("上传文件扩展名是不允许的扩展名，\n只允许" + extMap.get(dir) + "格式。");
			}
			return null;
		}
		
		fileDir += (new SimpleDateFormat("yyyyMMdd").format(new Date())+"/");
		//创建目录结构
		File newFileDir = new File(savePath+fileDir);
		if(!newFileDir.exists()) newFileDir.mkdirs();
		String timeStrig=System.currentTimeMillis()+"";
		timeStrig=timeStrig.substring(timeStrig.length()-6,timeStrig.length()-1)+"_";
		imgFileFileName=timeStrig+imgFileFileName;
		File newFile = new File(savePath+fileDir+imgFileFileName);
		try{
			if(imgFile.exists()){
				FileUtils.copyFile(imgFile, newFile);
			}else{
				if(request.getParameter("type")!=null){
					outErrorMsg("未知错误，请检查文件是否小于10MB或使用非中文文件名","true");
				}else{
					outErrorMsg("未知错误，请检查文件是否小于10MB或使用非中文文件名");
				}
			} 
			saveUrl += (fileDir+imgFileFileName);
			System.out.println(savePath);
			System.out.println(savePath+fileDir+imgFileFileName);
			//OSSObjectSample.uploadImg(saveUrl,savePath+fileDir+imgFileFileName);
			if(request.getParameter("type")!=null){
				outSuccessMsg("上传成功[OK]"+"|/"+saveUrl,"true");
			}else{
				outSuccessMsg(saveUrl);
			}
		}catch (Exception e) {
			e.printStackTrace();
			outErrorMsg("未知");
		}
		return null;       
	}
	private void outErrorMsg(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", "抱歉，上传遇到了错误（"+message+")");
		printMsg( obj.toString());
	}
	private void outErrorMsg(String message,String params){
		if(params.equals("true")){
			printMsg("<script>parent.callBack('"+message+"')</script>");
		}
	}
	private void outSuccessMsg(String url){
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url", url);
		printMsg( obj.toString());
	}
	private void outSuccessMsg(String message,String flag){
		if(flag.equals("true")){
			printMsg("<script>parent.callBack('"+message.split("\\|")[0]+"','"+message.split("\\|")[1]+"')</script>");
		}
	}
	private void printMsg(String arg){	
		HttpServletResponse reponse =  ServletActionContext.getResponse();	
		reponse.setCharacterEncoding("utf-8");
		try {
			PrintWriter out = reponse.getWriter();
			out.write(arg);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//------------------getter and setter----------------------
	public File getImgFile() {
		return imgFile;
	}


	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}


	public String getDir() {
		return dir;
	}


	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public String getMaxsize() {
		return maxsize;
	}

	@Inject(value="struts.multipart.maxSize")
	public void setMaxsize(String maxsize) {
		this.maxsize = maxsize;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
            this.request=arg0;		
	}
	
	
}
