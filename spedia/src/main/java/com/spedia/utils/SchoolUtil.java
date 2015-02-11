package com.spedia.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spedia.model.SchoolData;

/**
 * 
 */

/**
 * @author pawan
 *
 */
public class SchoolUtil {
	public static String getDataBetween2String(String str1,String str2,String content){
		int start_location = content.indexOf(str1);
		int end_location   = content.indexOf(str2);
		return content.substring(start_location+str1.length(), end_location);
	}
	public static String getDataBetween2StringRegex(String str1,String str2,String content){
		 try {
			Pattern p = Pattern.compile(
					 str1+ "(.*)"+str2,
			            Pattern.DOTALL
			        );

			    Matcher matcher = p.matcher(
			    		content
			        );

			    if(matcher.matches()){
			            return matcher.group(1);
			    }else{
			    	return getDataBetween2String(str1,str2,content);
			    }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public static SchoolData getData(String article){
		String school_name=getDataBetween2StringRegex("Name of Institution","Affiliation Number", article);
		String aff_no=getDataBetween2StringRegex("Affiliation Number","State", article);
		String state=getDataBetween2StringRegex("State","District", article);
		String district=getDataBetween2StringRegex("District","Postal Address", article);
		String postal_address=getDataBetween2StringRegex("Postal Address","Pin Code", article);
		String pin_code=getDataBetween2StringRegex("Pin Code","Phone No. with STD Code", article);
		String phone_no=getDataBetween2StringRegex("Phone No. with STD Code","Email", article);
		String email=getDataBetween2StringRegex("Email","Website", article);
		String website=getDataBetween2StringRegex("Website","Year of Foundation", article);
		SchoolData schoolData=new SchoolData(school_name,aff_no,state,district,postal_address,pin_code,phone_no,email,website);
		/*System.out.println(school_name+"=="+aff_no+"=="+state+"=="+district+"=="+
				postal_address+"=="+pin_code+"=="+phone_no+"=="+email+"=="+website);*/
		return schoolData;
	}
	static String extractText(String html) throws IOException {
	    final ArrayList<String> list = new ArrayList<String>();

	    ParserDelegator parserDelegator = new ParserDelegator();
	    ParserCallback parserCallback = new ParserCallback() {
	        public void handleText(final char[] data, final int pos) { 
	            list.add(new String(data));
	        }
	        public void handleStartTag(Tag tag, MutableAttributeSet attribute, int pos) { }
	        public void handleEndTag(Tag t, final int pos) {  }
	        public void handleSimpleTag(Tag t, MutableAttributeSet a, final int pos) { }
	        public void handleComment(final char[] data, final int pos) { }
	        public void handleError(final java.lang.String errMsg, final int pos) { }
	    };
	    parserDelegator.parse(new StringReader(html), parserCallback, true);

	    String text = "";

	    for(String s : list) {
	        text += " " + s;
	    }

	    return text;
	}

	   public static String removeHTML(String htmlString)
	    {
	          // Remove HTML tag from java String    
	        String noHTMLString = htmlString.replaceAll("\\<.*?\\>", "");

	        // Remove Carriage return from java String
	        noHTMLString = noHTMLString.replaceAll("\r", "<br/>");

	        // Remove New line from java string and replace html break
	        noHTMLString = noHTMLString.replaceAll("\n", " ");
	        noHTMLString = noHTMLString.replaceAll("\'", "&#39;");
	        noHTMLString = noHTMLString.replaceAll("\"", "&quot;");
	        return noHTMLString;
	    }

	public static StringBuffer getContent(String url) throws MalformedURLException,
			IOException {
		int c;
		URL hp = new URL(url);
		URLConnection hpCon = hp.openConnection();
		int len = hpCon.getContentLength();
		System.out.println("Content-Length: " + len);
		  StringBuffer content=new StringBuffer("");
			if (len > 0) {
			System.out.println("=== Content ===");
			InputStream input = hpCon.getInputStream();
			int i = len;
			
			while (((c = input.read()) != -1) && (--i > 0)) {
				content.append((char) c);
			}
			input.close();
			} else {
			System.out.println("No Content Available");
			}
		return content;
	}
	
	/*public static String readFile(String fileNanme){
		  String strLine="";
		  StringBuffer content=new StringBuffer("");
		  try{
			    // Open the file that is the first 
			    // command line parameter
			    InputStream stream = FetchData.class.getResourceAsStream(fileNanme);

			  //  FileInputStream fstream = new FileInputStream("/cbse_data.html");
			    // Get the object of DataInputStream
			    //DataInputStream in = new DataInputStream(fstream);
			        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			  
			    //Read File Line By Line
			    while ((strLine = br.readLine()) != null)   {
			      // Print the content on the console
			    	content.append(strLine);
			    }
			    //Close the input stream
			    }catch (Exception e){//Catch exception if any
			      System.err.println("Error: " + e.getMessage());
			    }
			    	return content.toString();
	}*/
	 public static String makeHttpCall(String address) throws Exception{
		 URL url = new URL(address);
		 HttpURLConnection  urlc = (HttpURLConnection) url.openConnection();
		 urlc.setDoOutput(true);
		 urlc.setConnectTimeout(60000);
		 /* OutputStreamWriter writer = new OutputStreamWriter(urlc
		 .getOutputStream());
		 writer.flush();*/
		 // Get the response
		 BufferedReader reader = new BufferedReader(new InputStreamReader(
		 urlc.getInputStream()));
		 StringBuffer sb = new StringBuffer();
		 String line;
		 System.out.println(urlc.getResponseCode());
		 while ((line = reader.readLine()) != null) {
			 sb.append(line);
		 }
		 return sb.toString();
		 
		 }

}
