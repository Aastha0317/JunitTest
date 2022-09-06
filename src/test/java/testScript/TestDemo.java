package testScript;

import org.junit.Test;

import com.github.javafaker.Faker;

import config.FrameworkException;
import config.TestSetup;
import objectRepo.CheckBox;

public class TestDemo extends TestSetup{
	
	@Test
	public void testAllCheckbox() {
		
		Faker fake = new Faker();

		String name = "Demo_" + fake.name().firstName();
		try {
			String homePage = "https://techfios.com/test/101/";
            
			CheckBox cat = new CheckBox(driver);
			cat.navigateURL(homePage);
			cat.addData(name);
			cat.verifyCheckboxesChecked();
			driver.quit();

		} catch (Exception e) {
			throw new FrameworkException("Exception  " + e.toString() + " occurred");
		}
	}

	@Test
	public void testRemoveAllItems() {
		
		Faker fake = new Faker();

		String name = "Demo_" + fake.name().firstName();
		try {
			String homePage = "https://techfios.com/test/101/";
            
			CheckBox cat = new CheckBox(driver);
			cat.navigateURL(homePage);
			cat.addData(name);
			cat.verifyCheckboxesChecked();
			cat.clickRemoveButton();
			cat.verifyRemovedItem();
			driver.quit();

		} catch (Exception e) {
			throw new FrameworkException("Exception  " + e.toString() + " occurred");
		}
	}

	@Test
	public void testRemoveButton() {
		
		try {
			String homePage = "https://techfios.com/test/101/";
            
			CheckBox cat = new CheckBox(driver);
			cat.navigateURL(homePage);
			cat.clickOneItem();
			cat.clickRemoveButton();
			cat.verifyRemovedItem();
			driver.quit();

		} catch (Exception e) {
			throw new FrameworkException("Exception  " + e.toString() + " occurred");
		}
	}

}
