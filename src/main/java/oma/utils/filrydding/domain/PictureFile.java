package oma.utils.filrydding.domain;

import java.io.File;

public class PictureFile{

	private File file;

	public PictureFile(File file) {
		this.file = file;
    }

	public String getFileName() {
        return file.getName();
    }

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((file == null) ? 0 : file.hashCode());
	    return result;
    }

	@Override
    public boolean equals(Object obj) {
	    if (this == obj) {
		    return true;
	    }
	    if (obj == null) {
		    return false;
	    }
	    if (!(obj instanceof PictureFile)) {
		    return false;
	    }
	    PictureFile other = (PictureFile) obj;
	    if (file == null) {
		    if (other.file != null) {
			    return false;
		    }
	    } else if (!file.equals(other.file)) {
		    return false;
	    }
	    return true;
    }
	
	
	
}