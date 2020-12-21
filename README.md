## 						使用selenium实现自动化测试

**前言：https://www.cnblogs.com/fortuneju/articles/13818905.html（参考）**

# 1、Selenium是什么？

​	Selenium是一个用于Web应用程序测试的工具。Selenium 测试直接运行在浏览器中，就像真正的用户在操作一样。

- 多浏览器支持
  - 如IE、Firefox、Safari、Chrome、Android手机浏览器等。
- 支持多语言
  - 如Java、C#、Python、Ruby、PHP等。
- 支持多操作系统
  - 如Windows、Linux、IOS、Android等。
- 开源免费
  - 官网：https://www.selenium.dev/

# 2、Selenium能干嘛？

- 这个工具的主要功能包括
  - 测试与浏览器的兼容性
    - 测试你的应用程序看是否能够很好得工作在不同浏览器和操作系统之上。
  - 测试系统功能
    - 创建衰退测试检验软件功能和用户需求。

# 3、如何结合Java实现自动化测试

### 3.1	Java环境

### 3.2	Selenium环境

​	Maven工程

```xml
   <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
    </dependencies>
```

### 3.3	Selenium3对应浏览器驱动下载

​		当selenium升级到3.0之后，对不同的浏览器驱动进行了规范。如果想使用selenium驱动不同的浏览器，必须单独下载并设置不同的浏览器驱动。
各浏览器下载地址：

- Firefox浏览器驱动：[geckodriver](https://github.com/mozilla/geckodriver/releases)
- Chrome浏览器驱动：[chromedriver](https://sites.google.com/a/chromium.org/chromedriver/home) [taobao备用地址](https://npm.taobao.org/mirrors/chromedriver)
- IE浏览器驱动：[IEDriverServer](http://selenium-release.storage.googleapis.com/index.html)
- Edge浏览器驱动：[MicrosoftWebDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
- Opera浏览器驱动：[operadriver](https://github.com/operasoftware/operachromiumdriver/releases)
- PhantomJS浏览器驱动：[phantomjs](http://phantomjs.org/)

### 3.4	设置Selenium3驱动

- 将chrome driver.exe设置到系统环境变量中（我尝试了不可用）

- 直接将chrome driver.exe可执行文件拷贝到System32中，框架会自动在该文件夹下寻找对应文件。（可用）

- 使用idea启动参数或者代码中设置（可用）

  - ```java
    //设置环境变量 chrome driver
    System.setProperty("webdriver.chrome.driver", "chrome driver.exe文件路径");
    ```

### 3.5	Chrome版本和Selenium对照表

​			https://blog.csdn.net/huilan_same/article/details/51896672

### 3.6	Selenium对应浏览器实例

```java
WebDriver driver = new ChromeDriver();    //Chrome浏览器

WebDriver driver = new FirefoxDriver();   //Firefox浏览器

WebDriver driver = new EdgeDriver();      //Edge浏览器

WebDriver driver = new InternetExplorerDriver();  // Internet Explorer浏览器

WebDriver driver = new OperaDriver();     //Opera浏览器

WebDriver driver = new PhantomJSDriver();   //PhantomJS
```

### 3.7	Selenium提供的元素定位方式

- id
- name
- class name
- tag name
- link text
- partial link text
- xpath
- css selector

​	

 