package inc.droidstar.abcmall;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AbcRevenue {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer Id;

private String Bfrom;
private String Bto;
private String Revenue;

public void setId(Integer Id){
    this.Id = Id;
}

public Integer getId(){
    return Id;
}

public void setBfrom(String Bfrom){
    this.Bfrom = Bfrom;
}

public String getBfrom(){
    return Bfrom;
}

public void setBto(String Bto){
    this.Bto = Bto;
}

public String getBto(){
    return Bto;
}

public void setRevenue(String Revenue){
    this.Revenue = Revenue;
}

public String getRevenue(){
    return Revenue;
}
}