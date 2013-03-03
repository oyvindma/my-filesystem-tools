package oma.utils.filrydding.domain;

import java.io.File;

public class PictureFile extends File{

    private static final long serialVersionUID = 1L;

	public PictureFile(String file) {
		super(file);
    }
	public PictureFile(File parent, String file) {
		super(parent, file);
    }

}