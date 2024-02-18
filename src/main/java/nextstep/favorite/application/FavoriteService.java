package nextstep.favorite.application;

import nextstep.favorite.application.dto.FavoriteRequest;
import nextstep.favorite.application.dto.FavoriteResponse;
import nextstep.favorite.domain.Favorite;
import nextstep.favorite.domain.FavoriteRepository;
import nextstep.member.application.MemberService;
import nextstep.member.application.dto.MemberResponse;
import nextstep.member.domain.LoginMember;
import nextstep.subway.domain.Station;
import nextstep.subway.domain.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    private FavoriteRepository favoriteRepository;
    private StationRepository stationRepository;
    private MemberService memberService;

    public FavoriteService(FavoriteRepository favoriteRepository, StationRepository stationRepository, MemberService memberService) {
        this.favoriteRepository = favoriteRepository;
        this.stationRepository = stationRepository;
        this.memberService = memberService;
    }

    /**
     * TODO: LoginMember 를 추가로 받아서 FavoriteRequest 내용과 함께 Favorite 를 생성합니다.
     *
     * @param request
     * @param loginMember
     */
    public void createFavorite(FavoriteRequest request, LoginMember loginMember) {
        final Station sourceStation = stationRepository.findById(request.getSource()).orElseGet(null);
        final Station targetStation = stationRepository.findById(request.getTarget()).orElseGet(null);
        final MemberResponse member = memberService.findMe(loginMember);

        final Favorite favorite = new Favorite(sourceStation, targetStation, member.getId());
        favoriteRepository.save(favorite);
    }

    /**
     * TODO: StationResponse 를 응답하는 FavoriteResponse 로 변환해야 합니다.
     *
     * @return
     */
    public List<FavoriteResponse> findFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream().map(FavoriteResponse::new).toList();
    }

    /**
     * TODO: 요구사항 설명에 맞게 수정합니다.
     * @param id
     */
    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }
}
