package org.hdu.mapper.students;

import org.apache.ibatis.annotations.Select;
import org.hdu.model.StudentsPo;
import org.mapstruct.Mapper;

/**
 * @author Shu shoufu. ${date} ${time}
 * ${tags}
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} ${date}
 * @modify by reason:{方法名}:{原因}
 */
public interface StudentsMapper {
    @Select("SELECT * FROM students WHERE id=#{id}")
    StudentsPo getStudentById(int id);
}
