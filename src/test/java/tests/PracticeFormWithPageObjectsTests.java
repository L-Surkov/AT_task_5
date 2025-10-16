package tests;

import org.junit.jupiter.api.Test;
import components.CheckComponent;
import pages.PracticeFormPage;

public class PracticeFormWithPageObjectsTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    CheckComponent checkComponent = new CheckComponent();

    @Test
    void positiveAllFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Ilya")
                .setLastName("Surkov")
                .setEmail("el@gmail.com")
                .setGender("Male")
                .setUserNumber("8929888554")
                .setDateOfBirth("27", "June", "2000")
                .setSubject ("Hi")
                .setHobby ("Sports")
                .uploadPicture("images/imagefortest.png")
                .setCurrentAddress("г. Пенза, ул. Красная 64")
                .setState("NCR")
                .setCity("Noida")
                .sendForm();

        checkComponent.checkModalIsOpen()
                .checkResult("Student Name", "Ilya Surkov")
                .checkResult("Student Email", "el@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8929888554")
                .checkResult("Date of Birth", "27 June,2000")
                .checkResult("Subjects", "Hindi")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "imagefortest.png")
                .checkResult("Address", "г. Пенза, ул. Красная 64")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void positiveMinimalFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Ilya")
                .setLastName("Surkov")
                .setGender("Male")
                .setUserNumber("8111888554")
                .sendForm();
        checkComponent.checkModalIsOpen()
                .checkResult("Student Name", "Ilya Surkov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8111888554");
    }
    @Test
    void NegativeFormTest() {
        practiceFormPage.openPage()
                .sendForm();
        checkComponent.checkModalIsNotOpen();
    }
}