package oma.utils.filrydding;

import static oma.utils.filrydding.ObjectMother.file_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.file_2010_08_28_18_19_19_1;
import static oma.utils.filrydding.ObjectMother.file_IMG_20100828_181919;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import oma.utils.repository.FileRepository;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

public class FileNameTransformerTest {
	private List<File> mockedFiles;
	
	@Mock
	private FileRepository repoMock; 
	
	@Before
	public void setUp(){
		mockedFiles = new ArrayList<File>();
		mockedFiles.add(file_2010_08_28_18_19_19);
		mockedFiles.add(file_2010_08_28_18_19_19_1);
		mockedFiles.add(file_IMG_20100828_181919);
	}

	@Test
	@Ignore
	public void shallGroupfilesByFilenames() throws Exception {
		when(repoMock.findFilesInDirectory(any(File.class))).thenReturn(mockedFiles);
	}
	
	public void mapFileNames(){
		
	}

}
