package oma.utils.filrydding;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import oma.utils.filrydding.domain.Filegroups;
import oma.utils.filrydding.domain.PictureFile;
import oma.utils.repository.FileRepository;

public class FileService {

	private FileRepository fileRepository;

	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
    }

	public Filegroups getFilesGroupedByTransformedFilename(File parentDirectory, FilenameFilter filenameFilter, FilenameTransformer transformer) {
		List<File> filesInDirectory = fileRepository.findFilesInDirectory(parentDirectory, filenameFilter);

		Filegroups filesGroupedByDigitsInFilename = new Filegroups();

		for (File file : filesInDirectory) {
			PictureFile pictureFile = new PictureFile(file);
			String digitsInFilename = transformer.transformFilename(pictureFile.getFileName());
			filesGroupedByDigitsInFilename.put(digitsInFilename, pictureFile);
		}

		return filesGroupedByDigitsInFilename;
	}

}
