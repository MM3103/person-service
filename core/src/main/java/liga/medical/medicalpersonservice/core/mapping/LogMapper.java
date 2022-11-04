package liga.medical.medicalpersonservice.core.mapping;

import liga.medical.medicalpersonservice.core.model.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    @Insert("INSERT INTO logs (time, username,info) VALUES (#{time}, #{username}, #{info});")
    void addLog(Log log);
}
