package Pages;



import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.time.Duration;

public abstract class PageSample {
    protected Page page;

    protected PageSample(Page page) {
        this.page = page;
    }

}
