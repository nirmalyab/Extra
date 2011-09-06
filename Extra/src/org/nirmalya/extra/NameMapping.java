package org.nirmalya.extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Maps;

public class NameMapping {
	
	public static void main(String[] args) {
		try {
			
			HashMap<String, String> localMap = Maps.newHashMap();
			
			BufferedReader mapFile = new BufferedReader(new FileReader(args[0]));
			BufferedReader levelFile = new BufferedReader(new FileReader(args[1]));
			
			String regex1 = "^(\\S+)\\s+(\\S+)\\s+\\S+\\s+(\\S+)\\s+(\\S+)";
			Pattern pat1 = Pattern.compile(regex1);
			
			
			String line1 = null;
			
			while (null != (line1 = mapFile.readLine()) ) {
				Matcher mat1 = pat1.matcher(line1);
				
				if (mat1.find()) {
					String first = mat1.group(1);
					String second = mat1.group(2);
					String third = mat1.group(3);
					String fourth = mat1.group(4);
					
					localMap.put(first, second);
					localMap.put(third, fourth);
				}
			}
			
			mapFile.close();
			
			
			String regex2 = "^(\\S+)\\s+(\\S+)";
			Pattern pat2 = Pattern.compile(regex2);

			PrintWriter outFile = new PrintWriter(new FileWriter(args[2]));
			
			String line2 = null;
			
			while (null != (line2 = levelFile.readLine())) {
				Matcher mat2 = pat2.matcher(line2);
				
				if (mat2.find()) {
					String key = mat2.group(1);
					Integer val = Integer.parseInt(mat2.group(2));
					
					if (localMap.containsKey(key)) {
						String localKey = localMap.get(key);
						outFile.println(localKey + " " + (val -1));
						
					}
				}
			}
			levelFile.close();
			outFile.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
