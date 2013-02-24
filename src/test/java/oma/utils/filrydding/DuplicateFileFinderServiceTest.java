package oma.utils.filrydding;

import static oma.utils.filrydding.ObjectMother.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import oma.utils.filrydding.domain.MapList;
import oma.utils.filrydding.domain.PictureFile;
import oma.utils.repository.FileRepository;
import oma.utils.repository.MobilephotoFilenamefilter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DuplicateFileFinderServiceTest {
	private List<File> mockedFiles;

	@Mock
	private FileRepository repoMock;

	private FilenameTransformer filenameTransformer;

	private DuplicateFileFinderService duplicateFileFinderService;

	private File parentDirectory;

	private MobilephotoFilenamefilter filenameFilter;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		filenameTransformer = new FilenameTransformer();
		parentDirectory = new File("");
		filenameFilter = new MobilephotoFilenamefilter();
		duplicateFileFinderService = new DuplicateFileFinderService(repoMock);

		mockedFiles = new ArrayList<File>();
		mockedFiles.add(file_2010_08_28_18_19_19);
		mockedFiles.add(file_2010_08_28_18_19_19_1);
		mockedFiles.add(file_IMG_20100828_181919);
	}

	@Test
	public void shallReturnAListOfFilesWithSameDigitSequenceInTheFilename() throws Exception {
		when(repoMock.findFilesInDirectory(any(File.class), any(MobilephotoFilenamefilter.class))).thenReturn(mockedFiles);
		MapList duplicatedPictures = duplicateFileFinderService.getFilesGroupedByTransformedFilename(parentDirectory, filenameFilter,
		        filenameTransformer);

		List<PictureFile> pictures = duplicatedPictures.get(filenameTransformer.transformFilename(file_2010_08_28_18_19_19.getName()));

		assertThat(pictures)
		        .hasSize(3)
		        .contains(new PictureFile(file_2010_08_28_18_19_19))
		        .contains(new PictureFile(file_2010_08_28_18_19_19_1))
		        .contains(new PictureFile(file_IMG_20100828_181919));
	}
	@Test
	public void shallCreateSeparateGroupsForFilesWithDifferenteDigitSequenceInTheFileName() throws Exception {
		mockedFiles.add(file_2010_08_22_13_12_13);
		when(repoMock.findFilesInDirectory(any(File.class), any(MobilephotoFilenamefilter.class))).thenReturn(mockedFiles);
		
		MapList duplicatedPictures = duplicateFileFinderService.getFilesGroupedByTransformedFilename(parentDirectory, filenameFilter,
		        filenameTransformer);

		List<PictureFile> pictures = duplicatedPictures.get(filenameTransformer.transformFilename(file_2010_08_28_18_19_19.getName()));
		List<PictureFile> pictures2 = duplicatedPictures.get(filenameTransformer.transformFilename(file_2010_08_22_13_12_13.getName()));

		assertThat(pictures2).hasSize(1);
		assertThat(pictures).hasSize(3);
	}

}
