;; gorilla-repl.fileformat = 1

;; **
;;; # Specter Examples
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns specter-example
  (:require [gorilla-plot.core :as plot])
  (:use com.rpl.specter))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def data {:a [{:aa 1 :bb 2}
               {:cc 3}]
           :b [{:dd 4}]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;specter-example/data</span>","value":"#'specter-example/data"}
;; <=

;; @@
(transform [MAP-VALS ALL MAP-VALS even?] inc data)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:aa</span>","value":":aa"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[:aa 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:bb</span>","value":":bb"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"[:bb 3]"}],"value":"{:aa 1, :bb 3}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:cc</span>","value":":cc"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"[:cc 3]"}],"value":"{:cc 3}"}],"value":"[{:aa 1, :bb 3} {:cc 3}]"}],"value":"[:a [{:aa 1, :bb 3} {:cc 3}]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:dd</span>","value":":dd"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"[:dd 5]"}],"value":"{:dd 5}"}],"value":"[{:dd 5}]"}],"value":"[:b [{:dd 5}]]"}],"value":"{:a [{:aa 1, :bb 3} {:cc 3}], :b [{:dd 5}]}"}
;; <=

;; @@
(def data2 {:a [1 2 3]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;specter-example/data2</span>","value":"#'specter-example/data2"}
;; <=

;; @@
(setval [:a END] [4 5] data2)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"[1 2 3 4 5]"}],"value":"[:a [1 2 3 4 5]]"}],"value":"{:a [1 2 3 4 5]}"}
;; <=

;; @@
(def data3 [1 2 3 4 5 6 7 8])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;specter-example/data3</span>","value":"#'specter-example/data3"}
;; <=

;; @@
(transform [(filterer odd?) LAST] inc data3)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}],"value":"[1 2 3 4 5 6 8 8]"}
;; <=

;; @@

;; @@
