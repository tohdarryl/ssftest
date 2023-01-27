package sg.edu.nus.iss.app.ssftest.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Details {
    @NotNull(message="Name cannot be empty")
    @Size(min=3,message = "Name must be atleast 3 chars")
    private String name;

    @NotEmpty(message="Address cannot be empty")
    private String address;

    @NotNull(message="Must have a phone number")
    @Size(min=8,max=8,message ="Phone number should be 8 digits")
    private String phone;

    private Boolean rush;

    private String comments;


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
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public Boolean getRush() {
        return rush;
    }
    public void setRush(Boolean rush) {
        this.rush = rush;
    }

    

    
    
}
