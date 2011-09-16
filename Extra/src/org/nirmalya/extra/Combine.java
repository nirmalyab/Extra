package org.nirmalya.extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author nirmalya
 *
 */
public class Combine {
	public static void main(String[] args) {
		String file1 = args[0];
		String file2 = args[1];
		String file3 = args[2];
		
		String regex = "^\\S+\\s+(\\S+)";
		Pattern pat = Pattern.compile(regex);
		
		String lineFile1 = null;
		String lineFile2 = null;
		
		BufferedReader reader1;
		try {
			reader1 = new BufferedReader(new FileReader(file1));
		
		BufferedReader reader2 = new BufferedReader(new FileReader(file2));
		
		PrintWriter out = new PrintWriter(new FileWriter(file3));
		while (null != (lineFile1 = reader1.readLine())) {
			lineFile2 = reader2.readLine();
			
			Matcher mat1 = pat.matcher(lineFile1);
			
			String gene = null;
			if (mat1.find()) {
				gene = mat1.group(1);
			}
			
			String score = null;
			
			Matcher mat2 = pat.matcher(lineFile2);
			
			if (mat2.find()) {
				score = mat2.group(1);
			}
			out.println(gene + " " + score);
		}
		out.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
