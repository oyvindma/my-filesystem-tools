package oma.utils.repository;

import java.io.File;
import java.io.FilenameFilter;

public class MobilephotoFilenamefilter implements FilenameFilter{
	String fileNamePatternA="\\d{4}-\\d{2}-\\d{2} \\d{2}.\\d{2}.\\d{2}(-\\d+)?.jpg";
	String fileNamePatternB="IMG_\\d{8}_\\d{6}.jpg";
	@Override
    public boolean accept(File dir, String name) {
		
	    return name.matches(fileNamePatternA) || name.matches(fileNamePatternB);
    }
	
}
