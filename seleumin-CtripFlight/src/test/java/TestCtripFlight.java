import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TestCtripFlight {
    private WebDriver driver;


    @BeforeEach
    public void setup() {
        //提交最终代码脚本时，请将驱动路径换回官方路径"C:\\Users\\86153\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\86153\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ctrip.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    // test-code-start

    // 请在此处插入JUnit5代码
    @ParameterizedTest
    @CsvSource({
            "北京,广州,CtripFlight_R001_001.png",
            "北京,成都,CtripFlight_R001_002.png",
            "上海,广州,CtripFlight_R001_003.png",
            "上海,成都,CtripFlight_R001_004.png"
    })
    public void CtripFlight_R001(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[1]/span")).click();//单程
        Thread.sleep(1000);
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div")).click();//局外点击
        Thread.sleep(1000);

        //经济舱
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/div/div/div[1]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/div/div/div[2]/ul/li[2]/div[2]")).click();
        Thread.sleep(1000);
        //儿童
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div/div/div/div/div/div/div[1]/span")).click();
        Thread.sleep(1000);

        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(10000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "#,CtripFlight_R002_001.png"

    })
    public void CtripFlight_R002(String from,String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[1]/span")).click();//单程
        Thread.sleep(1000);
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "上海,北京,CtripFlight_R003_001.png"
    })
    public void CtripFlight_R003(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[1]/span")).click();//单程
        Thread.sleep(1000);
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);


        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"datePicker\"]/div[1]/span/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]")).click();
        Thread.sleep(1000);

       //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(5000);
        //直飞
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[3]/div[2]/div/ul[1]/li[1]/div/span/i")).click();
        Thread.sleep(1000);
        //航空公司
        driver.findElement(By.xpath("//*[@id=\"filter_item_airline\"]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"filter_group_airline__airline\"]/li[1]/span/img")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"filter_item_airline\"]/div[2]/i")).click();
        //大型机
        driver.findElement(By.xpath("//*[@id=\"filter_item_other\"]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"filter_group_other__aircraft_size\"]/li[2]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"filter_item_other\"]/div[2]/i")).click();
        Thread.sleep(1000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "上海,北京,CtripFlight_R004_001.png"
    })
    public void CtripFlight_R004(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[1]/span")).click();//单程
        Thread.sleep(1000);
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);


        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"datePicker\"]/div[1]/span/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/div[7]")).click();

        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(5000);
        //【更多日期】，在日期控件中找到代表日期2025-01-01
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div/div/div/span/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"January-01-2025\"]/div[2]")).click();
        Thread.sleep(3000);

        //【更多排序】，在下拉框中选择【价格高-低】选项
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[3]/div[2]/div/ul[2]/li[4]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[3]/div[2]/div/ul[2]/li[4]/span/div/ul/li[6]")).click();
        Thread.sleep(1000);


        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,东京,CtripFlight_R005_001.png",
            "上海,大阪,CtripFlight_R005_002.png"
    })
    public void CtripFlight_R005(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[1]/span")).click();//单程
        Thread.sleep(1000);
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);

        //2成人、1儿童、1婴儿
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div/div/div/div[1]/div/div/i[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div[2]/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[3]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div/div/div/div[2]/div[3]/div[2]/div[3]/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div/div/div/div[2]/div[4]/a[1]")).click();
        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(8000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "上海,东京,CtripFlight_R006_001.png"
    })
    public void CtripFlight_R006(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[1]/span")).click();//单程
        Thread.sleep(1000);
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);
        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"datePicker\"]/div[1]/span/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/div[7]")).click();
        Thread.sleep(1000);
        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(5000);

        //航司比较表
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[3]/div[1]/div/div[2]/div[3]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[3]/div[1]/span/div/div[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[3]/div[1]/span/div/div[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[3]/div[1]/span/div/div[2]/div/ul/li[16]/div[3]")).click();
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,广州,CtripFlight_R007_001.png",
            "上海,成都,CtripFlight_R007_002.png"
    })
    public void CtripFlight_R007(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[1]/span")).click();//单程
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"datePicker\"]/div[2]/div/a")).click();//返程
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]")).click();//局外点击
        Thread.sleep(1000);
        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(5000);

       //出发地与目的地中间的【交换】
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[2]/div/i")).click();
        Thread.sleep(1000);
        //【选择去程】列表中的第一趟航班作为去程
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div/div[5]/div[2]/div[2]/span/div[1]/div/div/div/div/div[2]/div[2]/div")).click();
        Thread.sleep(1000);
        //【选择返程】列表中的第一趟航班作为返程
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div/div[5]/div[2]/div[2]/span/div[1]/div/div/div[2]/div/div[2]/div[2]/button")).click();
        Thread.sleep(1000);
        //

        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,东京,CtripFlight_R008_001.png",
            "上海,大阪,CtripFlight_R008_002.png"
    })
    public void CtripFlight_R008(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        //默认往返
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]")).click();//局外点击
        Thread.sleep(1000);
        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(5000);

        //出发地与目的地中间的【交换】
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[2]/div/i")).click();
        Thread.sleep(1000);
        //【选择去程】列表中的第一趟航班作为去程
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div/div[5]/div[2]/div[2]/span/div[1]/div/div/div/div/div[2]/div[2]/div")).click();
        Thread.sleep(3000);
        //【选择返程】列表中的第一趟航班作为返程
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div/div[5]/div[2]/div[2]/span/div[1]/div/div/div/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"0_0\"]")).click();


        Thread.sleep(2000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,上海,CtripFlight_R009_001.png"
    })
    public void CtripFlight_R009(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        //默认往返
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(8000);
//日期-手动

        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/ul[1]/li[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/ul[1]/li[1]/div[2]/div/div")).click();

        Thread.sleep(3000);
        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,上海,CtripFlight_R010_001.png"
    })
    public void CtripFlight_R010(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        //多程
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[3]/span/i[1]")).click();
        Thread.sleep(1000);

        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);

        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker0\"]/div/span/div/div/div/input")).click();
        Thread.sleep(2000);

