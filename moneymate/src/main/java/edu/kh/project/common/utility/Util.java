package edu.kh.project.common.utility;

import java.text.SimpleDateFormat;

public class Util {

	public static String XSSHandling(String content) {



		content = content.replaceAll("&", "&amp;");
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\"", "&quot;");

		return content;
	}

	public static String fileRename(String originFileName) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

		int ranNum = (int)(Math.random() * 100000); // 5자리 랜덤 숫자 생성

		String str = "_" + String.format("%05d", ranNum);

		String ext = originFileName.substring(originFileName.lastIndexOf("."));

		return date + str + ext;
	}

}
