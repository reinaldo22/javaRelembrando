package com.crud.postgres.reinaldo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import com.crud.postgres.reinaldo.enums.BannerInformationType;
import com.crud.postgres.reinaldo.model.Banner;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BannerDTO {

    private Long id;
    private String imageBanner;
    private String site;
    private MultipartFile file;
    private String title;
    private boolean active;
    private BannerInformationType purchaseInformation;
    private Timestamp createdAt;

    public BannerDTO(Banner banner) {
        this.id = banner.getId();
        this.title = banner.getTitle();
        this.site = banner.getSite();
        this.active = banner.getActive();
        this.purchaseInformation = banner.getPurchaseInformation();
        this.createdAt = banner.getCreatedAt();
    }

}
