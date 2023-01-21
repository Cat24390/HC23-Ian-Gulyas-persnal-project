package com.example.RandomForceGenerator;
import org.junit.Test;
import org.testfx.api.FxAssert;
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
import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;


public class RandomForceGeneratorTest extends ApplicationTest {

        VBox UIRoot;
        Button ExitButton;
        Button GenerateButton;
        Button SaveButton;
        ChoiceBox FactionsChoiceBox;
        ChoiceBox ErasChoiceBox;
        TextField BattleValueField;
        TextField Result_field;
        RandomForceGeneratorBuilder RD;

        @Override
        public void start(Stage stage) {
            RD = new RandomForceGeneratorBuilder();
            VBox UIroot = RD.getUIRoot();
            Scene Mainscene = new Scene(UIroot, RandomForceGeneratorData.width, RandomForceGeneratorData.height);
            stage.setTitle("Random Force Generator");
            stage.setScene(Mainscene);
            stage.show();

        }

        @Test
        public void allUIButtonsAreHere() {
            Assertions.assertThat(RD.ExitButton).hasText("Exit");
            Assertions.assertThat(RD.GenerateButton).hasText("Generate Force");
            Assertions.assertThat(RD.SaveButton).hasText("Save");
        }
        @Test
        public void textFieldsAreHere()
        {
            Assertions.assertThat(RD.BattleValueField).hasText("Enter Battle Value");
            Assertions.assertThat(RD.Result_field).hasText("");
        }



    }


