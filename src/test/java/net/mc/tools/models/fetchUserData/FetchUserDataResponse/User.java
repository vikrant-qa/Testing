package net.mc.tools.models.fetchUserData.FetchUserDataResponse;

public class User
{
    private Email email;
    private Roles roles;

    private String status;
    private String brandName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String _id;
    private String address;
    private String city;
    private String country;
    private String pinCode;
    private String commision;
    private String commisionType;
    private String shop;
    private String userLevel;
    private String createdAt;

    public Email getemail() {

        return email;
    }

    public void setemail(Email email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Roles getroles() {

        return roles;
    }

    public void setroles(Roles roles) {
        this.roles = roles;
    }


    public String getbrandName() {
        return brandName;
    }

    public void setbrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }



    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }


    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }

    public String getpinCode() {
        return pinCode;
    }

    public void setpinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getcommision() {
        return commision;
    }

    public void setcommision(String commision) {
        this.commision = commision;
    }


    public String getcommisionType() {
        return commisionType;
    }

    public void setcommisionType(String commisionType) {
        this.commisionType = commisionType;
    }

    public String getshop() {
        return shop;
    }

    public void setshop(String shop) {
        this.shop = shop;
    }

    public String getuserLevel() {
        return userLevel;
    }

    public void setuserLevel(String userLevel) {
        this.userLevel = userLevel;
    }


    public String getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
