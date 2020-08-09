package inc.droidstar.abcmall;

import inc.droidstar.abcmall.AbcRevenue;
import org.springframework.data.repository.CrudRepository;

public interface AbcRevenueRepository extends CrudRepository<AbcRevenue,Long>{
    @Query("SELECT Id,Bfrom,Bto,Revenue FROM AbcRevenue WHERE Bfrom>=:Bfrom AND Bto<=:Bto")
    Iterable<AbcRevenue> getRev(@Param("Bfrom")String Bfrom,@Param("Bto")String Bto);

    @Query("SELECT SUM(Revenue) FROM AbcRevenue WHERE Bfrom>=:Bfrom AND Bto<=:Bto")
    Integer totRev(@Param("Bfrom")String Bfrom,@Param("Bto")String Bto);
}
