/**
 * For program specifics please see 'CST246_Text_Editor_Project.pdf'
 * For Progeam instructions please use the ABOUT menu in the project or the ReadMe.txt
 * 
 * @see <A HREF="C:/users/sbw73_000/CST_246/WilliamsFinalProject_CST246/src
 * /TextEditor/EditorApp.java">
 * 
 * Java Source Code
 * 
 * @author Williams, Shawn
 * <A HERF="mailto:sbw73@optonline.net"> (sbw73@optonline.net) </A>
 *
 * @version 1.0 November 15th, 2016
 */

package TextEditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Class EditorApp.
 */
public class EditorApp extends Application {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
		loader.setControllerFactory(t -> new EditorController(new EditorModel()));
		stage.setScene(new Scene(loader.load()));
		stage.show();
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}