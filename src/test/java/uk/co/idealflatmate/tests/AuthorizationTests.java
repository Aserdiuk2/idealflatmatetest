package uk.co.idealflatmate.tests;

import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifStageGoLive;


public class AuthorizationTests extends TestBase {



    @Test
    public void classicLogInOut() {

        open("http://front.idealflatmate4test.demo.devplatform2.com/");

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void logInOutOnPropertyPage() {

        helperBase.pageUrlVerifLiveGoStage();
        clearCache();
        authorizationHelper.goToPropertyPage();

        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

    @Test
    public void logInOutOnFMPage() {

        helperBase.pageUrlVerifLiveGoStage();
        clearCache();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickSignInButtonInPopup();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("Borris");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void emailWrongHomePage() {

        helperBase.pageUrlVerifLiveGoStage();

        //helperBase.pageUrlHomeNew();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FHq@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();

        verificationHelper.passwWrongAlertHome();

        signUpHelper.quit();
    }

    @Test
    public void loginPassWronglogInHomePage() {

        helperBase.pageUrlVerifLiveGoStage();

        clearCache();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FH@gmail.com");
        authorizationHelper.setPassword("qqqqqq1");
        authorizationHelper.submitLogin();

        verificationHelper.passwWrongAlertHome();

        signUpHelper.quit();
    }

    @Test
    //Facebook authorization doen`t work on staging
    public void ablogInViaFacebook() {

        clearCache();
        close();
        open("https://www.idealflatmate.co.uk/");
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.clickLoginWithFacebook1();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

    @Test
    public void alogInWithMatchingFB() {
        clearCache();
        close();
        open("https://www.idealflatmate.co.uk/");
        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        matchingHelper.clickAFM();

        matchingHelper.clickContinueMatching1();
        matchingHelper.clickContinueMatching2();
        matchingHelper.clickContinueMatching3();
        matchingHelper.clickContinueMatching4();
        matchingHelper.clickContinueMatching5();
        matchingHelper.clickContinueMatching6();
        matchingHelper.clickContinueMatching7();
        matchingHelper.clickContinueMatching8();
        matchingHelper.clickContinueMatching9();
        matchingHelper.clickContinueMatching10();
        matchingHelper.clickContinueMatching11();
        matchingHelper.clickContinueMatching12();
        matchingHelper.clickContinueMatching13();
        matchingHelper.clickContinueMatching14();
        matchingHelper.clickContinueMatching15();
        matchingHelper.clickContinueMatching16();
        matchingHelper.clickContinueMatching17();
        matchingHelper.clickContinueMatching18();
        matchingHelper.clickContinueMatching19();
        matchingHelper.clickContinueMatching20();

        authorizationHelper.clickLoginWithFacebook();
        authorizationHelper.LoginFacebookWithActiveAccount("aleksandr.serdiuk@gmail.com", "Apple210189");
        verificationHelper.verificationUserNameOnHomePage("Alex");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void invalidLoginWithEmptyFields() {

        helperBase.pageUrlVerifLiveGoStage();
        clearCache();
        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.submitLogin();
        verificationHelper.VerificationLoginError();
        verificationHelper.VerificationPasswordError();
        signUpHelper.quit();
       //verificationHelper.VerificationMessagesTabIsAbsent();
    }

    @Test
    public void logInMessageProperty() {

        helperBase.pageUrlVerifLiveGoStage();
        clearCache();
        getMessageHelper().clickPropertyCardMessageUnlogged();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("FM_Manch_2@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();

        verificationHelper.verificationUserNameOnHomePage("FM_Manch_2");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

    @Test
    public void logInContactProperty() {

        helperBase.pageUrlVerifLiveGoStage();
        getMessageHelper().clickPropertyCardFirstOnPage();
        //authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickPropertyContact();
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.setLoginAsUserWithoutPackage("FM_Manch_2@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("FM_Manch_2");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

    @Test
    public void logInMessageFM() {

        helperBase.pageUrlVerifLiveGoStage();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickFMCardMessageUnlogged();
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.setLoginAsUserWithoutPackage("FMnew314@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

    @Test
    public void logInContactFM() {

        helperBase.pageUrlVerifLiveGoStage();
        authorizationHelper.goToFMpage();
        authorizationHelper.clickCloseSignUp();
        getMessageHelper().clickFMCardFirstOnPage();
        getMessageHelper().clickFMContact();
        authorizationHelper.clickFormSignInContact();
        authorizationHelper.setLoginAsUserWithoutPackage("FMnew314@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        verificationHelper.verifyPageMessage();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }
    @Test
    public void logInPhoneReveal() {

        helperBase.pageUrlVerifLiveGoStage();
        clearCache();
        getMessageHelper().clickPropertyCardFirstOnPage();
        getMessageHelper().clickPhoneReveal();
        authorizationHelper.clickSignInButtonInPopupPhone();
        authorizationHelper.setLoginAsUserWithoutPackage("FMnew314@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
        helperBase.toHomePage();
    }

}

