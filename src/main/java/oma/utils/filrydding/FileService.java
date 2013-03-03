package oma.utils.filrydding;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import oma.utils.filrydding.domain.FileGroups;
import oma.utils.filrydding.domain.PictureFile;
import oma.utils.repository.FileRepository;

public class FileService {

	private FileRepository fileRepository;

	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
    }

	public FileGroups getFilesGroupedByTransformedFilename(File parentDirectory, FilenameFilter filenameFilter, FilenameTransformer transformer) {
		List<File> filesInDirectory = fileRepository.findFilesInDirectory(parentDirectory, filenameFilter);

		FileGroups filesGroupedByDigitsInFilename = new FileGroups();

		for (File file : filesInDirectory) {
			PictureFile pictureFile = new PictureFile(file.getParentFile(), file.getName());
			String digitsInFilename = transformer.transformFilename(pictureFile.getName());
			if(!"".equals(digitsInFilename)){
				filesGroupedByDigitsInFilename.addFileToGroup(digitsInFilename, pictureFile);
			}
		}

		return filesGroupedByDigitsInFilename;
	}

}
