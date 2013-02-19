package oma.utils.repository;

import static org.fest.assertions.Assertions.assertThat;
import static oma.utils.filrydding.ObjectMother.*;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import oma.utils.exceptions.FunctionalException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
public class FileRepositoryImplTest {
	
	@Rule
	public TemporaryFolder sourceFolder = new TemporaryFolder();
	private FileRepositoryImpl repository;
	
	@Before
	public void setUp() throws IOException{
		sourceFolder.create();
		repository = new FileRepositoryImpl();
	}

	@Test
	public void shallReturnAllFilesInADirectory() throws IOException {
		sourceFolder.newFile("a.txt");
		
		List<File> filesFound = repository.findFilesInDirectory(sourceFolder.getRoot());
		
		assertThat(filesFound)
						.isNotNull()
						.isNotEmpty()
						.contains(new File(sourceFolder.getRoot(), "a.txt"));
	}
	
	@Test
	public void shallReturnEmptyListWhenNoFilesFound() throws IOException {
		
		List<File> filesFound = repository.findFilesInDirectory(sourceFolder.getRoot());
		
		assertThat(filesFound)
						.isNotNull()
						.isEmpty();
	}
	
	@Test
	public void shallThrowExceptionWhenSourceFolderDoesNotExist() throws IOException {
		sourceFolder.delete();
		assertThat(sourceFolder.getRoot()).doesNotExist();
		
		try{
			repository.findFilesInDirectory(sourceFolder.getRoot());
			fail("Should throw exception when source folder does not exist.");
		}catch(Exception e){
			assertThat(e).isInstanceOf(FunctionalException.class);
		}
		
	}
	
	
}


