package com.project.sd73_datn.controller;

import com.project.sd73_datn.entity.ChiTietSanPham;
import com.project.sd73_datn.entity.SanPham;
import com.project.sd73_datn.service.ChiTietSanPhamService;
import com.project.sd73_datn.service.SanPhamService;
import com.project.sd73_datn.service.ThuocTinhService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String save(@ModelAttribute ChiTietSanPham chiTietSanPham, 
                      RedirectAttributes redirectAttributes) {
        try {
            // Validate required fields
            if (chiTietSanPham.getSanPham() == null || chiTietSanPham.getSanPham().getId() == null) {
                redirectAttributes.addFlashAttribute("error", "Sản phẩm không được để trống");
                return "redirect:/san-pham";
            }

            if (chiTietSanPham.getMauSac() == null || chiTietSanPham.getMauSac().getId() == null) {
                redirectAttributes.addFlashAttribute("error", "Màu sắc không được để trống");
                return "redirect:/chi-tiet-san-pham/" + chiTietSanPham.getSanPham().getId();
            }

            if (chiTietSanPham.getKichThuoc() == null || chiTietSanPham.getKichThuoc().getId() == null) {
                redirectAttributes.addFlashAttribute("error", "Kích thước không được để trống");
                return "redirect:/chi-tiet-san-pham/" + chiTietSanPham.getSanPham().getId();
            }

            // Auto-generate MaCTSP if not provided
            if (chiTietSanPham.getMaCTSP() == null || chiTietSanPham.getMaCTSP().trim().isEmpty()) {
                String maCTSP = "CTSP" + String.format("%06d", System.currentTimeMillis() % 1000000);
                chiTietSanPham.setMaCTSP(maCTSP);
            }
            
            // Auto-generate TenCTSP if not provided
            if (chiTietSanPham.getTenCTSP() == null || chiTietSanPham.getTenCTSP().trim().isEmpty()) {
                SanPham sp = sanPhamService.getById(chiTietSanPham.getSanPham().getId());
                String tenSP = sp.getTenSanPham();
                String mauSac = thuocTinhService.getMauSacById(chiTietSanPham.getMauSac().getId())
                    .map(ms -> ms.getTenMau()).orElse("Unknown");
                String kichThuoc = thuocTinhService.getKichThuocById(chiTietSanPham.getKichThuoc().getId())
                    .map(kt -> kt.getSize().toString()).orElse("Unknown");
                chiTietSanPham.setTenCTSP(tenSP + " - " + mauSac + " - " + kichThuoc);
            }
            
            // Set default status if not provided
            if (chiTietSanPham.getTrangThai() == null) {
                chiTietSanPham.setTrangThai(1);
            }
            
            ctspService.save(chiTietSanPham);
            redirectAttributes.addFlashAttribute("success", "Thêm biến thể thành công!");
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        }
        
        return "redirect:/chi-tiet-san-pham/" + chiTietSanPham.getSanPham().getId();
    }

    @GetMapping("/{id}")
    public String viewChiTietSanPhamTheoSP(@PathVariable Long id, Model model) {
        try {
            SanPham sp = sanPhamService.getById(id);
            if (sp == null) {
                model.addAttribute("error", "Không tìm thấy sản phẩm");
                return "redirect:/san-pham";
            }

            List<ChiTietSanPham> chiTietList = ctspService.findBySanPhamId(id);

            model.addAttribute("sanPham", sp);
            model.addAttribute("listChiTiet", chiTietList);
            model.addAttribute("chiTietSanPham", new ChiTietSanPham());

            // Dữ liệu cho form tạo mới
            model.addAttribute("listMauSac", thuocTinhService.getAllMauSac());
            model.addAttribute("listKichThuoc", thuocTinhService.getAllKichThuoc());

            // Gửi thêm các thuộc tính phụ vào view
            model.addAttribute("thuongHieu", sp.getHang() != null ? sp.getHang().getTenHang() : "Chưa có");
            model.addAttribute("danhMuc", sp.getDanhMuc() != null ? sp.getDanhMuc().getTenDanhMuc() : "Chưa có");
            model.addAttribute("chatLieu", sp.getChatLieu() != null ? sp.getChatLieu().getLoai() : "Chưa có");
            model.addAttribute("deGiay", sp.getDeGiay() != null ? sp.getDeGiay().getTenDeGiay() : "Chưa có");
            model.addAttribute("coGiay", sp.getCoGiay() != null ? sp.getCoGiay().getTenCoGiay() : "Chưa có");
            model.addAttribute("khoiLuong", sp.getKhoiLuong() != null ? sp.getKhoiLuong().getTenKhoiLuong() : "Chưa có");
            model.addAttribute("xuatXu", sp.getXuatXu() != null ? sp.getXuatXu().getNoiXuatXu() : "Chưa có");
            model.addAttribute("nsx", sp.getNsx() != null ? sp.getNsx().getTenNSX() : "Chưa có");
            model.addAttribute("dotGiamGia", sp.getDotGiamGia() != null ? sp.getDotGiamGia().getTenDot() : "Chưa có");

            return "chi_tiet_san_pham/view";
            
        } catch (Exception e) {
            model.addAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
            return "redirect:/san-pham";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            ChiTietSanPham ctsp = ctspService.getById(id);
            if (ctsp == null) {
                redirectAttributes.addFlashAttribute("error", "Không tìm thấy biến thể sản phẩm");
                return "redirect:/san-pham";
            }
            
            Long sanPhamId = ctsp.getSanPham().getId();
            ctspService.delete(id);
            redirectAttributes.addFlashAttribute("success", "Xóa biến thể thành công!");
            return "redirect:/chi-tiet-san-pham/" + sanPhamId;
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra khi xóa: " + e.getMessage());
            return "redirect:/san-pham";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            ChiTietSanPham ctsp = ctspService.getById(id);
            if (ctsp == null) {
                model.addAttribute("error", "Không tìm thấy biến thể sản phẩm");
                return "redirect:/san-pham";
            }

            model.addAttribute("chiTietSanPham", ctsp);
            model.addAttribute("listMauSac", thuocTinhService.getAllMauSac());
            model.addAttribute("listKichThuoc", thuocTinhService.getAllKichThuoc());
            model.addAttribute("formTitle", "Cập nhật biến thể sản phẩm");

            return "chi_tiet_san_pham/form";
            
        } catch (Exception e) {
            model.addAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
            return "redirect:/san-pham";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ChiTietSanPham chiTietSanPham, 
                        RedirectAttributes redirectAttributes) {
        try {
            ctspService.save(chiTietSanPham);
            redirectAttributes.addFlashAttribute("success", "Cập nhật biến thể thành công!");
            return "redirect:/chi-tiet-san-pham/" + chiTietSanPham.getSanPham().getId();
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
            return "redirect:/chi-tiet-san-pham/" + chiTietSanPham.getSanPham().getId();
        }
    }
}