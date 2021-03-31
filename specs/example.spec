# Specification Heading


Senaryo Pet
-------------
 tags:petApi

* Pet servisine request body oluştur
* "pet" endpointi ile servisi başlat
* "POST" islemi yap
* "19979" idli request bodyde 'name' keyini "ouz oooo" ile güncelle
* "PUT" islemi yap
* "pet/{petId}" endpointi ile servisi başlat
* "petId" keyi ve "19979" degeri ile url pathi ekle
* "GET" islemi yap
* "pet/{petId}" endpointi ile servisi başlat
* "petId" keyi ve "19979" degeri ile url pathi ekle
* "DELETE" islemi yap


Senaryo Dosya okuma
-------------------
 tags:dosyaOkuma

* "pet" endpointi ve "petBody" json dosyası ile servisi başlat
* "POST" islemi yap


Senaryo Store
----------------
 tags:storeApi

* Store servisine request body oluştur
* "store/order" endpointi ile servisi başlat
* "POST" islemi yap
* "store/order/{orderId}" endpointi ile servisi başlat
* "orderId" keyi ve "8" degeri ile url pathi ekle
* "GET" islemi yap
* "store/order/{orderId}" endpointi ile servisi başlat
* "orderId" keyi ve "8" degeri ile url pathi ekle
* "DELETE" islemi yap


Senaryo User
----------------
 tags:userApi

* User createWithArray request body oluştur
* "user" endpointi ile servisi başlat
* "POST" islemi yap
* "user/{username}" endpointi ile servisi başlat
* "username" keyi ve "oo" degeri ile url pathi ekle
* "GET" islemi yap
"user/oo" endpointi ile servisi başlat
* "username" keyi ve "oo" degeri ile url pathi ekle
* "oo" usernameli request bodyde 'password' keyini "parolasifir1" ile güncelle
* "PUT" islemi yap
* "user/{username}" endpointi ile servisi başlat
* "username" keyi ve "oo" degeri ile url pathi ekle
* "DELETE" islemi yap