package vn.iotstart.models;

//import lombok.Data;
//LTWeb01\src\main\java\vn\iotstart\models\User.java
//@Data
public class User {
	private int id;
    private String name;
    private String password;
    private boolean isSeller;
    private boolean isAdmin;
    
    public User() {};
    public User(int id, String name, String password, boolean isSeller, boolean isAdmin) {
    	this.id=id;
    	this.name=name;
    	this.password=password;
    	this.isSeller=isSeller;
    	this.isAdmin=isAdmin;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSeller(boolean seller) {
        this.isSeller = seller;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
