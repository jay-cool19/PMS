package com.jay;
import com.jay.dao.PersonDAO;
import com.jay.health.DatabaseHealthCheck;
import com.jay.resources.PersonResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class App extends Application<PMSConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<PMSConfiguration> bootstrap) {
//        bootstrap.addBundle(new SwaggerBundle<PMSConfiguration>() {
//            @Override
//            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(PMSConfiguration pmsConfiguration){
//                return pmsConfiguration.swaggerBundleConfiguration;
//            }
//        });
//        bootstrap.addBundle(new MigrationsBundle<PMSConfiguration>() {
//            @Override
//            public PooledDataSourceFactory getDataSourceFactory(final PMSConfiguration configuration){
//                return configuration.getDataSourceFactory();
//            }
//        });
//        bootstrap.addBundle(new AssetsBundle("/asset/"));
    }

    @Override
    public void run(PMSConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment,configuration.getDataSourceFactory(), "mysql");
        final PersonDAO dao = jdbi.onDemand(PersonDAO.class);

        environment.jersey().register(new PersonResource(dao));

        environment.healthChecks().register("health", new DatabaseHealthCheck(jdbi,configuration.getDataSourceFactory().getValidationQuery()));
    }

}
