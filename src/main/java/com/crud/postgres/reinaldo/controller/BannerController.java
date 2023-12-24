package com.crud.postgres.reinaldo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.crud.postgres.reinaldo.dto.BannerDTO;
import com.crud.postgres.reinaldo.model.Banner;
import com.crud.postgres.reinaldo.service.BannerService;

import java.io.IOException;

@RestController()
@RequestMapping("/banner")
@RequiredArgsConstructor
public class BannerController {

    @Autowired
    BannerService bannerService;

    @PostMapping
    public ResponseEntity<Banner> createBanner(BannerDTO dto) throws IOException{

        return new ResponseEntity<>(bannerService.createBannerService(dto), HttpStatus.OK);
    }

    // @GetMapping
    // public ResponseEntity<Page<BannerDTO>> banners(
    //         @RequestParam(value = "page", required = false, defaultValue = "0") int page,
    //         @RequestParam(value = "size", required = false, defaultValue = "10") int size,
    //         @RequestParam(value = "search", required = false) String search
    //        ) {
    //     var pageRequest = PageRequest.of(page, size);
    //     return new ResponseEntity<>(bannerService.allBanners(pageRequest, search), HttpStatus.OK);
    // }

    // @PutMapping("/{id}/change_status")
    // public ResponseEntity<Boolean> changeStatus(@PathVariable Long id) {
    //     return new ResponseEntity<>(this.bannerService.updateStatus(id), HttpStatus.OK);
    // }

    // @GetMapping("/actual")
    // public ResponseEntity<Boolean> activeActual(@PathVariable Long id) {
    //     return new ResponseEntity<>(this.bannerService.updateStatus(id), HttpStatus.OK);
    // }
}
