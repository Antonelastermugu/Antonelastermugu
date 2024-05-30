package AshkLegalizimet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Perdorues {
	static protected SelfHealingDriver driver;
	WebDriver delegate;

	private String Username;
	private String NID;
	private String Emer;
	private String Mbiemer;
	private String Atesia;
	private String Gjinia;
	private String Datelindja;
	private String Adresa;
	private String DataFillimit;
	private String Roli;
	private String Email;
	private String NrTel;

	public void shtimPerdoruesi(String username, String pass, String username1, String NID, String emri, String mbiemri,
			String atesia, String gjinia, String dtl, String adresa, String dtFillimi, String fjalekalimi1,
			String fjalekalimi2, Boolean shtoOrganigrame, String idDrejtorie, String roli, Boolean shtoMail,
			String email, Boolean shtoNrTel, String tel) {
		
		WebDriverManager.chromedriver().setup();
		delegate = new ChromeDriver();
		SelfHealingDriver driver = SelfHealingDriver.create(delegate);
		driver.manage().window().maximize();
		// driver.get("http://192.168.15.40:2315/");
		Login Login = new Login();
		Login.loginC(username, pass, driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Konfigurime']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Përdoruesit']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Shto']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement usernameElm = driver.findElement(By.id("username"));
		usernameElm.sendKeys(username1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement NIDElm = driver.findElement(By.id("nid"));
		NIDElm.sendKeys(NID);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement EmriElm = driver.findElement(By.id("name"));
		EmriElm.sendKeys(emri);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement MbiemeriElm = driver.findElement(By.id("surname"));
		MbiemeriElm.sendKeys(mbiemri);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement AtesiaElm = driver.findElement(By.id("atesia"));
		AtesiaElm.sendKeys(atesia);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement GJiniaELM = driver.findElement(By.id("gender"));
		Select select = new Select(GJiniaELM);
		if (gjinia.equals("M")) {
			select.selectByValue("M");
		} else if (gjinia.equals("F")) {
			select.selectByValue("F");
		} else {

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("birthDate")).sendKeys(dtl);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement adresaElm = driver.findElement(By.id("adresa"));
		adresaElm.sendKeys(adresa);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dtFillimi.equals("Jo")) {

		} else {
			driver.findElement(By.id("dataFillimit")).sendKeys(dtFillimi);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("newPassword")).sendKeys(fjalekalimi1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("confirmPasswordInput")).sendKeys(fjalekalimi2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("//button[text()='Ruaj']")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.Username = usernameElm.getAttribute("value");
		this.NID = NIDElm.getAttribute("value");
		this.Emer = EmriElm.getAttribute("value");
		this.Mbiemer = MbiemeriElm.getAttribute("value");
		this.Atesia = AtesiaElm.getAttribute("value");
		this.Gjinia = select.getFirstSelectedOption().getText();
		this.Datelindja = driver.findElement(By.id("birthDate")).getAttribute("value");
		this.Adresa = adresaElm.getAttribute("value");
		this.DataFillimit = driver.findElement(By.id("dataFillimit")).getAttribute("value");

		// zgjidh elm organigrame
		if (shtoOrganigrame) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//div[@class='selected-rights-box form-control']")).click();
			String xpathDrejtoria = "//label[@for='" + idDrejtorie + "']";
			String xpathElm = "//label[@for='" + idDrejtorie + "']//label[text()=' " + roli + " ']";
			driver.findElement(By.xpath(xpathElm)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("(//button[text()='Shto'])[1]")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// shto mail
		if (shtoMail) {
			driver.findElement(By.id("addEmail")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("addemail")).sendKeys(email);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("//button[text()=' Ruaj ']")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.Email = driver.findElement(By.id("addemail")).getAttribute("value");
		}
		// shto nr tel
		if (shtoNrTel) {
			driver.findElement(By.id("addPhone")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("addphone")).sendKeys(tel);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("//button[text()=' Ruaj ']")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.NrTel = driver.findElement(By.id("addphone")).getAttribute("value");
		}

	}

	public void modifikimPerdoruesi(String username, String pass, String usernamePerModifikim, String modifikimUsername,
			String modifikimNID, String modifikimEmer, String modifikimMbiemer, String modifikimAtesi,
			Boolean modifikimGjini, String modifikimDTL, String modifikimDTF, Boolean NdryshoPass, String pass1,
			String pass2, String pozicioniNeOrganigrameLloji, String drejtoria, String roli) {
		WebDriverManager.chromedriver().setup();
		delegate = new ChromeDriver();
		SelfHealingDriver driver = SelfHealingDriver.create(delegate);
		driver.manage().window().maximize();
		// driver.get("http://192.168.15.40:2315/");
		Login Login = new Login();
		Login.loginC(username, pass, driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Konfigurime']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Përdoruesit']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// kod per te selektuar elementin nga tabela
		driver.findElement(By.xpath("//button[@data-dt-idx='last']")).click();
		String nrFaqeve = driver.findElement(By.xpath("//button[@aria-current='page']")).getText();
		// 2
		int numF = Integer.parseInt(nrFaqeve);
		System.out.println(numF);
		// boolean found = false;
		// Iterate through each page
		outerloop: for (int i = 0; i < numF; i++) {
			int butoniPerKlikom = (i + 1);
			String butonP = "//button[text()='" + butoniPerKlikom + "']";
			driver.findElement(By.xpath(butonP)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// table[@id='kt_datatable_responsiveHoliday']//tr
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='kt_datatable_responsive']//tr"));
			for (int j = 1; j < rows.size(); j++) {
				String emerxpath = "((//table[@id='kt_datatable_responsive']//tr)[" + (j + 1) + "]//td)[2]";
				String emer = driver.findElement(By.xpath(emerxpath)).getText();
				if (emer.equals(usernamePerModifikim)) {
					System.out.println("Value '" + emer + "' found in the table.");
					String elmB = "((//table[@id='kt_datatable_responsive']//tr)[" + (j + 1) + "]//button)[1]";
					driver.findElement(By.xpath(elmB)).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break outerloop;
				}
			}
		}
		String Username1 = driver.findElement(By.id("username")).getAttribute("value");
		String NID1 = driver.findElement(By.id("nid")).getAttribute("value");
		String Emer1 = driver.findElement(By.id("name")).getAttribute("value");
		String Mbiemer1 = driver.findElement(By.id("surname")).getAttribute("value");
		String Atesia1 = driver.findElement(By.id("atesia")).getAttribute("value");
		WebElement GJiniaELM = driver.findElement(By.id("gender"));
		Select select = new Select(GJiniaELM);
		String Gjinia1 = select.getFirstSelectedOption().getText();
		String Datelindja1 = driver.findElement(By.id("birthDate")).getAttribute("value");

		String Adresa1 = driver.findElement(By.id("adresa")).getAttribute("value");
		String DataFillimit1 = driver.findElement(By.id("dataFillimit")).getAttribute("value");
		System.out.println("Te dhenat e vjetra: "+Username1+","+NID1+","+Emer1+","+Mbiemer1+","+Atesia1+","+Gjinia1+","+Datelindja1+","+Adresa1+","+DataFillimit1+".");
		// vlerat Email
		List<WebElement> nrRow = driver.findElements(By.xpath("(//table)[1]//td[@scope='row']"));
		String[] valuesEmail1 = new String[nrRow.size()];
		for (int i = 0; i < valuesEmail1.length; i++) {
			valuesEmail1[i] = driver.findElement(By.xpath("((//tbody)[1]//tr[" + (i + 1) + "]//td)[2]")).getText();
		}
		// vlerat nr tel
		List<WebElement> nrRow1 = driver.findElements(By.xpath("(//tbody)[2]//tr"));
		String[] valuesTel1 = new String[nrRow1.size()];
		for (int i = 0; i < valuesTel1.length; i++) {
			valuesTel1[i] = driver.findElement(By.xpath("((//tbody)[2]//tr[" + (i + 1) + "]//td)[1]")).getText();
		}

		if (modifikimUsername.equals("Jo")) {

		} else {
			WebElement usernameElement = driver.findElement(By.id("username"));
			usernameElement.clear();
			usernameElement.sendKeys(modifikimUsername);
		}
		if (modifikimNID.equals("Jo")) {

		} else {
			WebElement NIDElement = driver.findElement(By.id("nid"));
			NIDElement.clear();
			NIDElement.sendKeys(modifikimNID);
		}
		if (modifikimEmer.equals("Jo")) {

		} else {
			WebElement EmerElement = driver.findElement(By.id("name"));
			EmerElement.clear();
			EmerElement.sendKeys(modifikimEmer);
		}
		if (modifikimMbiemer.equals("Jo")) {

		} else {
			WebElement MbiemerElement = driver.findElement(By.id("surname"));
			MbiemerElement.clear();
			MbiemerElement.sendKeys(modifikimMbiemer);
		}
		if (modifikimAtesi.equals("Jo")) {

		} else {
			WebElement AtesiElement = driver.findElement(By.id("atesia"));
			AtesiElement.clear();
			AtesiElement.sendKeys(modifikimAtesi);
		}
		// modifikim gjinie
		if (modifikimGjini) {
			WebElement GJiniaELM1 = driver.findElement(By.id("gender"));
			// Select select = new Select(GJiniaELM1);
			if (Gjinia1.equals("Mashkull")) {
				select.selectByValue("F");
			} else if (Gjinia1.equals("Femër")) {
				select.selectByValue("M");
			} else {

			}
		}
		if (modifikimDTL.equals("Jo")) {

		} else {
			WebElement DTLElement = driver.findElement(By.id("birthDate"));
			DTLElement.clear();
			DTLElement.sendKeys(modifikimDTL);
		}
		if (modifikimDTF.equals("Jo")) {

		} else {
			WebElement DTFElement = driver.findElement(By.id("dataFillimit"));
			DTFElement.clear();
			DTFElement.sendKeys(modifikimDTF);
		}
		if (NdryshoPass) {
			driver.findElement(By.id("changePassword")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("newPassword")).sendKeys(pass1);
			driver.findElement(By.id("confirmPasswordInput")).sendKeys(pass2);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("//button[text()='Ruaj']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//nuk eshte perfunduar
		if (pozicioniNeOrganigrameLloji.equals("Shtim Pozicioni Te Ri")) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//div[@class='selected-rights-box form-control']")).click();
			String xpathDrejtoria = "//label[@for='" + drejtoria + "']";
			String xpathElm = "//label[@for='" + drejtoria + "']//label[text()=' " + roli + " ']";
			driver.findElement(By.xpath(xpathElm)).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("(//button[text()='Shto'])[1]")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (pozicioniNeOrganigrameLloji.equals("Fshirje e pozicionit te meparshem dhe shtim i nje te riu")) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (pozicioniNeOrganigrameLloji.equals("Fshirje e te gjithe pozicioneve")) {

		}
		String Username2 = driver.findElement(By.id("username")).getAttribute("value");
		String NID12 = driver.findElement(By.id("nid")).getAttribute("value");
		String Emer12 = driver.findElement(By.id("name")).getAttribute("value");
		String Mbiemer12 = driver.findElement(By.id("surname")).getAttribute("value");
		String Atesia12 = driver.findElement(By.id("atesia")).getAttribute("value");
		//WebElement GJiniaELM = driver.findElement(By.id("gender"));
		//Select select = new Select(GJiniaELM);
		String Gjinia12 = select.getFirstSelectedOption().getText();
		String Datelindja12 = driver.findElement(By.id("birthDate")).getAttribute("value");

		String Adresa12 = driver.findElement(By.id("adresa")).getAttribute("value");
		String DataFillimit12 = driver.findElement(By.id("dataFillimit")).getAttribute("value");
		
		
		System.out.println("Te dhenat e vjetra: "+Username2+","+NID12+","+Emer12+","+Mbiemer12+","+Atesia12+","+Gjinia12+","+Datelindja12+","+Adresa12+","+DataFillimit12+".");
		
		//nuk eshte perfunduar
		//ndryshim maili
	}

	public String DataUsername() {
		return Username;
	}

	public String DataNID() {
		return NID;
	}

	public String DataEmer() {
		return Emer;
	}

	public String DataMbiemer() {
		return Mbiemer;
	}

	public String DataAtesia() {
		return Atesia;
	}

	public String DataGjinia() {
		return Gjinia;
	}

	public String Datelindja() {
		return Datelindja;
	}

	public String Adresa() {
		return Adresa;
	}

	public String DataFillimit() {
		return DataFillimit;
	}

	public String Roli() {
		return Roli;
	}

	public String Email() {
		return Email;
	}

	public String NrTel() {
		return NrTel;
	}

}
