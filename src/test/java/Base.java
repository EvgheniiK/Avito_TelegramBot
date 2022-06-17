import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class Base {

    WebDriver driver;
    SentToTelegram sentToTelegram = new SentToTelegram();
    @AfterClass
    public void afterClass() {

        // driver.close();
    }


    @BeforeClass
    public void beforeClass() {
        //запуск телеграм бота
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        //Bot bot = new Bot();
       // bot.onUpdateReceived();
        //bot.sendMessage("ddd55555");



        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jon\\Desktop\\java\\chromedriver101.exe");
        driver = new ChromeDriver();

    }


    @Test()
    public void test1_step_01() {
        try {


            driver.get("https://www.avito.ru/"); // открытие страницы avito
            //   driver.manage().window().maximize(); // задаем размеры браузера во все разрешение экрана
            //Есть кнопка  «зарабатывай с озон»
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertTrue(driver.findElement(By.xpath("//input[@data-marker=\"search-form/suggest\"]")).isDisplayed());


        } catch (Throwable e) {

            assertTrue(false);
        }
    }

    @Test()
    public void test1_step_02() throws Exception {
        try {


            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@data-marker=\"search-form/suggest\"]")).sendKeys("galaxy s10e");
            driver.findElement(By.xpath("//button[@data-marker=\"search-form/submit-button\"]")).click();
            assertTrue(driver.findElement(By.xpath("//div[@elementtiming=\"bx.catalog.container\"]")).isDisplayed());


        } catch (Throwable e) {

            assertTrue(false);
        }
    }


    @Test()
    public void test1_step_03() throws Exception {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


       // List<WebElement> elementLists = driver.findElements(By.xpath("//div[@elementtiming=\"bx.catalog.container\"]//div[@data-item-id]"));
       // List<WebElement> elementListsHref = driver.findElements(By.xpath("//div[@elementtiming=\"bx.catalog.container\"]//div[@data-item-id]/div/div/a"));
        List<WebElement> elementLists = driver.findElements(By.xpath("//div[@data-marker=\"catalog-serp\"]//div[@data-item-id]"));
      List<WebElement> elementListsHref = driver.findElements(By.xpath("//div[@data-marker=\"catalog-serp\"]//div[@data-item-id]/div/div/a"));


        //прокрутка страницы
        for (int i = 0; i < elementLists.size(); i++) {
            WebElement element = elementLists.get(i);
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        }


       // List<WebElement> elementListsImg = driver.findElements(By.xpath("//div[@elementtiming=\"bx.catalog.container\"]//div[@data-item-id]/div/div/a/div/div/ul/li/div/img"));
         List<WebElement> elementListsImg = driver.findElements(By.xpath("//div[@data-marker=\"catalog-serp\"]//div[@data-item-id]/div/div/a/div/div/ul/li/div/img"));


        //вывод колличества элементов
        System.out.println(elementLists.size());
        System.out.println(elementListsHref.size());
        System.out.println(elementListsImg.size());

      // for (int j = 0; j < elementLists.size(); j++) {

          //  if (elementLists.get(j).isEnabled()) {

                for (int i = 0; i < elementLists.size(); i++) {

                    String id = elementLists.get(i).getAttribute("data-item-id");
                    String text = elementLists.get(i).getText();
                    String href = elementListsHref.get(i).getAttribute("href");
                    String img = elementListsImg.get(i).getAttribute("src");

                    //метод для серилизации
                    MySerilization.isFileEmpty();

                    if (MySerilization.checkId(id)) {
                        MySerilization.serializationJson(id, text, href, img);

                        sentToTelegram.sentBot(href);

               //    }
               // }
            }
        }

    }


}
