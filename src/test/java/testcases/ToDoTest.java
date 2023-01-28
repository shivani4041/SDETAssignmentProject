package testcases;

import org.testng.annotations.Test;


import pages.ToDoPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ToDoTest {
	

	private WebDriver dr;
	private ToDoPage tp;
	
	
	
	
  @Test(priority=0)
  public void createToDoList_001() {
	  
	  tp.createToDo("buy groceries");
	  tp.createToDo("Wash dishes");
	  tp.createToDo("reply to email");
	  tp.createToDo("bank");
	  
  }
  
  @Test(priority=1)
  public void getToDoListItems_002() {
	  
	  List<String> act = tp.getToDoList();
	  System.out.println(act);
	  
	  List<String> exp = new ArrayList<String>();
	  exp.add("buy groceries");
	  exp.add("Wash dishes");
	  exp.add("reply to email");
	  exp.add("bank");
	  
	  Reporter.log("Actual:"+act+"-->"+"Expected:"+exp);
	  Assert.assertEquals(act, exp);

	  
  }
  
  
  @Test(priority=2)
  public void getToDoListCount_003() throws IOException, InterruptedException {
	 
	 
	 int act = tp.getToDoListCount();
	 System.out.println(act);
	 TestUtility.attachScreenshot();
	 Reporter.log("Actual:"+act+"-->"+"Expected:"+4);
	  Assert.assertEquals(act, 4);
  }
  
  
  @Test (priority=3)
  public void clearToDoList_004() {
	 int act = tp.clearToDo();
	 System.out.println(act);
	 Reporter.log("Actual:"+act+"-->"+"Expected:"+0);
	  Assert.assertEquals(act, 0);
	  
  }
  
  
  
  @BeforeClass
  public void beforeClass() throws IOException {

	  dr= TestBase.getInstance();
	  tp = new ToDoPage(dr);
	  
  }

  
  @AfterClass
  public void afterClass() {
	  dr.quit();
  }
  
  

}
