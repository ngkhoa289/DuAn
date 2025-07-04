package com.project.sd73_datn.controller;

import com.project.sd73_datn.entity.ChiTietSanPham;
import com.project.sd73_datn.entity.SanPham;
import com.project.sd73_datn.service.ChiTietSanPhamService;
import com.project.sd73_datn.service.SanPhamService;
import com.project.sd73_datn.service.ThuocTinhService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamController {

    private final ChiTietSanPhamService ctspService;
    private final SanPhamService sanPhamService;
    private final ThuocTinhService thuocTinhService;


    public ChiTietSanPhamController(ChiTietSanPhamService ctspService,
                                    SanPhamService sanPhamService,
                                    ThuocTinhService thuocTinhService) {
        this.ctspService = ctspService;
        this.sanPhamService = sanPhamService;
        this.thuocTinhService = thuocTinhService;
    }


    @PostMapping("/save")
    public String save(@ModelAttribute ChiTietSanPham chiTietSanPham) {
        ctspService.save(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/" + chiTietSanPham.getSanPham().getId();
    }
    @GetMapping("/{id}")
    public String viewChiTietSanPhamTheoSP(@PathVariable Long id, Model model) {
        SanPham sp = sanPhamService.getById(id);
        List<ChiTietSanPham> chiTietList = ctspService.findBySanPhamId(id);

        model.addAttribute("sanPham", sp);
        model.addAttribute("listChiTiet", chiTietList);
        model.addAttribute("chiTietSanPham", new ChiTietSanPham());

        // Dữ liệu cho form tạo mới
        model.addAttribute("listMauSac", thuocTinhService.getAllMauSac());
        model.addAttribute("listKichThuoc", thuocTinhService.getAllKichThuoc());

        // Gửi thêm các thuộc tính phụ vào view
        model.addAttribute("thuongHieu", sp.getHang() != null ? sp.getHang().getTenHang() : "");
        model.addAttribute("danhMuc", sp.getDanhMuc() != null ? sp.getDanhMuc().getTenDanhMuc() : "");
        model.addAttribute("chatLieu", sp.getChatLieu() != null ? sp.getChatLieu().getLoai() : "");
        model.addAttribute("deGiay", sp.getDeGiay() != null ? sp.getDeGiay().getTenDeGiay() : "");
        model.addAttribute("coGiay", sp.getCoGiay() != null ? sp.getCoGiay().getTenCoGiay() : "");
        model.addAttribute("khoiLuong", sp.getKhoiLuong() != null ? sp.getKhoiLuong().getTenKhoiLuong() : "");
        model.addAttribute("xuatXu", sp.getXuatXu() != null ? sp.getXuatXu().getNoiXuatXu() : "");
        model.addAttribute("nsx", sp.getNsx() != null ? sp.getNsx().getTenNSX() : "");
        model.addAttribute("dotGiamGia", sp.getDotGiamGia() != null ? sp.getDotGiamGia().getTenDot() : "");


        return "chi_tiet_san_pham/view"; // Tạo file mới: view.html
    }


}