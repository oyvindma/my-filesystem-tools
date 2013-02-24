package oma.utils.repository;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public interface FileRepository {
	public List<File> findFilesInDirectory(File parentDirectory);
	
	public List<File> findFilesInDirectory(File parentDirectory, FilenameFilter filenameFilter);
}