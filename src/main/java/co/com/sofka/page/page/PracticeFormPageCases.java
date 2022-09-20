package co.com.sofka.page.page;

import co.com.sofka.model.practiceform.PracticeFormModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPageCases extends PracticeFormPage{

    private static final Logger LOGGER = Logger.getLogger(PracticeFormPageCases.class);

    private PracticeFormModel practiceFormModel;

    public PracticeFormModel getPracticeFormModel() {
        return practiceFormModel;
    }

    public void setPracticeFormModel(PracticeFormModel practiceFormModel) {
        this.practiceFormModel = practiceFormModel;
    }

    public PracticeFormPageCases(WebDriver driver, PracticeFormModel practiceFormModel) {
        super(driver);
        this.practiceFormModel = practiceFormModel;
    }

    public PracticeFormPageCases(WebDriver driver) {
        super(driver);
    }

    public void fillStudentForm(){
        scrollOn(firstName);
        clearOn(firstName);
        typeOn(firstName, practiceFormModel.getName());

        scrollOn(lastName);
        clearOn(lastName);
        typeOn(lastName, practiceFormModel.getLastName());

        //Genero
        switch (practiceFormModel.getGender()){
            case MALE:
                clickOn(genderMale);
                break;
            case FEMALE:
                clickOn(genderFemale);
                break;
            case OTHER:
                clickOn(genderOther);
                break;
            default:
                LOGGER.warn("No se ha suministrado un valor de género adecuado;" +
                        "por favor valide la generación de datos");
        }

        scrollOn(mobile);
        clearOn(mobile);
        typeOn(mobile, practiceFormModel.getMobile());

        scrollOn(submit);
        clickWithJseOn(submit);
    }

    public void fillAllFields() {

    }
    public List<String> isRegistrationDone(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudentFullName).trim());
        submitedFormResult.add(getText(assertionStudentGender).trim());
        submitedFormResult.add(getText(assertionStudentMobile).trim());
        return submitedFormResult;
    }

}
