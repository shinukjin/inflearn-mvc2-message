#메시지 국제화
- MessageSource를 @Bean으로 등록

#직접등록
```
@Bean
public MessageSource messageSource() {
ResourceBundleMessageSource messageSource = new
ResourceBundleMessageSource();
messageSource.setBasenames("messages", "errors");
messageSource.setDefaultEncoding("utf-8");
return messageSource;
}
```

- 스프링부트를 사용하면 자동으로 빈으로 등록해줌.
- 타임리프에 메시지적용방법 th:text="#{messageCode}";
- Accept-Language 는 클라이언트가 서버에 기대하는 언어 정보를 담아서 요청하는 HTTP 요청 헤더
- 스프링에서 LocalResolver를 통해 구현체를 변경해 locale 선택기능을 사용가능하다.(default : accept_language)