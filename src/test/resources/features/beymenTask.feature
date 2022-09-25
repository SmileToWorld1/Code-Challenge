
Feature: Search Box ve Sepetim Fonksiyonlarının Test Edilmesi
  @wip
  Scenario: Aranan ürünün fiyatının Sepetim sayfasındaki ürün fiyatı ile karşılaştırılması ve sepetteki ürünün silinmesi
    Given Kullanıcı siteye giriş yapar
    When Ana sayfanın açıldığı kontrol edilir
    And Arama kutucuğu şort kelimesi girilir
    But Arama kutucuğuna girilen şort kelimesi silinir
    Then Arama kutucuğuna gömlek kelimesi girilir
    And Klavye üzerinden “enter” tuşuna bastırılır
    Then Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir
    And Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır
    Then Seçilen ürün sepete eklenir
    Then Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır
    Then Adet arttırılarak ürün adedinin 2 olduğu doğrulanır
    And Ürün sepetten silinerek sepetin boş olduğu kontrol edilir



