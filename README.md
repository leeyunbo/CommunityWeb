# SpringBootPractice
SpringBoot 학습을 위한 레포지토리

### 레포지토리 소개
```
Spring Boot를 활용한 커뮤니케이션 웹 개발 
DI, AOP를 위한 에노테이션 활용
```

### Spring Boot?
```
1. 일반적인 Spring Framework는 기본적인 설정이 너무 많아, 배보다 배꼽이 큼
2. Spring Boot는 Spring을 통해 개발을 할 수 있도록 기본적인 설정을 해놓은 것
3. 단독으로 실행 가능한 Spring Application을 생성하며, Tomcat을 따로 설치할 필요 없이 내장된 Tomcat Server가 존재
4. 설정을 위한 XML을 따로 요구하지 않음!
```

### 전체적인 흐름 
```
1. 클라이언트로부터 "/***.do" 요청이 오면 DispatcherServlet이 요청을 수신함 
2. URL과 일치하는 Controller를 HandlerMapping을 통해 검색함 
3. DispatcherServlet은 해당 Controller를 실행하여 요청을 처리함 
4. Controller는 검색결과를 담고 있는 객체(VO or List<VO>)를 Model 객체에 저장하고, 이동할 화면의 명칭을 String 형으로 반환함
5. DispatcherServlet은 view 정보와 model을 추출하고, ViewResolver를 이용하여 응답으로 사용할 화면의 이름을 검색함
6. DispatcherServlet은 해당 화면을 실행하여 결과를 전송함
```

### 기능?
```
1. 로그인, 로그아웃 기능
2. 게시물 등록, 수정, 삭제 기능
3. 게시물 검색 기능
4. 댓글 기능 
```
