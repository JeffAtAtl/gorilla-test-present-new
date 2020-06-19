;; gorilla-repl.fileformat = 1

;; **
;;; # Neocons Examples
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns neocons-ex
  (:use gorilla-plot.core)
  (:use [gorilla-repl table latex html])
  (:use dk.ative.docjure.spreadsheet)
  (:use clojure.repl)
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as nrl]
            [clojurewerkz.neocons.rest.cypher :as cy]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")
        jeff   (nn/create conn {:username "jtcummi"})
        wanda   (nn/create conn {:username "wanda"})
        rel   (nrl/create conn jeff wanda :friend {:source "college"})]
    (println rel))
;; @@
;; ->
;;; #clojurewerkz.neocons.rest.records.Relationship{:id 3, :location-uri http://localhost:7474/db/data/relationship/3, :start http://localhost:7474/db/data/node/8, :end http://localhost:7474/db/data/node/9, :type friend, :data {:source college}}
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")]
     (clojure.pprint/pprint (nn/get conn 0)))
;; @@
;; ->
;;; {:id 0,
;;;  :location-uri
;;;  &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0&quot;,
;;;  :data {:username &quot;jtcummi&quot;},
;;;  :relationships-uri
;;;  &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships/all&quot;,
;;;  :create-relationship-uri
;;;  &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships&quot;}
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")]
     (clojure.pprint/pprint (nn/get conn 20)))
;; @@
;; ->
;;; {:id 20,
;;;  :location-uri
;;;  &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20&quot;,
;;;  :data {:username &quot;wanda&quot;},
;;;  :relationships-uri
;;;  &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships/all&quot;,
;;;  :create-relationship-uri
;;;  &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships&quot;}
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")]
     (clojure.pprint/pprint (cy/tquery conn "MATCH (person)-[rel:friend]->(friend) RETURN person, rel, friend")))
;; @@
;; ->
;;; ({&quot;person&quot;
;;;   {:properties
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/properties&quot;,
;;;    :create_relationship
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships&quot;,
;;;    :labels
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/labels&quot;,
;;;    :incoming_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships/in&quot;,
;;;    :outgoing_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships/out&quot;,
;;;    :property
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/properties/{key}&quot;,
;;;    :paged_traverse
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/paged/traverse/{returnType}{?pageSize,leaseTime}&quot;,
;;;    :incoming_typed_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships/in/{-list|&amp;|types}&quot;,
;;;    :traverse
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/traverse/{returnType}&quot;,
;;;    :all_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships/all&quot;,
;;;    :extensions {},
;;;    :outgoing_typed_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships/out/{-list|&amp;|types}&quot;,
;;;    :metadata {:id 0, :labels []},
;;;    :all_typed_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0/relationships/all/{-list|&amp;|types}&quot;,
;;;    :self
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0&quot;,
;;;    :data {:username &quot;jtcummi&quot;}},
;;;   &quot;rel&quot;
;;;   {:properties
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/relationship/0/properties&quot;,
;;;    :property
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/relationship/0/properties/{key}&quot;,
;;;    :start
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/0&quot;,
;;;    :type &quot;friend&quot;,
;;;    :extensions {},
;;;    :end
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20&quot;,
;;;    :metadata {:id 0, :type &quot;friend&quot;},
;;;    :self
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/relationship/0&quot;,
;;;    :data {:source &quot;college&quot;}},
;;;   &quot;friend&quot;
;;;   {:properties
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/properties&quot;,
;;;    :create_relationship
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships&quot;,
;;;    :labels
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/labels&quot;,
;;;    :incoming_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships/in&quot;,
;;;    :outgoing_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships/out&quot;,
;;;    :property
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/properties/{key}&quot;,
;;;    :paged_traverse
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/paged/traverse/{returnType}{?pageSize,leaseTime}&quot;,
;;;    :incoming_typed_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships/in/{-list|&amp;|types}&quot;,
;;;    :traverse
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/traverse/{returnType}&quot;,
;;;    :all_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships/all&quot;,
;;;    :extensions {},
;;;    :outgoing_typed_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships/out/{-list|&amp;|types}&quot;,
;;;    :metadata {:id 20, :labels []},
;;;    :all_typed_relationships
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20/relationships/all/{-list|&amp;|types}&quot;,
;;;    :self
;;;    &quot;https://hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/node/20&quot;,
;;;    :data {:username &quot;wanda&quot;}}})
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")]
     (->> (cy/tquery conn "MATCH (person {username:'jtcummi'})-[rel:friend]->(friend) RETURN person, rel, friend")
          (map (juxt #(get-in % ["person" :data :username]) #(get-in % ["rel" :type]) #(get-in % ["friend" :data :username])))))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;jtcummi&quot;</span>","value":"\"jtcummi\""},{"type":"html","content":"<span class='clj-string'>&quot;friend&quot;</span>","value":"\"friend\""},{"type":"html","content":"<span class='clj-string'>&quot;wanda&quot;</span>","value":"\"wanda\""}],"value":"[\"jtcummi\" \"friend\" \"wanda\"]"}],"value":"([\"jtcummi\" \"friend\" \"wanda\"])"}
;; <=

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")
      jeff (get-in (first (cy/tquery conn "MATCH (person {username:'jtcummi'}) RETURN person")) ["person" :metadata :id])]
     (nrl/traverse conn (long jeff) :relationships) ; [{:direction "out" :type "friend"}])
  )
