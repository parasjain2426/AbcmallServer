package inc.droidstar.abcmall;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class abcServices {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer Id;

private String probdate;
private String probType;
private String probDesc;
private String probUsername;

public void setId(Integer Id){
    this.Id = Id;
}

public void setprobdate(String probdate){
    this.probdate = probdate;
}

public void setprobType(String probType){
    this.probType = probType;
}

public void setprobDesc(String probDesc){
    this.probDesc = probDesc;
}

public void setprobUsername(String probUsername){
    this.probUsername = probUsername;
}

public Integer getId(){
    return Id;
}

public String getprobdate(){
    return probdate;
}

public String getprobType(){
    return probType;
}

public String getprobDesc(){
    return probDesc;
}

public String getprobUsername(){
    return probUsername;
}
}