package umc.study.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.StoreService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    private final StoreConverter storeConverter;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO> addStore(
            @RequestBody @Valid StoreRequestDTO storeRequestDTO){
        Store store = storeService.addStore(storeRequestDTO);
        return ApiResponse.onSuccess(storeConverter.toDTO(store));
    }
}
