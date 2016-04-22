
package com.zs.framework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://zs.com/framework/jibx/beans" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="account">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="name" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="skill" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element name="car" minOccurs="0">
 *       &lt;!-- Reference to inner class Car -->
 *     &lt;/xs:element>
 *   &lt;/xs:sequence>
 *   &lt;xs:attribute type="xs:long" use="required" name="id"/>
 *   &lt;xs:attribute type="xs:int" use="required" name="age"/>
 *   &lt;xs:attribute type="xs:dateTime" name="birthday"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Account
{
    private String name;
    private List<String> skillList = new ArrayList<String>();
    private Car car;
    private long id;
    private int age;
    private Date birthday;

    /** 
     * Get the 'name' element value.
     * 
     * @return value
     */
    public String getName() {
        return name;
    }

    /** 
     * Set the 'name' element value.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Get the list of 'skill' element items.
     * 
     * @return list
     */
    public List<String> getSkillList() {
        return skillList;
    }

    /** 
     * Set the list of 'skill' element items.
     * 
     * @param list
     */
    public void setSkillList(List<String> list) {
        skillList = list;
    }

    /** 
     * Get the 'car' element value.
     * 
     * @return value
     */
    public Car getCar() {
        return car;
    }

    /** 
     * Set the 'car' element value.
     * 
     * @param car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /** 
     * Get the 'id' attribute value.
     * 
     * @return value
     */
    public long getId() {
        return id;
    }

    /** 
     * Set the 'id' attribute value.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /** 
     * Get the 'age' attribute value.
     * 
     * @return value
     */
    public int getAge() {
        return age;
    }

    /** 
     * Set the 'age' attribute value.
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /** 
     * Get the 'birthday' attribute value.
     * 
     * @return value
     */
    public Date getBirthday() {
        return birthday;
    }

    /** 
     * Set the 'birthday' attribute value.
     * 
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:element xmlns:ns="http://zs.com/framework/jibx/beans" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="car" minOccurs="0">
     *   &lt;xs:complexType>
     *     &lt;xs:sequence>
     *       &lt;xs:element type="xs:string" name="carname" minOccurs="0"/>
     *     &lt;/xs:sequence>
     *     &lt;xs:attribute type="xs:long" use="required" name="id"/>
     *     &lt;xs:attribute type="xs:boolean" use="required" name="isPass"/>
     *     &lt;xs:attribute type="xs:double" name="amount"/>
     *   &lt;/xs:complexType>
     * &lt;/xs:element>
     * </pre>
     */
    public static class Car
    {
        private String carname;
        private long id;
        private boolean isPass;
        private Double amount;

        /** 
         * Get the 'carname' element value.
         * 
         * @return value
         */
        public String getCarname() {
            return carname;
        }

        /** 
         * Set the 'carname' element value.
         * 
         * @param carname
         */
        public void setCarname(String carname) {
            this.carname = carname;
        }

        /** 
         * Get the 'id' attribute value.
         * 
         * @return value
         */
        public long getId() {
            return id;
        }

        /** 
         * Set the 'id' attribute value.
         * 
         * @param id
         */
        public void setId(long id) {
            this.id = id;
        }

        /** 
         * Get the 'isPass' attribute value.
         * 
         * @return value
         */
        public boolean isIsPass() {
            return isPass;
        }

        /** 
         * Set the 'isPass' attribute value.
         * 
         * @param isPass
         */
        public void setIsPass(boolean isPass) {
            this.isPass = isPass;
        }

        /** 
         * Get the 'amount' attribute value.
         * 
         * @return value
         */
        public Double getAmount() {
            return amount;
        }

        /** 
         * Set the 'amount' attribute value.
         * 
         * @param amount
         */
        public void setAmount(Double amount) {
            this.amount = amount;
        }
    }
}
