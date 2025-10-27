package com.biblioteca.zabat.bibleoteca_ms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbPing implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DbPing.class);
    private final JdbcTemplate jdbc;

    public DbPing(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            String now = jdbc.queryForObject(
                "select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') from dual", String.class);
            String svc = jdbc.queryForObject(
                "select sys_context('userenv','service_name') from dual", String.class);
            log.info("✅ Conectado a Oracle. SYSDATE={}, SERVICE_NAME={}", now, svc);
        } catch (Exception e) {
            log.error("❌ No se pudo conectar a Oracle", e);
        }
    }
}
