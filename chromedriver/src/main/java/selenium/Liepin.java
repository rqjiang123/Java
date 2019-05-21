package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Liepin {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",Liepin.class.getClassLoader().getResource("chromedriver").getPath());
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.liepin.com/zhaopin/;jsessionid=B4CB3EC7A5B00FC1547D9FA9FEE5C8F7?imscid=R000000035&key=Java&dqs=050");
        webDriver.findElement(By.xpath("//dl[@class='clearfix']//dt[contains(text(),'')]"));
    }
}
