package liga.medical.medicalpersonservice.core.mapping;

import liga.medical.medicalpersonservice.core.model.MedicalCard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalCardMapper {

    @Select("SELECT id, client_status as clientStatus, med_status as medStatus, registry_dt as registryDt, comment FROM medical_card;")
    List<MedicalCard> getAllMedicalCards();

    @Select("SELECT id, client_status as clientStatus, med_status as medStatus, registry_dt as registryDt, comment FROM medical_card WHERE id = #{id};")
    MedicalCard getMedicalCardById(@Param("id") long id);

    @Insert("INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (#{id}, #{clientStatus}, #{medStatus}, #{registryDt}, #{comment});")
    void addMedicalCard(MedicalCard medicalCard);
}
