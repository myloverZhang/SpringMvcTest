package org.hdu.mapper.school;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hdu.model.SchoolPo;

/**
 * @author Shu shoufu. ${date} ${time}
 * ${tags}
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} ${date}
 * @modify by reason:{方法名}:{原因}
 */
public interface SchoolMapper {
    /**
     * 查询学校信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM school WHERE id = #{id}")
    SchoolPo getSchoolInfo(@Param("id") Integer id);
}
