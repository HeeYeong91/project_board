# :computer: 다중게시판 Board
<br />

## :page_facing_up: 목차
1. 프로젝트 소개
2. 프로젝트 기능
   * [1. 회원가입](#1-회원가입)
   * [2. 게시글 작성](#2-게시글-작성)
   * [3. 게시글 수정](#3-게시글-수정)
   * [4. 게시글 삭제](#4-게시글-삭제)
   * [5. 답글 작성](#5-답글-작성)
   * [6. 게시글 클릭 시 조회 수 증가](#6-게시글-클릭-시-조회-수-증가)
   * [7. 게시글 검색](#7-게시글-검색)
<br />

## :eyes: 1. 프로젝트 소개
계층형 다중 게시판 웹 페이지 <br />
화면구현은 제공받은 템플릿 수정 없이 진행했고, 게시판 기능 구현에만 집중해서 프로젝트를 진행했다. (화면은 Bootstrap을 주로 이용해서 제작된 템플릿) <br />
<br /><br />

회원 및 게시판 정보를 DB에서 저장 및 관리 <br />
src / main /  resources / 다중게시판.sql 파일로 SQLDeveloper에서 테이블 생성, 제약조건 추가, 더미데이터 추가 가능 <br />
src / main /  resources / application.properties에서 username에 SQLDeveloper 사용자 이름, password에 SQLDeveloper 비밀번호 입력 <br />
![설정파일](https://github.com/HeeYeong91/project_board/assets/139057065/9df611f1-cf11-462c-8570-ea0c18b6e7b0)
<br /><br />

:calendar: 프로젝트 기간 : 2023년 8월 17일 ~ 2023년 8월 21일 <br />
:hammer: Tools : ![Visual Studio Code](https://img.shields.io/badge/VS%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white) 
<img src="https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white" /> 
![Oracle](https://img.shields.io/badge/SQLDeveloper-F80000?style=for-the-badge&logoColor=white) <br /> 
:books: languages : ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white) 
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) ![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white) 
![Oracle](https://img.shields.io/badge/Oracle%20SQL-F80000?style=for-the-badge&logo=oracle&logoColor=white) ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white) <br />
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white) ![Spring](https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
<br />

## :pushpin: 2. 프로젝트 기능
## 1. 회원가입
* 사용자로 부터 아이디, 비밀번호, 회원명, 이메일을 입력받아 회원을 등록한다. <br />

![1 회원가입](https://github.com/HeeYeong91/project_board/assets/139057065/7b5393f5-3096-4361-8459-c9d16024428e) <br />
[목차](#page_facing_up-목차)

## 2. 게시글 작성
* 게시글 쓰기버튼을 누르면 게시글 작성 페이지로 이동 <br />
* 제목, 내용, 수정 및 삭제를 위한 비밀번호를 입력받아 작성버튼을 누르면 게시글이 등록된다. <br />

![2 게시글작성](https://github.com/HeeYeong91/project_board/assets/139057065/ea13ab27-9ca4-4513-95fc-fd3607857459) <br />
![2-1 게시글등록완료](https://github.com/HeeYeong91/project_board/assets/139057065/e937abda-de53-4c4e-85f9-7f5f2e48b01a) <br />
[목차](#page_facing_up-목차)

## 3. 게시글 수정
* 게시글 클릭 후 수정 또는 삭제버튼으로 수정 또는 삭제 페이지로 이동 <br />
* 제목 또는 내용을 수정 후 게시글을 작성할 때 입력했던 비밀번호를 입력하고 수정버튼을 누르면 게시글 수정완료 <br />

![3 게시글수정](https://github.com/HeeYeong91/project_board/assets/139057065/920e5fa7-2ecf-4b7e-8747-14c825db738a) <br />
[목차](#page_facing_up-목차)

## 4. 게시글 삭제
* 게시글 클릭 후 수정 또는 삭제버튼으로 수정 또는 삭제 페이지로 이동 <br />
* 비밀번호를 입력하고 삭제버튼을 누르면 게시글 삭제완료 <br />

![3 게시글수정](https://github.com/HeeYeong91/project_board/assets/139057065/920e5fa7-2ecf-4b7e-8747-14c825db738a) <br />
[목차](#page_facing_up-목차)

## 5. 답글 작성
* 게시글 클릭 후 답글 작성버튼으로 답글 작성 페이지로 이동 <br />
* 제목, 내용, 수정 및 삭제를 위한 비밀번호를 입력받아 작성버튼을 누르면 게시글이 등록된다. <br />
* 계층형 게시판이기 때문에 답글은 부모글 밑에서 보여지며 're:' 표시로 부모글과 구분 <br />

![5 답글 작성](https://github.com/HeeYeong91/project_board/assets/139057065/6f3980ed-4613-4ed8-b00e-24ad8fdaa13a) <br />
![5-1 답글등록완료](https://github.com/HeeYeong91/project_board/assets/139057065/bc7766a7-09d2-4a8e-9552-fd4aa7cd9978) <br />
[목차](#page_facing_up-목차)

## 6. 게시글 클릭 시 조회 수 증가
* 게시글 조회 시 ArticleMapper.xml에서 article의 hitcount를 + 1 증가시켜준다. <br />

[목차](#page_facing_up-목차)

## 7. 게시글 검색
* 입력칸에 내용을 입력 후 검색버튼을 누르면 해당 내용이 들어간 게시글 조회해서 화면에 출력 <br />
* 검색 키워드는 작성자, 제목, 내용 모두 적용되며 화면에 출력 될 때 키워드 표시 <br />

![7 게시글검색](https://github.com/HeeYeong91/project_board/assets/139057065/e0615d2b-bf16-4c81-90b3-82375fb19882) <br />
[목차](#page_facing_up-목차)
