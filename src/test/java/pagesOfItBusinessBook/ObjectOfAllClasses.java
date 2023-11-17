package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;

public class ObjectOfAllClasses {

    public WebDriver driver;
    private LoginPage login;
    private ProfilePage profile;

    public ProfilePage getProfile() {

        if (profile==null){

            profile = new ProfilePage(driver);
        }
        return profile;
    }

    public ObjectOfAllClasses(WebDriver driver) {
this.driver=driver;
    }

    public ForgetPasswordPage getPassword() {
        if (password==null){

            password = new ForgetPasswordPage(driver);
        }
        return password;
    }

    private ForgetPasswordPage password;
    private HomePage homePage;

    public LoginPage getLogin() {

        if (login==null){

            login = new LoginPage(driver);
        }
        return login;
    }

    public HomePage getHomePage() {
        if (homePage==null){

            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public Jobs getJobs() {
        if (jobs==null){

            jobs = new Jobs(driver);
        }
        return jobs;
    }

    public Logout getLogout() {

        if (logout==null){

            logout = new Logout(driver);
        }
        return logout;
    }

    public OxcyTechPage getOxcyTechPage() {
        if (oxcyTechPage==null){

            oxcyTechPage = new OxcyTechPage(driver);
        }
        return oxcyTechPage;
    }

    public SettingsPage getSettings() {

        if (settings==null){

            settings = new SettingsPage(driver);
        }
        return settings;
    }



    public SignUp getSignup() {

        if (signup==null){

            signup = new SignUp(driver);
        }
        return signup;
    }

    private Jobs jobs;
    private Logout logout;
    private OxcyTechPage oxcyTechPage;
    private SettingsPage settings;
    private SignUp signup;

}
