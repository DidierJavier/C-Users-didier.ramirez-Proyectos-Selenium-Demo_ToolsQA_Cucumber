package co.com.sofka.stepdefinition.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.page.PracticeFormPageCases;
import co.com.sofka.runner.practiceform.PracticeFormTestCucumber;
import co.com.sofka.setup.SetupWebUI;
import co.com.sofka.util.Gender;
import co.com.sofka.util.Hobbies;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class PracticeFormTestCucumberStepDefinition extends SetupWebUI {

    private static final Logger LOGGER = Logger.getLogger(PracticeFormTestCucumber.class);

    PracticeFormPageCases practiceFormPageCases;
    @Dado("que el empleado administrativo se encuentra en la página web de los ingresos de estudiantes")
    public void queElEmpleadoAdministrativoSeEncuentraEnLaPaginaWebDeLosIngresosDeEstudiantes() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            LOGGER.info("Configuración del navegador lista.");
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    //Escenario: Ingreso de un estudiante con los campos obligatorios.
    @Cuando("el empleado administrativo ingresa los campos obligatorios y confirma la acción")
    public void elEmpleadoAdministrativoIngresaLosCamposObligatoriosYConfirmaLaAccion() {
        try{
            practiceFormPageCases = new PracticeFormPageCases(driver, practiceForm());
            practiceFormPageCases.fillStudentForm();
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }
    @Entonces("el sistema deberá mostrar por pantalla el registro del estudiante ingresado.")
    public void elSistemaDeberaMostrarPorPantallaElRegistroDelEstudianteIngresado() {
        Assertions.assertEquals(forSubmitedForm(), practiceFormPageCases.isRegistrationDone());
        quiteDriver();
    }

    //Escenario: Ingreso de un estudiante con todos los campos.
    @Cuando("el empleado administrativo ingresa valores a todos los campos obligatorios y confirma la acción")
    public void elEmpleadoAdministrativoIngresaValoresATodosLosCamposObligatoriosYConfirmaLaAccion() {
        try{
            practiceFormPageCases = new PracticeFormPageCases(driver, practiceForm());
            practiceFormPageCases.fillAllFields();
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }
    @Entonces("el sistema deberá mostrar por pantalla el registro del estudiante ingresado con todos sus campos.")
    public void elSistemaDeberaMostrarPorPantallaElRegistroDelEstudianteIngresadoConTodosSusCampos() {

    }


    //Funciones privadas
    private PracticeFormModel practiceForm(){
        PracticeFormModel practiceFormModel = new PracticeFormModel();
        practiceFormModel.setName("Iván");
        practiceFormModel.setLastName("Arroyave");
        practiceFormModel.setEmail("ivan@gmail.com");
        practiceFormModel.setGender(Gender.MALE);
        practiceFormModel.setMobile("3104567895");
        practiceFormModel.setDay("30");
        practiceFormModel.setMonth("September");
        practiceFormModel.setYear("1990");
        practiceFormModel.setSubjects(new ArrayList<String>(Arrays.asList("Math", "English", "Biology")));
        practiceFormModel.setHobbies(Hobbies.MUSIC);
        practiceFormModel.setPicture(USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\happy.png");
        practiceFormModel.setCurrentAddress("Calle 123");
        practiceFormModel.setState("Haryana");
        practiceFormModel.setCity("Karnal");

        return practiceFormModel;
    }

    private List<String> forSubmitedForm() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(practiceForm().getName() + " " + practiceForm().getLastName());
        submitedFormResult.add(practiceForm().getGender().getValue());
        submitedFormResult.add(practiceForm().getMobile());
        return submitedFormResult;
    }

}
