package by.ivuts.connection;

import org.postgresql.ds.PGSimpleDataSource;

public class DataSource {
    public  PGSimpleDataSource createDataSource() {
        String url =
                "jdbc:postgresql://localhost:5432/postgres";
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(url);
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }
}