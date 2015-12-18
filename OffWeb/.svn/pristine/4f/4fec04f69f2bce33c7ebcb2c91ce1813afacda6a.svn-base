package cn.wegoteam.shop.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class PostAndGetRequset {
	public static String post(String path, Map<String, String> params)
			throws Exception {
		StringBuilder parambuilder = new StringBuilder("");
		if (params != null && !params.isEmpty()) {

			for (Map.Entry<String, String> entry : params.entrySet()) {
				parambuilder.append(entry.getKey()).append("=")
						.append(URLEncoder.encode(entry.getValue(), "UTF-8"))
						.append("&");
			}
			parambuilder.deleteCharAt(parambuilder.length() - 1);
		}
		byte[] data = parambuilder.toString().getBytes();
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);// 允许对外发送请求参数
		conn.setUseCaches(false);// 不进行缓存
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("POST");
		// 下面设置http请求头
		conn.setRequestProperty("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
		conn.setRequestProperty("Accept-Language",
				"en,zh-CN;q=0.8,zh;q=0.6,de;q=0.4,zh-TW;q=0.2,en-US;q=0.2");

		conn.setRequestProperty(
				"User-Agent",
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(data.length));
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Cache-Control", "max-age=0");

		// 发送参数
		DataOutputStream outStream = new DataOutputStream(
				conn.getOutputStream());
		outStream.write(data);// 把参数发送出去
		outStream.flush();
		outStream.close();

		if (conn.getResponseCode() == 200) {
			return readStream(conn.getInputStream());
		}
		return null;
	}

	// 获取页面代码
	public static String Get(String path) throws Exception {
		URL url = new URL(path);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(3 * 1000);
		// 设置头信息
		conn.setRequestProperty(
				"Accept",
				"Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
		conn.setRequestProperty(
				"User-Agent",
				"User-Agent:Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setUseCaches(false);// 不进行缓存
		// 头部必须设置不缓存，否则第二次获取不到sessionID
		conn.setUseCaches(false);
		if (conn.getResponseCode() == 200) {
			return readStream(conn.getInputStream());
		}

		return "";
	}

	// 获取页面代码
	public static String Kuaidi(String path) throws Exception {
		URL url = new URL(path);
		String result = "";
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		url = new URL(path);
		urlConn.setDoInput(true); // 设置输入流采用字节流
		urlConn.setDoOutput(true); // 设置输出流采用字节流
		urlConn.setRequestMethod("POST");
		urlConn.setUseCaches(false); // 设置缓存
		urlConn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		urlConn.setRequestProperty("Charset", "utf-8");
		urlConn.connect();

		DataOutputStream dos = new DataOutputStream(urlConn.getOutputStream());

		dos.writeBytes("tqpadmac=" + URLEncoder.encode("B407F9D67C80", "utf-8"));
		dos.writeBytes("tqpadver=" + URLEncoder.encode("1", "utf-8"));
		dos.flush();
		dos.close();
		if (urlConn.getResponseCode() == 200) {
			// 这句：new InputStreamReader(urlConn.getInputStream(), "gbk") 设置编码
			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream(), "utf-8"));
			String line = "";
			while (null != (line = br.readLine())) {
				result += line;
			}
			br.close();
			urlConn.disconnect();
		}
		return result;
	}

	public static String readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return new String(outSteam.toByteArray(), "utf-8");
	}
}
