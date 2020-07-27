package inc.droidstar.abcmall;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AbcmallUserdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(nullable = false)
    private String FirstName;
    @Column(nullable = false)
    private String LastName;
    @Column(nullable = false)
    private String UserType;
    @Column(nullable = false)
    private String ContactNo;
    @Column(nullable = false)
    private String Username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String Address;
    @Column(nullable = false)
    private String pinCode;
    @Column(nullable = false)
    private String BookFrom;
    @Column(nullable = false)
    private String BookTo;
    @Column(nullable = false)
    private String BusinessSpace;

    public void setId(Integer Id){
        this.Id = Id;
    }

    public Integer getId(){
        return Id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String Username){
        this.Username = Username;
    }

    public String getUsername(){
        return Username;
    }

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }

    public void setUserType(String UserType){
        this.UserType = UserType;
    }

    public void setContactNo(String ContactNo){
        this.ContactNo = ContactNo;
    }

    public void setemail(String email){
        this.email = email;
    }

    public void setAddress(String Address){
        this.Address = Address;
    }

    public void setpinCode(String pinCode){
        this.pinCode = pinCode;
    }

    public void setBookFrom(String BookFrom){
        this.BookFrom = BookFrom;
    }

    public void setBookTo(String BookTo){
        this.BookTo = BookTo;
    }

    public void setBusinessSpace(String BusinessSpace){
        this.BusinessSpace = BusinessSpace;
    }

    public String getFirstName(){
        return FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public String getUserType(){
        return UserType;
    }

    public String getContactNo(){
        return ContactNo;
    }

    public String getemail(){
        return email;
    }

    public String getAddress(){
        return Address;
    }

    public String getpinCode(){
        return pinCode;
    }

    public String getBookFrom(){
        return BookFrom;
    }

    public String getBookTo(){
        return BookTo;
    }

    public String getBusinessSpace(){
        return BusinessSpace;
    }
}