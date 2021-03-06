package uk.co.idealflatmate.tests;

import org.testng.annotations.*;
//import ru.yandex.qatools.allure.annotations.Parameter;
import utils.ConfData;

import static com.codeborne.selenide.Selenide.sleep;
import static uk.co.idealflatmate.appmanager.HelperBase.closeListRenewPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.closeMatchPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;


public class AbclearDataTests extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }


    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        return new Object[][] { {ConfData.getData("passwUniv"), ConfData.getData("agentRemoved" )},
                { "qqqqqq", "FMnewlq1t6@gmail.com" }, { "qqqqqq", "FMnew999@gmail.com"}, { "qqqqqq", "agentTest08@gmail.com" },
                { "qqqqqq", "Li1q3e11@gmail.com" }, { "qqqqqq", "Live_inNew021r@gmail.com" },{ "qqqqqq", "Lord_out_New034@gmail.com" },
                { "qqqqqq", "Live_inNewL012@gmail.com" },{ "qqqqqq", "Live_inNewL012yyy@gmail.com" },{ "qqqqqq", "Mes1email@gmail.com" },
                { "qqqqqq", "Mes2email@gmail.com" }, {"qqqqqq", "TerezaHQ1a@gmail.com"},{"qqqqqq", "Mes4email@gmail.com" },
                {"qqqqqq", "FMupsBuddy5@gmail.com" }, {"qqqqqq", "TerezaHQ5@gmail.com"}, {"qqqqqq", "TerezaHQ2@gmail.com"},
                {"qqqqqq", "FMnew124o@gmail.com"}, {"qqqqqq", "Tenanttyrrr1r@gmail.com"}, {"qqqqqq", "Live_inNewy733430@gmail.com"},
                {"qqqqqq", "FMnewuy7233@gmail.com"}, {"qqqqqq", "FMnew33riiq@gmail.com"}, {"qqqqqq", "LiveOut7t111r21@gmail.com"},
                {"qqqqqq", "FMupsBuddy6@gmail.com"}, {"qqqqqq", "FMupsBuddy7@gmail.com"}};

        }




    @Test(dataProvider = "Authentication" )
    

    public void removeAccountBeforeTest(String confEmail, String confPassword) {

        authorizationHelper.loginHeader1(confEmail, confPassword);
        authorizationHelper.removeAccountBeforeTest();



    }

    //@Test (dataProvider = "dasf")


    @Parameters ({ "confEmail", "confPassword" })
    public void removeAccountBeforeTestLive(@Optional("qqqqqq") String confPassword,@Optional("proideal@ukr.net") String confEmail) {

        authorizationHelper.loginHeader2(confEmail, confPassword);
        authorizationHelper.removeAccountBeforeTest();



    }



    @Test
    public void removeListingBeforeTest() {

        authorizationHelper.login("passwUniv", "agentNotPaid");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "userNotpaid");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "userNotpaid1");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "agentBuddyUp");
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "agentNewBuddyUp");
        closeListRenewPopUp();
        verifyNoPropertyOrRemove();

        authorizationHelper.login("passwUniv", "userTitle");
        closeMatchPopUp();
        verifyNoPropertyOrRemove();

    }

    @Test
    public void activateListingBeforeTest() {
        authorizationHelper.login("passwUniv", "Live_in_Mes");
        closeListRenewPopUp();
        closeMatchPopUp();
        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.isNotActive("12947");
        sleep(2000);
        clearCache();

    }



    public void verifyNoPropertyOrRemove() {
        addPropertyHelper.chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoUnfinishedProperty();
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
        sleep(2000);
        clearCache();
    }


}

