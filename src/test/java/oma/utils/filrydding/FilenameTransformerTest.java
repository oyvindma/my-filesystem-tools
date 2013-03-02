package oma.utils.filrydding;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FilenameTransformerTest {
	
	
	
	private FilenameTransformer transformer;
	
	@Before
	public void setUp(){
		transformer = new FilenameTransformer();
	}
	
	@Test
	public void shallExtractDigitsFrom_fileName_2010_08_28_18_19_19(){
		String originalFilename = ObjectMother.fileName_2010_08_28_18_19_19;
		
		String result = transformer.transformFilename(originalFilename);
		
		assertThat(result).isNotNull().isEqualTo("20100828181919");
		
	}
	
	@Test
	public void shallExtractDigitsFrom_fileName_2010_08_28_18_19_19_1(){
		String originalFilename = ObjectMother.fileName_2010_08_28_18_19_19_1;
		
		String result = transformer.transformFilename(originalFilename);
		
		assertThat(result).isNotNull().isEqualTo("20100828181919");
	}
	
	@Test
	public void shallExtractDigitsFrom_fileName_2010_08_28_18_19_19_2(){
		String originalFilename = ObjectMother.fileName_2010_08_28_18_19_19_2;
		
		String result = transformer.transformFilename(originalFilename);
		
		assertThat(result).isNotNull().isEqualTo("20100828181919");
	}
	
	@Test
	public void shallExtractDigitsFrom_fileName_2010_08_28_18_19_19_199(){
		String originalFilename = ObjectMother.fileName_2010_08_28_18_19_19_199;
		
		String result = transformer.transformFilename(originalFilename);
		
		assertThat(result).isNotNull().isEqualTo("20100828181919");
	}


	
	@Test
	public void shallExtractDigitsFrom_fileName_IMG_20100828_181919(){
		String originalFilename = ObjectMother.fileName_IMG_20100828_181919;
		
		String result = transformer.transformFilename(originalFilename);
		
		assertThat(result).isNotNull().isEqualTo("20100828181919");
		
	}
}
