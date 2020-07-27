package inc.droidstar.abcmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/abcmall")
public class AbcmallController {
    @Autowired
    private AbcmallUserRepository abcUser;

    @Autowired
    private AbcmallShopRepository abcShop;

    @Autowired
    private AbcRevenueRepository Reprevenue;

    @Autowired
    private AbcServiceRepo reqService;

    @Autowired
    private AbcauthRepository authRepo;

    @PostMapping("/saveUser")
    public @ResponseBody abcMessage saveUser(@RequestParam(value="Username")String Username,@RequestParam(value="password")String password,@RequestParam(value = "FirstName") String FirstName,@RequestParam(value = "LastName") String LastName,@RequestParam(value = "UserType") String UserType,@RequestParam(value = "ContactNo") String ContactNo,@RequestParam(value = "email") String email,@RequestParam(value = "Address") String Address,@RequestParam(value = "pinCode") String pinCode,@RequestParam(value = "BookFrom") String BookFrom,@RequestParam(value = "BookTo") String BookTo,@RequestParam(value = "BusinessSpace") String BusinessSpace){
        AbcmallUserdetails abcUserDetails = new AbcmallUserdetails();
        abcUserDetails.setFirstName(FirstName);
        abcUserDetails.setLastName(LastName);
        abcUserDetails.setAddress(Address);
        abcUserDetails.setemail(email);
        abcUserDetails.setBookFrom(BookFrom);
        abcUserDetails.setBookTo(BookTo);
        abcUserDetails.setpinCode(pinCode);
        abcUserDetails.setBusinessSpace(BusinessSpace);
        abcUserDetails.setUserType(UserType);
        abcUserDetails.setContactNo(ContactNo);
        abcUserDetails.setUsername(Username);
        abcUserDetails.setPassword(password);
        abcUser.save(abcUserDetails);
        abcShop.updateSpace("0", BusinessSpace);
        return new abcMessage("Saved Successfully");
    }

    @PostMapping("/addShop")
    public @ResponseBody abcMessage addShop(@RequestParam(value = "BusinessSpaceType")String BusinessSpaceType,@RequestParam(value = "duration")String duration,@RequestParam(value = "RentType")String RentType,@RequestParam(value = "Cost")String Cost,@RequestParam(value = "Available")String Available){
           AbcmallShopDetails abcShopdetails = new AbcmallShopDetails();
           abcShopdetails.setBusinessSpaceType(BusinessSpaceType);
           abcShopdetails.setCost(Cost);
           abcShopdetails.setduration(duration);
           abcShopdetails.setrentType(RentType);
           abcShopdetails.setavailable(Available);
           abcShop.save(abcShopdetails);
        return new abcMessage("Added BusinessSpace Successfully");
    }

    @GetMapping("/login")
    public @ResponseBody abcMessage login(@RequestParam(value = "Username")String Username,@RequestParam(value = "password")String password){
        if(abcUser.fetchUser(Username)!=null){    
            String cud = abcUser.fetchUser(Username);
            String utype = abcUser.fetchUserType(Username);
               if(cud.equals(password) && utype.equals("Business Owner")){
                return new abcMessage("Business Owner");
               }
               else if(cud.equals(password) && utype.equals("Marketing")){
                return new abcMessage("Marketing");
               }
               else{
                return new abcMessage("No");
                }
            }
        else{
            return new abcMessage("No");
            }
    }

    @GetMapping("/getUser")
    public @ResponseBody Iterable<AbcmallUserdetails> getUser(@RequestParam(value = "Username")String Username){
        return abcUser.userDetails(Username);
    }

    @GetMapping("/getAllUsers")
    public @ResponseBody Iterable<AbcmallUserdetails> getAllUser(@RequestParam(value = "UserType")String UserType){
        return abcUser.allUserDetails(UserType);
    }

    @GetMapping("/getShop")
    public @ResponseBody Iterable<AbcmallShopDetails> getShop(@RequestParam(value="BusinessSpaceType")String BusinessSpaceType){
        return abcShop.getByType(BusinessSpaceType);
    }

