import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordFrequencies{
	
	public static void main (String args[]) throws FileNotFoundException, IOException {
		Map map1 = new HashMap();
		String argument = "";

		try (BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sBuild = new StringBuilder();
			String line = "";
			String text = "";
			if(args.length > 0) {
				argument = args[0];
			} else {
				argument = argument;
			}
			while((line = bRead.readLine()) != null) {
				text += line;
				
			}
			String[] words = new String[0];
			if((argument.equals("-s")) || (argument.equals("-sc")) || (argument.equals("-cs"))) {
				String[] temp = text.replaceAll("[\\p{Punct}&&[^0-9]]", "").split(" ");
				words = temp;
			} else {
				String[] temp = ((text.replaceAll("[\\p{Punct}&&[^0-9]]", "")).toUpperCase()).split(" ");
				words = temp;
			}
			//String[] words = ((text.replaceAll("[\\p{Punct}&&[^0-9]]", "")).toUpperCase()).split(" ");
			//String line = "";
			//for(int i = 0; i < stringy.length; i++) {
			//	line = line + stringy[i] + " ";
			//}
			//line = line.toUpperCase();

			//while(line != null) {
				//String[] words = line.split(" ");
				for(int i = 0; i < words.length; i++) {
					if(words[i].trim().isEmpty()) {
						continue;
					} else {
					    if(map1.get(words[i]) == null) {
						    map1.put(words[i], 1);
					    } else {
						    int newValue = Integer.valueOf(String.valueOf(map1.get(words[i])));
						    newValue++;
						    map1.put(words[i], newValue);
					    }
					}
				}
				//sBuild.append(System.lineSeparator());
				//line = bRead.readLine();
			//}
		}
		Map<String, String> sorted = new TreeMap<String, String>(map1);
		boolean isT = true;
		if((argument.equals("-c")) || (argument.equals("-cs"))|| (argument.equals("-sc"))){
			for(Object key : sorted.keySet()) {
				System.out.println(key);
			}
		} else {
        for (Object key : sorted.keySet()) {
    	    System.out.println(key + " " + map1.get(key));
        }
    }
   } 
    
  
}
