package oma.utils.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import oma.utils.exceptions.FunctionalException;

/**
 * The repository used to interact with the file system.
 */
public class FileRepository {
	
	
	public List<File> findFilesInDirectory(File parentDirectory) {
		if(!parentDirectory.exists()){
			throw new FunctionalException("parentDirectory does not exist.");
		}
		String[] filenamesFound = parentDirectory.list();
		List<File> fileInstances = new ArrayList<>();
		
		for (String filename : filenamesFound) {
			fileInstances.add(new File(parentDirectory, filename));
		}
		
		return fileInstances;
	}
	
}