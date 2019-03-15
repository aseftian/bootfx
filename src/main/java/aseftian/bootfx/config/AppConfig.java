package aseftian.bootfx.config;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import aseftian.bootfx.logging.ExceptionWriter;
import javafx.stage.Stage;

@Configuration
public class AppConfig {

	@Autowired
	SpringFXMLLoader springFXMLLoader;

	@Bean
	@Scope("prototype")
	public ExceptionWriter exceptionWriter() {
		return new ExceptionWriter(new StringWriter());
	}

	@Bean
	ResourceBundle resourceBundle() {
		return ResourceBundle.getBundle("bootfx");
	}

	@Bean
	@Lazy(value = true)
	public StageManager stageManager(Stage stage) throws IOException {
		return new StageManager(springFXMLLoader, stage);
	}
}
