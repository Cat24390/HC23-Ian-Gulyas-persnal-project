package com.example.RandomForceGenerator;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;


public class RandomForceGeneratorTest extends ApplicationTest {

        VBox UIRoot;
        Button ExitButton;
        Button GenerateButton;
        Button SaveButton;
        Button TestButton;
        ChoiceBox FactionsChoiceBox;
        ChoiceBox ErasChoiceBox;
        TextField BattleValueField;
        TextField Result_field;

        @Override
        public void start(Stage stage) {
            RandomForceGeneratorBuilder RD = new RandomForceGeneratorBuilder();
            VBox UIroot = RD.getUIRoot();
            Button TestButton = new Button("Test");
            UIroot.getChildren().addAll(TestButton);
            Scene Mainscene = new Scene(UIroot, RandomForceGeneratorData.width, RandomForceGeneratorData.height);
            stage.setTitle("Random Force Generator");
            stage.setScene(Mainscene);
            stage.show();
        }

        @Test
        public void allUIButtonsAreHere() {
            verifyThat(".TestButton",hasText("Test"));
            //Assertions.assertThat(TestButton).hasText("Test");
           // Assertions.assertThat(ExitButton).hasText("Exit");
           // Assertions.assertThat(GenerateButton).hasText("Generate Force");
           // Assertions.assertThat(SaveButton).hasText("Save");
        }
       /* @Test
        public void textFieldsAreHere()
        {
            verifyThat(".battleValueField",hasText("Enter Battle Value"));
            verifyThat(".result_field",hasText(""));
        }

        */

    }


