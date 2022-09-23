package domaci23package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*
        Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com, izlistati sve kategorije (Stvari) sa leve strane i njihove linkove (kao spoken tekst “kategorija: link”), kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu, iskoristiti element iz nje da se klikne), kliknuti na Električni (mozete hardcodovati). Ostati na toj strani kao kraj zadatka. Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.

Obratiti paznju na "ad" koji kaze da se registrujete. Uzeti dugme x i kliknuti ga pre svega da ne bi ste imali problem da ne mozete da kliknete na kategoriju.

Za 5+ nakon klika na kategoriju bicikli, treba izlistati sve kategorije koje pisu (Mountainbike, Gradski itd).


Domaci kaciti na git kao i ostale. To vazi i za buduce domace, da ne pisem na svakom posto sam vec krenuo da zaboravljam. :)

         */

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.kupujemprodajem.com/");

        driver.manage().window().maximize();

        WebElement ad = driver.findElement(By.xpath("//*[@id='bodyTag']/div[9]/div/div[1]/div[2]/div/div"));

        if (ad.isDisplayed()) {
            WebElement xButton = driver.findElement(By.xpath("//*[@id='bodyTag']/div[9]/div/div[2]"));
            xButton.click();
        }



        WebElement okButton = driver.findElement(By.name("i-understand"));
        okButton.click();

        List<WebElement> predmeti = driver.findElements(By.xpath("//*[@id='category-tree-content-goods']//a"));


        for (int i = 0; i < predmeti.size(); i++) {
            WebElement predmet = predmeti.get(i);
            System.out.println("Predmeti: "+(i+1)+". " + predmet.getText());
        }

      //  driver.manage().window().maximize();




        for (int i = 0; i < predmeti.size(); i++) {
            WebElement predmet = predmeti.get(i);
        //    System.out.println(i+ " " + predmet.getText());

            if (predmet.getText().contains("Bicikli")) {
                predmet.click();
                break;
//                driver.manage().window().maximize();
            }

        }



   //     Thread.sleep(5000);

        List<WebElement> bicikli = driver.findElements(By.xpath("//*[@id='realCategoriesHolder']/div//*[contains(@id,'groupBox')]//h2/a"));

        for (int i = 0; i < bicikli.size(); i++) {
            WebElement bicikl = bicikli.get(i);
            System.out.println("Bicikli: "+(i+1)+". "+bicikl.getText());


        }

  //      System.out.println(bicikli.size());

         for (int i = 0; i < bicikli.size(); i++) {
            WebElement bicikl = bicikli.get(i);
        //    System.out.println(i+1+" "+bicikl.getText());
            if (bicikl.getText().contains("Električni")) {
                bicikl.click();
                break;
//                driver.manage().window().fullscreen();
            }
        }
        Thread.sleep(5000);

        driver.close();




























    }

}
