package com.project.sd73_datn.service;

import com.project.sd73_datn.entity.ChiTietSanPham;
import com.project.sd73_datn.repository.ChiTietSanPhamRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChiTietSanPhamService {
    private final ChiTietSanPhamRepo repo;

    public ChiTietSanPhamService(ChiTietSanPhamRepo repo) {
        this.repo = repo;
    }

    public List<ChiTietSanPham> findBySanPhamId(Long idSanPham) {
        return repo.findBySanPhamId(idSanPham);
    }

    public ChiTietSanPham save(ChiTietSanPham ctsp) {
        return repo.save(ctsp);
    }

    public void delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Không tìm thấy chi tiết sản phẩm với ID: " + id);
        }
    }

    public ChiTietSanPham getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<ChiTietSanPham> getAll() {
        return repo.findAll();
    }

    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    public long count() {
        return repo.count();
    }

    public List<ChiTietSanPham> findByMauSacId(Long mauSacId) {
        return repo.findAll().stream()
                .filter(ctsp -> ctsp.getMauSac() != null && ctsp.getMauSac().getId().equals(mauSacId))
                .toList();
    }

    public List<ChiTietSanPham> findByKichThuocId(Long kichThuocId) {
        return repo.findAll().stream()
                .filter(ctsp -> ctsp.getKichThuoc() != null && ctsp.getKichThuoc().getId().equals(kichThuocId))
                .toList();
    }
}