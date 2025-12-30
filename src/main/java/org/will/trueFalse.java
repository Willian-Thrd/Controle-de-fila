package org.will;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class trueFalse {
    @FXML
    private TextField EnderecoCliente, TelCliente;
    @FXML
    private ComboBox<String> box;

    public void trueFalse(Boolean checker, Boolean mouseTransparent) {
        EnderecoCliente.setEditable(checker);
        TelCliente.setEditable(checker);
        box.setFocusTraversable(checker);
        box.setMouseTransparent(mouseTransparent);
    }
}
