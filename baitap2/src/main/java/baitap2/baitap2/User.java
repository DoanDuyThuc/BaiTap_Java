package baitap2.baitap2;

import java.sql.Date;

public class User {
    private String firstName;
    private String lastName;
    private Number idSinhvien;
    private Number SoCCCD;
    private Date NgayThangNamSinh;
    
    public Date getNgayThangNamSinh() {
        return NgayThangNamSinh;
    }

    public void setNgayThangNamSinh(Date ngayThangNamSinh) {
        NgayThangNamSinh = ngayThangNamSinh;
    }

    public Number getIdSinhvien() {
        return idSinhvien;
    }

    public void setIdSinhvien(Number idSinhvien) {
        this.idSinhvien = idSinhvien;
    }

    public Number getSoCCCD() {
        return SoCCCD;
    }

    public void setSoCCCD(Number soCCCD) {
        SoCCCD = soCCCD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
