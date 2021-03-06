package uk.co.idealflatmate.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class SignUpMatching extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }


    @Test

    public void signUpMatchingWithBlankFirstName() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.verifyBlankNameMatchSign();
        matchingHelper.quitQuiz();
    }

    @Test
    public void SignUpMatchingWithRequiredFieldsRoom() {
        String name = "Donald";
        String location = "Watford";
        String age = "42";

        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName(name);
        matchingHelper.clickARoom();

        //matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", name, "FMMatch5");
        signUpHelper.moreAboutYou("15","2","1977","45656776","20","Tell us about yourself",
                                                "Professional", "Freelancer/self employed");

        signUpHelper.backClick();
        signUpHelper.profilePhotoAddJpeg();
        signUpHelper.clickYourInformationContinue();
        signUpHelper.preferredLocation( "watf", location);
        signUpHelper.clickYourInformationContinue();


        signUpHelper.budgetMax();
        signUpHelper.clickYourInformationContinue();
        verificationHelper.budgetError();


        signUpHelper.budgetMin();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.toMoveCheckboxEnabled();
        signUpHelper.selectMoveDate("8", "8", "2019");
        signUpHelper.selectHappyReceiveNews();
        signUpHelper.clickYourInformationContinue();

        //signUpHelper.clickShowMeMyMatches();
        verificationHelper.verifySearchListingPageMatching();

        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        matchingHelper.chooseMatchingFromDropDownMenu();
        matchingHelper.verificationResultOfMatching();

        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        verificationHelper.profileDisplays("80%\n" + "complete",
                                            "User Type\n" + "Personal Details\n" +
                                            "Property Preferences\n" + "Budget & Availability\n" +
                                            "Your ideal flatmate",
                                            name, age, "I'm looking for a room",
                                            "About me\n" + "Tell us about yourself\n" +
                                                    "Maximum budget: £1250/month\n" +
                                                    "Ready to move in: 08-08-2019\n" +
                                                    "Looking for a room in\n" + location,
                                                    "no rooms", 0);

        verificationHelper.verificationUserNameOnHomePage(name);

        authorizationHelper.removeAnyAccount();
    }


    @Test
    public void SignUpMatchingWithRequiredFieldsFMRoom() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMMatch4");
        signUpHelper.moreAboutYou("15","2","1977","45656776","227",
                    "Tell us about yourself", "Professional", "Other");

        signUpHelper.clickListYourRoomMatching();

        verificationHelper.verifyAddListingPage();
        addPropertyHelper.openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
       // matchingHelper.closePopupMatching();
        //signUpHelper.verificationDataProfileNameUser("flatmate");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }

    @Test
    public void SignUpMatchingWithRequiredFieldsFMRoomSearchFM() {

        matchingHelper.clickHomePageMatching();
        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.yourInformation("passwUniv", "Ronald", "FMMatch6");
        signUpHelper.moreAboutYou("15","2","1977","45656776","227",
                     "Tell us about yourself", "Professional", "Other");

        signUpHelper.clickSearchFMMatching();
        verificationHelper.verifySearchFMPage();
        //verificationHelper.verifyAddListingPage();

        getAddPropertyHelper().openDropDownMenu();
        verificationHelper.checkMatchingConcurrence("100% complete");
        authorizationHelper.chooseSectionDropDownMenu("My profile");
       // matchingHelper.closePopupMatching();
        signUpHelper.verificationDataProfileNameUser("Ronald", "42");
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        authorizationHelper.removeAnyAccount();
    }


    @Test
    public void SignUpWithMatchingWithBlankRequiredFields() {
        pageUrlVerifLiveGoStage();
        clearCache();
        matchingHelper.clickHomePageMatching();

        matchingHelper.enterFirstName("Donald");
        //matchingHelper.clickARoom();

        matchingHelper.clickAFM();
        matchingHelper.matchingTests();

        signUpHelper.clickEmailMatching1();

        signUpHelper.clickYourInformationContinue();

        verificationHelper.emailBlankAlert();
        verificationHelper.nameFirstBlankAlert();
        verificationHelper.genderBlankAlert();
        verificationHelper.passwordBlankAlert();

        signUpHelper.quit();
        verificationHelper.isHomePage();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

}
