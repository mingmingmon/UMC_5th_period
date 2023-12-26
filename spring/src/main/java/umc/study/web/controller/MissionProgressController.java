package umc.study.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionProgressConverter;
import umc.study.domain.mapping.MissionProgress;
import umc.study.service.MissionProgressService;
import umc.study.validation.annotation.ExistMember;
import umc.study.web.dto.MissionProgressRequestDTO;
import umc.study.web.dto.MissionProgressResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/mission-progress")

public class MissionProgressController {

    private final MissionProgressService missionProgressService;

    private final MissionProgressConverter missionProgressConverter;

    @PostMapping("/{memberId}")
    public ApiResponse<MissionProgressResponseDTO> addMissionProgress(
            @RequestBody @Valid MissionProgressRequestDTO missionProgressRequestDTO,
            @RequestParam @Valid @ExistMember Long memberId){
        MissionProgress missionProgress = missionProgressService.addMissionProgress(missionProgressRequestDTO, memberId);
        return ApiResponse.onSuccess(missionProgressConverter.toDTO(missionProgress));
    }
}
