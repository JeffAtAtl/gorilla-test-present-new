;; gorilla-repl.fileformat = 1

;; **
;;; # Prototyping UML with Gorilla REPL and PlantUML
;;; 
;;; Require [gorilla-plantuml.core], call diagram-view and enjoy the insights.
;; **

;; @@
(ns star-wars-uml-example
  (:require [gorilla-plantuml.core :as uml]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def star-wars "
@startuml
Vader -> Luke: I'm your father.
Luke --> Vader: No. No. Nooo! It's not true. That's impossible.  
Vader -> Luke: Search your feelings.
@enduml
")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;star-wars-uml-example/star-wars</span>","value":"#'star-wars-uml-example/star-wars"}
;; <=

;; @@
(uml/diagram-view star-wars)
;; @@
;; =>
;;; {"type":"html","content":"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" contentScriptType=\"application/ecmascript\" contentStyleType=\"text/css\" height=\"190px\" preserveAspectRatio=\"none\" style=\"width:350px;height:190px;\" version=\"1.1\" viewBox=\"0 0 350 190\" width=\"350px\" zoomAndPan=\"magnify\"><defs><filter height=\"300%\" id=\"fw1a5in\" width=\"300%\" x=\"-1\" y=\"-1\"><feGaussianBlur result=\"blurOut\" stdDeviation=\"2.0\"/><feColorMatrix in=\"blurOut\" result=\"blurOut2\" type=\"matrix\" values=\"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 .4 0\"/><feOffset dx=\"4.0\" dy=\"4.0\" in=\"blurOut2\" result=\"blurOut3\"/><feBlend in=\"SourceGraphic\" in2=\"blurOut3\" mode=\"normal\"/></filter></defs><g><line style=\"stroke: #A80036; stroke-width: 1.0; stroke-dasharray: 5.0,5.0;\" x1=\"36\" x2=\"36\" y1=\"39.6094\" y2=\"150.6641\"/><line style=\"stroke: #A80036; stroke-width: 1.0; stroke-dasharray: 5.0,5.0;\" x1=\"320.5\" x2=\"320.5\" y1=\"39.6094\" y2=\"150.6641\"/><rect fill=\"#FEFECE\" filter=\"url(#fw1a5in)\" height=\"31.6094\" style=\"stroke: #A80036; stroke-width: 1.5;\" width=\"52\" x=\"8\" y=\"3\"/><text fill=\"#000000\" font-family=\"sans-serif\" font-size=\"14\" lengthAdjust=\"spacingAndGlyphs\" textLength=\"38\" x=\"15\" y=\"24.5332\">Vader</text><rect fill=\"#FEFECE\" filter=\"url(#fw1a5in)\" height=\"31.6094\" style=\"stroke: #A80036; stroke-width: 1.5;\" width=\"52\" x=\"8\" y=\"149.6641\"/><text fill=\"#000000\" font-family=\"sans-serif\" font-size=\"14\" lengthAdjust=\"spacingAndGlyphs\" textLength=\"38\" x=\"15\" y=\"171.1973\">Vader</text><rect fill=\"#FEFECE\" filter=\"url(#fw1a5in)\" height=\"31.6094\" style=\"stroke: #A80036; stroke-width: 1.5;\" width=\"45\" x=\"296.5\" y=\"3\"/><text fill=\"#000000\" font-family=\"sans-serif\" font-size=\"14\" lengthAdjust=\"spacingAndGlyphs\" textLength=\"31\" x=\"303.5\" y=\"24.5332\">Luke</text><rect fill=\"#FEFECE\" filter=\"url(#fw1a5in)\" height=\"31.6094\" style=\"stroke: #A80036; stroke-width: 1.5;\" width=\"45\" x=\"296.5\" y=\"149.6641\"/><text fill=\"#000000\" font-family=\"sans-serif\" font-size=\"14\" lengthAdjust=\"spacingAndGlyphs\" textLength=\"31\" x=\"303.5\" y=\"171.1973\">Luke</text><polygon fill=\"#A80036\" points=\"309,67.6094,319,71.6094,309,75.6094,313,71.6094\" style=\"stroke: #A80036; stroke-width: 1.0;\"/><line style=\"stroke: #A80036; stroke-width: 1.0;\" x1=\"36\" x2=\"315\" y1=\"71.6094\" y2=\"71.6094\"/><text fill=\"#000000\" font-family=\"sans-serif\" font-size=\"13\" lengthAdjust=\"spacingAndGlyphs\" textLength=\"85\" x=\"43\" y=\"67.1045\">I'm your father.</text><polygon fill=\"#A80036\" points=\"47,97.9609,37,101.9609,47,105.9609,43,101.9609\" style=\"stroke: #A80036; stroke-width: 1.0;\"/><line style=\"stroke: #A80036; stroke-width: 1.0; stroke-dasharray: 2.0,2.0;\" x1=\"41\" x2=\"320\" y1=\"101.9609\" y2=\"101.9609\"/><text fill=\"#000000\" font-family=\"sans-serif\" font-size=\"13\" lengthAdjust=\"spacingAndGlyphs\" textLength=\"261\" x=\"53\" y=\"97.4561\">No. No. Nooo! It's not true. That's impossible.</text><polygon fill=\"#A80036\" points=\"309,128.3125,319,132.3125,309,136.3125,313,132.3125\" style=\"stroke: #A80036; stroke-width: 1.0;\"/><line style=\"stroke: #A80036; stroke-width: 1.0;\" x1=\"36\" x2=\"315\" y1=\"132.3125\" y2=\"132.3125\"/><text fill=\"#000000\" font-family=\"sans-serif\" font-size=\"13\" lengthAdjust=\"spacingAndGlyphs\" textLength=\"122\" x=\"43\" y=\"127.8076\">Search your feelings.</text></g></svg>","value":"\n@startuml\nVader -> Luke: I'm your father.\nLuke --> Vader: No. No. Nooo! It's not true. That's impossible.  \nVader -> Luke: Search your feelings.\n@enduml\n"}
;; <=

;; @@

;; @@
