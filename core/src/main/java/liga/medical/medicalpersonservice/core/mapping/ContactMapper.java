package liga.medical.medicalpersonservice.core.mapping;

import liga.medical.medicalpersonservice.core.model.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContactMapper {

    @Select("SELECT id, phone_number as phoneNumber, email, profile_link as profileLink FROM contact;")
    List<Contact> getAllContacts();

    @Select("SELECT id, phone_number as phoneNumber, email, profile_link as profileLink FROM contact WHERE id = #{id};")
    Contact getContactById(@Param("id") long id);

    @Insert("INSERT INTO contact (id, phone_number, email, profile_link) VALUES (#{id}, #{phoneNumber}, #{email}, #{profileLink});")
    void addContact(Contact contact);

}
