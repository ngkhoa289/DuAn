package com.project.sd73_datn.service;

import com.project.sd73_datn.entity.SanPham;
import com.project.sd73_datn.repository.SanPhamRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SanPhamService {

    private final SanPhamRepo sanPhamRepo;

    public SanPhamService(SanPhamRepo sanPhamRepo) {
        this.sanPhamRepo = sanPhamRepo;
    }

    public List<SanPham> getAll() {
        return sanPhamRepo.findAll();
    }

    public SanPham getById(Long id) {
        return sanPhamRepo.findById(id).orElse(null);
    }

    public void add(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
    }

    public void update(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
    }

    public void delete(Long id) {
        sanPhamRepo.deleteById(id);
    }

    public List<SanPham> filter(String ten, Long hangId, Long danhMucId, Integer trangThai) {
        List<SanPham> all = sanPhamRepo.findAll();

        return all.stream()
                .filter(sp -> ten == null || sp.getTenSanPham().toLowerCase().contains(ten.toLowerCase()))
                .filter(sp -> hangId == null || (sp.getHang() != null && sp.getHang().getId().equals(hangId)))
                .filter(sp -> danhMucId == null || (sp.getDanhMuc() != null && sp.getDanhMuc().getId().equals(danhMucId)))
                .filter(sp -> trangThai == null || Objects.equals(sp.getTrangThai(), trangThai))
                .collect(Collectors.toList());
    }


}
