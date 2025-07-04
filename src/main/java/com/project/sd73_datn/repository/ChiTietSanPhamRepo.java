package com.project.sd73_datn.repository;

import com.project.sd73_datn.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham, Long> {
    List<ChiTietSanPham> findBySanPhamId(Long idSanPham);
}