    @GetMapping("/getAllShops")
    public @ResponseBody Iterable<AbcmallShopDetails> getAllShops(){
        return abcShop.findAll();
    }

    @GetMapping("/nonAvail")
    public @ResponseBody abcMessage nonAvail(@RequestParam(value = "BusinessSpace")String BusinessSpace){
        String LastDate = abcUser.nextAvail(BusinessSpace);
        if(LastDate==null){
            return new abcMessage("No");
        }
        else{
        return new abcMessage(LastDate);
        }
    }

    @PostMapping("/addRevenue")
    public @ResponseBody abcMessage addRevenue(@RequestParam(value = "Bfrom")String Bfrom,@RequestParam(value = "Bto")String Bto,@RequestParam(value="revenue")String revenue){
        AbcRevenue abcrevenue = new AbcRevenue();
        abcrevenue.setBfrom(Bfrom);
        abcrevenue.setBto(Bto);
        abcrevenue.setRevenue(revenue);
        Reprevenue.save(abcrevenue);
        return new abcMessage("Added Successfully");
    }

    @GetMapping("/getRevenue")
    public @ResponseBody Iterable<AbcRevenue> getRevenue(){
        return Reprevenue.findAll();
    }

    @PostMapping("/addReq")
    public @ResponseBody abcMessage addReq(@RequestParam(value = "Comdate")String Comdate,@RequestParam(value = "ComType")String ComType,@RequestParam(value = "probDesc")String probDesc,@RequestParam(value="probUsername")String probUsername){
        abcServices req = new abcServices();
        req.setprobType(ComType);
        req.setprobdate(Comdate);
        req.setprobDesc(probDesc);
        req.setprobUsername(probUsername);
        reqService.save(req);
        return new abcMessage("Request Sent");
    }

    @GetMapping("/getReq")
    public @ResponseBody Iterable<abcServices> getReqbyD(){
        return reqService.findAll();
    }

    @PostMapping("/saveAuth")
    public @ResponseBody abcMessage saveAuth(@RequestParam(value = "authName")String authName){
        Abcauth auth = new Abcauth();
        auth.setauthName(authName);
        auth.setauthtoken("1");
        authRepo.save(auth);
        return new abcMessage("Auth Generated Successfully");
    }

    @GetMapping("/updateAuth")
    public @ResponseBody abcMessage updateAuth(@RequestParam(value = "authName")String authName,@RequestParam(value = "authToken")String authToken){
        Abcauth auth = authRepo.findById(authName).get();
        auth.setauthtoken(authToken);
        authRepo.save(auth);
        return new abcMessage("Updated Successfully");
    }

    @GetMapping("/getAuth")
    public @ResponseBody abcMessage getAuth(@RequestParam(value = "authName")String authName){
        Abcauth auth = authRepo.findById(authName).get();
        return new abcMessage(auth.getauthtoken());
    }

    @PutMapping("/updatepass")
    public @ResponseBody abcMessage updatepass(@RequestParam(value = "Username")String Username,@RequestParam(value = "newPassword")String newPassword){
        abcUser.updatepass(Username, newPassword);
        return new abcMessage("Updated Successfully");
    }

    @PutMapping("/updatebook")
    public @ResponseBody abcMessage updatebook(@RequestParam(value = "Username")String Username,@RequestParam(value = "BusinessSpace")String BusinessSpace,@RequestParam(value = "BookFrom")String BookFrom,@RequestParam(value = "BookTo")String BookTo){
        abcUser.updatebook(Username,BusinessSpace,BookFrom, BookTo);
        return new abcMessage("Updated Successfully");
    }

    @PutMapping("/updatespace")
    public @ResponseBody abcMessage updatespace(@RequestParam(value = "Available")String Available,@RequestParam(value = "BusinessSpaceType")String BusinessSpaceType){
        abcShop.updateSpace(Available, BusinessSpaceType);
        return new abcMessage("Updated");
    }

    @GetMapping("/hello")
    public @ResponseBody abcMessage hello(){
        return new abcMessage("Hii I received");
    }
}