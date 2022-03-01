package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /**
         *  탐색할 패키지의 시작위치 지정, 해당 패키지를 포함한 하위 패키지 모두 탐색
         *  default (basePackages, basePackageClasses 설정 X) = @ComponentScan 을 붙힌 클래스가 속해있는 패키지(hello.core)부터 하위 패키지까지 탐색
         *  ** 권장방법 ** : basePackages 를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것
         */
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,

        // 기존 예제 코드를 남기고 유지하기 위해 사용
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
