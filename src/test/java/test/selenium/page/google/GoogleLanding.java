package test.selenium.page.google;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.fluentlenium.core.wait.FluentWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.selenium.page.interfaces.Landing;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://google.com")
public class GoogleLanding extends Landing {
	public GoogleLanding(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="[name=\"q\"]")
    WebElement q;

	@FindBy(css="div.clearfix.field > input[name=\"btnK\"]")
    WebElement submit;

	@WhenPageOpens
    public void waitUntilMainElementsAppears() {
		System.out.println("Waiting");
        try {
            element(q).waitUntilVisible();
            element(submit).waitUntilVisible();
        }catch(Exception e){
            System.out.println("Threw an exception....");
        }
    }
    public void search(String keyword){
        q.clear();
        element(q).typeAndEnter(keyword);
        WebElement resultStats = (new WebDriverWait(getDriver(), 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

    }

    public void login(String user, String pass){
        q.clear();
        element(q).type(user);
        submit.submit();
    }


    public void findUrl(String url){
        try{
            (new WebDriverWait(getDriver(), 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
            (new WebDriverWait(getDriver(), 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".rc")));
        }catch(Exception e){
            System.out.println("It failed but so what.."+e.getMessage());
        }finally{
            List<WebElement> l  = getDriver().findElements(By.cssSelector(".rc"));
            ListIterator<WebElement> ite = l.listIterator();
            while(ite.hasNext()){
                WebElement m = ite.next();
                String item = m.getText();
                if (item.contains(url)){
                    return;
                }
            }
            throw new RuntimeException("Should have found a URL ");
        }

    }
    public void dump(WebElement element){
        String contents = (String)((JavascriptExecutor)this.getDriver()).executeScript("return arguments[0].innerHTML;", element);
        System.out.println(contents);
    }
}