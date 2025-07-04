package com.project.sd73_datn.controller;

import com.project.sd73_datn.entity.*;
import com.project.sd73_datn.service.ThuocTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThuocTinhController {

    @Autowired
    private ThuocTinhService thuocTinhService;

    @GetMapping("/thuoc-tinh")
    public String viewThuocTinhForm(Model model) {
        model.addAttribute("listDanhMuc", thuocTinhService.getAllDanhMuc());
        model.addAttribute("listDotGiamGia", thuocTinhService.getAllDotGiamGia());
        model.addAttribute("listHang", thuocTinhService.getAllHang());
        model.addAttribute("listChatLieu", thuocTinhService.getAllChatLieu());
        model.addAttribute("listDeGiay", thuocTinhService.getAllDeGiay());
        model.addAttribute("listCoGiay", thuocTinhService.getAllCoGiay());
        model.addAttribute("listHinhAnh", thuocTinhService.getAllHinhAnh());
        model.addAttribute("listKhoiLuong", thuocTinhService.getAllKhoiLuong());
        model.addAttribute("listXuatXu", thuocTinhService.getAllXuatXu());
        model.addAttribute("listNSX", thuocTinhService.getAllNSX());
        model.addAttribute("listMauSac", thuocTinhService.getAllMauSac());
        model.addAttribute("listKichThuoc", thuocTinhService.getAllKichThuoc());

        return "thuoc_tinh/form";
    }

    @PostMapping("/thuoc-tinh/add/danh-muc")
    public String addDanhMuc(@RequestParam("ten") String ten) {
        DanhMuc dm = new DanhMuc();
        dm.setTenDanhMuc(ten);
        thuocTinhService.addDanhMuc(dm);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/danh-muc/{id}")
    public String deleteDanhMuc(@PathVariable Long id) {
        thuocTinhService.deleteDanhMuc(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/hang")
    public String addHang(@RequestParam("ten") String ten) {
        Hang h = new Hang();
        h.setTenHang(ten);
        thuocTinhService.addHang(h);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/hang/{id}")
    public String deleteHang(@PathVariable Long id) {
        thuocTinhService.deleteHang(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/chat-lieu")
    public String addChatLieu(@RequestParam("ten") String ten) {
        ChatLieu cl = new ChatLieu();
        cl.setLoai(ten);
        thuocTinhService.addChatLieu(cl);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/chat-lieu/{id}")
    public String deleteChatLieu(@PathVariable Long id) {
        thuocTinhService.deleteChatLieu(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/de-giay")
    public String addDeGiay(@RequestParam("ten") String ten) {
        DeGiay dg = new DeGiay();
        dg.setTenDeGiay(ten);
        thuocTinhService.addDeGiay(dg);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/de-giay/{id}")
    public String deleteDeGiay(@PathVariable Long id) {
        thuocTinhService.deleteDeGiay(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/co-giay")
    public String addCoGiay(@RequestParam("ten") String ten) {
        CoGiay cg = new CoGiay();
        cg.setTenCoGiay(ten);
        thuocTinhService.addCoGiay(cg);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/co-giay/{id}")
    public String deleteCoGiay(@PathVariable Long id) {
        thuocTinhService.deleteCoGiay(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/xuat-xu")
    public String addXuatXu(@RequestParam("ten") String ten) {
        XuatXu xx = new XuatXu();
        xx.setNoiXuatXu(ten);
        thuocTinhService.addXuatXu(xx);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/xuat-xu/{id}")
    public String deleteXuatXu(@PathVariable Long id) {
        thuocTinhService.deleteXuatXu(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/khoi-luong")
    public String addKhoiLuong(@RequestParam("ten") String ten) {
        KhoiLuong kl = new KhoiLuong();
        kl.setTenKhoiLuong(ten);
        thuocTinhService.addKhoiLuong(kl);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/khoi-luong/{id}")
    public String deleteKhoiLuong(@PathVariable Long id) {
        thuocTinhService.deleteKhoiLuong(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/nsx")
    public String addNSX(@RequestParam("ten") String ten) {
        NSX nsx = new NSX();
        nsx.setTenNSX(ten);
        thuocTinhService.addNSX(nsx);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/nsx/{id}")
    public String deleteNSX(@PathVariable Long id) {
        thuocTinhService.deleteNSX(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/hinh-anh")
    public String addHinhAnh(@RequestParam("ten") String ten) {
        HinhAnh ha = new HinhAnh();
        ha.setTenAnh(ten);
        thuocTinhService.addHinhAnh(ha);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/hinh-anh/{id}")
    public String deleteHinhAnh(@PathVariable Long id) {
        thuocTinhService.deleteHinhAnh(id);
        return "redirect:/thuoc-tinh";
    }

    @PostMapping("/thuoc-tinh/add/dot-giam-gia")
    public String addDotGiamGia(@RequestParam("ten") String ten, @RequestParam("phanTram") Float phanTram) {
        DotGiamGia dgg = new DotGiamGia();
        dgg.setTenDot(ten);
        dgg.setPhanTramGiamGia(phanTram);
        dgg.setThoiGianBatDau(java.time.LocalDateTime.now());
        dgg.setThoiGianKetThuc(java.time.LocalDateTime.now().plusDays(30));
        thuocTinhService.addDotGiamGia(dgg);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/dot-giam-gia/{id}")
    public String deleteDotGiamGia(@PathVariable Long id) {
        thuocTinhService.deleteDotGiamGia(id);
        return "redirect:/thuoc-tinh";
    }
    @PostMapping("/thuoc-tinh/add/mau-sac")
    public String addMauSac(@RequestParam("ten") String ten) {
        MauSac ms = new MauSac();
        ms.setTenMau(ten);
        thuocTinhService.addMauSac(ms);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/mau-sac/{id}")
    public String deleteMauSac(@PathVariable Long id) {
        thuocTinhService.deleteMauSac(id);
        return "redirect:/thuoc-tinh";
    }
    @PostMapping("/thuoc-tinh/add/kich-thuoc")
    public String addKichThuoc(@RequestParam("size") Integer size) {
        KichThuoc kt = new KichThuoc();
        kt.setSize(size);
        thuocTinhService.addKichThuoc(kt);
        return "redirect:/thuoc-tinh";
    }

    @GetMapping("/thuoc-tinh/delete/kich-thuoc/{id}")
    public String deleteKichThuoc(@PathVariable Long id) {
        thuocTinhService.deleteKichThuoc(id);
        return "redirect:/thuoc-tinh";
    }


}
