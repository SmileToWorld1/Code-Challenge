package com.step_definitions;

import com.pages.BasketPage;
import com.pages.HomePage;
import com.utilities.*;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class BeymenTask_StepDefinition {
    private static final Logger logger = LogManager.getLogger(BeymenTask_StepDefinition.class.getName());
    HomePage homePage = new HomePage();
    BasketPage basketPage = new BasketPage();
    ExcelUtil excelUtil = new ExcelUtil("src/test/resources/BeymenTaskData.xlsx", "page1");
    WriteFile writeFile = new WriteFile();
    String ürünSayfasındakitutarBilgisi = null;

    @Given("Kullanıcı siteye giriş yapar")
    public void kullanıcı_siteye_giriş_yapar() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("Ana sayfanın açıldığı kontrol edilir")
    public void ana_sayfanın_açıldığı_kontrol_edilir() {
        BrowserUtils.verifyTitle(homePage.homePageTitle);
    }

    @When("Arama kutucuğu şort kelimesi girilir")
    public void arama_kutucuğu_şort_kelimesi_girilir() {
        homePage.getSearchBox().sendKeys(excelUtil.getCellData(0, 0));
    }

    @When("Arama kutucuğuna girilen şort kelimesi silinir")
    public void arama_kutucuğuna_girilen_şort_kelimesi_silinir() throws InterruptedException {
        homePage.getSearchBox().sendKeys(Keys.CONTROL + "A" + Keys.BACK_SPACE);
    }

    @Then("Arama kutucuğuna gömlek kelimesi girilir")
    public void arama_kutucuğuna_gömlek_kelimesi_girilir() {
        homePage.getSearchBox().sendKeys(excelUtil.getCellData(0, 1));
    }

    @Then("Klavye üzerinden “enter” tuşuna bastırılır")
    public void klavye_üzerinden_enter_tuşuna_bastırılır() {
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }

    @Then("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir")
    public void sonuca_göre_sergilenen_ürünlerden_rastgele_bir_ürün_seçilir() {
        homePage.clickRandomProduct1Page();
    }

    @Then("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır")
    public void seçilen_ürünün_ürün_bilgisi_ve_tutar_bilgisi_txt_dosyasına_yazılır() {
        String ürünBilgisi = homePage.getProductInformation().getText();
        ürünSayfasındakitutarBilgisi = homePage.getPriceNew().getText();
        writeFile.writeUsingBufferedWriter(ürünBilgisi, ürünSayfasındakitutarBilgisi);
        writeFile.closeWriteFile();
    }

    @Then("Seçilen ürün sepete eklenir")
    public void seçilen_ürün_sepete_eklenir() {
        homePage.clickFirstEnableProductVariation();
        homePage.clickAddBasketButton();
    }

    @Then("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır")
    public void ürün_sayfasındaki_fiyat_ile_sepette_yer_alan_ürün_fiyatının_doğruluğu_karşılaştırılır() {
        homePage.clickGoToBasketButton();
        String sepetimSayfasındakiTutarBilgisi = basketPage.getSalePrice().getText();
        Assert.assertEquals("Her iki sayfadaki tutar bilgisi uyuşmamaktadır!",ürünSayfasındakitutarBilgisi,sepetimSayfasındakiTutarBilgisi);
    }

    @Then("Adet arttırılarak ürün adedinin {int} olduğu doğrulanır")
    public void adet_arttırılarak_ürün_adedinin_olduğu_doğrulanır(Integer adet) {
        try {
            basketPage.selectQuantityByValue(String.valueOf(adet));
            String sepettekiÜrünMiktarı = basketPage.getBasketQuantity().getText();
            Assert.assertTrue("Miktar uyuşmuyor!", sepettekiÜrünMiktarı.contains(String.valueOf(adet)));
            BrowserUtils.waitForVisibility(basketPage.getNotifyTitle());
        }catch (Exception e){
            logger.error("Bu ürün tek kalmıştır, miktar arttırılamaz!");
        }
    }

    @Then("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir")
    public void ürün_sepetten_silinerek_sepetin_boş_olduğu_kontrol_edilir() {
        basketPage.clickDeleteButton();
        Assert.assertEquals("Sepetin boş olduğuna dair mesaj metni uyuşmuyor!",basketPage.expectedEmptyBasketBoxMessage,basketPage.getEmptyMessageTitle().getText());
    }


}
