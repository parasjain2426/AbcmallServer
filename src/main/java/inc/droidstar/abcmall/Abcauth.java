package inc.droidstar.abcmall;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Abcauth {
@Id
@Column(unique = true)
private String authName;

private String authtoken;

public void setauthName(String authName){
    this.authName = authName;
}

public void setauthtoken(String authtoken){
    this.authtoken = authtoken;
}

public String getauthName(){
    return authName;
}

public String getauthtoken(){
    return authtoken;
}
    
}