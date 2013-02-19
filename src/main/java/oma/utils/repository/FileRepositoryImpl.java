package oma.utils.repository;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import oma.utils.exceptions.FunctionalException;

/**
 * The repository used to interact with the file system.
 */
public class FileRepositoryImpl implements FileRepository {
	
	public List<File> findFilesInDirectory(File parentDirectory, FilenameFilter fileFilter) {
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
	
	public List<File> findFilesInDirectory(File parentDirectory) {
		return findFilesInDirectory(parentDirectory, new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return true;
			}
		});
	}
	
}