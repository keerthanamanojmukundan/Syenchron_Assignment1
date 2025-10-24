package com.gen.Sauce;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class Screenshot extends Base {
	public void takeScreenshot() throws IOException{
		
		TakesScreenshot ss=(TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		File destination= new File("./src/test/resources/ScreenShots/summaryvalidation.jpg");
		Files.copy(source, destination);
		
	

	
	}

}
