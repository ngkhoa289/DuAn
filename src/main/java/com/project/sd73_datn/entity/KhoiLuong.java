package com.project.sd73_datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "KhoiLuong")
public class KhoiLuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "TenKhoiLuong")
    private String tenKhoiLuong;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenKhoiLuong() {
        return tenKhoiLuong;
    }

    public void setTenKhoiLuong(String tenKhoiLuong) {
        this.tenKhoiLuong = tenKhoiLuong;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
