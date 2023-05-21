package com.webautotest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author sgj
 * @create 2023-05-20 8:53
 */

public class FirstAutoTest {

    // 测试
    @Test
    public void nameTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver edgeDriver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        edgeDriver.get("https://www.baidu.com/");

        // 找到百度输入框
        edgeDriver.findElement(By.cssSelector("#kw")).clear();
        Thread.sleep(3000);

        // 释放掉驱动对象 关闭浏览器
        edgeDriver.quit();
    }


    // 定位元素的方法
    @Test
    public void positionElement() throws InterruptedException {
        // 创建一个驱动对象打开浏览器
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver edgeDriver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        edgeDriver.get("https://www.baidu.com/");

        // 选择器，并返回相关信息
        String text = edgeDriver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).getText();
        System.out.println(text);
        Thread.sleep(3000);

        // 释放掉驱动对象 关闭浏览器
        edgeDriver.quit();
    }

    // 利用xpath定位元素
    @Test
    public void nameTest02() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        driver.get("https://www.baidu.com/");

        // 找到百度输入框, 并且输入文字
        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("SGJ"); // 在百度搜索框输入“SGJ”
        driver.findElement(By.xpath("//*[@id=\"su\"]")).click(); // 进去“SGJ”的页面
        Thread.sleep(3000);
        String txt = driver.findElement(By.xpath("//*[@id=\"3\"]/div/div[1]/h3/a")).getText(); // 查找SGJ页面中的某个元素
        System.out.println(txt);
        Thread.sleep(3000);

        // 输出百度输入界面中某个板块
//        String txt = driver.findElement(By.xpath("//*[@id=\"hotsearch-content-wrapper\"]/li[1]/a/span[2]")).getText();
//        System.out.println(txt);
//        Thread.sleep(3000);

        // 打印”按钮“中的文字
//        driver.findElement(By.xpath("//*[@id=\"su\"]")).getText(); // 对于属性值，不能用getText
        String str = driver.findElement(By.xpath("//*[@id=\"su\"]")).getAttribute("value"); // 在百度搜索框输入“SGJ”
        System.out.println(str);


        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }

    @Test
    public void waitTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        driver.get("https://www.baidu.com/");

        driver.findElement(By.cssSelector("#kw")).sendKeys("SGJ");
        driver.findElement(By.cssSelector("#su")).click();

        // 强制等待
        // 如果没有等待，或者等待时间过短，会导致渲染没有完成，那么查找元素也会失败
//        Thread.sleep(3000); // 强制等待
//        driver.findElement(By.cssSelector("#\\31  > h3 > a"));

        // 隐式等待
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        driver.findElement(By.cssSelector("#\\31  > h3 > a"));


        // 显式等待
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));  // 先设置隐式等待（也可以不设置），等待页面的最长时间
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2)); // 再设置显式等待，等待该元素的最长时间
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#\\31  > h3 > a"))); // 检查页面是否存在对应的元素
        webDriverWait.until(ExpectedConditions.textToBe(By.cssSelector("#\\31  > h3 > a"), "sgj - 百度翻译")); // 检查对应的元素的值是否正确


        // 释放掉驱动对象 关闭浏览器
        driver.quit();

    }
}
