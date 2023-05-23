package com.example.demoselenium;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
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
        Thread.sleep(3000);
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


    // 导航
    @Test
    public void navigateTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入百度网址
        driver.get("https://tool.lu/");
        Thread.sleep(1000);

        // 进入”我的“页面
        driver.findElement(By.cssSelector("#nav > div > div > ul > li:nth-child(1) > a")).click();
        Thread.sleep(1000);

        // 退回到”工具“页面
        driver.navigate().back();
        Thread.sleep(1000);

        // 前进到”我的页面“
        driver.navigate().forward();
        Thread.sleep(1000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();

    }

    // 关闭普通弹窗
    // 可以在前端代码里定位到普通的弹窗，都可以使用driver.findElement()的方法来定位元素
    @Test
    public void alertTest01() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(3000);

        // 输入
        driver.get("file:///C:/Users/20961/Documents/WPSDrive/418342908/WPS%E4%BA%91%E7%9B%98/myFiles/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/%E6%B5%8B%E5%BC%80/%E5%AD%A6%E4%B9%A0_BT/selenium4html/modal.html");
        Thread.sleep(1000);

        // 弹出弹窗
        driver.findElement(By.cssSelector("#show_modal")).click();
        Thread.sleep(1000);

        // 关闭普通弹窗
        driver.findElement(By.cssSelector("#myModal > div.modal-footer > button:nth-child(1)")).click();
        Thread.sleep(1000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();

    }

    // 关闭警告弹窗
    // 这类弹窗，是不能在前端定位到元素的，需要使用selenium提供的alert接口
    @Test
    public void alertTest02() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);

        // 输入
        driver.get("file:///C:/Users/20961/Documents/WPSDrive/418342908/WPS%E4%BA%91%E7%9B%98/myFiles/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/%E6%B5%8B%E5%BC%80/%E5%AD%A6%E4%B9%A0_BT/selenium4html/confirm.html");
        Thread.sleep(1000);

        // 弹出弹窗
        driver.findElement(By.xpath("/html/body/input")).click();

        // 关闭警告弹窗
        Alert alert = driver.switchTo().alert();

//        alert.accept(); // 点击”确认按钮“
        alert.dismiss(); // 点击”取消按钮“
        Thread.sleep(3000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }

    // 关闭提示弹窗
    // 这类弹窗，是不能在前端定位到元素的，需要使用selenium提供的alert接口
    @Test
    public void alertTest03() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);

        // 输入
        driver.get("file:///C:/Users/20961/Documents/WPSDrive/418342908/WPS%E4%BA%91%E7%9B%98/myFiles/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/%E6%B5%8B%E5%BC%80/%E5%AD%A6%E4%B9%A0_BT/selenium4html/Prompt.html");
        Thread.sleep(1000);

        // 弹出弹窗
        driver.findElement(By.xpath("/html/body/input")).click();

        // 切换弹窗
        Alert alert = driver.switchTo().alert();

        // 往弹窗里面输入东西
        alert.sendKeys("SGJ");

        alert.accept(); // 点击”确认按钮“
        Thread.sleep(3000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }

    // 模拟鼠标
    @Test
    public void mouseBoardTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);

        // 输入
        driver.get("file:///C:/Users/20961/Documents/WPSDrive/418342908/WPS%E4%BA%91%E7%9B%98/myFiles/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/%E6%B5%8B%E5%BC%80/%E5%AD%A6%E4%B9%A0_BT/selenium4html/level_locate.html");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("body > div:nth-child(2) > div > div > a")).click();
        WebElement element = driver.findElement(By.cssSelector("#dropdown1 > li:nth-child(1) > a"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform(); // 将鼠标移动选项上
        actions.click(element).perform(); // 将鼠标移动选项上
        Thread.sleep(3000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }

    // 模拟键盘
    @Test
    public void keyBoardTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);

        // 输入
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);

        // 模拟键盘往百度输入框输入信息
        WebElement element = driver.findElement(By.cssSelector("#kw"));
        element.sendKeys("SGJ");

        Thread.sleep(3000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }


    // 选择框
    @Test
    public void selectTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);

        // 输入
        driver.get("file:///C:/Users/20961/Documents/WPSDrive/418342908/WPS%E4%BA%91%E7%9B%98/myFiles/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/%E6%B5%8B%E5%BC%80/%E5%AD%A6%E4%B9%A0_BT/selenium4html/select.html");
        Thread.sleep(3000);

        // 点击选项
        WebElement element = driver.findElement(By.cssSelector("#ShippingMethod"));
        Select select = new Select(element);
//        select.selectByIndex(1); // 通过索引找选项（0开始计数）
//        select.selectByValue("10.69"); // 通过value属性选择
        select.selectByVisibleText("UPS Next Day Air Saver ==> $11.61"); // 通过
        Thread.sleep(3000);

        // 释放掉驱动对象 关闭浏览器
        driver.quit();
    }

    // 文件上传
    @Test
    public void fileUploadTest() throws InterruptedException {
        // 创建驱动对象
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);

        // 输入
        driver.get("file:///C:/Users/20961/Documents/WPSDrive/418342908/WPS%E4%BA%91%E7%9B%98/myFiles/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/%E6%B5%8B%E5%BC%80/%E5%AD%A6%E4%B9%A0_BT/selenium4html/upload.html");
        WebElement element = driver.findElement(By.cssSelector("body > div > div > input[type=file]"));
        element.sendKeys("C:\\Users\\20961\\Documents\\WPSDrive\\418342908\\WPS云盘\\myFiles\\学习资料\\测开\\学习_BT\\selenium4html");

        Thread.sleep(3000);
    }

    // 屏幕截图
    @Test
    public void screenShotTest() throws InterruptedException, IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");//解决 403 出错问题
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        Thread.sleep(1000);

        driver.get("https://www.baidu.com/");
        driver.findElement(By.cssSelector("#kw")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#su")).click();

        // 屏幕截图
        Thread.sleep(3000);
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        File filename = new File ("./src/test/autoPic/my.png"); // 保存截图到指定路径
        FileUtils.copyFile(srcFile, filename);

        Thread.sleep(3000);
    }
}
