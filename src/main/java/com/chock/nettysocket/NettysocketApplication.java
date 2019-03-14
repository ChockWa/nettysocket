package com.chock.nettysocket;

import com.chock.nettysocket.netty.NettyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettysocketApplication implements CommandLineRunner {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(NettysocketApplication.class, args);
    }

    @Autowired
    private NettyService nettyService;

    @Override
    public void run(String... args) throws Exception {
        nettyService.run();
    }
}
