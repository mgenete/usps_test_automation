package test;

import org.testng.annotations.Test;

import com.base.TestBase;

public class Dummy extends TestBase{
	
	@Test
	public void testClickForJSAlert() {
		System.out.println(driver.getTitle());
	}

}
