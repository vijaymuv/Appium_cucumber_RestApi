package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	public WebDriver driver;
	
	
	public ProfilePage(WebDriver driver2) {
		this.driver =driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="/html/body/div[2]/header/div/div/div[4]/div[1]/i")
	private WebElement profileButton;  

	
	@FindBy(xpath="/html/body/div[2]/header/div/div/div[4]/div[2]/h3[1]/a") 
	private WebElement myProfile;  

	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[5]/h3/a[2]/i") 
	private WebElement skills;  

	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[2]/form/div[1]/div/div/button/span") 
	private WebElement prgLang;  

	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[2]/form/div[1]/div/div/div/ul/li[4]/label/input") 
	private WebElement langBtn;  

	
	public WebElement getProfileButton() {
		return profileButton;
	}


	public WebElement getMyProfile() {
		return myProfile;
	}


	public WebElement getSkills() {
		return skills;
	}


	public WebElement getPrgLang() {
		return prgLang;
	}


	public WebElement getLangBtn() {
		return langBtn;
	}


	public WebElement getMessage() {
		return message;
	}


	public WebElement getOverView() {
		return overView;
	}


	public WebElement getDesignation() {
		return designation;
	}


	public WebElement getPhoneNumber() {
		return phoneNumber;
	}


	public WebElement getGender() {
		return gender;
	}


	public WebElement getAboutMe() {
		return aboutMe;
	}

	@FindBy(xpath="/html/body/div[2]/header/div/div/nav/ul/li[5]/a") 
	private WebElement message;  

	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[1]/h3/a[2]") private WebElement overView;  
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getDob() {
		return dob;
	}


	public WebElement getCountry() {
		return country;
	}


	public WebElement getCity() {
		return city;
	}


	public WebElement getOverviewSubmit() {
		return overviewSubmit;
	}


	public WebElement getExpBtnMain() {
		return expBtnMain;
	}


	public WebElement getCompanyname() {
		return companyname;
	}


	public WebElement getCdes() {
		return cdes;
	}


	public WebElement getTodate() {
		return todate;
	}


	public WebElement getFromdate() {
		return fromdate;
	}


	public WebElement getWorkCountry() {
		return workCountry;
	}


	public WebElement getWorkCity() {
		return workCity;
	}


	public WebElement getWorkDescription() {
		return workDescription;
	}


	public WebElement getWorkSubmit() {
		return workSubmit;
	}


	public WebElement getOmpanyname() {
		return ompanyname;
	}


	public WebElement getEduMain() {
		return eduMain;
	}


	public WebElement getCollege() {
		return college;
	}

	@FindBy(id="current_title") 
	private WebElement designation;  

	@FindBy(xpath= "//input[@value='Male']")
	private WebElement gender;
	
	@FindBy(id = "phone")
	private WebElement phoneNumber;
	
	
	@FindBy(id = "bdate")
	private WebElement dob;


	@FindBy(id = "country")
	private WebElement country;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "submitprofile")
	private WebElement overviewSubmit;
	
	@FindBy(xpath = "/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[2]/h3/a[2]/i")
	private WebElement expBtnMain;
	
	
	@FindBy(id = "company")
	private WebElement companyname;
	
	@FindBy(id = "designation")
	private WebElement cdes;
	@FindBy(id = "present")
	private WebElement todate;
	
	@FindBy(id = "fromdate")
	private WebElement fromdate;
	
	@FindBy(id = "work_country")
	private WebElement workCountry;
	@FindBy(id = "work_city")
	private WebElement workCity;
	
	@FindBy(id = "work_description")
	private WebElement workDescription;
	
	@FindBy(id = "work_submit")
	private WebElement workSubmit;
	
	@FindBy(id = "company")
	private WebElement ompanyname;
	
	@FindBy(xpath = "//div[@class='user-profile-ov st2 education-div']//descendant::a[@title='Add']")
	private WebElement eduMain ;
	
	@FindBy(id = "college")
	private WebElement college;
	
	@FindBy(id = "degree")
	private WebElement degree;
	
	public WebElement getDegree() {
		return degree;
	}


	public WebElement getFieldStudy() {
		return fieldStudy;
	}


	public WebElement getEduDescription() {
		return eduDescription;
	}

	public WebElement getCrtMain() {
		return crtMain;
	}


	public WebElement getCertification() {
		return certification;
	}


	public WebElement getIssuer() {
		return issuer;
	}


	public WebElement getCertificationDescription() {
		return certificationDescription;
	}

	@FindBy(id = "field_study")
	private WebElement fieldStudy;
	
	@FindBy(id = "edu_description")
	private WebElement eduDescription;
	@FindBy(id="about_me") 
	private WebElement aboutMe; 
	@FindBy(id="graduate") 
	private WebElement graduate;
	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[4]/h3/a[2]/i") 
	private WebElement crtMain;
	
	@FindBy(id="certification") 
	private WebElement certification;
	
	@FindBy(id="issuer") 
	private WebElement issuer;
	
	@FindBy(id="certification_description") 
	private WebElement certificationDescription;
	
	@FindBy(xpath="//span[.='Select Languages']") 
	private WebElement selectlang;
	
	
	
	@FindBy(id="submitskills") 
	private WebElement submitskills;
	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[5]/h3/a[3]/i") 
	private WebElement todeleteLang;
	
	public WebElement getSubmitskills() {
		return submitskills;
	}


	public WebElement getTodeleteLang() {
		return todeleteLang;
	}


	public WebElement getoKBtn() {
		return oKBtn;
	}


	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	@FindBy(xpath="//button[.='OK']") 
	private WebElement oKBtn;
	@FindBy(xpath="//button[.='Cancel']") 
	private WebElement cancelBtn;
	
	
	
	
	
	public WebElement getSelectlang() {
		return selectlang;
	}


	public WebElement getLang() {
		return lang;
	}

	@FindBy(id="ms-opt-2") 
	private WebElement lang;
	
	
	
	
	public WebElement getGraduate() {
		return graduate;
		
		
		
		
	}  
	@FindBy(id="Logout") 
	private WebElement Logout;


	public WebElement getLogout() {
		return Logout;
	}
	@FindBy(xpath="//a[.='About']") 
	private WebElement AboutIT;


	public WebElement getAboutIT() {
		return AboutIT;
	}
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div[6]/h3/a[2]/i") 
	private WebElement VoluntExp;
	@FindBy(id="organization") 
	private WebElement organization;
	
	@FindBy(id="role") 
	private WebElement role;
	
	@FindBy(id="volunteer_country") 
	private WebElement volunteercountry;
	
	@FindBy(id="volunteer_city") 
	private WebElement volunteerCity;
	
	@FindBy(id="currently_enrolled") 
	private WebElement currentlyEnrolled;
	@FindBy(id="volunteer_description") 
	private WebElement volunteerDescription;
	@FindBy(id="vol_submit") 
	private WebElement volSubmit;
	
	@FindBy(xpath="span[.='Feed']") 
	private WebElement mpFeed;
	
	@FindBy(xpath="//span[.='Applied Jobs']") 
	private WebElement mpAppliedJob;
	
	@FindBy(xpath="//span[.='Image Bank']") 
	private WebElement mpImageBank;
	
	@FindBy(xpath="//li[@data-tab='payment-dd']") 
	private WebElement mpContacts;
	
	public WebElement getVoluntExp() {
		return VoluntExp;
	}


	public WebElement getOrganization() {
		return organization;
	}


	public WebElement getRole() {
		return role;
	}


	public WebElement getVolunteercountry() {
		return volunteercountry;
	}


	public WebElement getVolunteerCity() {
		return volunteerCity;
	}


	public WebElement getCurrentlyEnrolled() {
		return currentlyEnrolled;
	}


	public WebElement getVolunteerDescription() {
		return volunteerDescription;
	}


	public WebElement getVolSubmit() {
		return volSubmit;
	}


	public WebElement getMpFeed() {
		return mpFeed;
	}


	public WebElement getMpAppliedJob() {
		return mpAppliedJob;
	}


	public WebElement getMpImageBank() {
		return mpImageBank;
	}


	public WebElement getMpContacts() {
		return mpContacts;
	}


	public WebElement getUploadCv() {
		return uploadCv;
	}


	public WebElement getDownloadUploadedCV() {
		return DownloadUploadedCV;
	}


	public WebElement getDownloadCvBtn() {
		return downloadCvBtn;
	}


	public WebElement getDownloadCvMain() {
		return downloadCvMain;
	}

	@FindBy(id="upload_cv") 
	private WebElement uploadCv;
	public WebElement getChangeProPic() {
		return ChangeProPic;
	}


	public WebElement getChoosepic() {
		return Choosepic;
	}


	public WebElement getUploadPicBtn() {
		return uploadPicBtn;
	}


	public WebElement getUploadPicCancelBtn() {
		return uploadPicCancelBtn;
	}

	@FindBy(xpath="//button[.='Download Uploaded CV']") 
	private WebElement DownloadUploadedCV;
	
	@FindBy(xpath="//a[.='Download CV']") 
	private WebElement downloadCvBtn;
	
	@FindBy(xpath="//button[.='Download']") 
	private WebElement downloadCvMain;
	@FindBy(xpath="//a[@title='Change Profile Picture']//child::i") 
	private WebElement ChangeProPic;
	@FindBy(id="upload") 
	private WebElement Choosepic;
	
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[1]/div/div[1]/div[3]/div/div/div/div[2]/div[3]/div/button[1]") 
	private WebElement uploadPicBtn;
	@FindBy(xpath="/html/body/div[2]/main/div/div/div/div/div[1]/div/div[1]/div[3]/div/div/div/div[1]/button") 
	private WebElement uploadPicCancelBtn;
	
	
	
	
}
