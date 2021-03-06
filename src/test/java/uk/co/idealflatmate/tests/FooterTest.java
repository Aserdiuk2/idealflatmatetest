package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class FooterTest extends TestBase {

    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }

    @Test
    public void footerHomeLink() {

        footerHelper.footerClick("Home");
        footerHelper.verificationFooterHome();
        helperBase.toHomePage();
    }

    @Test
    public void footerAboutUsLink() {

        footerHelper.footerClick("About us");
        footerHelper.verificationFooter("About us");
        helperBase.toHomePage();
    }

    @Test
    public void footerContactLink() {

        footerHelper.footerClick("Contact");
        footerHelper.verificationFooter("Contact");
        helperBase.toHomePage();
    }

    @Test
    public void footerPressLink() {

        footerHelper.footerClick("Press");
        footerHelper.verificationFooter("Press");
        helperBase.toHomePage();
    }

    @Test
    public void footerPricingLink() {

        footerHelper.footerClick("Pricing");
        footerHelper.verificationFooter("Pricing");
        helperBase.toHomePage();
    }

    @Test
    public void footerMediaLink() {

        footerHelper.footerClick("Media");
        footerHelper.verificationFooter("Media");

    }

    @Test
    public void footerStaySafeLink() {

        footerHelper.footerClick("Stay safe");
        footerHelper.verificationFooter("Security warning");

    }

    @Test
    public void footerBlogLink() {

        footerHelper.footerClick("Blog");
        verificationHelper.FMBlogPage();

    }

    @Test
    public void footerBrowseFlatsharesLink() {
        String area = "Chalk Farm";
        String city = "London";

        footerHelper.footerClick("Browse Flatshares");
        footerHelper.verificationBrowseFlatshares(city, area,"Click to search nearby areas",
                "Found ", " rooms to rent in ");
        }

    @Test
    public void footerAskLandlord() {

        helperBase.toHomePage();
        footerHelper.footerClick("#AskTheLandlord");
        footerHelper.verificationAskLandlord();
        helperBase.toHomePage();
    }

    @Test
    public void footerModern() {

        helperBase.toHomePage();
        footerHelper.footerClick("Modern Living Index");
        footerHelper.verificationModern();

    }

    @Test
    public void footerBrowseHowItWorksLink() {

        footerHelper.footerClick("How it works");
        footerHelper.verificationHowItWorks();
        helperBase.toHomePage();
    }

    @Test
    public void footerBrowseTipsLink() {

        footerHelper.footerClick("Tips");
        footerHelper.verificationFooter("Tips");
        helperBase.toHomePage();
    }

    @Test
    public void footerNLALink() {

        footerHelper.footerNLAWorks();
        footerHelper.verificationNLAWorks();
        //helperBase.toHomePage();
    }

    //@Test
    public void footerFBLink() {
        pageUrlVerifLiveGoStage();
        helperBase.toHomePage();
        footerHelper.footerFB();
        footerHelper.verificationFB();

    }

    @Test
    public void footerTwitterLink() {

        footerHelper.footerTwitter();
        footerHelper.verificationTwitter();
    }

   @Test
    public void footerInstagramLink() {

        footerHelper.footerInstagram();
        footerHelper.verificationInstagram();

    }

    @Test
    public void footerYoutubeLink() {

        footerHelper.footerYoutube();
        refresh();
        footerHelper.verificationYoutube();
    }



}
