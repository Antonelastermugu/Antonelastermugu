package AshkLegalizimet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;
import com.github.javafaker.Faker;

import EdgedataTesting.RandomAlphabeticStringGenerator;
import EdgedataTesting.UniqueData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testim1Perdoruesit {
	static protected SelfHealingDriver driver;
	WebDriver delegate;

	@Test
	public void shtimPerdoruesiMeTeDhenaTePavleshme() {
		// Tek fushat e detyrueshme vendosim vlera empty
		UniqueData UniqueData = new UniqueData();
		String username = UniqueData.generateNullEmptyValues("Empty");
		Perdorues Perdorues = new Perdorues();
		Perdorues.shtimPerdoruesi("admin", "Test@123", username, username, username, username, username, "M", username,
				username, username, username, username);
	}

	@Test
	public void shtimPerdoruesiMeTeDhenaTePavleshme1() {
		// Tek fushat e detyrueshme vendosim vlera " ".
		UniqueData UniqueData = new UniqueData();
		String username = UniqueData.generateNullEmptyValues("Space");
		Perdorues Perdorues = new Perdorues();
		Perdorues.shtimPerdoruesi("admin", "Test@123", username, username, username, username, username, "F", username,
				username, username, username, username);
	}

	@Test
	public void shtimPerdoruesiMeTeDhenaTePavleshme2() {
		// Tek fusha datelindja dhe data e fillimit vendos nje vlere te pavlefshme:
		// 30.02.2024
		UniqueData UniqueData = new UniqueData();
		String username = UniqueData.generateNullEmptyValues("Space");
		Perdorues Perdorues = new Perdorues();
		Perdorues.shtimPerdoruesi("admin", "Test@123", "Test", "Test", "Test", "Test", "Test", "F", "30.02.2024",
				"Test", "30.02.2025", "Test", "Test");
	}

	@Test
	public void shtimPerdoruesiMeTeDhenaTePavleshme3() {
		// Tek fusha username vendos te gjitha test caset e nje username te rregjistruar
		// me pare.
		RandomAlphabeticStringGenerator RandomAlphabeticStringGenerator = new RandomAlphabeticStringGenerator();
		List<String> vlera = RandomAlphabeticStringGenerator.generateDifferentStringCases("Test");
		String[] arrayVlera = vlera.toArray(new String[vlera.size()]);
		for (int i = 0; i < arrayVlera.length; i++) {
			Faker faker = new Faker();
			String nid = faker.letterify("?12121214?", true);
			Perdorues Perdorues = new Perdorues();
			Perdorues.shtimPerdoruesi("admin", "Test@123", arrayVlera[i], nid, "Test", "Test", "Test", "F",
					"01.01.2001", "Test", "01.01.2025", "Test1234", "Test1234");

		}
	}

	@Test
	public void shtimPerdoruesiMeTeDhenaTePavleshme4() {
		// Tek fusha nid vendos te gjitha test caset e nje username te rregjistruar
		// me pare.
		RandomAlphabeticStringGenerator RandomAlphabeticStringGenerator = new RandomAlphabeticStringGenerator();
		List<String> vlera = RandomAlphabeticStringGenerator.generateDifferentStringCases("J70808024U");
		String[] arrayVlera = vlera.toArray(new String[vlera.size()]);
		for (int i = 0; i < arrayVlera.length; i++) {
			Faker faker = new Faker();
			String username = faker.numerify("Test##");
			Perdorues Perdorues = new Perdorues();
			Perdorues.shtimPerdoruesi("admin", "Test@123", username, arrayVlera[i], "Test", "Test", "Test", "F",
					"01.01.2001", "Test", "01.01.2025", "Test1234", "Test1234");
		}

	}

	@Test
	public void shtimPerdoruesiMeVleraTeVlefshme() {
		Faker faker = new Faker();
		String username = faker.numerify("Test##");
		String nid = faker.letterify("?12121214?", true);
		Perdorues Perdorues = new Perdorues();

		String nrTel = faker.numerify("+35569#######");
		String email = faker.numerify("test##@test.com");

		Perdorues.shtimPerdoruesi("admin", "Test@123", username, nid, username, username, username, "F",
				"01.01.2001", username, "01.01.2025", "Test1234@", "Test1234@", true, "2000063", "Administrator", true,
				email, true, nrTel);
		//kontrolllogimi
		String VleraUsernameRuajtur = Perdorues.DataUsername();
		String VleraNIDRuajtur = Perdorues.DataNID();
		String VleraEmriRuajtur = Perdorues.DataEmer();
		String VleraMbiemriRuajtur = Perdorues.DataMbiemer();
		String VleraAtesiaRuajtur= Perdorues.DataAtesia();
		String VleraGjiniaRuajtur = Perdorues.DataGjinia();
		String vleraDTLRuajtur = Perdorues.Datelindja();
		String velraAdresaRuajtur = Perdorues.Adresa();
		String vleraDFillimiRuajtur = Perdorues.DataFillimit();
		kontrollShtimPerdoruesi("admin", "Test@123",   VleraUsernameRuajtur,  VleraNIDRuajtur,
			 VleraEmriRuajtur,  VleraMbiemriRuajtur,  VleraAtesiaRuajtur,  VleraGjiniaRuajtur,
			 vleraDTLRuajtur,  velraAdresaRuajtur,  vleraDFillimiRuajtur);
		//kontroll qe useri i krijuar mund te logohet
		testoLogin(VleraUsernameRuajtur,"Test1234@");
	}
	@Test
	public void modifikimUseriMeTeDhenaTePavlefshme() {
		//krijousername
		Perdorues Perdorues = new Perdorues();
		Faker faker = new Faker();
		String nusername = faker.numerify("Test##");
		String nid = faker.letterify("?12121214?", true);
		String nrTel = faker.numerify("+35569#######");
		String email = faker.numerify("test##@test.com");
		Perdorues.shtimPerdoruesi("admin", "Test@123", nusername, nid, nusername, nusername, nusername, "F",
				"01.01.2001", nusername, "01.01.2025", "Test1234@", "Test1234@", true, "2000063", "Administrator", true,
				email, true, nrTel);
		//UniqueData UniqueData = new UniqueData();
		//String username = UniqueData.generateNullEmptyValues("Space");
		String nusername1 = faker.numerify("Test##");
		Perdorues.modifikimPerdoruesi("admin", "Test@123", nusername, nusername1, "Jo", "Jo", "Jo", "Jo", false, "Jo", "Jo", false, "Jo", "Jo", "Jo", "Jo", "Jo");
	}
	
	public void modifikimUseriMeTeDhenaTeVlefshmeUsername() {
		//krijousername
		Perdorues Perdorues = new Perdorues();
		Faker faker = new Faker();
		String nusername = faker.numerify("Test##");
		String nid = faker.letterify("?12121214?", true);
		String nrTel = faker.numerify("+35569#######");
		String email = faker.numerify("test##@test.com");
		Perdorues.shtimPerdoruesi("admin", "Test@123", nusername, nid, nusername, nusername, nusername, "F",
				"01.01.2001", nusername, "01.01.2025", "Test1234@", "Test1234@", true, "2000063", "Administrator", true,
				email, true, nrTel);
		//UniqueData UniqueData = new UniqueData();
		//String username = UniqueData.generateNullEmptyValues("Space");
		String nusername1 = faker.numerify("Test##");
		Perdorues.modifikimPerdoruesi("admin", "Test@123", nusername, nusername1, "Jo", "Jo", "Jo", "Jo", false, "Jo", "Jo", false, "Jo", "Jo", "Jo", "Jo", "Jo");
	}
	@Test
	public void modifikimUseriMeTeDhenaTeVlefshmePass() {
		//krijousername
		Perdorues Perdorues = new Perdorues();
		Faker faker = new Faker();
		String nusername = faker.numerify("Test##");
		String nid = faker.letterify("?12121214?", true);
		String nrTel = faker.numerify("+35569#######");
		String email = faker.numerify("test##@test.com");
		Perdorues.shtimPerdoruesi("admin", "Test@123", nusername, nid, nusername, nusername, nusername, "F",
				"01.01.2001", nusername, "01.01.2025", "Test1234@", "Test1234@", true, "2000063", "Administrator", true,
				email, true, nrTel);
		//UniqueData UniqueData = new UniqueData();
		//String username = UniqueData.generateNullEmptyValues("Space");
		String nusername1 = faker.numerify("Test##");
		Perdorues.modifikimPerdoruesi("admin", "Test@123", nusername, "Jo", "Jo", "Jo", "Jo", "Jo", false, "Jo", "Jo", true, "Test1234@@", "Test1234@@", "Jo", "Jo", "Jo");
	}
	
	public void testoLogin(String username, String pass) {
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
		driver.findElement(By.xpath("//div[@class='cursor-pointer symbol symbol-35px symbol-md-40px']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[text()=' Profili im ']")).click();
		
	}

	public void kontrollShtimPerdoruesi(String username, String pass, String VleraUsernameRuajtur, String VleraNIDRuajtur,
			String VleraEmriRuajtur, String VleraMbiemriRuajtur, String VleraAtesiaRuajtur, String VleraGjiniaRuajtur,
			String vleraDTLRuajtur, String velraAdresaRuajtur, String vleraDFillimiRuajtur) {

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
				if (emer.equals(VleraUsernameRuajtur)) {
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
		String[] VleraTeRuajturaNgaShtimi = { VleraUsernameRuajtur, VleraNIDRuajtur, VleraEmriRuajtur, VleraMbiemriRuajtur,
				VleraAtesiaRuajtur, vleraDTLRuajtur, velraAdresaRuajtur, vleraDFillimiRuajtur };
		String[] vleraReale = { Username1, NID1, Emer1, Mbiemer1, Atesia1, Datelindja1, Adresa1,
				DataFillimit1 };
		String[] E = { "username", "NID", "emri", "mbiemri", "atesia", "dtl", "adresa", "dtFillimi" };

		for (int i = 0; i < VleraTeRuajturaNgaShtimi.length; i++) {
			if (VleraTeRuajturaNgaShtimi[i].equals(vleraReale[i])) {
				System.out.println("Te dhenat ruhen sakt per fushen " + E[i] + ".");
			} else {
				System.out.println("Error: Te dhenat nuk ruhen sakt per fushen " + E[i] + ".");

			}
		}
		if (VleraGjiniaRuajtur.equals("M")) {
			if (VleraGjiniaRuajtur.equals("Mashkull")) {
				System.out.println("Te dhenat ruhen sakt per fushen e gjinise");
			} else {
				System.out.println("Error: Te dhenat nuk ruhen sakt per fushen e gjinise");
			}
		} else {
			if (VleraGjiniaRuajtur.equals("Femër")) {
				System.out.println("Te dhenat ruhen sakt per fushen e gjinise");
			} else {
				System.out.println("Error: Te dhenat nuk ruhen sakt per fushen e gjinise");
			}
		}
	}

}
