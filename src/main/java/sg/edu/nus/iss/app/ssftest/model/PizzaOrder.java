package sg.edu.nus.iss.app.ssftest.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class PizzaOrder {
    private String orderId;
    private String name;
    private String address;
    private String phone;
    private Boolean rush;
    private String comments;
    private String pizza;
    private String size;
    private Integer quantity;
    private Double total;

    private Double pizzaCost;
    
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Boolean getRush() {
        return rush;
    }
    public void setRush(Boolean rush) {
        this.rush = rush;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getPizza() {
        return pizza;
    }
    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Double getPizzaCost() {
        return pizzaCost;
    }
    public void setPizzaCost(Double pizzaCost) {
        this.pizzaCost = pizzaCost;
    }
    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("orderId", this.getOrderId())
                .add("name", this.getName())
                .add("address", this.getAddress())
                .add("phone", this.getPhone())
                .add("rush", this.getRush())
                .add("comments", this.getComments())
                .add("pizza", this.getPizza())
                .add("size", this.getSize())
                .add("quantity", this.getQuantity())
                .add("total", this.getTotal())
                .build();
    }
    //Task 4
    public static PizzaOrder create(String json) throws IOException{
        PizzaOrder p = new PizzaOrder();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            p.setOrderId(o.getString("orderId"));
            p.setName(o.getString("name"));
            p.setAddress(o.getString("address"));
            p.setPhone(o.getString("phone"));
            p.setRush(o.getBoolean("rush"));
            p.setComments(o.getString("comments"));
            p.setPizza(o.getString("pizza"));
            p.setSize(o.getString("size"));
            p.setQuantity(o.getInt("quantity"));
            p.setTotal((double) o.getInt("total"));
        }
        return p;
    }
    

}
