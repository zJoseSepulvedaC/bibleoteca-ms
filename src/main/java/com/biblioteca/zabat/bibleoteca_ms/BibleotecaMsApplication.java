package com.biblioteca.zabat.bibleoteca_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class BibleotecaMsApplication {

    public static void main(String[] args) {
        // Ruta relativa al wallet dentro del proyecto (funciona al ejecutar desde VS Code o con mvn spring-boot:run)
        String walletPath = new File("src/main/resources/wallet").getAbsolutePath();

        // Fija la propiedad para que el driver Oracle use ese wallet (tnsnames.ora, sqlnet.ora, cwallet.sso, etc.)
        System.setProperty("oracle.net.tns_admin", walletPath);

        // Opcional: si tu wallet contiene un truststore JKS y necesitas indicarlo explícitamente,
        // descomenta y ajusta las líneas siguientes.
        // System.setProperty("javax.net.ssl.trustStore", walletPath + File.separator + "truststore.jks");
        // System.setProperty("javax.net.ssl.trustStorePassword", "TU_PASSWORD_AQUI");

        SpringApplication.run(BibleotecaMsApplication.class, args);
    }
}
