package com.project.sd73_datn.controller;

import com.project.sd73_datn.entity.SanPham;
import com.project.sd73_datn.service.SanPhamService;
import com.project.sd73_datn.service.ThuocTinhService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

    private final SanPhamService sanPhamService;
    private final ThuocTinhService thuocTinhService;


    public SanPhamController(SanPhamService sanPhamService, ThuocTinhService thuocTinhService) {
        this.sanPhamService = sanPhamService;
        this.thuocTinhService = thuocTinhService;
    }

    @GetMapping
    public String viewAll(
            @RequestParam(required = false) String ten,
            @RequestParam(required = false) Long hang,
            @RequestParam(required = false) Long danhMuc,
            @RequestParam(required = false) Integer trangThai,
            Model model
    ) {
        List<SanPham> filteredList = sanPhamService.filter(ten, hang, danhMuc, trangThai);
        model.addAttribute("listSanPham", filteredList);

        // Dữ liệu cho dropdown lọc
        model.addAttribute("listHang", thuocTinhService.getAllHang());
        model.addAttribute("listDanhMuc", thuocTinhService.getAllDanhMuc());

        return "sanpham/index"; // sử dụng đúng tên giao diện bạn đang dùng
    }



    @GetMapping("/form")
public String showForm(Model model) {
    model.addAttribute("sanPham", new SanPham());
    model.addAttribute("formTitle", "Thêm sản phẩm");
    loadThuocTinh(model);
    return "sanpham/form";
}

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        SanPham sp = sanPhamService.getById(id);
        model.addAttribute("sanPham", sp);
        model.addAttribute("formTitle", "Cập nhật sản phẩm");
        loadThuocTinh(model);
        return "sanpham/form";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("sanPham") SanPham sanPham) {
        sanPhamService.add(sanPham); // nếu có ID thì sẽ update, không thì add
        return "redirect:/san-pham";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        sanPhamService.delete(id);
        return "redirect:/san-pham";
    }
    private void loadThuocTinh(Model model) {
        model.addAttribute("listDanhMuc", thuocTinhService.getAllDanhMuc());
        model.addAttribute("listHang", thuocTinhService.getAllHang());
        model.addAttribute("listChatLieu", thuocTinhService.getAllChatLieu());
        model.addAttribute("listDeGiay", thuocTinhService.getAllDeGiay());
        model.addAttribute("listCoGiay", thuocTinhService.getAllCoGiay());
        model.addAttribute("listHinhAnh", thuocTinhService.getAllHinhAnh());
        model.addAttribute("listKhoiLuong", thuocTinhService.getAllKhoiLuong());
        model.addAttribute("listXuatXu", thuocTinhService.getAllXuatXu());
        model.addAttribute("listNSX", thuocTinhService.getAllNSX());
        model.addAttribute("listDotGiamGia", thuocTinhService.getAllDotGiamGia());

    }

    @GetMapping("/chi-tiet-san-pham/{id}")
    public String viewChiTietSanPhamTheoSP(@PathVariable Long id, Model model) {
        SanPham sp = sanPhamService.getById(id);
        model.addAttribute("sanPham", sp);
        loadThuocTinh(model); // load các dropdown danh mục, hãng...
        return "sanpham/view"; // file view đã sửa
    }
    @PostMapping("/update")
    public String updateSanPham(@ModelAttribute("sanPham") SanPham sanPham) {
        sanPhamService.update(sanPham); // dùng update thay vì add
        return "redirect:/san-pham"; // hoặc quay về trang chi tiết nếu muốn
    }



}
