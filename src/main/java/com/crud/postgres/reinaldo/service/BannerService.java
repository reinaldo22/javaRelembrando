package com.crud.postgres.reinaldo.service;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.crud.postgres.reinaldo.dto.BannerDTO;
import com.crud.postgres.reinaldo.model.Banner;
import com.crud.postgres.reinaldo.repository.BannerRepository;

@Service
public class BannerService {

    @Autowired
    BannerRepository bannerRepository;


     public Banner createBannerService(BannerDTO  bannerDTO){
        Banner newSave = new Banner();
        
        newSave.setSite(bannerDTO.getSite());
        newSave.setTitle(bannerDTO.getTitle());
        newSave.setPurchaseInformation(bannerDTO.getPurchaseInformation());
        newSave.setImageBanner(saveImageAndGetPath(bannerDTO.getFile()));
        Banner  savedBanner = this.bannerRepository.save(newSave);
        
        return savedBanner;
        
    }

    private String saveImageAndGetPath(MultipartFile imageFile) {
    
    return  "C:" + File.separator + "Users" + File.separator + "varga" + File.separator +
    "OneDrive" + File.separator + "Imagens" + File.separator + "Capturas de tela" +
    File.separator + imageFile.getOriginalFilename();
}
}
