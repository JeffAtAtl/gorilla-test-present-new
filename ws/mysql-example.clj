;; gorilla-repl.fileformat = 1

;; **
;;; # ClojureQL MySQL/MariaDb Example
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace.
;; **

;; @@
(ns mysql-example
  (:require [gorilla-plot.core :as plot])
  (:use clojureql.core)
  (:use clojure.repl)
  (:use clojure.pprint))
;; @@

;; @@
(def testdb {:classname "com.mysql.jdbc.Driver" 
             :subprotocol "mysql" 
<<<<<<< Updated upstream
             :user "jtcummi" 
             :password "h2ll0gone" 
=======
             :user "root" 
             :password "H2ll0gone!" 
>>>>>>> Stashed changes
             :subname "//localhost:3306/test"})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mysql-example/testdb</span>","value":"#'mysql-example/testdb"}
;; <=

;; @@
(count @(table testdb :words))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>234936</span>","value":"234936"}
;; <=

;; @@
(pprint (keys (first @(table testdb :words))))
;; @@
<<<<<<< Updated upstream

;; @@
(dir clojure.pprint)
;; @@
=======
;; ->
;;; (:word_id :word :length)
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def words-file (slurp "data/words"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mysql-example/words-file</span>","value":"#'mysql-example/words-file"}
;; <=

;; @@
(def words (clojure.string/split words-file #"\r\n"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mysql-example/words</span>","value":"#'mysql-example/words"}
;; <=

;; @@
(count words)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>234936</span>","value":"234936"}
;; <=

;; @@
(= words (map :word @(table testdb :words)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(doc conj!)
;; @@
;; ->
;;; -------------------------
;;; clojureql.core/conj!
;;; ([this records])
;;;   Inserts record(s) into the table
;;; 
;;;      Ex. (conj! (table :one) {:age 22})
;;;          (conj! (table :one) [{:age 22} {:age 23}]
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(assoc {} :word "test" :length (count "test"))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:length</span>","value":":length"},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"[:length 4]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:word</span>","value":":word"},{"type":"html","content":"<span class='clj-string'>&quot;test&quot;</span>","value":"\"test\""}],"value":"[:word \"test\"]"}],"value":"{:length 4, :word \"test\"}"}
;; <=

;; @@
;; Load words into database
;;(count @(conj! (table testdb :words) (vec (doall (map #(assoc {} :word % :length (count %)) words)))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>234936</span>","value":"234936"}
;; <=

;; @@
@(-> (table testdb :words)
	   (aggregate [:count/*]))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:count(*)</span>","value":":count(*)"},{"type":"html","content":"<span class='clj-long'>234936</span>","value":"234936"}],"value":"[:count(*) 234936]"}],"value":"{:count(*) 234936}"}],"value":"({:count(*) 234936})"}
;; <=

;; @@
@(-> (table testdb :words)
	   (select "word like '%root%'")
	   (aggregate [:count/*]))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:count(*)</span>","value":":count(*)"},{"type":"html","content":"<span class='clj-long'>180</span>","value":"180"}],"value":"[:count(*) 180]"}],"value":"{:count(*) 180}"}],"value":"({:count(*) 180})"}
;; <=

;; @@
@(-> (table testdb :words)
	   (select "word like '%root'")
	   (aggregate [:count/*]))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:count(*)</span>","value":":count(*)"},{"type":"html","content":"<span class='clj-long'>143</span>","value":"143"}],"value":"[:count(*) 143]"}],"value":"{:count(*) 143}"}],"value":"({:count(*) 143})"}
;; <=

;; @@
@(-> (table testdb :words)
	   (select "word like 'root%'")
	   (aggregate [:count/*]))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:count(*)</span>","value":":count(*)"},{"type":"html","content":"<span class='clj-long'>25</span>","value":"25"}],"value":"[:count(*) 25]"}],"value":"{:count(*) 25}"}],"value":"({:count(*) 25})"}
;; <=

;; @@
@(-> (table testdb :words)
	 (select (where (= :word "root"))))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:word_id</span>","value":":word_id"},{"type":"html","content":"<span class='clj-unkown'>170120</span>","value":"170120"}],"value":"[:word_id 170120]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:word</span>","value":":word"},{"type":"html","content":"<span class='clj-string'>&quot;root&quot;</span>","value":"\"root\""}],"value":"[:word \"root\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:length</span>","value":":length"},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"[:length 4]"}],"value":"{:word_id 170120, :word \"root\", :length 4}"}],"value":"({:word_id 170120, :word \"root\", :length 4})"}
;; <=

;; @@
@(-> (table testdb :words)
	 (select (where (= :word "root")))
	 (aggregate [:count/*]))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:count(*)</span>","value":":count(*)"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[:count(*) 1]"}],"value":"{:count(*) 1}"}],"value":"({:count(*) 1})"}
;; <=

;; @@
(pprint @(-> (table testdb :words)
	         (aggregate [[:count/* :as :count]] [[:length/word :as :length]])))
;; @@
;; ->
;;; ({:count 52, :length 1}
;;;  {:count 155, :length 2}
;;;  {:count 1351, :length 3}
;;;  {:count 5110, :length 4}
;;;  {:count 9987, :length 5}
;;;  {:count 17477, :length 6}
;;;  {:count 23734, :length 7}
;;;  {:count 29926, :length 8}
;;;  {:count 32380, :length 9}
;;;  {:count 30867, :length 10}
;;;  {:count 26010, :length 11}
;;;  {:count 20460, :length 12}
;;;  {:count 14937, :length 13}
;;;  {:count 9763, :length 14}
;;;  {:count 5924, :length 15}
;;;  {:count 3377, :length 16}
;;;  {:count 1813, :length 17}
;;;  {:count 842, :length 18}
;;;  {:count 428, :length 19}
;;;  {:count 198, :length 20}
;;;  {:count 82, :length 21}
;;;  {:count 41, :length 22}
;;;  {:count 17, :length 23}
;;;  {:count 5, :length 24})
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(pprint (sort (frequencies (map count words))))
;; @@
;; ->
;;; ([1 52]
;;;  [2 155]
;;;  [3 1351]
;;;  [4 5110]
;;;  [5 9987]
;;;  [6 17477]
;;;  [7 23734]
;;;  [8 29926]
;;;  [9 32380]
;;;  [10 30867]
;;;  [11 26010]
;;;  [12 20460]
;;;  [13 14937]
;;;  [14 9763]
;;;  [15 5924]
;;;  [16 3377]
;;;  [17 1813]
;;;  [18 842]
;;;  [19 428]
;;;  [20 198]
;;;  [21 82]
;;;  [22 41]
;;;  [23 17]
;;;  [24 5])
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [db (map :count 
              @(-> (table testdb :words)
	               (aggregate [[:count/* :as :count]] [[:length/word :as :length]])))
      mem (vals(frequencies (map count words)))]
  (= (sort db) (sort mem)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=
>>>>>>> Stashed changes

;; @@

;; @@
