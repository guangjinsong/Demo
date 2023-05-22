package com.example.demoselenium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

/**
 * @author sgj
 * @create 2023-05-22 8:17
 */
@Slf4j
public class SeleniumTest {
    @Test
    public void printfTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        driver.get("https://www.baidu.com/");

        // 打印当前页面title
        String title = driver.getTitle();
        System.out.println(title);

        // 打印当前页面url
        String url = driver.getCurrentUrl();
        System.out.println(url);

        // 获取当前页面句柄
        String handle = driver.getWindowHandle();
        System.out.println("current handle: " + handle);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }

    // 进入百度页面后，点击任意一个元素，进入下一个页面
    // 发现，无法直接打印下一个页面的title，依旧是百度
    // 页面的title
    // 这是因为进入百度页面后，再点击超链接，也就是打开了
    // 新的标签页，这对于selenium来说是不知道应该展示的
    // 页面是什么
    @Test
    public void getHandle01() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        driver.get("https://www.baidu.com/");


        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(7)")).click();
        String title = driver.getTitle();
        System.out.println("预期title：百度网盘； 实际title：" + title);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }

    @Test
    public void getHandle02() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        driver.get("https://www.baidu.com/");

        // 获取当前页面的句柄
        String currentHandle = driver.getWindowHandle();
        System.out.println("current handle: " + currentHandle);

        // 获取新标签页的句柄
        driver.findElement(By.cssSelector("#hotsearch-content-wrapper > li:nth-child(2) > a > span.title-content-title")).click();
        String nextHandle = driver.getWindowHandle();
        System.out.println("next handle: " + nextHandle); // 此时的句柄和current handle句柄一样


        // 获取所有标签页的句柄
        // 且跳到别的页面的句柄
        Set<String> set = driver.getWindowHandles();
        for (String str : set) {
            if (!str.equals(currentHandle)) {
                driver.switchTo().window(str);  // 页面跳转
                String title = driver.getTitle();
                System.out.println("--------" + title);
            }
        }
        Thread.sleep(2000);

        // 窗口最大化
        driver.manage().window().maximize();

        // 窗口最小化
        driver.manage().window().minimize();

        // 设置窗口指定的尺寸
        driver.manage().window().setSize(new Dimension(1000, 800));

        // 置底
        driver.executeScript("window.scroll(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        // 置顶
        driver.executeScript("window.scroll(0, document.body.scrollTop)");
        Thread.sleep(2000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }


    @Test
    public void navigateTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        driver.get("https://www.baidu.com/");

        // 释放掉驱动对象 关闭浏览器
        driver.quit();

    }

}
