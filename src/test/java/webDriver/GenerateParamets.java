package webDriver;

import com.google.gson.Gson;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import webDriver.Model.Hub;
import webDriver.Model.Rim;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateParamets {
    static WebDriver driver;
    Select select;
    List listRims;
    List listFrontHubs;
    List listRearHubs;
    Gson gson;


    @Test
    public void first() throws IOException {
        gson = new Gson();
        System.setProperty("webdriver.chrome.driver", "/Users/ryasik/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.prowheelbuilder.com/spokelengthcalculator");

//        getParametsRim();
//        getParametsHubFront();
        getParametsHubRear();

        driver.quit();
    }

    public void getParametsRim() throws IOException {
        listRims = new ArrayList();
        List<WebElement> rimMaker = getListSelected("//*[@id=\'rimMake\']");
        for (int i1 = 0; i1 < rimMaker.size(); i1++) {
            choseSelected("//*[@id=\'rimMake\']", rimMaker.get(i1).getAttribute("value"));
            sleep(500);
            List<WebElement> rimModels = getListSelected("//*[@id=\'rimModel\']");
            for (int g1 = 1; g1 < rimModels.size(); g1++) {
                choseSelected("//*[@id=\'rimModel\']", rimModels.get(g1).getAttribute("value"));
                sleep(500);
                WebElement rimErd = driver.findElement(By.id("erd"));
                System.out.println(rimMaker.get(i1).getText() + " " + rimModels.get(g1).getText() +
                        " ERD = " + rimErd.getAttribute("value"));
                listRims.add(new Rim(rimMaker.get(i1).getText(), rimModels.get(g1).getText(),
                        Integer.parseInt(rimErd.getAttribute("value"))));
            }
        }
        String jsonRims = gson.toJson(listRims);
        System.out.println("Data = " + jsonRims);
        FileWriter fileWriter = new FileWriter("/Users/ryasik/Desktop/SileniumWebDriver1/src/test/java/webDriver/files/rims.json");
        fileWriter.write(jsonRims);
        fileWriter.flush();
        fileWriter.close();
    }

    public void getParametsHubFront() throws IOException {
        listFrontHubs = new ArrayList();
        List<WebElement> hubMaker = getListSelected("//*[@id=\'hubMake\']");
        for (int i1 = 0; i1 < hubMaker.size(); i1++) {
            choseSelected("//*[@id=\'hubMake\']", hubMaker.get(i1).getAttribute("value"));
            sleep(1500);
            List<WebElement> hubModel = getListSelected("//*[@id=\'hubModel\']");
            for (int i2 = 1; i2 < hubModel.size(); i2++) {
                choseSelected("//*[@id=\'hubModel\']", hubModel.get(i2).getAttribute("value"));

                sleep(1000);
                WebElement axleWidth = driver.findElement(By.xpath("//*[@id=\'axle_width\']"));
                WebElement leftFlangeEnd = driver.findElement(By.xpath("//*[@id=\'lo\']"));
                WebElement rightFlangeEnd = driver.findElement(By.xpath("//*[@id=\'ro\']"));
                WebElement leftFlangeDiameter = driver.findElement(By.xpath("//*[@id=\'lfd\']"));
                WebElement rightFlangeDiameter = driver.findElement(By.xpath("//*[@id=\'rfd\']"));
                try {
                    System.out.println(hubMaker.get(i1).getAttribute("value") + " " +
                            hubModel.get(i2).getText() + " axle Width = " + axleWidth.getAttribute("value") + " left Flange End = "
                            + leftFlangeEnd.getAttribute("value") + " right Flange End = " + rightFlangeEnd.getAttribute("value")
                            + " left Flange Diameter = " + leftFlangeDiameter.getAttribute("value")
                            + " right Flange Diameter = " + rightFlangeDiameter.getAttribute("value"));


                    listFrontHubs.add(new Hub(hubMaker.get(i1).getText(), hubModel.get(i2).getText(),
                            Integer.parseInt(axleWidth.getAttribute("value")),
                            Integer.parseInt(leftFlangeEnd.getAttribute("value")),
                            Integer.parseInt(rightFlangeEnd.getAttribute("value")),
                            Integer.parseInt(leftFlangeDiameter.getAttribute("value")),
                            Integer.parseInt(rightFlangeDiameter.getAttribute("value"))));
                } catch (Exception e) {
                    sleep(2000);
                    System.out.println("Be here");
                }

            }
        }
        String jsonFrontHubs = gson.toJson(listFrontHubs);
        System.out.println("Data = " + jsonFrontHubs);
        FileWriter fileWriter = new FileWriter("/Users/ryasik/Desktop/SileniumWebDriver1/src/test/java/webDriver/files/frontHubs.json");
        fileWriter.write(jsonFrontHubs);
        fileWriter.flush();
        fileWriter.close();
    }

    public void getParametsHubRear() throws IOException {
        choseSelected("//*[@id='fr']", "R");
        listRearHubs = new ArrayList();
        sleep(1000);
        List<WebElement> hubMaker = getListSelected("//*[@id=\'hubMake\']");
        for (int i1 = 0; i1 < hubMaker.size(); i1++) {
            choseSelected("//*[@id=\'hubMake\']", hubMaker.get(i1).getAttribute("value"));
            sleep(1500);
            List<WebElement> hubModel = getListSelected("//*[@id=\'hubModel\']");
            for (int i2 = 1; i2 < hubModel.size(); i2++) {
                choseSelected("//*[@id=\'hubModel\']", hubModel.get(i2).getAttribute("value"));

                sleep(1000);
                WebElement axleWidth = driver.findElement(By.xpath("//*[@id=\'axle_width\']"));
                WebElement leftFlangeEnd = driver.findElement(By.xpath("//*[@id=\'lo\']"));
                WebElement rightFlangeEnd = driver.findElement(By.xpath("//*[@id=\'ro\']"));
                WebElement leftFlangeDiameter = driver.findElement(By.xpath("//*[@id=\'lfd\']"));
                WebElement rightFlangeDiameter = driver.findElement(By.xpath("//*[@id=\'rfd\']"));
                try {
                    System.out.println(hubMaker.get(i1).getAttribute("value") + " " +
                            hubModel.get(i2).getText() + " axle Width = " + axleWidth.getAttribute("value") + " left Flange End = "
                            + leftFlangeEnd.getAttribute("value") + " right Flange End = " + rightFlangeEnd.getAttribute("value")
                            + " left Flange Diameter = " + leftFlangeDiameter.getAttribute("value")
                            + " right Flange Diameter = " + rightFlangeDiameter.getAttribute("value"));


                    listRearHubs.add(new Hub(hubMaker.get(i1).getText(), hubModel.get(i2).getText(),
                            Integer.parseInt(axleWidth.getAttribute("value")),
                            Integer.parseInt(leftFlangeEnd.getAttribute("value")),
                            Integer.parseInt(rightFlangeEnd.getAttribute("value")),
                            Integer.parseInt(leftFlangeDiameter.getAttribute("value")),
                            Integer.parseInt(rightFlangeDiameter.getAttribute("value"))));
                } catch (Exception e) {
                    sleep(2000);
                    System.out.println("Be here");
                }

            }
        }
        String jsonRearHubs = gson.toJson(listRearHubs);
        System.out.println("Data = " + jsonRearHubs);
        FileWriter fileWriter = new FileWriter("/Users/ryasik/Desktop/SileniumWebDriver1/src/test/java/webDriver/files/rearHubs.json");
        fileWriter.write(jsonRearHubs);
        fileWriter.flush();
        fileWriter.close();
    }


    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List getListSelected(String xpath) {
        WebElement listText = driver.findElement(By.xpath(xpath));
        getSelect(listText);
        List<WebElement> lists = select.getOptions();
        return lists;
    }

    public void choseSelected(String xpath, String selectedByValue) {
        WebElement listText = driver.findElement(By.xpath(xpath));
        getSelect(listText);
        select.selectByValue(selectedByValue);
    }


}
