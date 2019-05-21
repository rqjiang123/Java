package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 *
 */
public class SeleniumDemo {
    public static void main(String[] args){
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver",SeleniumDemo.class.getClassLoader().getResource("chromedriver").getPath());
        //创建webdriver
        WebDriver webDriver  = new ChromeDriver();
        //跳转页面
        webDriver.get("https://search.51job.com/list/030000,000000,0000,32,9,99,%25E8%25BD%25AF%25E4%25BB%25B6%25E5%25B7%25A5%25E7%25A8%258B%25E5%25B8%2588,2,1.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=");
        //调用方法，选择范围
        clickOption(webDriver, "发布日期", "24小时内");
        clickOption(webDriver,"月薪范围：","6-8千");
        //解析元素
        List<WebElement> jobElements = webDriver.findElements(By.className("el"));
        for (WebElement jobElement : jobElements) {
            WebElement moneyElement = jobElement.findElement(By.className("t4"));
            System.out.println(moneyElement.getText());
        }
    }

    /**
     * 定位元素并点击
     * @param webDriver
     * @param chroseTitle
     * @param optionTitle
     */
    private static void clickOption(WebDriver webDriver, String chroseTitle, String optionTitle) {
        WebElement chroseElement1 = webDriver.findElement(By.xpath("//div[@class='el mk']//span[contains(text(),'" + chroseTitle + "')]"));
        WebElement optionElement1 = chroseElement1.findElement(By.xpath("../ul//li//a[contains(text(),'" + optionTitle + "')]"));
        optionElement1.click();
    }
}
