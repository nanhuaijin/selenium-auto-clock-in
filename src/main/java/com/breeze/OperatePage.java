package com.breeze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author : breeze
 * @date : 2020/12/21
 * @description : 操作打卡页面的方法
 */
public class OperatePage {

    //下载的chrome driver路径
    public static final String CHROME_DRIVER = "E:\\java\\chromedriver.exe";
    //需要打开的网址
    public static final String URL = "url";
    //账号
    public static final String ACCOUNT = "account";
    //密码
    public static final String PASSWORD = "password";

    public static void clockIn() {
        //设置环境变量 chrome driver
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);

        ChromeDriver driver = new ChromeDriver();
        //打开网址
        driver.get(URL);

        //打开网址后，设置隐性等待20s
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //打开网址后，窗口最大化
        driver.manage().window().maximize();

        //点击打卡按钮
        driver.findElementById("打卡按钮元素id").click();

        //获取账号输入框
        WebElement accountInput = driver.findElementByName("账号输入框元素的name值");
        accountInput.clear();
        accountInput.sendKeys(ACCOUNT);

        //获取密码输入框
        WebElement passwordInput = driver.findElementByClassName("密码输入框元素的ClassName值");
        passwordInput.clear();
        passwordInput.sendKeys(PASSWORD);

        //获取打卡提交父子元素
        WebElement clockIn = driver.findElementByClassName("打卡父按钮元素className值");
        WebElement sonClockIn = clockIn.findElement(By.className("打卡子元素className值"));
        sonClockIn.click();
    }

}
