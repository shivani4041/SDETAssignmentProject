package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class ToDoPage {
	
	private WebDriver dr;
	
	public ToDoPage(WebDriver driver) 
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css=".todo-name-input")
	WebElement todoInput;
	

	@FindBy(xpath="//button[@class='form-button form-button-add']")
	WebElement addTaskBtn;
	
	
	@FindBy(css=".todo-item")
	List<WebElement> todoItem;
	
	@FindBy(xpath="//*[@class='todo-item'][1]")
	WebElement todoTask;
	
	@FindBy(xpath="//*[text()='Clear All']")
	WebElement clearBtn;
	
	
	
	public void createToDo(String text) {
		todoInput.sendKeys(text);
		addTaskBtn.click();
	}
	
	public List<String> getToDoList() {
		
		List<String> temp = new ArrayList<String>();
		
		for(WebElement e:todoItem)
			
		{
			temp.add(e.getText().trim());	
		}
		
		return temp;
	}
	
	public int getToDoListCount() {
	      return todoItem.size();
	}
	
	
	
	public int clearToDo() {
		clearBtn.click();
		return todoItem.size();
		
		
	}
	
	

}
