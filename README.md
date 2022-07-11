## (파스타 공모전) MBTI를 활요한 스터디 매칭 서비스
* passta_end -> src -> poly 메인 코드
* passta_end -> WebContent -> WEB-INF -> view jsp코드
<hr/>

## 적용 기술

* 배포서버 : NHN Pass-TA, AWS EC2
* 개발언어 : Java, JavaScript, HTML5, CSS, Pyhton, Jquery
* 개발 툴 : Eclipse, PyCharm
* 개발환경 : Spring FrameWork, Flask
* 데이터베이스 : Mysql, redis
* API : kakao Login API
* 라이브러리 : Selenium, OpenCV
* 프로토콜 : webSocket
* 형상관리 : Git
* 스토리지 : AWS S3
<hr/>

## 기능

1. MBTI 성향분석 - 개인의 성향을 파악할 수 있는 MBTI 성격유형 검사를 제공하여 성향간의 궁합을 분석함 - 성향간의 궁합은 16가지 성격유형의 상관관계의 가중치를 두어 분석
2. 스터디모임 추천 서비스 - 생성된 스터디그룹의 팀원의 성향을 사용자의 성향과 비교 분석하여 사용자에 맞는 스터디 그룹을 추천함
3. 정보 공유서비스 - 각 스터디모임은 멀티게시판으로 구현되어 팀원들간 소통이 가능
4. WebSocket을 활용한 실시간채팅은 각그룹별로 RedisDB에 저장되며 개인적인 정보를 공유할 수 있음
5. Python Selenium라이브러리를 활용하여 웹사이트에서 크롤링한 공모전 데이터는 사용자에 맞춤형 정보를 제공함
6. 멀티 파일 업로드를 통해 스터디별 자료 공유
<hr/>

## 프로젝트 기간

2021-09-01 ~ 2022-11-01
<hr/>

#### 역할

* AWS S3 연동을 통한 스터디별 다중 파일 업로드 및 다운로드
* 회원관리 CRUD 로직 구현
* NHN Pass-ta 배포 및 Bug Fix
* 기타 프로젝트 개발 시 Bug Fix
<hr/>
