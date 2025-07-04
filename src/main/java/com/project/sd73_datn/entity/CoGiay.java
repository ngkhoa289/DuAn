package com.project.sd73_datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CoGiay")
public class CoGiay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "TenCoGiay")
    private String tenCoGiay;

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

    public String getTenCoGiay() {
        return tenCoGiay;
    }

    public void setTenCoGiay(String tenCoGiay) {
        this.tenCoGiay = tenCoGiay;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}

