package org.hdu.service;

import org.hdu.model.SchoolPo;
import org.hdu.model.StudentsPo;

/**
 * @author Shu shoufu. ${date} ${time}
 * ${tags}
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} ${date}
 * @modify by reason:{方法名}:{原因}
 */
public interface ITestService {
    StudentsPo getStudentInfo(Integer id);
    SchoolPo getSchoolInfo(Integer id);
}
