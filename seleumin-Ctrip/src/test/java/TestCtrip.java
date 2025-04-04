import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestCtrip {
    private WebDriver driver;


    @BeforeEach
    public void setup() {
        //提交最终代码脚本时，请将驱动路径换回官方路径"C:\\Users\\86153\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", "D:\\app\\Google\\Chrome\\Application\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ctrip.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    // test-code-start

    @ParameterizedTest
    @CsvSource({
            "北京,广州,Ctrip_R001_001.png",
            "北京,成都,Ctrip_R001_002.png",
            "上海,成都,Ctrip_R001_003.png",
            "上海,广州,Ctrip_R001_004.png"
    })
    public void Ctrip_R001(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();

        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        /*driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);*/
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);//输入出发地


        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);//输入目的地

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/strong[2]")).click();//日期
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[27]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();//搜索
        Thread.sleep(2000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "1,Ctrip_R002_001.png",
            "#,Ctrip_R002_002.png",
            "广州深圳,Ctrip_R002_003.png",
    })
    public void Ctrip_R002(String from, String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
       driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,上海,Ctrip_R003_001.png"
    })
    public void Ctrip_R003(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);


        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/strong[2]")).click();//点击日期
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[5]")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();//搜索
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[1]/ul/li/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[3]/ul/li[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div[1]/ul[2]/li[3]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div[1]/ul[2]/li[3]/div")).click();
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "南京,广州,Ctrip_R004_001.png"
    })
    public void Ctrip_R004(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);


        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[5]")).click();//日期

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[1]/ul/li/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[3]/ul/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[3]")).click();//展开列表
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[4]/ul/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[5]/ul/li[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[6]/ul/li[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/ul/li[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/ul/li[1]/i")).click();
        Thread.sleep(1000);
        //重置
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[3]/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[4]/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[5]/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[6]/div/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div/a")).click();
        Thread.sleep(1000);
        //收起列表
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div[1]/div[3]")).click();
        Thread.sleep(1000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "天津,西安,Ctrip_R005_001.png",
            "天津,杭州,Ctrip_R005_002.png",
            "济南,杭州,Ctrip_R005_003.png",
            "济南,西安,Ctrip_R005_004.png"
    })
    public void Ctrip_R005(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();

        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/ul/li[2]/i")).click();//往返按钮
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);
        Thread.sleep(1000);

        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[5]")).click();//出发日期
        Thread.sleep(1000);


        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();//搜索
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/div")).click();//展开列表
        Thread.sleep(1000);//车型、坐席、出发车站选中第一个复选框
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[4]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[5]/div[1]/i")).click();
        Thread.sleep(1000);
//出发时间、到达时间选中第二个复选框
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/div[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[3]/div[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/div")).click();//收起列表
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "兰州,郑州,Ctrip_R006_001.png",
            "兰州,厦门,Ctrip_R006_002.png",
            "徐州,郑州,Ctrip_R006_003.png",
            "徐州,厦门,Ctrip_R006_004.png"
    })
    public void Ctrip_R006(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/ul/li[2]/i")).click();//往返按钮
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);


        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[5]")).click();//出发日期

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/div")).click();//展开列表
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[4]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[6]/div[1]/i")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[2]/div[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[3]/div[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/div")).click();
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "11,海南,Ctrip_R007_001.png",
            "#,海南,Ctrip_R007_002.png",
            "广州北京,海南,Ctrip_R007_003.png"

    })
    public void Ctrip_R007(String from, String to,  String screenShot) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[2]")).click();//添加往返按钮
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[6]")).click();//出发日期
        Thread.sleep(1000);

        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);

        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);
        Thread.sleep(1000);


        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "Ctrip_R008_001.png"

    })
    public void Ctrip_R008(String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[2]")).click();//添加往返按钮
        Thread.sleep(1000);
        //返回日期
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[8]")).click();
        Thread.sleep(1000);
        //出发日期
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul[2]/li[6]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul[1]/li[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul[6]/li[6]")).click();


        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul[1]/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul[2]/li[1]")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[3]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
//在【去程】Tab中日期选择12-07周六
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/ul[1]/li[3]/div[1]")).click();
        Thread.sleep(1000);
        //展开列表
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/div[2]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/div[3]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/div[4]/i")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[3]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[4]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[5]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/ul/li[6]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/div[3]/div")).click();
        Thread.sleep(1000);//收起列表

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[4]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[5]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/ul/li[6]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/div[3]/div")).click();
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "哈尔滨,济南,Ctrip_R009_001.png",
            "哈尔滨,西安,Ctrip_R009_002.png",
            "哈尔滨,拉萨,Ctrip_R009_003.png"

    })
    public void Ctrip_R009(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();//导航栏
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/ul/li[3]/i")).click();//中转按钮
        Thread.sleep(1000);

        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);
        Thread.sleep(1000);


        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);
        //日期
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[1]/ul[2]/li[35]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(2000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "哈尔滨,济南,1,Ctrip_R010_001.png",
            "哈尔滨,济南,#,Ctrip_R010_002.png",
            "哈尔滨,济南,广州深圳,Ctrip_R010_003.png"

    })
    public void Ctrip_R010(String from, String to, String mid, String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();//导航栏
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/ul/li[3]/i")).click();//中转按钮
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);


        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);

        //日期
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[1]/ul[2]/li[35]")).click();
        Thread.sleep(1000);
        //中转城市
        driver.findElement(By.id("label-transitStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-transitStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-transitStation")).sendKeys(mid);
        Thread.sleep(1000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "哈尔滨,南京,济南,Ctrip_R011_001.png",
            "哈尔滨,南京,安阳,Ctrip_R011_002.png",
            "哈尔滨,南京,周口,Ctrip_R011_003.png"

    })
    public void Ctrip_R011(String from, String to, String mid, String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();//导航栏
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[3]/button/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[1]/div/ul/li[3]/i")).click();//中转按钮
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-departStation")).sendKeys(from);
        Thread.sleep(1000);


        driver.findElement(By.id("label-arriveStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-arriveStation")).sendKeys(to);
        Thread.sleep(1000);

        //日期
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[1]/ul[2]/li[35]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("label-transitStation")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("label-transitStation")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("label-transitStation")).sendKeys(mid);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]")).click();//局外点击

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/ul[2]/li[2]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/div[2]/ul[2]/li[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/ul[2]/li[2]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/div[2]/ul[2]/li[2]/div")).click();
        Thread.sleep(1000);

        takeScreenshot(screenShot);
    }
    // test-code-end



    @AfterEach
    public void teardown() {
        this.driver.quit();
    }

    private void takeScreenshot(String fileName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmssddSSS");
        String timestamp = dateFormat.format(new Date());
        String timestampedFileName = timestamp + "_" + fileName;
        File screenshotsDir = new File("screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }
        String screenshotFilePath = screenshotsDir.getAbsolutePath() + File.separator + timestampedFileName;
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

