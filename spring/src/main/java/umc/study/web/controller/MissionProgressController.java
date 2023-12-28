package umc.study.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionProgressConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MissionProgress;
import umc.study.repository.MissionProgressRepository;
import umc.study.service.MissionProgressService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistMember;
import umc.study.web.dto.MissionProgressRequestDTO;
import umc.study.web.dto.MissionProgressResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.StoreResponseDTO;

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

    @GetMapping("/{memberId}")
    @Operation(summary = "특정 멤버의 진행중인 미션 목록 조회 API", description = "특정 멤버의 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<MissionProgressResponseDTO.MissionProgressListDTO> getMyChallengingMissionList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page){

        page -= 1;
        Page<MissionProgress> challengingMissionList = missionProgressService.getMyChallengingMissionList(memberId, page);

        return ApiResponse.onSuccess(missionProgressConverter.toMissionProgressListDTO(challengingMissionList));
    }
}
