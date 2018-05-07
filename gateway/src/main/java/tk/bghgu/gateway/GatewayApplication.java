package tk.bghgu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import tk.bghgu.gateway.filter.JwtPreFilter;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    @Bean
    public JwtPreFilter JwtPreFIlter() {
        return new JwtPreFilter();
    }


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
