package aseftian.bootfx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import aseftian.bootfx.config.StageManager;
import aseftian.bootfx.view.FxmlView;
import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class BootfxApplication extends Application {
	
	protected ConfigurableApplicationContext springContext;
	protected StageManager stageManager;

	public static void main(final String[] args) {
//		SpringApplication.run(BootfxApplication.class, args);
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		springContext = springBootApplicationContext();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stageManager = springContext.getBean(StageManager.class, stage);
		displayInitialScene();
	}
	
	@Override
	public void stop() throws Exception {
		springContext.close();
	}
	
    /**
     * Useful to override this method by sub-classes wishing to change the first
     * Scene to be displayed on startup. Example: Functional tests on main
     * window.
     */
	protected void displayInitialScene() {
		stageManager.switchScene(FxmlView.LOGIN);
	}
	
	private ConfigurableApplicationContext springBootApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(BootfxApplication.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		return builder.run(args);
	}
}
