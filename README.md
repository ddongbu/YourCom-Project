# YourCom
# 2023 1분기 PC 부품 견적 호환성 검사 + 쇼핑몰 개발 구현하기 !

개발 기간: 2023.03.02 ~ 2020.06.14 (약 12주)

참여 인원: 1명

## 사용 기술

 <img alt="C" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/Mysql-E6B91E?style=for-the-badge&logo=MySql&logoColor=white"/></a>
 <img alt="C" src ="https://img.shields.io/badge/JavaScript-F7DF1E.svg?&style=for-the-badge&logo=JAVASCRIPT&logoColor=white"/>
<img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Javat&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Springsecurity-6DB33F?style=for-the-badge&logo=Springsecurity&logoColor=white">

## 담당 구현 파트

프로젝트 개발환경 구축, 설계 참여

메인 페이지 구현

Header 메인 메뉴 디자인 및 구성(검색)

GitHub 레포지토리 전체 관리

스프링시큐리티 , oAuth2.0을 이용한 소셜로그인 (구글 , 네이버 , 카카오)




## 작성코드

## 구현한 코드

_프로젝트중 글쓴이가 작성한 코드_
  
## 작성코드
### 로그인
```
<form action="/loginProc" method="post" >
    <div id="header" style="text-align : center">
        <a href="/" target="_blank" title="메인 페이지로 돌아가기" style="text-decoration: none" ><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4wQe6oRdWzwrkzHcOqmfeLpG7kGdcRuWWPDS8rxFjQGbdx8xQlmgtvwxPktn4H9gucdU&usqp=CAU" id="logo"></a>
    </div>
    <div>
        <label for="textEmail">이메일</label>
        <input type="email" id="textEmail" name="memberEmail" placeholder="이메일을 선택하세요." required>
        <span>@</span>
        <select id="select">
            <option value="" disabled selected>E-Mail 선택</option>
            <option value="naver.com" id="naver.com">naver.com</option>
            <option value="hanmail.net" id="hanmail.net">hanmail.net</option>
            <option value="gmail.com" id="gmail.com">gmail.com</option>
            <option value="nate.com" id="nate.com">nate.com</option>
            <option value="directly" id="text">직접 입력하기</option>
        </select>
    </div>
    <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="memberPassword" placeholder="특수문자+영문자 포함">
        <div th:if="${errorMessage}" class="alert alert-danger" role="alert">
            <span th:text="${errorMessage}"></span>
        </div>
    <button type="submit">로그인 하기</button>
        <br>

    </div>
    </form>
    
form으로 데이터를 보내면     
Entity ->

public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getID());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setRole(memberDTO.getRole());
        return memberEntity;
    }
 Interface ->
 public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByMemberEmail(String memberEmail);

}
service-> 
ex: 회원가입
 public void save(MemberDTO memberDTO) {
        //1.dto-> entity 변환
        //2. repository의 join 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        String encodedPassword = passwordEncoder.encode(memberEntity.getMemberPassword());
        memberEntity.setMemberPassword(encodedPassword);
        memberRepository.save(memberEntity);
        //JPA에서 주는 SAVE메서드 무조건
    }
 login -> 
 public MemberDTO login(MemberDTO memberDto) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDto.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // there are query results
            MemberEntity memberEntity = byMemberEmail.get();
            if (passwordEncoder.matches(memberDto.getMemberPassword(), memberEntity.getMemberPassword())) {
                // 비밀번호 동일시
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 틀림
                return null;
            }
        } else {
            // 결과 널값;
            return null;
        }
    }

```
### DB설정
```


```

### 최신글구현

```

```
### 비밀번호확인
```

```
### 추가작업
```

```
## 사용한 언어

 
.
