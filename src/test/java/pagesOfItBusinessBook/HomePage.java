package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(xpath = "//a[.='Do you have something to say']")
	private WebElement postbtn;

	@FindBy(id = "profile_img")
	private WebElement image;

	@FindBy(id = "docu1")
	private WebElement file;

	@FindBy(id = "contents")
	private WebElement content;

	public HomePage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPostbtn() {
		return postbtn;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getFile() {
		return file;
	}

	public WebElement getContent() {
		return content;
	}

	public WebElement getImg1() {
		return img1;
	}

	public WebElement getFile1() {
		return file1;
	}

	public WebElement getPostButton() {
		return postButton;
	}

	public WebElement getTopButton() {
		return topButton;
	}

	public WebElement getProflieDaniel() {
		return proflieDaniel;
	}

	@FindBy(id = "pimage")
	private WebElement img1;

	@FindBy(id = "pdocu")
	private WebElement file1;

	@FindBy(id = "publishf")
	private WebElement postButton;

	@FindBy(id = "myBtn")
	private WebElement topButton;

	@FindBy(xpath = "/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[5]/div[1]/div[1]/div/div/h3/a")
	private WebElement proflieDaniel;

	public WebElement getCancel() {
		return cancel;
	}

	@FindBy(xpath = "/html/body/div[2]/main/div/div/div/div/div[2]/div/div[1]/div[2]/ul/li[1]/div/div/div/div/form/div[1]/button")
	private WebElement cancel;
	
	@FindBy(id = "findall")
	private WebElement findAll;
	
	@FindBy(id= "findbutton")
	private WebElement fdSearchBtn;
	
	
	@FindBy(xpath= "/html/body/div[2]/main/div/div/div/div/div[1]/div/div[2]/div[2]/div[480]/a")
	private WebElement SugessViewMore;
	
	@FindBy(xpath= "//a[.='Gentle Post']")
	private WebElement clickGentle;
	
	@FindBy(xpath= "//img[@class='cover-img pointerr']")
	private WebElement imageOfProflie;
	
	@FindBy(xpath= "/html/body/div[2]/div[5]/div/div/div/button")
	private WebElement cancelBtnImgProfile;
	
	@FindBy(xpath= "//a[@data-target='.modal-message']")
	private WebElement messageProfilebtn;
	
	
	@FindBy(id = "message")
	private WebElement messagePrfTextt;
	
	@FindBy(xpath = "//h3[.='New Message']//following::button[@class='close']")
	private WebElement closeMessage;
	
	@FindBy(xpath = "//button[.='Send']")
	private WebElement sendBtn;
	@FindBy(xpath = "//i[@class='fa fa-facebook-square']")
	private WebElement facebookIt;
	//

	@FindBy(xpath = "//i[@class='fa fa-linkedin']")
	private WebElement LinkedInIt;
	
	@FindBy(xpath= "//i[@class='fa fa-twitter']")
	private WebElement twitterIt;
	
	@FindBy(xpath= "/html/body/div[2]/footer/div/div/ul/li[1]/a")
	private WebElement aboutIt;

	@FindBy(xpath= "//a[.='Privacy Policy']")
	private WebElement privacyPolicy;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFindAll() {
		return findAll;
	}

	public WebElement getFdSearchBtn() {
		return fdSearchBtn;
	}

	public WebElement getSugessViewMore() {
		return SugessViewMore;
	}

	public WebElement getClickGentle() {
		return clickGentle;
	}

	public WebElement getImageOfProflie() {
		return imageOfProflie;
	}

	public WebElement getCancelBtnImgProfile() {
		return cancelBtnImgProfile;
	}

	public WebElement getMessageProfilebtn() {
		return messageProfilebtn;
	}

	public WebElement getMessagePrfTextt() {
		return messagePrfTextt;
	}

	public WebElement getCloseMessage() {
		return closeMessage;
	}

	public WebElement getSendBtn() {
		return sendBtn;
	}

	public WebElement getFacebookIt() {
		return facebookIt;
	}

	public WebElement getLinkedInIt() {
		return LinkedInIt;
	}

	public WebElement getTwitterIt() {
		return twitterIt;
	}

	public WebElement getAboutIt() {
		return aboutIt;
	}

	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}

	public WebElement getCookiesPolicy() {
		return cookiesPolicy;
	}

	public WebElement getCopyrightPolicy() {
		return copyrightPolicy;
	}

	public WebElement getProfileFeed() {
		return profileFeed;
	}

	public WebElement getImgPhoto() {
		return ImgPhoto;
	}

	@FindBy(xpath= "//a[.='Cookies Policy']")
	private WebElement cookiesPolicy;
	
	@FindBy(xpath= "//a[.='Copyright Policy']")
	private WebElement copyrightPolicy;
	@FindBy(xpath= "//span[.='Feed']")
	private WebElement profileFeed;
	
	@FindBy(xpath= "//span[.='Image Bank']")
	private WebElement ImgPhoto;
	
	@FindBy(xpath="/html/body/div[2]/header/div/div/nav/ul/li[4]/a") 
	private WebElement mycontacts;
	@FindBy(xpath="/html/body/div[2]/header/div/div/nav/ul/li[5]/a/span/img") 
	private WebElement messagesmain;

	@FindBy(xpath="/html/body/div[2]/header/div/div/nav/ul/li[6]/a") 
	private WebElement notificationMain;

	public WebElement getMycontacts() {
		return mycontacts;
	}

	public WebElement getMessagesmain() {
		return messagesmain;
	}

	public WebElement getNotificationMain() {
		return notificationMain;
	}
	
	
	public WebElement getHomeMain() {
		return homeMain;
	}

	public WebElement getLikeForSanaPost() {
		return likeForSanaPost;
	}

	public WebElement getCommentForSanaPost() {
		return commentForSanaPost;
	}

	public WebElement getSharePost() {
		return sharePost;
	}

	public WebElement getCancelSharingApost() {
		return cancelSharingApost;
	}

	@FindBy(xpath="/html/body/div[2]/header/div/div/nav/ul/li[1]/a/span") 
	private WebElement  homeMain;
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[5]/ul/li[1]/a/i") 
	private WebElement  likeForSanaPost;

	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[5]/ul/li[2]/a") 
	private WebElement commentForSanaPost;
	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[5]/a") 
	private WebElement sharePost;
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div[5]/div/div/div/div/div/button") 
	private WebElement cancelSharingApost;
}
