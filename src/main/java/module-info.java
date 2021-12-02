module com.tp.rak_mel.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tp.rak_mel.demo to javafx.fxml;
    exports com.tp.rak_mel.demo;
    exports com.tp.rak_mel.demo.Controller;
    opens com.tp.rak_mel.demo.Controller to javafx.fxml;
}