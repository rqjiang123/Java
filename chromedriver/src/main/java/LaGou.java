import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaGou {
    public static void main(String[] args) throws IOException{
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver",LaGou.class.getClassLoader().getResource("chromedriver").getPath());
        //创建Webdrvier
        WebDriver lakoudriver = new ChromeDriver();
        lakoudriver.get("https://www.lagou.com/zhaopin/Java/?labelWords=label");
        //根据元素名称选择
        optionClick(lakoudriver, "工作经验", "应届毕业生");
        optionClick(lakoudriver, "学历要求", "本科");
        optionClick(lakoudriver, "融资阶段", "不限");
        optionClick(lakoudriver, "公司规模", "不限");
        optionClick(lakoudriver,"行业领域","移动互联网");
        //解析元素
        List<WebElement> jobElements = lakoudriver.findElements(By.className("con_list_item"));
        for (WebElement jobElement : jobElements) {
            WebElement moneyElements = jobElement.findElement(By.className("position")).findElement(By.className("money"));
            String money = moneyElements.getText();
            System.out.println(money);
            String companyName = jobElement.findElement(By.className("company_name")).getText();
            System.out.println(companyName);
            savefile(companyName,moneyElements);

        }
    }

    private static void optionClick(WebDriver lakoudriver, String chroseTitle, String optionTitle) {
        WebElement chroseElement = lakoudriver.findElement(By.xpath("//li[@class='multi-chosen']//span[contains(text(),'" + chroseTitle + "')]"));
        WebElement optionElement = chroseElement.findElement(By.xpath("../a[contains(text(),'" + optionTitle + "')]"));
        optionElement.click();
    }
    private static void savefile(String name,WebElement jobmoney) throws IOException {
        String path = "/Users/rqjiang/reptile/job.txt";
        File file = new File(path);
        OutputStream out = new FileOutputStream(file);
        DataOutputStream ds = new DataOutputStream(out);
        String money = jobmoney.getText();
        ds.writeBytes(name);
        ds.writeBytes(money);
        ds.flush();
    }
}
