package sample.util;

import org.json.JSONObject;


public class Response {
    private int responseCode;
    private JSONObject data;

    public Response() {
    }

    public Response(int responseCode, JSONObject myresponse) {
        this.responseCode = responseCode;
        this.data = myresponse;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    //private JsonObject data;
}