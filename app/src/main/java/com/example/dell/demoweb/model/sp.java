package com.example.dell.demoweb.model;

public class sp {
    public int ID;
    public String Tensp;
    public Integer giasp;
    public String hinhanhsp;
    public String  motasp;
    public int IDsp;

    public sp(int ID, String tensp, Integer giasp, String hinhanhsp, String motasp, int IDsp) {

        this.ID = ID;
        Tensp = tensp;
        this.giasp = giasp;
        this.hinhanhsp = hinhanhsp;
        this.motasp = motasp;
        this.IDsp = IDsp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public Integer getGiasp() {
        return giasp;
    }

    public void setGiasp(Integer giasp) {
        this.giasp = giasp;
    }

    public String getHinhanhsp() {
        return hinhanhsp;
    }

    public void setHinhanhsp(String hinhanhsp) {
        this.hinhanhsp = hinhanhsp;
    }

    public String getMotasp() {
        return motasp;
    }

    public void setMotasp(String motasp) {
        this.motasp = motasp;
    }

    public int getIDsp() {
        return IDsp;
    }

    public void setIDsp(int IDsp) {
        this.IDsp = IDsp;
    }
}
