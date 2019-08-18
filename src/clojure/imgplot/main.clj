(ns imgplot.main)

(defn -main
  [& args]
  (let [app (doto (imgplot.app.ImgPlotApp. #(println "hi there"))
              (.init))]
    (javafx.application.Platform/startup #(.start app (javafx.stage.Stage.)))))
