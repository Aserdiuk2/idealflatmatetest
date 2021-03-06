package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static uk.co.idealflatmate.appmanager.HelperBase.closeMatchPopUp;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class PaymentTests extends TestBase {
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        refresh();
    }


    @Test
    public void abilityToSeePhone() {


        authorizationHelper.login("passwUniv", "Prem_FH_paid");
        verificationHelper.verificationUserNameOnHomePage("Zlatan");
        searchHelper.searchPropertyHome("#0012906");
        paymentsHelper.verificationPhone("XXXX");
        getMessageHelper().clickPhoneReveal();

        paymentsHelper.verificationPhoneVisible("777777777");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void goPremiumFHPaymentOnPhone() {

        authorizationHelper.login("passwUniv", "FMNotPaid");

        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchPropertyHome("#0012906");
        paymentsHelper.verificationPhone("XXXX");
        getMessageHelper().clickPhoneReveal();
        paymentsHelper.verificationPremiumPopup("Get access to all properties");
        paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void goPremiumFHPaymentOnMessage() {

        authorizationHelper.login("passwUniv", "FMNotPaid");

        verificationHelper.verificationUserNameOnHomePage("Borris");
        searchHelper.searchPropertyHome("#0012906");
        getMessageHelper().clickPropertyContact();
        paymentsHelper.clickUpgradePremiumFH("Upgrade to get a faster reply");
        paymentsHelper.clickUpgradePremiumFH("Upgrade Now");
        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void premiumFHPaymentWorldPay() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUpFMPage();

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickRoom();
        signUpHelper.clickEmail();

        signUpHelper.yourInformation("passwUniv", "Ronald", "fmNotPaid3");

        signUpHelper.moreAboutYou("5", "12","1988","77777777", "227","I am a FlatHunter", "Professional", "Other");

        signUpHelper.whereWouldLikeLive("watf", "Watford");

        signUpHelper.budgetMin();
        signUpHelper.budgetMax();
        signUpHelper.verifyToMoveCheckboxDisabled();
        signUpHelper.clickYourInformationContinue();

        //signUpHelper.priceMove("15", "12", "2019");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();

        paymentsHelper.verificationPaymentPage("Premium Flathunter");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.upgradePremiumFH();
        paymentsHelper.verificationCheckout("£"+"3.99 (week)");
        paymentsHelper.verificationCheckoutTotal("3.99");
        paymentsHelper.checkout();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");

        verificationHelper.verifyPackagePurchase("Congratulations on choosing our Premium Flathunter plan for the property .");
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");
        verificationHelper.verificationUserNameOnHomePage("Ronald");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void lordInWorldPaylistingEssen() {
        String price = "8";

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();
        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("live-In1", "passwUniv",
                "5", "5", "1959", "55555555", "19", "Ronald",
                "Professional", "Student");

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.pressAddListingFromBody();
        addPropertyHelper.addListingWithoutPhoto("SE1", "Bermondsey", "2", "900",  "London SE1, UK");

        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");

        paymentsHelper.defaultPlanActiveIs("Monthly", "16", "22", "34");
        paymentsHelper.clickPlan("Weekly");
        paymentsHelper.defaultPlanActiveIs("Weekly", "8", "12", "disabled");
        paymentsHelper.clickSelectPlan("Essential", "button");

        paymentsHelper.verificationCheckoutNewTotal(price);
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");

        verificationHelper.verifyPackagePurchaseList("ideal flatmate Essentials");
        closeMatchPopUp();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.promoteCard();
        verificationHelper.packageOnCard("Essentials listing", "default");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }
    @Test
    public void lordOutWorldPaylistingPrem() {
        String price = "22";

        authorizationHelper.goToFMpage();

        authorizationHelper.clickCloseSignUp();

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser("Live-out landlord");

        signUpHelper.signListingLiveOut("liv-Out1", "passwUniv",
                "2Ronald", "897876567");

        addPropertyHelper.saveQuitHeaderMenuListing();
        verificationHelper.verificationUserNameOnHomePage("2Ronald");
        addPropertyHelper.pressAddListingFromBody();

        addPropertyHelper.addListingWithoutPhoto("lon", "Chalk Farm", "15", "1333",
                                                "London Euston, London, UK");

        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");

        paymentsHelper.defaultPlanActiveIs("Monthly", "16", "22", "34");
        paymentsHelper.clickPlan("Weekly");
        paymentsHelper.defaultPlanActiveIs("Weekly", "8", "12", "disabled");
        paymentsHelper.clickPlan("Monthly");
        paymentsHelper.defaultPlanActiveIs("Monthly", "16", "22", "34");
        paymentsHelper.clickSelectPlan("Premium", "button");

        paymentsHelper.verificationCheckoutNewTotal(price);
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");

        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        closeMatchPopUp();
        verificationHelper.verifyPackagePurchaseList("ideal flatmate Premium");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Premium listing", "primary");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("2Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }




    @Test
    public void lordInWorldPaidListingProf() {
        String price = "319";

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("Live-in landlord");

        signUpHelper.signListingFM_LiveIn("fmNotPaid4", "passwUniv",
                "5", "5", "1959", "55555555", "19", "Ronald",
                "Professional", "Student");

        addPropertyHelper.saveQuitHeaderMenuListing();
        closeMatchPopUp();

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        addPropertyHelper.pressAddListingFromBody();
        addPropertyHelper.addListingWithoutAreaDefault("C", "Studio",  "2100",
                                                        "Eden, CA10 1AA, UK", "Lazonby");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        paymentsHelper.verificationPaymentPageFeatureListing("Now choose the plan that is right for you.");
        //paymentsHelper.selectPremiumFlathunterPlan();
        paymentsHelper.defaultPlanActiveIs("Monthly", "16", "22", "34");
        paymentsHelper.clickPlan("Yearly");
        paymentsHelper.defaultPlanProf("249");//essential and premium are disabled
        paymentsHelper.clickSelectPlan("Professional", "a");
        paymentsHelper.upgradeListingProfNew("up to 5");
        paymentsHelper.priceVerifPaymentSystemPage(price);
        //paymentsHelper.choosePrice("183", "ProfessionalPaymentForm");//1 month - "+"£"+"44.99
        paymentsHelper.upgradeListing("Upgrade to Professional", "Upgrade to Professional");
        //paymentsHelper.verificationCheckout("£"+"44.99 (monthly)");
        paymentsHelper.verificationCheckoutNewTotal(price);
        //paymentsHelper.checkout();
        //paymentsHelper.choosePayPal();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        closeMatchPopUp();

        verificationHelper.verifyPackagePurchaseList("ideal flatmate Professional");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Free listing", "default");
        paymentsHelper.promoteCardClick("Promote");
        verificationHelper.packageOnCard("Premium listing", "primary");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }



    @Test
    public void agentProfWorldPay() {

        authorizationHelper.clickJoinFreeButton();
        signUpHelper.clickFM();

        addPropertyHelper.selectTypeUser("An agency");

        signUpHelper.agentSignListing("Ronald", "agent2", "passwUniv",
                "66666666", "Tell us about yourself");
        addPropertyHelper.saveQuitHeaderMenuListing();
        verificationHelper.verificationUserNameOnHomePage("Ronald");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();

        paymentsHelper.upgradeListingProfOld("1-2");

        paymentsHelper.choosePrice("181", "ProfessionalPaymentForm");//1 month - £34.99
        //paymentsHelper.selectNLADiscount("NLA15", "ProfessionalPaymentForm");
        paymentsHelper.upgradeListing("Upgrade to", "Professional");
        paymentsHelper.verificationCheckout("£"+"34.99 (monthly)");
        paymentsHelper.verificationCheckoutTotal("34.99");
        paymentsHelper.checkout();
        paymentsHelper.chooseWorldPay("or Credit / Debit Card");
        paymentsHelper.fillinDebitCardData("Alex", "5454545454545454", "11", "2020", "123");
        verificationHelper.verifyPackagePurchaseList("ideal flatmate Professional");
        //paymentsHelper.choosePayPal();

        addPropertyHelper.chooseListLoggedFromHeaderProfile();
        addPropertyHelper.addListingWithoutAreaDefault("Coventry", "3",  "2100",
                "Coventry University, Priory Street, Coventry, UK", "Coventry");

        addPropertyHelper.finishPropertyAgencyWithSubs("Your listing is now live!");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.packageOnCard("Premium listing", "primary");
        paymentsHelper.promoteCardClick("Switch to Essentials");
        verificationHelper.packageOnCard("Essentials listing", "default");

        addPropertyHelper.openDropDownMenu();
        paymentsHelper.goToPaymentsTab();
        paymentsHelper.removePackage();
        verificationHelper.verifyPackageCanceled("Your subscription will not renew automatically.");

        verificationHelper.verificationUserNameOnHomePage("Ronald");
        getAddPropertyHelper().openDropDownMenu();
        authorizationHelper.chooseSectionDropDownMenu("My profile");
        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");


    }

}
