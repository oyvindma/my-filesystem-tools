package oma.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import oma.utils.filrydding.FileService;
import oma.utils.filrydding.FilenameTransformer;
import oma.utils.filrydding.domain.Filegroups;
import oma.utils.filrydding.domain.PictureFile;
import oma.utils.repository.FileRepositoryImpl;
import oma.utils.repository.MobilephotoFilenamefilter;

public class MyApp {
	public static void main(String[] args) {
	    FileService fileFinderService = new FileService(new FileRepositoryImpl());
	    File parentDirectory = new File("/home/oyvindma/Pictures/mobilbilder");
		FilenameFilter filenameFilter = new MobilephotoFilenamefilter();
		FilenameTransformer transformer = new FilenameTransformer();
		
		Filegroups filesGroupedByTransformedFilename = fileFinderService.getFilesGroupedByTransformedFilename(parentDirectory, filenameFilter, transformer);

		//TODO create Filegroup to hold List<PictureFile> and methods to extract relevant data.
		Map<String, List<PictureFile>> groupsWithMoreThanOneFile = filesGroupedByTransformedFilename.getGroupsWithMoreThanOneFile();
		
		Iterator<Entry<String, List<PictureFile>>> iterator = groupsWithMoreThanOneFile.entrySet().iterator(); 
		while (iterator.hasNext()){
			Entry<String, List<PictureFile>> entry = iterator.next();
			System.out.println("Entry: "+entry.getKey());
			List<PictureFile> files = entry.getValue();
			for(PictureFile picture: files){
				System.out.println(picture.getFileName());
			}
        }
		
    }

}