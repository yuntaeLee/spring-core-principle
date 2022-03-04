package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/**
 * proxyMode = ScopedProxyMode.TARGET_CLASS 를 사용하면
 * CGLIB 이라는 라이브러리로 내 클래스를 상속 받을 가짜 프록시 객체를 만들어서 주입한다.
 * 이 가짜 프록시 객체는 실제 요청이 오면 그때 내부에서 실제 빈을 요청하는 위임 로직이 들어있다.
 * 가짜 프록시 객체는 실제 request scope 와는 관계가 없다.
 * 그냥 가짜이고, 내부에 단순한 위임 로직만 있고, 싱글톤 처럼 동작한다.
 *
 * * 핵심 *
 *   진짜 객체 조회를 꼭 필요한 시점까지 지연처리 한다는 점
 *
 * * 주의점 *
 * 1. 마치 싱글톤을 사용하는 것 같지만 다르게 동작하기 때문에 주의해서 사용해야 함.
 * 2. 이런 특별한 scope 는 꼭 필요한 곳에만 최소화해서 사용, 무분별하게 사용시 유지보수가 어려워짐
 */

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
