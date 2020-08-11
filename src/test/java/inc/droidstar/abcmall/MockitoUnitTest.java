package inc.droidstar.abcmall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MockitoUnitTest {

    @InjectMocks
    AbcmallController abcCont;

    @Mock
    private AbcmallUserRepository UserRepository;

    @Autowired
    private AbcmallUserRepository userRepo;

    @Autowired
    private AbcmallShopRepository abcShop;

    @Autowired
    private AbcRevenueRepository Reprevenue;

    @Autowired
    private AbcServiceRepo reqService;

    @Autowired
    private AbcauthRepository authRepo;

    @Test
    public void UserDbTest(){
        AbcmallUserdetails User = new AbcmallUserdetails();
        User.setAddress("NA");
        User.setUsername("Droidstar");
        User.setPassword("123");
        User.setBookFrom("NA");
        User.setBookTo("NA");
        User.setUserType("Business Owner");
        User.setBusinessSpace("NA");
        User.setemail("paras.24@gmail.com");
        User.setFirstName("Paras");
        User.setLastName("Jain");
        User.setpinCode("250002");
        User.setContactNo("8171733710");
        userRepo.save(User);
        String user = userRepo.fetchUserType("Droidstar");
        assertEquals("Business Owner", user);
    }

    @Test
    public void ShopDbTest(){
        AbcmallShopDetails abcShopdetails = new AbcmallShopDetails();
           abcShopdetails.setBusinessSpaceType("BusinessSpaceType");
           abcShopdetails.setCost("2500");
           abcShopdetails.setduration("duration");
           abcShopdetails.setrentType("RentType");
           abcShopdetails.setavailable("1");
           abcShop.save(abcShopdetails);
           Iterable<AbcmallShopDetails> shops =  abcShop.getByType("BusinessSpaceType");
           assertNotNull(shops);
    }

    @Test
    public void RevDbTest(){
        AbcRevenue abcrevenue = new AbcRevenue();
        abcrevenue.setBfrom("2020-08-10T18:30:00.000Z");
        abcrevenue.setBto("2020-08-12T18:30:00.000Z");
        abcrevenue.setRevenue(20);
        Reprevenue.save(abcrevenue);
        Iterable<AbcRevenue> rev = Reprevenue.getRev("2020-08-10T18:30:00.000Z", "2020-08-12T18:30:00.000Z");
        assertNotNull(rev);
    }

    @Test
    public void SerDbTest(){
        abcServices req = new abcServices();
        req.setprobType("ComType");
        req.setprobdate("2020-08-10T18:30:00.000Z");
        req.setprobDesc("probDesc");
        req.setprobUsername("probUsername");
        reqService.save(req);
        Iterable<abcServices> services = reqService.findAll();
        assertNotNull(services);
    }

    @Test
    public void AuthDbTest(){
        Abcauth auth = new Abcauth();
        auth.setauthName("authName");
        auth.setauthtoken("1");
        authRepo.save(auth);
        assertNotNull(authRepo.findById("authName").get());
    }

    @Test
    public void postTest(){
        abcMessage msg = abcCont.updatepass("Droidstar", "123");
        assertEquals("Updated Successfully", msg.getMessage());
    }


    
}