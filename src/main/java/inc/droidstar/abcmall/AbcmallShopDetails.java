package inc.droidstar.abcmall;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AbcmallShopDetails {
@Id
private String BusinessSpaceType;

private String duration;
private String rentType;
private String Cost;
private String available;

public void setBusinessSpaceType(String BussinessSpaceType){
    this.BusinessSpaceType = BussinessSpaceType;
}

 
public void setduration(String duration){
    this.duration = duration;
}

public void setrentType(String rentType){
    this.rentType = rentType;
}

public void setCost(String Cost){
    this.Cost = Cost;
}

public void setavailable(String available){
    this.available = available;
}

public String getBusinessSpaceType(){
    return BusinessSpaceType;
}

public String getduration(){
    return duration;
}

public String getrentType(){
    return rentType;
}

public String getCost(){
    return Cost;
}

public String getavailable(){
    return available;
}
}