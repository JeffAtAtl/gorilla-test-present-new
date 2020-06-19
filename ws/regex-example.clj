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
(ns regex-example
  (:require [gorilla-plot.core :as plot]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(re-seq #"\d" "clojure 1.1.0")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;1&quot;</span>","value":"\"1\""},{"type":"html","content":"<span class='clj-string'>&quot;1&quot;</span>","value":"\"1\""},{"type":"html","content":"<span class='clj-string'>&quot;0&quot;</span>","value":"\"0\""}],"value":"(\"1\" \"1\" \"0\")"}
;; <=

;; @@
(re-seq #"\w+" "mary had a little lamb")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;mary&quot;</span>","value":"\"mary\""},{"type":"html","content":"<span class='clj-string'>&quot;had&quot;</span>","value":"\"had\""},{"type":"html","content":"<span class='clj-string'>&quot;a&quot;</span>","value":"\"a\""},{"type":"html","content":"<span class='clj-string'>&quot;little&quot;</span>","value":"\"little\""},{"type":"html","content":"<span class='clj-string'>&quot;lamb&quot;</span>","value":"\"lamb\""}],"value":"(\"mary\" \"had\" \"a\" \"little\" \"lamb\")"}
;; <=

;; @@
(def line " RX pkts:18 err:5 drop:48")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;regex-example/line</span>","value":"#'regex-example/line"}
;; <=

;; @@
(re-seq #"(\S+):(\d+)" line)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;pkts:18&quot;</span>","value":"\"pkts:18\""},{"type":"html","content":"<span class='clj-string'>&quot;pkts&quot;</span>","value":"\"pkts\""},{"type":"html","content":"<span class='clj-string'>&quot;18&quot;</span>","value":"\"18\""}],"value":"[\"pkts:18\" \"pkts\" \"18\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;err:5&quot;</span>","value":"\"err:5\""},{"type":"html","content":"<span class='clj-string'>&quot;err&quot;</span>","value":"\"err\""},{"type":"html","content":"<span class='clj-string'>&quot;5&quot;</span>","value":"\"5\""}],"value":"[\"err:5\" \"err\" \"5\"]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;drop:48&quot;</span>","value":"\"drop:48\""},{"type":"html","content":"<span class='clj-string'>&quot;drop&quot;</span>","value":"\"drop\""},{"type":"html","content":"<span class='clj-string'>&quot;48&quot;</span>","value":"\"48\""}],"value":"[\"drop:48\" \"drop\" \"48\"]"}],"value":"([\"pkts:18\" \"pkts\" \"18\"] [\"err:5\" \"err\" \"5\"] [\"drop:48\" \"drop\" \"48\"])"}
;; <=

;; @@
(->> (re-seq #"(\S+):(\d+)" line)
     (map (juxt (comp keyword second) (comp #(Integer/parseInt %) last)))
     (apply map list)
     (apply zipmap)
     )
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:pkts</span>","value":":pkts"},{"type":"html","content":"<span class='clj-unkown'>18</span>","value":"18"}],"value":"[:pkts 18]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:err</span>","value":":err"},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"[:err 5]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:drop</span>","value":":drop"},{"type":"html","content":"<span class='clj-unkown'>48</span>","value":"48"}],"value":"[:drop 48]"}],"value":"{:pkts 18, :err 5, :drop 48}"}
;; <=

;; @@
(clojure.string/join " " (re-seq #"[A-Z][a-z]+|[0-9]+" "ManishKumar12332"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Manish Kumar 12332&quot;</span>","value":"\"Manish Kumar 12332\""}
;; <=

;; @@

;; @@
