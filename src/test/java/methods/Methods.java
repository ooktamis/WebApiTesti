package methods;

import base.Service;
import helper.Helper;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Methods {

    Service service;

    private JSONObject requestPayload ; // ana body

    private JSONObject jsonObject ; // {parametre : "value"}

    private JSONArray jsonArray ;

    private List<String> listObject ;

    private String fileName = "";

    public Methods(){
        this.service = new Service();
        requestPayload = new JSONObject();
        jsonObject = new JSONObject();
        jsonArray = new JSONArray();
        listObject = new ArrayList<>();
    }

    public void startWebService(String path, String filePath) {//end point buraya geliyor. user veya pet veya store gibi

        fileName = filePath;
        service.startWebServices(path);

    }

    public void setMethods(String requestType) throws IOException{//bu fonksiyonda spwc den gönderilen yapilacak işlemi belirler

        if(!fileName.isEmpty()){
            service.requestSpecBuilder(getBody(fileName));
        }else {
            service.requestSpecBuilder(requestPayload.toString());
        }

        switch(requestType){

            case "GET":
                service.get();
                service.getResponse().prettyPrint();
                System.out.println("Get islemi");
                break;
            case "POST":
                service.post();
                service.getResponse().prettyPrint();
                System.out.println("Post islemi");
                break;
            case "PUT":
                service.put();
                service.getResponse().prettyPrint();
                System.out.println("Guncelleme");
                break;
            case "DELETE":
                service.delete();
                System.out.println("Silindi");
                break;

        }
    }

    public void setPathParam(String key, Object value){//Bu fonksiyon url sonuna mesela user/oguz gibi oguz degerini ekler veya user/123gibi
        service.pathParam(key, value);
    }

    public void createJsonArray(String arrayParameter) {//Body de array varsa bunu kullanırız
        requestPayload.put(arrayParameter, jsonArray.put(jsonObject));
    }

    public void createListObject(String arrayParameter) {//Bir liste varsa bu fonk
        requestPayload.put(arrayParameter, listObject.toArray());
    }


    public void createJsonObject(String objectParameter) {//sadece json objesi ise bunu
        requestPayload.put(objectParameter, jsonObject);
    }

    public void setParameter(String parameter, Object value) {//direkt olarak body de satır olusturmak icin kullandık
        requestPayload.put(parameter, value);
    }

    public void setListObject(String parameter) {//gelen parametre turunu listeye ekliyor cunku liste de tur olarak ekletiyoruz
        listObject.add(parameter);
    }

    public void setJsonObjectParameter(String parameter, Object value) {//jsonobjesi olusturmak icin turu ile
        jsonObject.put(parameter, value);
    }


    public void clearJsonObject() {
        while (jsonObject.length() > 0)
            jsonObject.remove(jsonObject.keys().next());
    }

    public void clearListObject() {
        while (listObject.size() > 0)
            listObject.remove(listObject.iterator().next());
    }

    public String getBody(String file) throws IOException {
        return  Helper.readJsonFile(file);
    }


}
