package mrs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

/**
 * Date and Time API定義クラス
 * @author t_ito
 *
 */
@Configuration
public class ThymeleafConfig {

	/**
	 * Date and Time API
	 * @return
	 */
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
}
