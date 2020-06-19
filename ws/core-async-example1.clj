;; gorilla-repl.fileformat = 1

;; **
;;; # Core Async One
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns core-async-example1
  (:require [clojure.core.async :refer [chan <!! >!! put! take!]]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [c (chan)]
  (future (>!! c 42))
  (future (println (<!! c))))
;; @@
;; ->
;;; 42
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[clojure.core$future_call$reify__6962 0x278438f1 {:status :pending, :val nil}]</span>","value":"#object[clojure.core$future_call$reify__6962 0x278438f1 {:status :pending, :val nil}]"}
;; <=

;; @@
(let [c (chan)]
  (future (dotimes [x 10] 
           (>!! c x)))
  (future (dotimes [x 10] 
            (println (<!! c)))))
;; @@
;; ->
;;; 0
;;; 1
;;; 2
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[clojure.core$future_call$reify__6962 0x265f6c7b {:status :pending, :val nil}]</span>","value":"#object[clojure.core$future_call$reify__6962 0x265f6c7b {:status :pending, :val nil}]"}
;; <=

;; @@
(let [c (chan)]
  (future (dotimes [x 10] 
           (>!! c x)))
  @(future (dotimes [x 10] 
           (>!! c x)))
  (future (dotimes [x 20] 
            (println (<!! c)))))
;; @@

;; @@
(let [c (chan)]
  (put! c 42)
  (take! c (fn [x] (println "Got: " x))))
;; @@
;; ->
;;; Got:  42
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [c (chan)]
  (put! c 42 (fn [x] (println "Sent: " x)))
  (take! c (fn [x] (println "Got: " x))))
;; @@
;; ->
;;; Got:  42
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
