package sample.sample;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch {

	 //static String Status = "failed";
	public static final String AUTOMATE_USERNAME = "mohammadk";
	public static final String AUTOMATE_ACCESS_KEY = "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setup() {
		com.lambdatest.utils.ExtentReportListner.onTestStart();
	}

	public static void googleSearch(WebDriver driver) throws MalformedURLException, InterruptedException {
		// Open google.com
//		driver.get("https://www.google.com/");
//		WebElement element = driver.findElement(By.name("q"));
//		element.sendKeys("Lambdatest");
//		element.submit();
//		Thread.sleep(5000);
//		Assert.assertEquals("Lambdatest - Google Search", driver.getTitle());
//		driver.quit();

		String spanText;
		System.out.println("Loading Url");

		driver.get("https://lambdatest.github.io/sample-todo-app/");

		System.out.println("Checking Box");
		driver.findElement(By.name("li1")).click();

		System.out.println("Checking Another Box");
		driver.findElement(By.name("li2")).click();

		System.out.println("Checking Box");
		driver.findElement(By.name("li3")).click();

		System.out.println("Checking Another Box");
		driver.findElement(By.name("li4")).click();

//		driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//		driver.findElement(By.id("addbutton")).click();
//
//		driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//		driver.findElement(By.id("addbutton")).click();
//
//		driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//		driver.findElement(By.id("addbutton")).click();
//
//		System.out.println("Checking Another Box");
//		driver.findElement(By.name("li1")).click();
//
//		System.out.println("Checking Another Box");
//		driver.findElement(By.name("li3")).click();
//
//		System.out.println("Checking Another Box");
//		driver.findElement(By.name("li7")).click();
//
//		System.out.println("Checking Another Box");
//		driver.findElement(By.name("li8")).click();
//
//		System.out.println("Entering Text");
//		driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//
//		driver.findElement(By.id("addbutton")).click();
//
//		System.out.println("Checking Another Box");
//		driver.findElement(By.name("li9")).click();
//
//		// Let's also assert that the todo we added is present in the list.
//
//		spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText();
//		Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
		//Status = "passed";
		//Thread.sleep(150);

		System.out.println("TestFinished");
		driver.quit();
	}

	@Test
	public static void launchChrome()
			throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("build", "Corebridge Demo");
		caps.setCapability("name", "chrome test");
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("network", true);
		caps.setCapability("version", "100.0");
		caps.setCapability("resolution", "1600x1200");
		caps.setCapability("tunnel", false);
		com.lambdatest.utils.LambdaTestApi ltApi = new com.lambdatest.utils.LambdaTestApi();
		com.lambdatest.utils.ExtentReportListner reporter = new com.lambdatest.utils.ExtentReportListner();
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		String session_id = sessionid.toString();

		googleSearch(driver);
		System.out.println(ltApi.getSessionDetails(session_id));
		String sessionName = ltApi.getValue(ltApi.getSessionDetails(session_id), "name");
		ltApi.markTestStatus(session_id, "FAILED", "Fail");
		reporter.onTestFailure(sessionName);

	}

	@Test
	public static void launchEdge()
			throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("build", "Corebridge Demo");
		caps.setCapability("name", "edge test");
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("browserName", "MicrosoftEdge");
		caps.setCapability("version", "100.0");
		caps.setCapability("resolution", "1600x1200");
		caps.setCapability("tunnel", false);
		com.lambdatest.utils.LambdaTestApi ltApi = new com.lambdatest.utils.LambdaTestApi();
		com.lambdatest.utils.ExtentReportListner reporter = new com.lambdatest.utils.ExtentReportListner();
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		System.out.println(sessionid);

		googleSearch(driver);

		String session_id = sessionid.toString();
		String sessionName = ltApi.getValue(ltApi.getSessionDetails(session_id), "name");
		System.out.println(ltApi.getSessionDetails(session_id));
		ltApi.markTestStatus(session_id, "FAILED", "Fail");
		reporter.onTestFailure(sessionName);
	}

	@Test
	public static void launchSafari()
			throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("build", "Corebridge Demo");
		caps.setCapability("name", "safari test");
		caps.setCapability("platform", "macOS Mojave");
		caps.setCapability("browserName", "Safari");
		caps.setCapability("version", "12.0");
		caps.setCapability("resolution", "1920x1080");
		caps.setCapability("tunnel", false);
		com.lambdatest.utils.LambdaTestApi ltApi = new com.lambdatest.utils.LambdaTestApi();
		com.lambdatest.utils.ExtentReportListner reporter = new com.lambdatest.utils.ExtentReportListner();
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		System.out.println(sessionid);

		googleSearch(driver);
		String session_id = sessionid.toString();
		String sessionName = ltApi.getValue(ltApi.getSessionDetails(session_id), "name");
		System.out.println(ltApi.getSessionDetails(session_id));
		ltApi.markTestStatus(session_id, "PASSED", "Pass");
		
		JSONObject videoResponse = ltApi.getVideo(session_id);
		Map<String, String> metadata = new LinkedHashMap<>();
		metadata.put("View Test", "<a href='https://automation.lambdatest.com/test?sessionId="+session_id+"' target='_blank'>Logs</a>");
		metadata.put("Download Test", "<a href='"+videoResponse.getString("url")+"'>Video</a>");
		metadata.put("Watch Test ", "<video width='400' controls><source src='"+videoResponse.getString("url")+"' type='video/mp4'></video>");
		reporter.onTestPass(sessionName, metadata);
	}

	@Test
	public static void launchFirefox()
			throws InterruptedException, UnsupportedEncodingException, URISyntaxException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("build", "Corebridge Demo");
		caps.setCapability("name", "firefox test");
		caps.setCapability("platform", "macOS Mojave");
		caps.setCapability("browserName", "Firefox");
		caps.setCapability("version", "99.0");
		caps.setCapability("resolution", "1920x1080");
		caps.setCapability("tunnel", false);
		com.lambdatest.utils.LambdaTestApi ltAPI = new com.lambdatest.utils.LambdaTestApi();
		com.lambdatest.utils.ExtentReportListner reporter = new com.lambdatest.utils.ExtentReportListner();
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();

		googleSearch(driver);

		String session_id = sessionid.toString();
		String sessionName = ltAPI.getValue(ltAPI.getSessionDetails(session_id), "name");
		System.out.println(ltAPI.getSessionDetails(session_id));
		ltAPI.markTestStatus(session_id, "PASSED", "Pass");
		
		JSONObject videoResponse = ltAPI.getVideo(session_id);
		
		Map<String, String> metadata = new LinkedHashMap<>();
		metadata.put("View Test", "<a href='https://automation.lambdatest.com/test?sessionId="+session_id+"' target='_blank'>Logs</a>");
		metadata.put("Download Test", "<a href='"+videoResponse.getString("url")+"'>Video</a>");
		metadata.put("View Test", "<video width='400' controls><source src='"+videoResponse.getString("url")+"' type='video/mp4'></video>");
		reporter.onTestPass(sessionName, metadata);
	}

	@AfterTest
	public void teardown() {
		com.lambdatest.utils.ExtentReportListner.onFinish();

	}

	public static void mark(SessionId sessionid) throws URISyntaxException, UnsupportedEncodingException, IOException {
		URI uri = new URI(
				"https://ritia:IhJg3iv6ldrK8PY9tQrbpZCLM8QL1PBRLDrcn1N8t1pmS5HKAa@api.lambdatest.com/automation/api/v1/"
						+ sessionid + ".json");
		HttpPut putRequest = new HttpPut(uri);

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add((new BasicNameValuePair("status", "passed")));
		nameValuePairs.add((new BasicNameValuePair("reason", "")));
		putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		HttpClientBuilder.create().build().execute(putRequest);
	}
}
