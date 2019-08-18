(ns imgplot.main
  (:import [javafx.scene Scene]
           [javafx.scene.control
            Button
            Label
            ProgressBar
            TextField]
           [javafx.scene.layout VBox]
           [javafx.scene.paint Color]
           [javafx.scene.web WebView]
           [javafx.stage Stage]))

(defn- start
  [stage]
  (let [address-bar  (doto (TextField.)
                       (.setText "https://eclipse.org"))
        go-button    (Button. "Go!")
        state-label  (doto (Label.)
                       (.setTextFill Color/RED))
        progress-bar (ProgressBar.)
        browser      (WebView.)
        web-engine   (.getEngine browser)
        worker       (.getLoadWorker web-engine)
        root         (doto (VBox.)
                       (-> .getChildren (.addAll [address-bar go-button state-label progress-bar browser])))
        scene        (Scene. root)]
    (doto stage
      (.setTitle "Whatevs")
      (.setScene scene)
      (.setWidth 800)
      (.setHeight 600)
      (.show))
    ))

(defn -main
  [& args]
  (let [app (doto (proxy [javafx.application.Application] []
                    (start [stage] (imgplot.main/start stage)))
              (.init))]
    (javafx.application.Platform/startup #(.start app (javafx.stage.Stage.)))))
