package com.liangshou.jmoneyprinter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JMoneyPrinterApplication {

	public static void main(String[] args) {
		System.setProperty("java.net.useSystemProxies", "true");
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "7890");
		System.setProperty("https.proxyHost", "127.0.0.1");
		System.setProperty("https.proxyPort", "7890");
		log.info("Using proxy on port 7890");
		SpringApplication.run(JMoneyPrinterApplication.class, args);
	}

}
