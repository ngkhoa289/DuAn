package com.project.sd73_datn.service;

import com.project.sd73_datn.entity.ChiTietSanPham;
import com.project.sd73_datn.repository.ChiTietSanPhamRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSanPhamService {
    private final ChiTietSanPhamRepo repo;

    public ChiTietSanPhamService(ChiTietSanPhamRepo repo) {
        this.repo = repo;
    }

    public List<ChiTietSanPham> findBySanPhamId(Long idSanPham) {
        return repo.findBySanPhamId(idSanPham);
    }

    public void save(ChiTietSanPham ctsp) {
        repo.save(ctsp);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
