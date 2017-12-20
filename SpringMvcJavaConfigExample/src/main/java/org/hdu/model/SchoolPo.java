package org.hdu.model;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author Shu shoufu. ${date} ${time}
 * ${tags}
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} ${date}
 * @modify by reason:{方法名}:{原因}
 */
public class SchoolPo implements Serializable{
    private Integer id;
    private String name;
    private String location;
    private Integer salary;

    public SchoolPo() {
    }

    public SchoolPo(Integer id, String name, String location, Integer salary) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
