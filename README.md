# 지하철 노선도 미션
[ATDD 강의](https://edu.nextstep.camp/c/R89PYi5H) 실습을 위한 지하철 노선도 애플리케이션

# Step1 - 즐겨찾기 기능 완성
## 기능 요구사항
### 즐겨 찾기 기능 인수 테스트 작성
- [ ] 즐겨 찾기 생성
    - [ ] 즐겨 찾기를 생성할 수 있다.
        - when: 즐겨 찾기를 생성하면
        - then: 즐겨 찾기가 생성된다.
    - [ ] 즐겨 찾기 요청 시 source와 target역 모두 존재해야 한다.
        - given: 존재하지 않는 역 id에 대해서
        - when: 즐겨 찾기를 생성하면
        - then: 즐겨 찾기 생성에 실패한다.
    - [ ] 즐겨 찾기 요청 시 source와 target역이 같으면 안된다.
        - given: source와 target이 같은 역 id에 대해서
        - when: 즐겨 찾기를 생성하면
        - then: 즐겨 찾기 생성에 실패한다.
    - [ ] 즐겨 찾기 요청 시 bearer token이 유효하지 않으면 안된다.
        - given: 유효하지 않은 bearer token에 대해서
        - when: 즐겨 찾기를 생성하면
        - then: 즐겨 찾기 생성에 실패한다.
- [ ] 즐겨 찾기 조회
    - [ ] 즐겨 찾기 조회
        - when: 즐겨 찾기를 조회하면
        - then: 즐겨 찾기가 조회된다.
    - [ ] 즐겨 찾기 조회 시 bearer token이 유효하지 않으면 안된다.
        - given: 유효하지 않은 bearer token에 대해서
        - when: 즐겨 찾기를 조회하면
        - then: 즐겨 찾기 조회에 실패한다.
    - [ ] 즐겨 찾기 조회 시 없으면 빈 어레이가 리턴된다.
        - given: 즐겨 찾기가 없을 때
        - when: 즐겨 찾기를 조회하면
        - then: 빈 어레이가 리턴된다.
- [ ] 즐겨 찾기 삭제
    - [ ] 즐겨 찾기 삭제
        - when: 즐겨 찾기를 삭제하면
        - then: 즐겨 찾기가 삭제된다.
    - [ ] 즐겨 찾기 삭제 시 bearer token이 유효하지 않으면 안된다.
        - given: 유효하지 않은 bearer token에 대해서
        - when: 즐겨 찾기를 삭제하면
        - then: 즐겨 찾기 삭제에 실패한다.
    - [ ] 즐겨 찾기 삭제 시 존재하지 않는 즐겨 찾기를 삭제하면 안된다.
        - given: 존재하지 않는 즐겨 찾기에 대해서
        - when: 즐겨 찾기를 삭제하면
        - then: 즐겨 찾기 삭제에 실패한다.
