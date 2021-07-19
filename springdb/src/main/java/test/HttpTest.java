package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class HttpTest {
	
	public static void main(String[] args) {
		URL url;
		HttpURLConnection con=null;
		InputStream is=null;
		BufferedReader buffr=null;
		
		try {
			url = new URL("http://localhost:8888/data/members.xml");
			con = (HttpURLConnection)url.openConnection();
			//웹상의 요청이 가능한 시점
			con.setRequestMethod("GET");
			is=con.getInputStream();//웹상의 요청 후, 순간적으로 서버와 연결 될때의 스트림을 통해 데이터를 가져올 수 있다.
			buffr = new BufferedReader(new InputStreamReader(is));
			
			String tag=null;
			StringBuilder sb = new StringBuilder();
			while(true) {
				tag = buffr.readLine();
				if(tag==null)break;
				sb.append(tag);
			}
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(buffr!=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
