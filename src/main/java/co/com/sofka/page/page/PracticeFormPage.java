package co.com.sofka.page.page;

import co.com.sofka.page.common.CommonActionsOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends CommonActionsOnPages {

    //Entrada datos
    protected By firstName = By.id("firstName");

    protected By lastName = By.id("lastName");

    protected By genderMale = By.xpath("//label[normalize-space()='Male']");

    protected By genderFemale = By.xpath("//label[normalize-space()='Female']");

    protected By genderOther = By.id("//label[normalize-space()='Other']");

    protected By mobile = By.id("userNumber");

    protected By submit = By.id("submit");

    //Para validaciones.
    protected final By assertionStudentFullName = By.xpath("//table/tbody/tr[1]/td[2]");

    protected final By assertionStudentEmail = By.xpath("//table/tbody/tr[2]/td[2]");

    protected final By assertionStudentGender = By.xpath("//table/tbody/tr[3]/td[2]");

    protected final By assertionStudentMobile = By.xpath("//table/tbody/tr[4]/td[2]");

    protected final By assertionStudentDateOfBirth = By.xpath("//table/tbody/tr[5]/td[2]");

    protected final By assertionStudentSubjects = By.xpath("//table/tbody/tr[6]/td[2]");

    protected final By assertionStudentHobbies = By.xpath("//table/tbody/tr[7]/td[2]");

    protected final By assertionStudentPicture = By.xpath("//table/tbody/tr[8]/td[2]");

    protected final By assertionStudentAddress = By.xpath("//table/tbody/tr[9]/td[2]");

    protected final By assertionStudentStateAndCity = By.xpath("//table/tbody/tr[10]/td[2]");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
}
