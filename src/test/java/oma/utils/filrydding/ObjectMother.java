package oma.utils.filrydding;

import java.io.File;

import oma.utils.filrydding.domain.PictureFile;

public class ObjectMother {
	public static final String fileName_2010_08_22_13_12_13 = "2010-08-22 13.12.13.jpg";
	public static final String fileName_2010_08_28_18_19_19 = "2010-08-28 18.19.19.jpg";
	public static final String fileName_2010_08_28_18_19_19_1 = "2010-08-28 18.19.19-1.jpg";
	public static final String fileName_2010_08_28_18_19_19_2 = "2010-08-28 18.19.19-2.jpg";
	public static final String fileName_2010_08_28_18_19_19_199 = "2010-08-28 18.19.19-199.jpg";
	public static final String fileName_IMG_20100828_181919 = "IMG_20100828_181919.jpg";
	
	
	public static final File file_2010_08_22_13_12_13 = new File(fileName_2010_08_22_13_12_13);
	public static final File file_2010_08_28_18_19_19 = new File(fileName_2010_08_28_18_19_19);
	public static final File file_2010_08_28_18_19_19_1 = new File(fileName_2010_08_28_18_19_19_1);
	public static final File file_IMG_20100828_181919 = new File(fileName_IMG_20100828_181919);
	public static final File dummyFolder = new File("dummyFolder");
	
	public static final PictureFile pictureFile_2010_08_28_18_19_19 = new PictureFile(file_2010_08_28_18_19_19);
	public static final PictureFile pictureFile_2010_08_28_18_19_19_1 = new PictureFile(file_2010_08_28_18_19_19_1);
	public static final PictureFile pictureFile_IMG_20100828_181919 = new PictureFile(file_IMG_20100828_181919);
	public static final PictureFile pictureFile_2010_08_22_13_12_13 = new PictureFile(file_2010_08_22_13_12_13);

}