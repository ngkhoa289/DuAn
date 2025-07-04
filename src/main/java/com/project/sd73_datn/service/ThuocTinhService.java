package com.project.sd73_datn.service;

import com.project.sd73_datn.entity.*;
import com.project.sd73_datn.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThuocTinhService {
    private final DanhMucRepo danhMucRepo;
    private final DotGiamGiaRepo dotGiamGiaRepo;
    private final HangRepo hangRepo;
    private final ChatLieuRepo chatLieuRepo;
    private final DeGiayRepo deGiayRepo;
    private final CoGiayRepo coGiayRepo;
    private final HinhAnhRepo hinhAnhRepo;
    private final KhoiLuongRepo khoiLuongRepo;
    private final XuatXuRepo xuatXuRepo;
    private final NSXRepo nsxRepo;
    private final MauSacRepo mauSacRepo;
    private final KichThuocRepo kichThuocRepo;

    public ThuocTinhService(DanhMucRepo danhMucRepo, DotGiamGiaRepo dotGiamGiaRepo,
                            HangRepo hangRepo, ChatLieuRepo chatLieuRepo, DeGiayRepo deGiayRepo,
                            CoGiayRepo coGiayRepo, HinhAnhRepo hinhAnhRepo,
                            KhoiLuongRepo khoiLuongRepo, XuatXuRepo xuatXuRepo,
                            NSXRepo nsxRepo,MauSacRepo mauSacRepo, KichThuocRepo kichThuocRepo) {
        this.danhMucRepo = danhMucRepo;
        this.dotGiamGiaRepo = dotGiamGiaRepo;
        this.hangRepo = hangRepo;
        this.chatLieuRepo = chatLieuRepo;
        this.deGiayRepo = deGiayRepo;
        this.coGiayRepo = coGiayRepo;
        this.hinhAnhRepo = hinhAnhRepo;
        this.khoiLuongRepo = khoiLuongRepo;
        this.xuatXuRepo = xuatXuRepo;
        this.nsxRepo = nsxRepo;
        this.mauSacRepo = mauSacRepo;
        this.kichThuocRepo = kichThuocRepo;
    }

    public List<DanhMuc> getAllDanhMuc() { return danhMucRepo.findAll(); }
    public void addDanhMuc(DanhMuc dm) { danhMucRepo.save(dm); }
    public void deleteDanhMuc(Long id) { danhMucRepo.deleteById(id); }
    public Optional<DanhMuc> getDanhMucById(Long id) { return danhMucRepo.findById(id); }

    public List<DotGiamGia> getAllDotGiamGia() { return dotGiamGiaRepo.findAll(); }
    public void addDotGiamGia(DotGiamGia dgg) { dotGiamGiaRepo.save(dgg); }
    public void deleteDotGiamGia(Long id) { dotGiamGiaRepo.deleteById(id); }
    public Optional<DotGiamGia> getDotGiamGiaById(Long id) { return dotGiamGiaRepo.findById(id); }

    public List<Hang> getAllHang() { return hangRepo.findAll(); }
    public void addHang(Hang h) { hangRepo.save(h); }
    public void deleteHang(Long id) { hangRepo.deleteById(id); }
    public Optional<Hang> getHangById(Long id) { return hangRepo.findById(id); }

    public List<ChatLieu> getAllChatLieu() { return chatLieuRepo.findAll(); }
    public void addChatLieu(ChatLieu cl) { chatLieuRepo.save(cl); }
    public void deleteChatLieu(Long id) { chatLieuRepo.deleteById(id); }
    public Optional<ChatLieu> getChatLieuById(Long id) { return chatLieuRepo.findById(id); }

    public List<DeGiay> getAllDeGiay() { return deGiayRepo.findAll(); }
    public void addDeGiay(DeGiay dg) { deGiayRepo.save(dg); }
    public void deleteDeGiay(Long id) { deGiayRepo.deleteById(id); }
    public Optional<DeGiay> getDeGiayById(Long id) { return deGiayRepo.findById(id); }

    public List<CoGiay> getAllCoGiay() { return coGiayRepo.findAll(); }
    public void addCoGiay(CoGiay cg) { coGiayRepo.save(cg); }
    public void deleteCoGiay(Long id) { coGiayRepo.deleteById(id); }
    public Optional<CoGiay> getCoGiayById(Long id) { return coGiayRepo.findById(id); }

    public List<HinhAnh> getAllHinhAnh() { return hinhAnhRepo.findAll(); }
    public void addHinhAnh(HinhAnh ha) { hinhAnhRepo.save(ha); }
    public void deleteHinhAnh(Long id) { hinhAnhRepo.deleteById(id); }
    public Optional<HinhAnh> getHinhAnhById(Long id) { return hinhAnhRepo.findById(id); }

    public List<KhoiLuong> getAllKhoiLuong() { return khoiLuongRepo.findAll(); }
    public void addKhoiLuong(KhoiLuong kl) { khoiLuongRepo.save(kl); }
    public void deleteKhoiLuong(Long id) { khoiLuongRepo.deleteById(id); }
    public Optional<KhoiLuong> getKhoiLuongById(Long id) { return khoiLuongRepo.findById(id); }

    public List<XuatXu> getAllXuatXu() { return xuatXuRepo.findAll(); }
    public void addXuatXu(XuatXu xx) { xuatXuRepo.save(xx); }
    public void deleteXuatXu(Long id) { xuatXuRepo.deleteById(id); }
    public Optional<XuatXu> getXuatXuById(Long id) { return xuatXuRepo.findById(id); }

    public List<NSX> getAllNSX() { return nsxRepo.findAll(); }
    public void addNSX(NSX nsx) { nsxRepo.save(nsx); }
    public void deleteNSX(Long id) { nsxRepo.deleteById(id); }
    public Optional<NSX> getNSXById(Long id) { return nsxRepo.findById(id); }

    // MauSac
    public List<MauSac> getAllMauSac() { return mauSacRepo.findAll(); }
    public void addMauSac(MauSac ms) { mauSacRepo.save(ms); }
    public void deleteMauSac(Long id) { mauSacRepo.deleteById(id); }
    public Optional<MauSac> getMauSacById(Long id) { return mauSacRepo.findById(id); }

    // KichThuoc
    public List<KichThuoc> getAllKichThuoc() { return kichThuocRepo.findAll(); }
    public void addKichThuoc(KichThuoc kt) { kichThuocRepo.save(kt); }
    public void deleteKichThuoc(Long id) { kichThuocRepo.deleteById(id); }
    public Optional<KichThuoc> getKichThuocById(Long id) { return kichThuocRepo.findById(id); }



}