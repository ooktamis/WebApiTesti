package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;


import static io.restassured.RestAssured.*;


public class Service {

    private Response response;
    private String requestBody;
    private String baseURL = "https://petstore.swagger.io/v2/";
    private RequestSpecBuilder reqSpecBuilder;


    public void startWebServices(String path) {//Gelen path endpoint burada ekleniyor

        reqSpecBuilder = new RequestSpecBuilder();//end point eklemek adına kullanıldı
        reqSpecBuilder.setBasePath(path);
    }

    public void requestSpecBuilder(String body){//apimiz de ki temel kısımlar islemler burada oluşturuldu.

                    //requestBody = requestPayload;
                    reqSpecBuilder
                    .setBaseUri(baseURL)
                    .setBody(body)
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON);

    }

    public void pathParam(String key, Object value) {//Methods sınıfından gelen degeri setpatparam fonskiyonunun degerini buraya ekliyor
        reqSpecBuilder.addPathParam(key, value);//specbuilder ile ekliyoruz
    }

    public void get(){

        RequestSpecification requestSpecification = given();

         response = requestSpecification
                 .spec(reqSpecBuilder.build()).redirects()
                 .follow(true)
                 .when()
                 .get()
                 .then()
                 .extract().response();

    }

    public void post(){

        RequestSpecification requestSpecification = given();

        response = requestSpecification
                .spec(reqSpecBuilder.build()).redirects()
                .follow(true)
                .when()
                .post()
                .then()
                .extract().response();

    }

    public Response getResponse(){//donen degeri ekrana yazdirmak icin kullandık
        return  response;
    }

    public void delete(){

        RequestSpecification requestSpecification = given();

        response = requestSpecification
                .spec(reqSpecBuilder.build()).redirects()
                .follow(true)
                .when()
                .delete()
                .then()
                .extract().response();

    }

    public void put(/*String key, Object value*/){

        RequestSpecification requestSpecification = given();

        response = requestSpecification
                .spec(reqSpecBuilder.build()).redirects()
                .follow(true)
                .when()
                .put()
                .then()
                .extract().response();

    }

}