package com.theblockph.patientinformationsystem;

public class Table_Patient {

    private String fname, mname, lname;
    private String gender, marital, address;
    private String religion, occupation;
    private Integer age;
    private Long cellphone, telephone;
    private String email;

    private String kin_fname, kin_mname, kin_lname;
    private Long k_cellphone, k_telephone;


    public Table_Patient() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKin_fname() {
        return kin_fname;
    }

    public void setKin_fname(String kin_fname) {
        this.kin_fname = kin_fname;
    }

    public String getKin_mname() {
        return kin_mname;
    }

    public void setKin_mname(String kin_mname) {
        this.kin_mname = kin_mname;
    }

    public String getKin_lname() {
        return kin_lname;
    }

    public void setKin_lname(String kin_lname) {
        this.kin_lname = kin_lname;
    }

    public Long getK_cellphone() {
        return k_cellphone;
    }

    public void setK_cellphone(Long k_cellphone) {
        this.k_cellphone = k_cellphone;
    }

    public Long getK_telephone() {
        return k_telephone;
    }

    public void setK_telephone(Long k_telephone) {
        this.k_telephone = k_telephone;
    }
}
