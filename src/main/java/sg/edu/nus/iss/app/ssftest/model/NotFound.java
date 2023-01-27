package sg.edu.nus.iss.app.ssftest.model;

import java.io.Serializable;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class NotFound implements Serializable{
    private String message;


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
 
   
    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("message", this.getMessage())
                .build();
    }
    
    
}
