package com.csv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.print.DocFlavor.INPUT_STREAM;

public class Read {
	public static void main(String[] args) {
		try {
			URL u=new URL("https://www.staples.com/Computer-office-desks/cat_CL210795/663ea?icid=BTS:2020:STUDYSPACE:DESKS");
			HttpsURLConnection hr=(HttpsURLConnection)u.openConnection();
			System.out.println(hr.getResponseCode());
			if(hr.getResponseCode()==200) {
				InputStream im=hr.getInputStream();
				StringBuffer sb=new StringBuffer();
				BufferedReader br=new BufferedReader(new InputStreamReader(im));
				String line= br.readLine();
				while(line!=null) {
					System.out.println(line);
					line=br.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
