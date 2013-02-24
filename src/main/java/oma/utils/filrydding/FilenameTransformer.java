package oma.utils.filrydding;

import com.google.common.base.CharMatcher;

public class FilenameTransformer {
	public String transformFilename(String originalFilename){
			originalFilename = originalFilename.replaceAll("-\\d+\\.jpg", "");
			
			String theDigits = CharMatcher.DIGIT.retainFrom(originalFilename); // only the digits
			return theDigits;
		}
}

