package oma.utils.repository;

import java.io.File;
import java.util.List;

public interface FileRepository {
	public List<File> findFilesInDirectory(File parentDirectory); 
}