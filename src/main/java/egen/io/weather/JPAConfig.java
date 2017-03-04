package egen.io.weather;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getDatasource());
		emf.setPackagesToScan("egen.io.weather.details");
		emf.setJpaProperties(getjpaProperties());
		return emf;
	}

	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3306/user-db");
		data.setUsername("root");
		data.setPassword("sri.K888");
		return data;
	}

	@Bean
	public PlatformTransactionManager textmgr(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	private Properties getjpaProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		prop.setProperty("hibernate.hbm2ddl.auto", "create");

		return prop;

	}
}
