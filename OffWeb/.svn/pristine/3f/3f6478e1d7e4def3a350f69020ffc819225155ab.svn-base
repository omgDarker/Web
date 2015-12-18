package cn.wegoteam.shop.util;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.io.IOException;

import java.util.Random;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class AuthImg extends HttpServlet {

	private static final long serialVersionUID = 8165458985542870320L;

	// 设置图形验证码中的字符串的字体的大小

	private Font mFont = new Font("",Font.BOLD,26);

	public void init() throws ServletException {

		super.init();

	}

	/**
	 * 
	 * 生成随机颜色
	 * 
	 * @param fc
	 * 
	 * @param bc
	 * 
	 * @return
	 */

	Color getRandColor(int fc, int bc) {

		Random random = new Random();

		if (fc > 255)

			fc = 255;

		if (bc > 255)

			bc = 255;

		int r = fc + random.nextInt(bc - fc);

		int g = fc + random.nextInt(bc - fc);

		int b = fc + random.nextInt(bc - fc);

		return new Color(r, g, b);

	}

	// servlet的响应方法
	public void service(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {

		// 生成服务器相应的service方法

		// 阻止生成的页面内容被缓存，保证每次重新生成随机验证码

		response.setHeader("Pragma", "No-cache");

		response.setHeader("Cache-Control", "no-cache");

		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

		// 指定图形验证码图片的大小；

		int width = 100;// 宽度

		int height = 32;// 高度

		BufferedImage image = new BufferedImage(width, height,

		BufferedImage.TYPE_INT_RGB);

		// 准备在图片中绘制内容

		Graphics g = image.getGraphics();

		Random random = new Random();

		g.setColor(getRandColor(200, 250));

		g.fillRect(1, 1, width - 1, height - 1);

		g.setColor(new Color(202, 102, 102));

		g.drawRect(0, 0, width - 1, height - 1);

		g.setFont(mFont);

		g.setColor(getRandColor(160, 200));

		// 生成随机线条

		for (int i = 0; i < 155; i++) {

			int x = random.nextInt(width - 1);

			int y = random.nextInt(height - 1);

			int xl = random.nextInt(16) + 1;

			int yl = random.nextInt(22) + 1;

			g.drawLine(x, y, x + xl, y + yl);

		}
		// 从另一个方向画随机线条
		for (int i = 0; i < 70; i++) {

			int x = random.nextInt(width - 1);

			int y = random.nextInt(height - 1);

			int xl = random.nextInt(52) + 1;

			int yl = random.nextInt(56) + 1;

			g.drawLine(x, y, x - xl, y - yl);

		}
		// 生成随机的字符串并加入到图片中
		String sRand = "";
		int LEN = 4; // 控制随机码的长度

		for (int i = 0; i < LEN; i++) {

			String tmp = getRandomChar();

			sRand += tmp;

			g.setColor(new Color(20 + random.nextInt(110), 20 + random

			.nextInt(110), 20 + random.nextInt(110)));
			
			//单个字符输出坐标
			g.drawString(tmp, 20 * i + 10,24);

		}

		HttpSession session = request.getSession(true);


		// 将其自动转换为小写。也就是说用户在输入验证码的时候，不需要区分大小写，方便输入。

		session.setAttribute(Const.SESS_RANDOM_IMG, sRand.toLowerCase());

		g.dispose();

		ImageIO.write(image, "JPEG", response.getOutputStream());

	}

	/**
	 * 
	 * 随机生成字符串
	 * 
	 * @return
	 */

	private String getRandomChar() {

		int rand = (int) Math.round(Math.random() * 2);

		long itmp = 0;

		char ctmp = '\u0000';

		switch (rand) {

		case 1:

			itmp = Math.round(Math.random() * 25 + 65);

			ctmp = (char) itmp;

			return String.valueOf(ctmp);

		case 2:

			itmp = Math.round(Math.random() * 25 + 97);

			ctmp = (char) itmp;

			return String.valueOf(ctmp);

		default:

			itmp = Math.round(Math.random() * 9);

			return String.valueOf(itmp);

		}

	}
	public static String getNumber(int num){
		Random random = new Random();
		String temp="";
		for(int i=0;i<num;i++){
			temp=temp+random.nextInt(9);
		}
		return temp;
	}
	public static String getChar(int num){
		String md="123456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ789abcd";
		Random random = new Random();
		String temp="";
		for(int i=0;i<num;i++){
			temp=temp+md.charAt(random.nextInt(50));
		}
		return temp;
	}
}

