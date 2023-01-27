package sg.edu.nus.iss.app.ssftest.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Order {
    
    @NotNull(message="Must have a pizza selection")
    private String pizza;

    @NotNull(message="Must have a size")
    private String size;

    @Min(value=1, message="Quantity cannot be less than 1")
    @Max(value=10, message="Quantity cannot be more than 10")
    private Integer quantity;

    private String id;

    private Integer total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
}
