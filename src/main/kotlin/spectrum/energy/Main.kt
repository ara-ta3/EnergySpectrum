package spectrum.energy

import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright


fun main() {
    val userId = System.getenv("USER_ID") ?: throw IllegalArgumentException("User ID is not set")
    val password = System.getenv("PASSWORD") ?: throw IllegalArgumentException("Password is not set")

    Playwright.create().use { playwright ->
        val browser = playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(false))
        val page: Page = browser.newPage()
        page.navigate("https://japaden.econo-crea.com/absClientB2C/loginAction")
        page.fill("#loginId", userId) 
        page.fill("#passWord", password)
        page.click("#login a")

        page.waitForNavigation {
            // IDがloginのdivの中にあるaタグをクリック
            page.click("#login a")
        }

        val pageTitle = page.title()
        println("遷移後のページタイトル: $pageTitle")
        browser.close()
    }
}