//第二程
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        //默认输入
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]")).click();//局外
        Thread.sleep(1000);

        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(2000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,北京,CtripFlight_R011_001.png"
    })
    public void CtripFlight_R011(String from, String to,  String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        //多程
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[3]/span/i[1]")).click();
        Thread.sleep(1000);

        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).sendKeys(from);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]")).click();//局外
        Thread.sleep(1000);

        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(2000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "北京,上海,上海,广州,广州,南京,CtripFlight_R012_001.png"
    })
    public void CtripFlight_R012(String from01, String to01,String from02, String to02, String from03, String to03, String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        //多程
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[3]/span/i[1]")).click();
        Thread.sleep(1000);

        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).sendKeys(from01);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to01);
        Thread.sleep(1000);
        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker0\"]/div/span/div/div/div/input")).click();
        Thread.sleep(3000);

        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[2]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[2]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to02);
        Thread.sleep(1000);
        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker1\"]/div/span/div/div/div/input")).click();
        Thread.sleep(3000);

        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to03);
        Thread.sleep(1000);
        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker2\"]/div/span/div/div/div/input")).click();
        Thread.sleep(3000);


        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(2000);

        takeScreenshot(screenShot);
    }

    @ParameterizedTest
    @CsvSource({
            "上海,北京,首尔,东京,CtripFlight_R013_001.png"
    })
    public void CtripFlight_R013(String from01, String to01,String to02, String to03, String screenShot) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"leftSideNavLayer\"]/div/div/div[2]/div/div[1]/div/div[2]/button")).click();//机票
        Thread.sleep(1000);
        //多程
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[1]/ul/li[3]/span/i[1]")).click();
        Thread.sleep(1000);

        //【+再加一程】
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/a")).click();
        Thread.sleep(500);
        //【×】符号
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[6]/a/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[5]/a/i")).click();
        Thread.sleep(1000);
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/input")).sendKeys(from01);
        Thread.sleep(1000);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[1]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to01);
        Thread.sleep(1000);
        //日期-手动
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker0\"]/div/span/div/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]")).click();
        Thread.sleep(1000);
//2
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[2]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[2]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to02);
        Thread.sleep(1000);
        //日期
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker1\"]/div/span/div/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/div[5]")).click();
        Thread.sleep(1000);
//3
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[3]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(to03);
        Thread.sleep(1000);
        //日期
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker2\"]/div/span/div/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]")).click();
        Thread.sleep(1000);

        //4
        //出发地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[4]/div[1]/div/div[2]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        //目的地
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[4]/div[1]/div/div[4]/div/div/div[1]/input")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/div/div[2]/div[4]/div[1]/div/div[4]/div/div/div[1]/input")).sendKeys(from01);
        Thread.sleep(1000);
        //日期
        driver.findElement(By.xpath("//*[@id=\"multiDatePicker3\"]/div/span/div/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div[2]/div/div[2]/div[3]")).click();
        Thread.sleep(1000);

        //搜索
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div[3]/div[2]/span/div[1]/div/div/div/div/div[2]/div[2]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div[4]/div[2]/span/div[1]/div/div/div/div/div[2]/div[2]/div")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div[4]/div[2]/span/div[1]/div/div/div/div/div[2]/div[2]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"hp_container\"]/div[2]/div/div[2]/div[4]/div[2]/span/div[1]/div/div/div/div/div[2]/div[2]/button")).click();
        Thread.sleep(10000);

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
