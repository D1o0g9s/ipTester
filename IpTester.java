import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple webscraping example using html unit that gets the public ip address 
 * the program is running on. Program scrapes http://whatismyipaddress.com/ for 
 * the ip. 
 * 
 * Uses the htmlunit-2.23-OSGi.jar library to create a headless browser. 
 * https://sourceforge.net/projects/htmlunit/files/htmlunit/2.23/ 
 * 
 * 
 * @author Geeling Chau
 * @date August 16, 2017
 */
public class IpTester {

    /**
     * main() This program only consists of a main function. 
     * 
     * No command line arguments required. 
     * 
     * Prints scraped ip address to console output. 
     */
    
    
    @SuppressWarnings("unchecked") // To suppress the List<DomElement> cast.
                                   // You can unsuppress and compile with 
                                   // -Xlint:unchecked to check what is being
                                   // unchecked.
    
    public static void main(String[] args) {
        
        // To keep warning loggers quiet.
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit")
                .setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(
                java.util.logging.Level.OFF);
        
        // Create headless browser to get html page to scrape
        try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
            webClient.setAjaxController(
                    new NicelyResynchronizingAjaxController());
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            
            // load whatismyipaddress.com - this takes quite a while idk why
            final HtmlPage page = 
                    webClient.getPage("http://whatismyipaddress.com/");
            
            // where to find the ipElement by HTML tags.
            List<DomElement> ipElement = (List<DomElement>)page.getByXPath(
                    "//div[@id='section_left']//a");
            
            //System.out.println(page.getWebResponse().getContentAsString());
            System.out.println(ipElement.get(0).getTextContent().trim());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (FailingHttpStatusCodeException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
