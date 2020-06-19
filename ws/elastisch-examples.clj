;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns elastisch-examples
  (:require [clojurewerkz.elastisch.rest :as esr]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn -main
  [& args]
  (let [conn (esr/connect "http://127.0.0.1:9200")]
    ))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;elastisch-examples/-main</span>","value":"#'elastisch-examples/-main"}
;; <=

;; @@
(-main)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
