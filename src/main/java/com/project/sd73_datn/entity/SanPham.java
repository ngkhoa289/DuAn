

package com.project.sd73_datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaSP", nullable = false)
    private String maSP;

    @Column(name = "TenSanPham", nullable = false)
    private String tenSanPham;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "urlHinhAnh")
    private String urlHinhAnh;

    @Column(name = "SoLuongNguoiXem")
    private Integer soLuongNguoiXem;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    // Liên kết với các bảng thuộc tính

    @ManyToOne
    @JoinColumn(name = "IdDanhMuc")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "IdDGG")
    private DotGiamGia dotGiamGia;

    @ManyToOne
    @JoinColumn(name = "IdHang")
    private Hang hang;

    @ManyToOne
    @JoinColumn(name = "IdChatLieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "IdDeGiay")
    private DeGiay deGiay;

    @ManyToOne
    @JoinColumn(name = "IdCoGiay")
    private CoGiay coGiay;

    @ManyToOne
    @JoinColumn(name = "IdHinhAnh")
    private HinhAnh hinhAnh;

    @ManyToOne
    @JoinColumn(name = "IdKhoiLuong")
    private KhoiLuong khoiLuong;

    @ManyToOne
    @JoinColumn(name = "IdXuatXu")
    private XuatXu xuatXu;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NSX nsx;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getUrlHinhAnh() {
        return urlHinhAnh;
    }

    public void setUrlHinhAnh(String urlHinhAnh) {
        this.urlHinhAnh = urlHinhAnh;
    }

    public Integer getSoLuongNguoiXem() {
        return soLuongNguoiXem;
    }

    public void setSoLuongNguoiXem(Integer soLuongNguoiXem) {
        this.soLuongNguoiXem = soLuongNguoiXem;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public DotGiamGia getDotGiamGia() {
        return dotGiamGia;
    }

    public void setDotGiamGia(DotGiamGia dotGiamGia) {
        this.dotGiamGia = dotGiamGia;
    }

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public DeGiay getDeGiay() {
        return deGiay;
    }

    public void setDeGiay(DeGiay deGiay) {
        this.deGiay = deGiay;
    }

    public CoGiay getCoGiay() {
        return coGiay;
    }

    public void setCoGiay(CoGiay coGiay) {
        this.coGiay = coGiay;
    }

    public HinhAnh getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(HinhAnh hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public KhoiLuong getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(KhoiLuong khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    // Không cần thêm danh sách chi tiết sản phẩm nếu không dùng DTO/relationship 2 chiều
}

