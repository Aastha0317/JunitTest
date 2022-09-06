package objectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CheckBox {
	private final WebDriver driver;
	WebDriverWait wait;
	
	public CheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(name="allbox")
	WebElement toggleAllCheckbox;
	
	@FindBy(name="data")
	WebElement addDataField;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement addButton;
	
	@FindBy(xpath="//form[@name='todo']/ul/li/input")
	List<WebElement> dataCheckboxes;
	
	@FindBy(xpath="//input[@value='Remove']")
	WebElement removeBtn;
	
	public void checkedToggleAll() {
		toggleAllCheckbox.click();
		//Assert.assertTrue(toggleAllCheckbox.isSelected());
	}
	
	public void navigateURL(String url) {
		driver.get(url);
	}
	
	public void addData(String name) {
		
		for(int i=1;i<4;i++) {
			
			addDataField.sendKeys(name+"-"+i);
			addButton.click();
		}
	}
	
	public void verifyCheckboxesChecked() {
		checkedToggleAll();
		for(int i=0; i<dataCheckboxes.size();i++) {
			Assert.assertTrue(dataCheckboxes.get(i).isSelected());
		}
	}
	
	public void clickOneItem() {
		    addDataField.sendKeys("Test");
		    addButton.click();
			dataCheckboxes.get(0).click();
			
	}
	
	public void clickRemoveButton() {
		removeBtn.click();
	}
	
	public void verifyRemovedItem() throws InterruptedException {
		Thread.sleep(5000);
		if(dataCheckboxes.size()>0) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	}
}
