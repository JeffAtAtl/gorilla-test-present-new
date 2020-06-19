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
(ns rhizome-examples
  (:use rhizome.viz)
  (:use gorilla-plot.core)
  (:use [gorilla-repl table latex html])
  (:use dk.ative.docjure.spreadsheet)
  (:use clojure.repl)
  (:use clojure.data.json))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def g
    {"a" ["b" "c"]
     "b" ["c"]
     "c" ["a"]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;rhizome-examples/g</span>","value":"#'rhizome-examples/g"}
;; <=

;; @@
(view-graph (keys g) g
            :node->descriptor (fn [n] {:label n}))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(graph->svg (keys g) g
            :node->descriptor (fn [n] {:label n}))
;; @@

;; @@
(doc graph->svg)
;; @@
;; ->
;;; -------------------------
;;; rhizome.viz/graph-&gt;svg
;;; ([nodes adjacent &amp; {:keys [directed? vertical? options node-&gt;descriptor edge-&gt;descriptor cluster-&gt;parent node-&gt;cluster cluster-&gt;descriptor], :or {directed? true, vertical? true, node-&gt;descriptor (constantly nil), edge-&gt;descriptor (constantly nil), cluster-&gt;parent (constantly nil), node-&gt;cluster (constantly nil), cluster-&gt;descriptor (constantly nil)}, :as graph-descriptor}])
;;;   Takes a graph descriptor in the style of `graph-&gt;dot`, and returns SVG.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir rhizome.viz)
;; @@
;; ->
;;; create-frame
;;; default-frame
;;; dot-&gt;image
;;; dot-&gt;svg
;;; graph-&gt;image
;;; graph-&gt;svg
;;; headless?
;;; rhizome.viz.proxy$java.awt.event.WindowAdapter$ff19274a
;;; rhizome.viz.proxy$javax.swing.AbstractAction$ff19274a
;;; save-graph
;;; save-image
;;; save-tree
;;; tree-&gt;image
;;; tree-&gt;svg
;;; view-graph
;;; view-image
;;; view-tree
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc view-graph)
;; @@
;; ->
;;; -------------------------
;;; rhizome.viz/view-graph
;;; ([nodes adjacent &amp; {:keys [directed? vertical? options node-&gt;descriptor edge-&gt;descriptor cluster-&gt;parent node-&gt;cluster cluster-&gt;descriptor], :or {directed? true, vertical? true, node-&gt;descriptor (constantly nil), edge-&gt;descriptor (constantly nil), cluster-&gt;parent (constantly nil), node-&gt;cluster (constantly nil), cluster-&gt;descriptor (constantly nil)}, :as graph-descriptor}])
;;;   Takes a graph descriptor in the style of `graph-&gt;dot`, and displays a rendered image.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc graph->dot)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
