package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage(){
        String result = ms.getMessage("hello", null, Locale.ENGLISH);// code, arg, locale
        System.out.println("result = " + result);
        assertThat(result).isEqualTo("hello");
    }

    /* 일치하는 MeesageCode가 없는 경우, NoSuchMessageException*/
    @Test
    void notFoundMessageCode(){
        ms.getMessage("no_code", null, null);
//        assertThatThrownBy(()-> ms.getMessage("no_code", null, null))
//                .isInstanceOf(NoSuchMessageException.class);
    }

    
    /*default Message 설정 방법*/
    @Test
    void notFoundMessageCodeEdfaultMessage(){
        String result = ms.getMessage("no_code", null, "기본 메시지",null);
        assertThat(result).isEqualTo("기본 메시지");

    }

    /*argument message 방법*/
    @Test
    void argumentMessage(){
        String result = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        assertThat(result).isEqualTo("안녕 Spring");
    }

    @Test
    void defaultLang(){
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    void enLang(){
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }
}
