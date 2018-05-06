package tk.bghgu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import tk.bghgu.gateway.filter.CustomPreFIlter;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    @Bean
    public CustomPreFIlter customPreFIlter() {
        return new CustomPreFIlter();
    }


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