;; @@

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")]
     (cy/tquery conn "UNWIND range(1, 10) AS n RETURN n, n * n as n_sq"))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[\"n\" 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[\"n_sq\" 1]"}],"value":"{\"n\" 1, \"n_sq\" 1}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"[\"n\" 2]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"[\"n_sq\" 4]"}],"value":"{\"n\" 2, \"n_sq\" 4}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"[\"n\" 3]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>9</span>","value":"9"}],"value":"[\"n_sq\" 9]"}],"value":"{\"n\" 3, \"n_sq\" 9}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"[\"n\" 4]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>16</span>","value":"16"}],"value":"[\"n_sq\" 16]"}],"value":"{\"n\" 4, \"n_sq\" 16}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"[\"n\" 5]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>25</span>","value":"25"}],"value":"[\"n_sq\" 25]"}],"value":"{\"n\" 5, \"n_sq\" 25}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"}],"value":"[\"n\" 6]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>36</span>","value":"36"}],"value":"[\"n_sq\" 36]"}],"value":"{\"n\" 6, \"n_sq\" 36}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}],"value":"[\"n\" 7]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>49</span>","value":"49"}],"value":"[\"n_sq\" 49]"}],"value":"{\"n\" 7, \"n_sq\" 49}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>8</span>","value":"8"}],"value":"[\"n\" 8]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>64</span>","value":"64"}],"value":"[\"n_sq\" 64]"}],"value":"{\"n\" 8, \"n_sq\" 64}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>9</span>","value":"9"}],"value":"[\"n\" 9]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>81</span>","value":"81"}],"value":"[\"n_sq\" 81]"}],"value":"{\"n\" 9, \"n_sq\" 81}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n&quot;</span>","value":"\"n\""},{"type":"html","content":"<span class='clj-unkown'>10</span>","value":"10"}],"value":"[\"n\" 10]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;n_sq&quot;</span>","value":"\"n_sq\""},{"type":"html","content":"<span class='clj-unkown'>100</span>","value":"100"}],"value":"[\"n_sq\" 100]"}],"value":"{\"n\" 10, \"n_sq\" 100}"}],"value":"({\"n\" 1, \"n_sq\" 1} {\"n\" 2, \"n_sq\" 4} {\"n\" 3, \"n_sq\" 9} {\"n\" 4, \"n_sq\" 16} {\"n\" 5, \"n_sq\" 25} {\"n\" 6, \"n_sq\" 36} {\"n\" 7, \"n_sq\" 49} {\"n\" 8, \"n_sq\" 64} {\"n\" 9, \"n_sq\" 81} {\"n\" 10, \"n_sq\" 100})"}
;; <=

;; @@
(let [conn  (nr/connect "https://jeff:b.I1nDfEQcsIBC.LqKgDLdDppNge9sq@hobby-mkdhejicdnflgbkeedhmhgdl.dbs.graphenedb.com:24780/db/data/")]
     (->> (cy/tquery conn "UNWIND range(1, 10) AS n RETURN n, n * n as n_sq")
          (map (juxt #(get % "n") #(get % "n_sq")))))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[1 1]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"[2 4]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-unkown'>9</span>","value":"9"}],"value":"[3 9]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-unkown'>16</span>","value":"16"}],"value":"[4 16]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-unkown'>25</span>","value":"25"}],"value":"[5 25]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-unkown'>36</span>","value":"36"}],"value":"[6 36]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-unkown'>49</span>","value":"49"}],"value":"[7 49]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-unkown'>64</span>","value":"64"}],"value":"[8 64]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-unkown'>81</span>","value":"81"}],"value":"[9 81]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-unkown'>100</span>","value":"100"}],"value":"[10 100]"}],"value":"([1 1] [2 4] [3 9] [4 16] [5 25] [6 36] [7 49] [8 64] [9 81] [10 100])"}
;; <=

;; @@

;; @@
