package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Jobs {
	public Jobs(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebDriver driver;

	@FindBy(id = "job_title")
	private WebElement title;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getEvolve() {
		return evolve;
	}

	public WebElement getFeedEvlove() {
		return feedEvlove;
	}

	public WebElement getFollowersEvolve() {
		return followersEvolve;
	}

	public WebElement getJobsEvolve() {
		return jobsEvolve;
	}

	public WebElement getDotNet() {
		return dotNet;
	}

	public WebElement getInterested() {
		return interested;
	}

	public WebElement getCv() {
		return cv;
	}

	public WebElement getNotes() {
		return notes;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getCancel() {
		return cancel;
	}

	@FindBy(id = "searchsubmit")
	private WebElement search;

	@FindBy(xpath = "/html/body/div[2]/main/div/div/div/div/div[2]/div/div/div/div[2]/ul/li[1]/span/a")
	private WebElement evolve;

	@FindBy(xpath = "//span[text()='Feed']")
	private WebElement feedEvlove;
	@FindBy(xpath = "//span[text()='Followers']")
	private WebElement followersEvolve;
	@FindBy(xpath = "//span[text()='Jobs']")
	private WebElement jobsEvolve;

	@FindBy(xpath = "/html/body/div[2]/main/div/div/div/div/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/div/h2/a")
	private WebElement dotNet;

	@FindBy(id = "Interested")
	private WebElement interested;

	public WebElement getMyAppiedJobs() {
		return myAppiedJobs;
	}

	public WebElement getMypostedJobs() {
		return mypostedJobs;
	}

	public WebElement getJobPostMain() {
		return jobPostMain;
	}

	@FindBy(id = "cv1")
	private WebElement cv;
	@FindBy(id = "inotes")
	private WebElement notes;

	@FindBy(id = "interested")
	private WebElement submit;
	@FindBy(xpath = "/html/body/div[2]/div[4]/div/div/form/div/div[1]/button")
	private WebElement cancel;

	public WebElement getJobs() {
		return jobs;
	}

	public WebElement getFindjobs() {
		return findjobs;
	}

	@FindBy(xpath = "//a[normalize-space(.)='Jobs']")
	private WebElement jobs;
	@FindBy(xpath = "/html/body/div[2]/header/div/div/nav/ul/li[2]/ul/li[1]/a")
	private WebElement findjobs;
	@FindBy(id= "company")
	private WebElement companyname;

	@FindBy(xpath = "//button[.='Start Job Post']")
	private WebElement start;

	@FindBy(id = "title")
	private WebElement jbtitle;

	@FindBy(id = "address")
	private WebElement addressJob;

	@FindBy(id = "function")
	private WebElement jbfunction;

	@FindBy(id = "industry")
	private WebElement jbindustry;
	@FindBy(id = "experience")
	private WebElement jbexp;
	@FindBy(id = "skills")
	private WebElement jbskills;

	public WebElement getJbexp() {
		return jbexp;
	}

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getJbskills() {
		return jbskills;
	}

	public WebElement getStart() {
		return start;
	}

	public WebElement getJbtitle() {
		return jbtitle;
	}

	public WebElement getAddressJob() {
		return addressJob;
	}

	public WebElement getJbfunction() {
		return jbfunction;
	}

	public WebElement getJbindustry() {
		return jbindustry;
	}

	public WebElement getEmpType() {
		return empType;
	}

	public WebElement getJblevel() {
		return jblevel;
	}

	public WebElement getJbqual() {
		return jbqual;
	}

	public WebElement getJbdescription() {
		return jbdescription;
	}

	public WebElement getJbemail() {
		return jbemail;
	}

	public WebElement getPostAjobBtn() {
		return postAjobBtn;
	}

	@FindBy(id = "emp_type")
	private WebElement empType;
	@FindBy(id = "level")
	private WebElement jblevel;

	@FindBy(id = "qualification")
	private WebElement jbqual;

	@FindBy(xpath = "/html/body/div[2]/section[2]/div/div[2]/div/div/div/form/div[8]/div/div/div/div[3]/iframe")
	private WebElement jbdescription;

	@FindBy(id = "email")
	private WebElement jbemail;

	@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
	private WebElement postAjobBtn;

	@FindBy(xpath = "//a[.='My Applied Jobs']")
	private WebElement myAppiedJobs;

	@FindBy(xpath = "//a[.='My Posted Jobs']")
	private WebElement mypostedJobs;

	@FindBy(xpath = "//a[.='Post a Job']")
	private WebElement jobPostMain;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement appliedJobsSearch;

	@FindBy(xpath = "//select[@name='example1_length']")
	private WebElement showEntity;

	@FindBy(xpath = "/html/body/div[2]/section[2]/div/div[2]/div/div/div/div/div/div/div[4]/div[2]/div/table/tbody/tr[1]/td[8]")
	private WebElement reply;

	public WebElement getAppliedJobsSearch() {
		return appliedJobsSearch;
	}

	public WebElement getShowEntity() {
		return showEntity;
	}

	public WebElement getReply() {
		return reply;
	}

	public WebElement getTypeHere() {
		return typeHere;
	}

	public WebElement getCommentBtn() {
		return commentBtn;
	}

	@FindBy(id = "seeker_comment1")
	private WebElement typeHere;

	@FindBy(xpath = "/html/body/div[2]/section[2]/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div/div")
	private WebElement commentBtn;

}
