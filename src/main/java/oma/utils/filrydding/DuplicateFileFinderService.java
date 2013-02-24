package oma.utils.filrydding;

import java.io.File;
import java.util.List;

import oma.utils.filrydding.domain.MapList;
import oma.utils.filrydding.domain.PictureFile;
import oma.utils.repository.FileRepository;
import oma.utils.repository.MobilephotoFilenamefilter;

public class DuplicateFileFinderService {

	private FileRepository fileRepository;

	public DuplicateFileFinderService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
    }

	public MapList getFilesGroupedByTransformedFilename(File parentDirectory, MobilephotoFilenamefilter filenameFilter, FilenameTransformer transformer) {
		List<File> filesInDirectory = fileRepository.findFilesInDirectory(parentDirectory, filenameFilter);

		MapList filesGroupedByDigitsInFilename = new MapList();

		for (File file : filesInDirectory) {
			PictureFile pictureFile = new PictureFile(file);
			String digitsInFilename = transformer.transformFilename(pictureFile.getFileName());
			filesGroupedByDigitsInFilename.put(digitsInFilename, pictureFile);
		}

		return filesGroupedByDigitsInFilename;
	}

}
