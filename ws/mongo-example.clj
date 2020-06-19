;; gorilla-repl.fileformat = 1

;; **
;;; # MongoDb Examples
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;; **

;; @@
(ns mongo-example
  (:require [gorilla-plot.core :as plot])
  (:use clojure.repl)
  (:require [clojure.string :as s])
  (:use clojure.pprint)
  (:use somnium.congomongo))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(mongo! :host "127.0.0.1" :db "mydb")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(databases)
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"html","content":"<span class='clj-unkown'>(&quot;local&quot; &quot;mydb&quot;)</span>","value":"(\"local\" \"mydb\")"}
=======
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;local&quot;</span>","value":"\"local\""},{"type":"html","content":"<span class='clj-string'>&quot;admin&quot;</span>","value":"\"admin\""}],"value":"(\"local\" \"admin\")"}
>>>>>>> Stashed changes
;; <=

;; @@
(collections)
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"html","content":"<span class='clj-unkown'>(&quot;system.indexes&quot; &quot;words&quot; &quot;words1&quot;)</span>","value":"(\"system.indexes\" \"words\" \"words1\")"}
=======
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
>>>>>>> Stashed changes
;; <=

;; @@
(defn lower [s] (.toLowerCase s))

(defn w2cf 
  [w] 
  (frequencies (sort (map #((comp keyword lower str) %) (seq w)))))

(defn mongo-find-matching-words
	  [w]
	  (map :word (fetch :words :where {:freq (w2cf w)})))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mongo-example/mongo-find-matching-words</span>","value":"#'mongo-example/mongo-find-matching-words"}
;; <=

;; @@
(time (mongo-find-matching-words "aeerst"))
;; @@
;; ->
<<<<<<< Updated upstream
;;; &quot;Elapsed time: 0.617885 msecs&quot;
=======
;;; &quot;Elapsed time: 0.282961 msecs&quot;
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;asteer&quot;</span>","value":"\"asteer\""},{"type":"html","content":"<span class='clj-string'>&quot;Easter&quot;</span>","value":"\"Easter\""},{"type":"html","content":"<span class='clj-string'>&quot;easter&quot;</span>","value":"\"easter\""},{"type":"html","content":"<span class='clj-string'>&quot;Eastre&quot;</span>","value":"\"Eastre\""},{"type":"html","content":"<span class='clj-string'>&quot;reseat&quot;</span>","value":"\"reseat\""},{"type":"html","content":"<span class='clj-string'>&quot;saeter&quot;</span>","value":"\"saeter\""},{"type":"html","content":"<span class='clj-string'>&quot;seater&quot;</span>","value":"\"seater\""},{"type":"html","content":"<span class='clj-string'>&quot;staree&quot;</span>","value":"\"staree\""},{"type":"html","content":"<span class='clj-string'>&quot;teaser&quot;</span>","value":"\"teaser\""}],"value":"(\"asteer\" \"Easter\" \"easter\" \"Eastre\" \"reseat\" \"saeter\" \"seater\" \"staree\" \"teaser\")"}
;; <=

;; @@
(fetch-count :words)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>234936</span>","value":"234936"}
;; <=

;; @@
(fetch-one :words)
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-unkown'>#&lt;ObjectId 543f5877e4b089993fc092a3&gt;</span>","value":"#<ObjectId 543f5877e4b089993fc092a3>"}],"value":"[:_id #<ObjectId 543f5877e4b089993fc092a3>]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:freq</span>","value":":freq"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[:a 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:e</span>","value":":e"},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"[:e 2]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:r</span>","value":":r"},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[:r 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:s</span>","value":":s"},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[:s 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:t</span>","value":":t"},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[:t 1]"}],"value":"{:a 1, :e 2, :r 1, :s 1, :t 1}"}],"value":"[:freq {:a 1, :e 2, :r 1, :s 1, :t 1}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:length</span>","value":":length"},{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"}],"value":"[:length 6]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:word</span>","value":":word"},{"type":"html","content":"<span class='clj-string'>&quot;reseat&quot;</span>","value":"\"reseat\""}],"value":"[:word \"reseat\"]"}],"value":"{:_id #<ObjectId 543f5877e4b089993fc092a3>, :freq {:a 1, :e 2, :r 1, :s 1, :t 1}, :length 6, :word \"reseat\"}"}],"value":"({:_id #<ObjectId 543f5877e4b089993fc092a3>, :freq {:a 1, :e 2, :r 1, :s 1, :t 1}, :length 6, :word \"reseat\"})"}
=======
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:freq</span>","value":":freq"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[:a 1]"}],"value":"{:a 1}"}],"value":"[:freq {:a 1}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:length</span>","value":":length"},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[:length 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:word</span>","value":":word"},{"type":"html","content":"<span class='clj-string'>&quot;A&quot;</span>","value":"\"A\""}],"value":"[:word \"A\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-unkown'>#object[org.bson.types.ObjectId 0x7cf8b388 &quot;58ae89a430b6e92f8e388da9&quot;]</span>","value":"#object[org.bson.types.ObjectId 0x7cf8b388 \"58ae89a430b6e92f8e388da9\"]"}],"value":"[:_id #object[org.bson.types.ObjectId 0x7cf8b388 \"58ae89a430b6e92f8e388da9\"]]"}],"value":"{:freq {:a 1}, :length 1, :word \"A\", :_id #object[org.bson.types.ObjectId 0x7cf8b388 \"58ae89a430b6e92f8e388da9\"]}"}
>>>>>>> Stashed changes
;; <=

;; @@
(pprint (sort (.split (System/getProperty "java.class.path") ":")))
;; @@
;; ->
<<<<<<< Updated upstream
;;; (&quot;/root/.m2/repository/args4j/args4j/2.0.16/args4j-2.0.16.jar&quot;
;;;  &quot;/root/.m2/repository/aysylu/loom/0.5.0/loom-0.5.0.jar&quot;
;;;  &quot;/root/.m2/repository/bouncycastle/bcmail-jdk14/138/bcmail-jdk14-138.jar&quot;
;;;  &quot;/root/.m2/repository/bouncycastle/bcprov-jdk14/138/bcprov-jdk14-138.jar&quot;
;;;  &quot;/root/.m2/repository/ch/qos/logback/logback-classic/1.1.2/logback-classic-1.1.2.jar&quot;
;;;  &quot;/root/.m2/repository/ch/qos/logback/logback-core/1.1.2/logback-core-1.1.2.jar&quot;
;;;  &quot;/root/.m2/repository/cheshire/cheshire/5.3.1/cheshire-5.3.1.jar&quot;
;;;  &quot;/root/.m2/repository/cider/cider-nrepl/0.7.0/cider-nrepl-0.7.0.jar&quot;
;;;  &quot;/root/.m2/repository/clatrix/clatrix/0.3.0/clatrix-0.3.0.jar&quot;
;;;  &quot;/root/.m2/repository/clj-blueprints2/clj-blueprints2/0.0.1/clj-blueprints2-0.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/clj-gremlin/clj-gremlin/0.0.3/clj-gremlin-0.0.3.jar&quot;
;;;  &quot;/root/.m2/repository/clj-http/clj-http/0.7.8/clj-http-0.7.8.jar&quot;
;;;  &quot;/root/.m2/repository/clj-time/clj-time/0.5.0/clj-time-0.5.0.jar&quot;
;;;  &quot;/root/.m2/repository/cljs-tooling/cljs-tooling/0.1.3/cljs-tooling-0.1.3.jar&quot;
;;;  &quot;/root/.m2/repository/clojure-complete/clojure-complete/0.2.3/clojure-complete-0.2.3.jar&quot;
;;;  &quot;/root/.m2/repository/clojureql/clojureql/1.0.4/clojureql-1.0.4.jar&quot;
;;;  &quot;/root/.m2/repository/clojurewerkz/neocons/2.0.1/neocons-2.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/clojurewerkz/support/0.19.0/support-0.19.0.jar&quot;
;;;  &quot;/root/.m2/repository/clojurewerkz/urly/2.0.0-alpha5/urly-2.0.0-alpha5.jar&quot;
;;;  &quot;/root/.m2/repository/clout/clout/1.2.0/clout-1.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/cn/guoyukun/jdbc/db2jcc/1.4.2/db2jcc-1.4.2.jar&quot;
;;;  &quot;/root/.m2/repository/cn/guoyukun/jdbc/db2jcc_license_cu/1.4.2/db2jcc_license_cu-1.4.2.jar&quot;
;;;  &quot;/root/.m2/repository/colt/colt/1.2.0/colt-1.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/ashafa/clutch/0.4.0/clutch-0.4.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/cemerick/piggieback/0.1.3/piggieback-0.1.3.jar&quot;
;;;  &quot;/root/.m2/repository/com/cemerick/url/0.0.6/url-0.0.6.jar&quot;
;;;  &quot;/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.3.1/jackson-core-2.3.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-smile/2.3.1/jackson-dataformat-smile-2.3.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/github/rwl/AMDJ/1.0.1/AMDJ-1.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/github/rwl/BTFJ/1.0.1/BTFJ-1.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/github/rwl/COLAMDJ/1.0.1/COLAMDJ-1.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/github/rwl/JKLU/1.0.0/JKLU-1.0.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar&quot;
;;;  &quot;/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/google/javascript/closure-compiler/v20130603/closure-compiler-v20130603.jar&quot;
;;;  &quot;/root/.m2/repository/com/google/protobuf/protobuf-java/2.4.1/protobuf-java-2.4.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/googlecode/netlib-java/netlib-java/0.9.3/netlib-java-0.9.3.jar&quot;
;;;  &quot;/root/.m2/repository/com/keminglabs/cljx/0.4.0/cljx-0.4.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/lowagie/itext/2.1.7/itext-2.1.7.jar&quot;
;;;  &quot;/root/.m2/repository/com/microsoft/sqljdbc4/3.0/sqljdbc4-3.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/mysql/connectorj/5.1.12/connectorj-5.1.12.jar&quot;
;;;  &quot;/root/.m2/repository/com/novemberain/monger/1.7.0-beta1/monger-1.7.0-beta1.jar&quot;
;;;  &quot;/root/.m2/repository/com/novemberain/validateur/1.5.0/validateur-1.5.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/rabbitmq/amqp-client/2.8.1/amqp-client-2.8.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/taoensso/carmine/2.7.0/carmine-2.7.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/taoensso/encore/1.7.1/encore-1.7.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/taoensso/nippy/2.6.3/nippy-2.6.3.jar&quot;
;;;  &quot;/root/.m2/repository/com/taoensso/timbre/3.2.1/timbre-3.2.1.jar&quot;
;;;  &quot;/root/.m2/repository/com/tinkerpop/blueprints/blueprints-core/2.2.0/blueprints-core-2.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/tinkerpop/gremlin/gremlin-java/2.2.0/gremlin-java-2.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/tinkerpop/pipes/2.2.0/pipes-2.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/com/uswitch/clj-soap/0.2.3/clj-soap-0.2.3.jar&quot;
;;;  &quot;/root/.m2/repository/com/vijaykiran/docjure/1.7.0/docjure-1.7.0.jar&quot;
;;;  &quot;/root/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar&quot;
;;;  &quot;/root/.m2/repository/commons-fileupload/commons-fileupload/1.3/commons-fileupload-1.3.jar&quot;
;;;  &quot;/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar&quot;
;;;  &quot;/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar&quot;
;;;  &quot;/root/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar&quot;
;;;  &quot;/root/.m2/repository/compliment/compliment/0.1.3/compliment-0.1.3.jar&quot;
;;;  &quot;/root/.m2/repository/compojure/compojure/1.1.8/compojure-1.1.8.jar&quot;
;;;  &quot;/root/.m2/repository/concurrent/concurrent/1.3.4/concurrent-1.3.4.jar&quot;
;;;  &quot;/root/.m2/repository/congomongo/congomongo/0.3.3/congomongo-0.3.3.jar&quot;
;;;  &quot;/root/.m2/repository/crouton/crouton/0.1.1/crouton-0.1.1.jar&quot;
;;;  &quot;/root/.m2/repository/de/kotka/lazymap/3.1.0/lazymap-3.1.0.jar&quot;
;;;  &quot;/root/.m2/repository/dom4j/dom4j/1.6.1/dom4j-1.6.1.jar&quot;
;;;  &quot;/root/.m2/repository/expresso/expresso/0.2.0/expresso-0.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/fr/grunwald/lazymap/3.1.0/lazymap-3.1.0.jar&quot;
;;;  &quot;/root/.m2/repository/gavagai/gavagai/0.3.1/gavagai-0.3.1.jar&quot;
;;;  &quot;/root/.m2/repository/gorilla-renderable/gorilla-renderable/1.0.0/gorilla-renderable-1.0.0.jar&quot;
;;;  &quot;/root/.m2/repository/gorilla-repl/gorilla-repl/0.3.3/gorilla-repl-0.3.3.jar&quot;
;;;  &quot;/root/.m2/repository/grimradical/clj-semver/0.2.0/clj-semver-0.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/hiccup/hiccup/1.0.5/hiccup-1.0.5.jar&quot;
;;;  &quot;/root/.m2/repository/http-kit/http-kit/2.1.18/http-kit-2.1.18.jar&quot;
;;;  &quot;/root/.m2/repository/incanter-gorilla/incanter-gorilla/0.1.0/incanter-gorilla-0.1.0.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-charts/1.5.4/incanter-charts-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-core/1.5.4/incanter-core-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-excel/1.5.4/incanter-excel-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-io/1.5.4/incanter-io-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-latex/1.5.4/incanter-latex-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-mongodb/1.5.4/incanter-mongodb-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-pdf/1.5.4/incanter-pdf-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-sql/1.5.4/incanter-sql-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-svg/1.5.4/incanter-svg-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter-zoo/1.5.4/incanter-zoo-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/incanter/1.5.4/incanter-1.5.4.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/jcommon/1.0.16/jcommon-1.0.16.jar&quot;
;;;  &quot;/root/.m2/repository/incanter/jfreechart/1.0.13-no-gnujaxp/jfreechart-1.0.13-no-gnujaxp.jar&quot;
;;;  &quot;/root/.m2/repository/instaparse/instaparse/1.2.2/instaparse-1.2.2.jar&quot;
;;;  &quot;/root/.m2/repository/io/aviso/pretty/0.1.10/pretty-0.1.10.jar&quot;
;;;  &quot;/root/.m2/repository/javax/servlet/servlet-api/2.5/servlet-api-2.5.jar&quot;
;;;  &quot;/root/.m2/repository/javax/ws/rs/jsr311-api/1.0/jsr311-api-1.0.jar&quot;
;;;  &quot;/root/.m2/repository/jaxen/jaxen/1.1.3/jaxen-1.1.3.jar&quot;
;;;  &quot;/root/.m2/repository/jline/jline/2.11/jline-2.11.jar&quot;
;;;  &quot;/root/.m2/repository/joda-time/joda-time/2.2/joda-time-2.2.jar&quot;
;;;  &quot;/root/.m2/repository/jonase/kibit/0.0.8/kibit-0.0.8.jar&quot;
;;;  &quot;/root/.m2/repository/junit/junit/4.10/junit-4.10.jar&quot;
;;;  &quot;/root/.m2/repository/lein-kibit/lein-kibit/0.0.8/lein-kibit-0.0.8.jar&quot;
;;;  &quot;/root/.m2/repository/loom-gorilla/loom-gorilla/0.1.0/loom-gorilla-0.1.0.jar&quot;
;;;  &quot;/root/.m2/repository/net/cgrand/parsley/0.9.1/parsley-0.9.1.jar&quot;
;;;  &quot;/root/.m2/repository/net/cgrand/regex/1.1.0/regex-1.1.0.jar&quot;
;;;  &quot;/root/.m2/repository/net/mikera/core.matrix/0.10.0/core.matrix-0.10.0.jar&quot;
;;;  &quot;/root/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar&quot;
;;;  &quot;/root/.m2/repository/net/sourceforge/csparsej/csparsej/1.1.1/csparsej-1.1.1.jar&quot;
;;;  &quot;/root/.m2/repository/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar&quot;
;;;  &quot;/root/.m2/repository/net/sourceforge/jplasma/core-lapack/0.1/core-lapack-0.1.jar&quot;
;;;  &quot;/root/.m2/repository/net/sourceforge/jplasma/jplasma/1.2.0/jplasma-1.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/net/sourceforge/jtransforms/jtransforms/2.4.0/jtransforms-2.4.0.jar&quot;
;;;  &quot;/root/.m2/repository/net/sourceforge/parallelcolt/optimization/1.0/optimization-1.0.jar&quot;
;;;  &quot;/root/.m2/repository/net/sourceforge/parallelcolt/parallelcolt/0.10.0/parallelcolt-0.10.0.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-adb/1.6.2/axis2-adb-1.6.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-kernel/1.6.2/axis2-kernel-1.6.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-transport-http/1.6.2/axis2-transport-http-1.6.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-transport-local/1.6.2/axis2-transport-local-1.6.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/commons/commons-pool2/2.2/commons-pool2-2.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-activation_1.1_spec/1.0.2/geronimo-activation_1.1_spec-1.0.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-javamail_1.4_spec/1.7.1/geronimo-javamail_1.4_spec-1.7.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-jta_1.1_spec/1.1/geronimo-jta_1.1_spec-1.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-stax-api_1.0_spec/1.0.1/geronimo-stax-api_1.0_spec-1.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-ws-metadata_2.0_spec/1.1.2/geronimo-ws-metadata_2.0_spec-1.1.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/httpcomponents/httpclient/4.3.1/httpclient-4.3.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/httpcomponents/httpcore/4.3/httpcore-4.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/httpcomponents/httpmime/4.3.1/httpmime-4.3.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/james/apache-mime4j-core/0.7.2/apache-mime4j-core-0.7.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/neethi/neethi/3.0.2/neethi-3.0.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/poi/poi-ooxml-schemas/3.9/poi-ooxml-schemas-3.9.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/poi/poi-ooxml/3.9/poi-ooxml-3.9.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/poi/poi/3.9/poi-3.9.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/woden/woden-api/1.0M9/woden-api-1.0M9.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/woden/woden-impl-commons/1.0M9/woden-impl-commons-1.0M9.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/woden/woden-impl-dom/1.0M9/woden-impl-dom-1.0M9.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/ws/commons/axiom/axiom-api/1.2.13/axiom-api-1.2.13.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/ws/commons/axiom/axiom-impl/1.2.13/axiom-impl-1.2.13.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/ws/commons/schema/XmlSchema/1.4.7/XmlSchema-1.4.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlbeans/xmlbeans/2.3.0/xmlbeans-2.3.0.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-awt-util/1.7/batik-awt-util-1.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-css/1.7/batik-css-1.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-dom/1.7/batik-dom-1.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-ext/1.7/batik-ext-1.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-svggen/1.7/batik-svggen-1.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-util/1.7/batik-util-1.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-xml/1.7/batik-xml-1.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/bouncycastle/bcmail-jdk14/1.38/bcmail-jdk14-1.38.jar&quot;
;;;  &quot;/root/.m2/repository/org/bouncycastle/bcprov-jdk14/1.38/bcprov-jdk14-1.38.jar&quot;
;;;  &quot;/root/.m2/repository/org/bouncycastle/bctsp-jdk14/1.38/bctsp-jdk14-1.38.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojars/trptcolin/sjacket/0.1.0.6/sjacket-0.1.0.6.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/clojure/1.5.1/clojure-1.5.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/clojurescript/0.0-2080/clojurescript-0.0-2080.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/core.cache/0.6.3/core.cache-0.6.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/core.incubator/0.1.1/core.incubator-0.1.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/core.logic/0.8.4/core.logic-0.8.4.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/core.match/0.2.0/core.match-0.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/core.memoize/0.5.6/core.memoize-0.5.6.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/core.unify/0.5.6/core.unify-0.5.6.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/data.codec/0.1.0/data.codec-0.1.0.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/data.json/0.2.5/data.json-0.2.5.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/data.priority-map/0.0.5/data.priority-map-0.0.5.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/data.xml/0.0.7/data.xml-0.0.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/google-closure-library-third-party/0.0-20130212-95c19e7f0f5f/google-closure-library-third-party-0.0-20130212-95c19e7f0f5f.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/google-closure-library/0.0-20130212-95c19e7f0f5f/google-closure-library-0.0-20130212-95c19e7f0f5f.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/java.classpath/0.2.0/java.classpath-0.2.0.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/java.jdbc/0.2.3/java.jdbc-0.2.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/math.combinatorics/0.0.3/math.combinatorics-0.0.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/tools.cli/0.2.2/tools.cli-0.2.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/tools.macro/0.1.0/tools.macro-0.1.0.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/tools.namespace/0.2.5/tools.namespace-0.2.5.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/tools.nrepl/0.2.6/tools.nrepl-0.2.6.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/tools.reader/0.8.1/tools.reader-0.8.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/clojure/tools.trace/0.7.8/tools.trace-0.7.8.jar&quot;
;;;  &quot;/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.8.5/jackson-core-asl-1.8.5.jar&quot;
;;;  &quot;/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.8.5/jackson-mapper-asl-1.8.5.jar&quot;
;;;  &quot;/root/.m2/repository/org/codehaus/jettison/jettison/1.3/jettison-1.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/codehaus/woodstox/wstx-asl/3.2.9/wstx-asl-3.2.9.jar&quot;
;;;  &quot;/root/.m2/repository/org/danlarkin/clojure-json/1.1/clojure-json-1.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/hamcrest/hamcrest-core/1.1/hamcrest-core-1.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/iq80/snappy/snappy/0.3/snappy-0.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/jblas/jblas/1.2.3/jblas-1.2.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/json/json/20090211/json-20090211.jar&quot;
;;;  &quot;/root/.m2/repository/org/jsoup/jsoup/1.7.1/jsoup-1.7.1.jar&quot;
;;;  &quot;/root/.m2/repository/org/mongodb/mongo-java-driver/2.11.2/mongo-java-driver-2.11.2.jar&quot;
;;;  &quot;/root/.m2/repository/org/mozilla/rhino/1.7R4/rhino-1.7R4.jar&quot;
;;;  &quot;/root/.m2/repository/org/scilab/forge/jlatexmath/0.9.6/jlatexmath-0.9.6.jar&quot;
;;;  &quot;/root/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar&quot;
;;;  &quot;/root/.m2/repository/org/tcrawley/dynapath/0.2.3/dynapath-0.2.3.jar&quot;
;;;  &quot;/root/.m2/repository/org/tukaani/xz/1.5/xz-1.5.jar&quot;
;;;  &quot;/root/.m2/repository/pathetic/pathetic/0.4.0/pathetic-0.4.0.jar&quot;
;;;  &quot;/root/.m2/repository/potemkin/potemkin/0.3.2/potemkin-0.3.2.jar&quot;
;;;  &quot;/root/.m2/repository/prismatic/plumbing/0.3.3/plumbing-0.3.3.jar&quot;
;;;  &quot;/root/.m2/repository/prismatic/schema/0.2.4/schema-0.2.4.jar&quot;
;;;  &quot;/root/.m2/repository/ragtime/ragtime.core/0.3.4/ragtime.core-0.3.4.jar&quot;
;;;  &quot;/root/.m2/repository/ring/ring-codec/1.0.0/ring-codec-1.0.0.jar&quot;
;;;  &quot;/root/.m2/repository/ring/ring-core/1.2.2/ring-core-1.2.2.jar&quot;
;;;  &quot;/root/.m2/repository/ring/ring-json/0.3.1/ring-json-0.3.1.jar&quot;
;;;  &quot;/root/.m2/repository/rplevy-draker/wabbitmq/0.3.0/wabbitmq-0.3.0.jar&quot;
;;;  &quot;/root/.m2/repository/slingshot/slingshot/0.10.3/slingshot-0.10.3.jar&quot;
;;;  &quot;/root/.m2/repository/stax/stax-api/1.0.1/stax-api-1.0.1.jar&quot;
;;;  &quot;/root/.m2/repository/swingrepl/swingrepl/1.3.0/swingrepl-1.3.0.jar&quot;
;;;  &quot;/root/.m2/repository/tigris/tigris/0.1.1/tigris-0.1.1.jar&quot;
;;;  &quot;/root/.m2/repository/watchtower/watchtower/0.1.1/watchtower-0.1.1.jar&quot;
;;;  &quot;/root/.m2/repository/wsdl4j/wsdl4j/1.6.2/wsdl4j-1.6.2.jar&quot;
;;;  &quot;/root/.m2/repository/xalan/xalan/2.6.0/xalan-2.6.0.jar&quot;
;;;  &quot;/root/.m2/repository/xml-apis/xml-apis-ext/1.3.04/xml-apis-ext-1.3.04.jar&quot;
;;;  &quot;/root/.m2/repository/xml-apis/xml-apis/1.0.b2/xml-apis-1.0.b2.jar&quot;
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/dev-resources&quot;
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/resources&quot;
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/src&quot;
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/target/base+system+user+dev/classes&quot;
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/test&quot;)
=======
;;; (&quot;C:\\Users\\Jeffrey\\.m2\\repository\\aysylu\\loom\\0.5.4\\loom-0.5.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\bouncycastle\\bcmail-jdk14\\138\\bcmail-jdk14-138.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\bouncycastle\\bcprov-jdk14\\138\\bcprov-jdk14-138.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ch\\qos\\logback\\logback-classic\\1.1.2\\logback-classic-1.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ch\\qos\\logback\\logback-core\\1.1.2\\logback-core-1.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cheshire\\cheshire\\5.3.1\\cheshire-5.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cider\\cider-nrepl\\0.10.2\\cider-nrepl-0.10.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clatrix\\clatrix\\0.3.0\\clatrix-0.3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-blueprints2\\clj-blueprints2\\0.0.1\\clj-blueprints2-0.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-gremlin\\clj-gremlin\\0.0.3\\clj-gremlin-0.0.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-http\\clj-http\\2.0.0\\clj-http-2.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-time\\clj-time\\0.4.4\\clj-time-0.4.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-tuple\\clj-tuple\\0.2.2\\clj-tuple-0.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojure-complete\\clojure-complete\\0.2.4\\clojure-complete-0.2.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojureql\\clojureql\\1.0.4\\clojureql-1.0.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojurewerkz\\neocons\\3.1.0\\neocons-3.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojurewerkz\\support\\1.1.0\\support-1.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clout\\clout\\1.2.0\\clout-1.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cn\\guoyukun\\jdbc\\db2jcc\\1.4.2\\db2jcc-1.4.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cn\\guoyukun\\jdbc\\db2jcc_license_cu\\1.4.2\\db2jcc_license_cu-1.4.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\colt\\colt\\1.2.0\\colt-1.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\ashafa\\clutch\\0.4.0\\clutch-0.4.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\cemerick\\url\\0.0.6\\url-0.0.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-core\\2.3.1\\jackson-core-2.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\fasterxml\\jackson\\dataformat\\jackson-dataformat-smile\\2.3.1\\jackson-dataformat-smile-2.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\AMDJ\\1.0.1\\AMDJ-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\BTFJ\\1.0.1\\BTFJ-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\COLAMDJ\\1.0.1\\COLAMDJ-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\JKLU\\1.0.0\\JKLU-1.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\googlecode\\netlib-java\\netlib-java\\0.9.3\\netlib-java-0.9.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\lowagie\\itext\\2.1.7\\itext-2.1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\microsoft\\sqljdbc4\\3.0\\sqljdbc4-3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\mysql\\connectorj\\5.1.12\\connectorj-5.1.12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\rabbitmq\\amqp-client\\2.8.1\\amqp-client-2.8.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\carmine\\2.12.2\\carmine-2.12.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\encore\\2.32.0\\encore-2.32.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\nippy\\2.10.0\\nippy-2.10.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\timbre\\4.2.1\\timbre-4.2.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\truss\\1.0.0\\truss-1.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\tinkerpop\\blueprints\\blueprints-core\\2.2.0\\blueprints-core-2.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\tinkerpop\\gremlin\\gremlin-java\\2.2.0\\gremlin-java-2.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\tinkerpop\\pipes\\2.2.0\\pipes-2.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\uswitch\\clj-soap\\0.2.3\\clj-soap-0.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\vijaykiran\\docjure\\1.7.0\\docjure-1.7.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-codec\\commons-codec\\1.10\\commons-codec-1.10.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-fileupload\\commons-fileupload\\1.3\\commons-fileupload-1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-httpclient\\commons-httpclient\\3.1\\commons-httpclient-3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-io\\commons-io\\2.4\\commons-io-2.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\compliment\\compliment\\0.2.7\\compliment-0.2.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\compojure\\compojure\\1.1.8\\compojure-1.1.8.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\concurrent\\concurrent\\1.3.4\\concurrent-1.3.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\congomongo\\congomongo\\0.3.3\\congomongo-0.3.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\de\\kotka\\lazymap\\3.1.0\\lazymap-3.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\defprecated\\defprecated\\0.1.3\\defprecated-0.1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\dom4j\\dom4j\\1.6.1\\dom4j-1.6.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\expresso\\expresso\\0.2.0\\expresso-0.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\fr\\grunwald\\lazymap\\3.1.0\\lazymap-3.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gavagai\\gavagai\\0.3.2\\gavagai-0.3.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gorilla-plot\\gorilla-plot\\0.1.4\\gorilla-plot-0.1.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gorilla-renderable\\gorilla-renderable\\2.0.0\\gorilla-renderable-2.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gorilla-repl\\gorilla-repl\\0.3.6\\gorilla-repl-0.3.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\grimradical\\clj-semver\\0.2.0\\clj-semver-0.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\hiccup\\hiccup\\1.0.5\\hiccup-1.0.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\http-kit\\http-kit\\2.1.18\\http-kit-2.1.18.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter-gorilla\\incanter-gorilla\\0.1.0\\incanter-gorilla-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-charts\\1.5.5\\incanter-charts-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-core\\1.5.5\\incanter-core-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-excel\\1.5.5\\incanter-excel-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-io\\1.5.5\\incanter-io-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-latex\\1.5.5\\incanter-latex-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-mongodb\\1.5.5\\incanter-mongodb-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-pdf\\1.5.5\\incanter-pdf-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-sql\\1.5.5\\incanter-sql-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-svg\\1.5.5\\incanter-svg-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-zoo\\1.5.5\\incanter-zoo-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter\\1.5.5\\incanter-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\jcommon\\1.0.16\\jcommon-1.0.16.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\jfreechart\\1.0.13-no-gnujaxp\\jfreechart-1.0.13-no-gnujaxp.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\instaparse\\instaparse\\1.2.2\\instaparse-1.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\io\\aviso\\pretty\\0.1.21\\pretty-0.1.21.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\javax\\servlet\\servlet-api\\2.5\\servlet-api-2.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\javax\\ws\\rs\\jsr311-api\\1.0\\jsr311-api-1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\jaxen\\jaxen\\1.1.3\\jaxen-1.1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\joda-time\\joda-time\\2.1\\joda-time-2.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\jonase\\kibit\\0.1.2\\kibit-0.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\junit\\junit\\4.8.2\\junit-4.8.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\lein-kibit\\lein-kibit\\0.1.2\\lein-kibit-0.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\loom-gorilla\\loom-gorilla\\0.1.0\\loom-gorilla-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\jpountz\\lz4\\lz4\\1.3\\lz4-1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\mikera\\core.matrix\\0.10.0\\core.matrix-0.10.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sf\\opencsv\\opencsv\\2.3\\opencsv-2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\csparsej\\csparsej\\1.1.1\\csparsej-1.1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\f2j\\arpack_combined_all\\0.1\\arpack_combined_all-0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\jplasma\\core-lapack\\0.1\\core-lapack-0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\jplasma\\jplasma\\1.2.0\\jplasma-1.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\jtransforms\\jtransforms\\2.4.0\\jtransforms-2.4.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\parallelcolt\\optimization\\1.0\\optimization-1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\parallelcolt\\parallelcolt\\0.10.1\\parallelcolt-0.10.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-adb\\1.6.2\\axis2-adb-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-kernel\\1.6.2\\axis2-kernel-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-transport-http\\1.6.2\\axis2-transport-http-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-transport-local\\1.6.2\\axis2-transport-local-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\commons\\commons-pool2\\2.4.2\\commons-pool2-2.4.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-activation_1.1_spec\\1.0.2\\geronimo-activation_1.1_spec-1.0.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-javamail_1.4_spec\\1.7.1\\geronimo-javamail_1.4_spec-1.7.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-jta_1.1_spec\\1.1\\geronimo-jta_1.1_spec-1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-stax-api_1.0_spec\\1.0.1\\geronimo-stax-api_1.0_spec-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-ws-metadata_2.0_spec\\1.1.2\\geronimo-ws-metadata_2.0_spec-1.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\httpcomponents\\httpclient\\4.5\\httpclient-4.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\httpcomponents\\httpcore\\4.4.1\\httpcore-4.4.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\httpcomponents\\httpmime\\4.5\\httpmime-4.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\james\\apache-mime4j-core\\0.7.2\\apache-mime4j-core-0.7.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\neethi\\neethi\\3.0.2\\neethi-3.0.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\poi\\poi-ooxml-schemas\\3.9\\poi-ooxml-schemas-3.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\poi\\poi-ooxml\\3.9\\poi-ooxml-3.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\poi\\poi\\3.9\\poi-3.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\woden\\woden-api\\1.0M9\\woden-api-1.0M9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\woden\\woden-impl-commons\\1.0M9\\woden-impl-commons-1.0M9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\woden\\woden-impl-dom\\1.0M9\\woden-impl-dom-1.0M9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\ws\\commons\\axiom\\axiom-api\\1.2.13\\axiom-api-1.2.13.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\ws\\commons\\axiom\\axiom-impl\\1.2.13\\axiom-impl-1.2.13.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\ws\\commons\\schema\\XmlSchema\\1.4.7\\XmlSchema-1.4.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlbeans\\xmlbeans\\2.3.0\\xmlbeans-2.3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-awt-util\\1.7\\batik-awt-util-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-css\\1.7\\batik-css-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-dom\\1.7\\batik-dom-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-ext\\1.7\\batik-ext-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-svggen\\1.7\\batik-svggen-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-util\\1.7\\batik-util-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-xml\\1.7\\batik-xml-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\bouncycastle\\bcmail-jdk14\\1.38\\bcmail-jdk14-1.38.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\bouncycastle\\bcprov-jdk14\\1.38\\bcprov-jdk14-1.38.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\bouncycastle\\bctsp-jdk14\\1.38\\bctsp-jdk14-1.38.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\clojure\\1.7.0\\clojure-1.7.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.cache\\0.6.3\\core.cache-0.6.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.incubator\\0.1.1\\core.incubator-0.1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.logic\\0.8.4\\core.logic-0.8.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.match\\0.2.2\\core.match-0.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.memoize\\0.5.6\\core.memoize-0.5.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.unify\\0.5.6\\core.unify-0.5.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.codec\\0.1.0\\data.codec-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.json\\0.2.6\\data.json-0.2.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.priority-map\\0.0.5\\data.priority-map-0.0.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.xml\\0.0.8\\data.xml-0.0.8.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\java.jdbc\\0.2.3\\java.jdbc-0.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\math.combinatorics\\0.0.4\\math.combinatorics-0.0.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.analyzer.jvm\\0.1.0-beta12\\tools.analyzer.jvm-0.1.0-beta12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.analyzer\\0.1.0-beta12\\tools.analyzer-0.1.0-beta12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.cli\\0.3.1\\tools.cli-0.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.macro\\0.1.0\\tools.macro-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.nrepl\\0.2.12\\tools.nrepl-0.2.12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.reader\\0.10.0\\tools.reader-0.10.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\jackson\\jackson-core-asl\\1.8.5\\jackson-core-asl-1.8.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\jackson\\jackson-mapper-asl\\1.8.5\\jackson-mapper-asl-1.8.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\jettison\\jettison\\1.3\\jettison-1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\woodstox\\wstx-asl\\3.2.9\\wstx-asl-3.2.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\danlarkin\\clojure-json\\1.1\\clojure-json-1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\iq80\\snappy\\snappy\\0.4\\snappy-0.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\jblas\\jblas\\1.2.3\\jblas-1.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\mongodb\\mongo-java-driver\\2.9.3\\mongo-java-driver-2.9.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\ow2\\asm\\asm-all\\4.1\\asm-all-4.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\scilab\\forge\\jlatexmath\\0.9.6\\jlatexmath-0.9.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.7.7\\slf4j-api-1.7.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\tcrawley\\dynapath\\0.2.3\\dynapath-0.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\tukaani\\xz\\1.5\\xz-1.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\pathetic\\pathetic\\0.4.0\\pathetic-0.4.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\potemkin\\potemkin\\0.4.1\\potemkin-0.4.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\prismatic\\plumbing\\0.5.2\\plumbing-0.5.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\prismatic\\schema\\1.0.1\\schema-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\proto-repl\\proto-repl\\0.1.2\\proto-repl-0.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\riddley\\riddley\\0.1.10\\riddley-0.1.10.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ring\\ring-codec\\1.0.0\\ring-codec-1.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ring\\ring-core\\1.2.2\\ring-core-1.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ring\\ring-json\\0.3.1\\ring-json-0.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\rplevy-draker\\wabbitmq\\0.3.0\\wabbitmq-0.3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\slingshot\\slingshot\\0.12.2\\slingshot-0.12.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\stax\\stax-api\\1.0.1\\stax-api-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\tigris\\tigris\\0.1.1\\tigris-0.1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\wsdl4j\\wsdl4j\\1.6.2\\wsdl4j-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\xalan\\xalan\\2.6.0\\xalan-2.6.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\xml-apis\\xml-apis-ext\\1.3.04\\xml-apis-ext-1.3.04.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\xml-apis\\xml-apis\\1.0.b2\\xml-apis-1.0.b2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\dev-resources&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\resources&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\src&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\target\\base+system+user+dev\\classes&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\test&quot;)
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(println (slurp "project.clj"))
;; @@
;; ->
<<<<<<< Updated upstream
;;; (defproject gorilla-test &quot;0.1.0-SNAPSHOT&quot;
;;;   :description &quot;A test project for the Gorilla REPL.&quot;
;;;   :dependencies [[org.clojure/clojure &quot;1.5.1&quot;]
;;;                  [com.vijaykiran/docjure &quot;1.7.0&quot;]
;;;                  [com.novemberain/monger &quot;1.7.0-beta1&quot;]
;;;                  [incanter &quot;1.5.4&quot;]
;;;                  [org.clojure/core.match &quot;0.2.0&quot;]
;;;                  [org.clojure/core.unify &quot;0.5.6&quot;]
;;;                  [clojurewerkz/neocons &quot;2.0.1&quot;]
;;;                  [clj-gremlin &quot;0.0.3&quot;]
;;;                  [clj-blueprints2 &quot;0.0.1&quot; :exclusions [com.tinkerpop.blueprints/blueprints-core]]
;;;                  [gavagai &quot;0.3.1&quot;]
;;;                  [prismatic/plumbing &quot;0.3.3&quot;]
;;;                  [clojureql &quot;1.0.4&quot;]
;;;                  [lein-kibit &quot;0.0.8&quot;]
;;;                  [rplevy-draker/wabbitmq &quot;0.3.0&quot; :exclusions [org.clojure/clojure]]
;;;                  [com.mysql/connectorj &quot;5.1.12&quot;]
;;;                  [hiccup &quot;1.0.5&quot;]
;;;                  [expresso &quot;0.2.0&quot;]
;;;                  [aysylu/loom &quot;0.5.0&quot;]
;;;                  [loom-gorilla &quot;0.1.0&quot;]
;;;                  [org.clojure/data.xml &quot;0.0.7&quot;]
;;;                  [incanter-gorilla &quot;0.1.0&quot;]
;;;                  [gorilla-renderable &quot;1.0.0&quot;]
;;;                  [com.microsoft/sqljdbc4 &quot;3.0&quot;]
;;; 	         [cn.guoyukun.jdbc/db2jcc &quot;1.4.2&quot;]
;;; 		 [cn.guoyukun.jdbc/db2jcc_license_cu &quot;1.4.2&quot;]
;;;                  [com.taoensso/carmine &quot;2.7.0&quot; :exclusions [org.clojure/clojure]]
;;;                  [com.ashafa/clutch &quot;0.4.0&quot;]
;;;                  [com.uswitch/clj-soap &quot;0.2.3&quot;]]
;;;   :main ^:skip-aot gorilla-test.core
;;;   :target-path &quot;target/%s&quot;
;;;   :plugins [[lein-gorilla &quot;0.3.3&quot;]
;;;             [lein-localrepo &quot;0.3&quot;]]
;;;   :profiles {:uberjar {:aot :all}})
;;; 
=======
;;; (defproject gorilla-test &quot;0.1.0-SNAPSHOT&quot;
;;;   :description &quot;A test project for the Gorilla REPL.&quot;
;;;   :dependencies [[org.clojure/clojure &quot;1.7.0&quot;]
;;;                  [com.vijaykiran/docjure &quot;1.7.0&quot;]
;;;                  [org.clojure/core.match &quot;0.2.2&quot;]
;;;                  [org.clojure/core.unify &quot;0.5.6&quot;]
;;;                  [clojurewerkz/neocons &quot;3.1.0&quot;]
;;;                  [clj-gremlin &quot;0.0.3&quot;]
;;;                  [clj-blueprints2 &quot;0.0.1&quot; :exclusions [com.tinkerpop.blueprints/blueprints-core]]
;;;                  [gavagai &quot;0.3.2&quot;]
;;;                  [prismatic/plumbing &quot;0.5.2&quot;]
;;;                  [clojureql &quot;1.0.4&quot;]
;;;                  [lein-kibit &quot;0.1.2&quot;]
;;;                  [rplevy-draker/wabbitmq &quot;0.3.0&quot; :exclusions [org.clojure/clojure]]
;;;                  [com.mysql/connectorj &quot;5.1.12&quot;]
;;;                  [hiccup &quot;1.0.5&quot;]
;;;                  [expresso &quot;0.2.0&quot;]
;;;                  [aysylu/loom &quot;0.5.4&quot;]
;;;                  [loom-gorilla &quot;0.1.0&quot;]
;;;                  [org.clojure/data.xml &quot;0.0.8&quot;]
;;;                  [incanter-gorilla &quot;0.1.0&quot;]
;;;                  [gorilla-renderable &quot;2.0.0&quot;]
;;;                  [com.microsoft/sqljdbc4 &quot;3.0&quot;]
;;;                  [cn.guoyukun.jdbc/db2jcc &quot;1.4.2&quot;]
;;;                  [cn.guoyukun.jdbc/db2jcc_license_cu &quot;1.4.2&quot;]
;;;                  [com.taoensso/carmine &quot;2.12.2&quot; :exclusions [org.clojure/clojure]]
;;;                  [com.ashafa/clutch &quot;0.4.0&quot;]
;;;                  [com.uswitch/clj-soap &quot;0.2.3&quot;]
;;;                  [proto-repl &quot;0.1.2&quot;]]
;;;   :main ^:skip-aot gorilla-test.core
;;;   :target-path &quot;target/%s&quot;
;;;   :plugins [[lein-gorilla &quot;0.3.6&quot;]
;;;             [lein-localrepo &quot;0.5.3&quot;]]
;;;   :profiles {:uberjar {:aot :all}})
;;; 
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def words-file (slurp "data/words"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mongo-example/words-file</span>","value":"#'mongo-example/words-file"}
;; <=

;; @@
<<<<<<< Updated upstream
(def words (s/split words-file #"\n"))
=======
(def words (s/split words-file #"\r\n"))
(count words)
>>>>>>> Stashed changes
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>234936</span>","value":"234936"}
;; <=

;; @@
(def vowels #{\a \A \e \E \i \I \o \O \u \U})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mongo-example/vowels</span>","value":"#'mongo-example/vowels"}
;; <=

;; @@
(defn filter-vowels 
  [w] 
  (apply str 
         (filter vowels w)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mongo-example/filter-vowels</span>","value":"#'mongo-example/filter-vowels"}
;; <=

;; @@
(defn remove-vowels 
  [w] 
  (apply str 
         (remove vowels w)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mongo-example/remove-vowels</span>","value":"#'mongo-example/remove-vowels"}
;; <=

;; @@
(count (mass-insert! :words1 
                     (map #(assoc {} 
                                  :word % 
				                  :length (count %)
                                  :vowels (filter-vowels %)
                                  :vcount (count (filter-vowels %))
                                  :consonants (remove-vowels %)
                                  :ccount (count (remove-vowels %))
				                  :freq (w2cf %)
                                  :vfreq (w2cf (filter-vowels %))
                                  :cfreq (w2cf (remove-vowels %)))
				          (take 32000
                                (drop (fetch-count :words1) 
                                      words)))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>234936</span>","value":"234936"}
;; <=

;; @@
(fetch-count :words1)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>234936</span>","value":"234936"}
;; <=

;; @@
(fetch-count :words)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>234936</span>","value":"234936"}
;; <=

;; @@
(drop-coll! :words)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir somnium.congomongo)
;; @@
;; ->
;;; StringNamed
;;; add-index!
;;; aggregate
;;; authenticate
;;; calculate-query-options
;;; close-connection
;;; collection-exists?
;;; collections
;;; command
;;; connection?
;;; create-collection!
;;; databases
;;; db-ref
;;; db-ref?
;;; destroy!
;;; destroy-file!
;;; distinct-values
;;; drop-all-indexes!
;;; drop-coll!
;;; drop-database!
;;; drop-index!
;;; fetch
;;; fetch-and-modify
;;; fetch-by-id
;;; fetch-by-ids
;;; fetch-count
;;; fetch-files
;;; fetch-one
;;; fetch-one-file
;;; get-coll
;;; get-db
;;; get-gridfs
;;; get-indexes
;;; get-timestamp
;;; group
;;; insert!
;;; insert-file!
;;; make-connection
;;; map-reduce
;;; mass-insert!
;;; mongo!
;;; mongo-options
;;; named
;;; object-id
;;; opt!
;;; query-option-map
;;; server-eval
;;; set-connection!
;;; set-database!
;;; set-write-concern
;;; stream-from
;;; update!
;;; with-db
;;; with-mongo
;;; with-ref-fetching
;;; write-concern-map
;;; write-file-to
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc fetch)
;; @@
;; ->
;;; -------------------------
;;; somnium.congomongo/fetch
;;; ([collection :where :only :limit :skip :as :from :one? :count? :sort :options])
;;;   Fetches objects from a collection.
;;;    Note that MongoDB always adds the _id and _ns
;;;    fields to objects returned from the database.
;;;    Optional arguments include
;;;    :where   -&gt; takes a query map
;;;    :only    -&gt; takes an array of keys to retrieve
;;;    :as      -&gt; what to return, defaults to :clojure, can also be :json or :mongo
;;;    :from    -&gt; argument type, same options as above
;;;    :skip    -&gt; number of records to skip
;;;    :limit   -&gt; number of records to return
;;;    :one?    -&gt; defaults to false, use fetch-one as a shortcut
;;;    :count?  -&gt; defaults to false, use fetch-count as a shortcut
;;;    :sort    -&gt; sort the results by a specific key
;;;    :options -&gt; query options [:tailable :slaveok :oplogreplay :notimeout :awaitdata]
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(pprint (fetch :words1 :where {:word "Aaron"}))
;; @@
;; ->
;;; ({:_id
;;;   #object[org.bson.types.ObjectId 0x17353302 &quot;58ae8a2030b6e92f8e3c236a&quot;],
;;;   :freq {:r 1, :o 1, :n 1, :a 2},
;;;   :vcount 3,
;;;   :vfreq {:o 1, :a 2},
;;;   :vowels &quot;Aao&quot;,
;;;   :word &quot;Aaron&quot;,
;;;   :length 5,
;;;   :ccount 2,
;;;   :consonants &quot;rn&quot;,
<<<<<<< Updated upstream
;;;   :vcount 3,
;;;   :vfreq {:a 2, :o 1},
;;;   :_id #&lt;ObjectId 554fa361e4b0f06476478f54&gt;})
=======
;;;   :cfreq {:r 1, :n 1}})
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn mongo-find-matching-words1
	  [w]
	  (map :word (fetch :words1 :where {:freq (w2cf w)})))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mongo-example/mongo-find-matching-words1</span>","value":"#'mongo-example/mongo-find-matching-words1"}
;; <=

;; @@
(time (mongo-find-matching-words1 "aeerst"))
;; @@
;; ->
<<<<<<< Updated upstream
;;; &quot;Elapsed time: 0.362408 msecs&quot;
=======
;;; &quot;Elapsed time: 0.33259 msecs&quot;
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;asteer&quot;</span>","value":"\"asteer\""},{"type":"html","content":"<span class='clj-string'>&quot;Easter&quot;</span>","value":"\"Easter\""},{"type":"html","content":"<span class='clj-string'>&quot;easter&quot;</span>","value":"\"easter\""},{"type":"html","content":"<span class='clj-string'>&quot;Eastre&quot;</span>","value":"\"Eastre\""},{"type":"html","content":"<span class='clj-string'>&quot;reseat&quot;</span>","value":"\"reseat\""},{"type":"html","content":"<span class='clj-string'>&quot;saeter&quot;</span>","value":"\"saeter\""},{"type":"html","content":"<span class='clj-string'>&quot;seater&quot;</span>","value":"\"seater\""},{"type":"html","content":"<span class='clj-string'>&quot;staree&quot;</span>","value":"\"staree\""},{"type":"html","content":"<span class='clj-string'>&quot;teaser&quot;</span>","value":"\"teaser\""}],"value":"(\"asteer\" \"Easter\" \"easter\" \"Eastre\" \"reseat\" \"saeter\" \"seater\" \"staree\" \"teaser\")"}
;; <=

;; @@
(pprint (fetch :words1 :where {:word "seater"}))
;; @@
;; ->
;;; ({:_id
;;;   #object[org.bson.types.ObjectId 0x7c19dcc2 &quot;58ae8a2230b6e92f8e3ed1f9&quot;],
;;;   :freq {:t 1, :s 1, :r 1, :e 2, :a 1},
;;;   :vcount 3,
;;;   :vfreq {:e 2, :a 1},
;;;   :vowels &quot;eae&quot;,
;;;   :word &quot;seater&quot;,
;;;   :length 6,
;;;   :ccount 3,
;;;   :consonants &quot;str&quot;,
;;;   :cfreq {:t 1, :s 1, :r 1}})
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(pprint (fetch :words1 :where {:vowels "ee" :consonants "sn"}))
;; @@
;; ->
;;; ({:_id
;;;   #object[org.bson.types.ObjectId 0x7ae70d36 &quot;58ae8a2030b6e92f8e3d1fa3&quot;],
;;;   :freq {:s 1, :n 1, :e 2},
;;;   :vcount 2,
;;;   :vfreq {:e 2},
;;;   :vowels &quot;ee&quot;,
;;;   :word &quot;esne&quot;,
;;;   :length 4,
;;;   :ccount 2,
;;;   :consonants &quot;sn&quot;,
;;;   :cfreq {:s 1, :n 1}}
;;;  {:_id
;;;   #object[org.bson.types.ObjectId 0x38ffede6 &quot;58ae8a2230b6e92f8e3ed34c&quot;],
;;;   :freq {:s 1, :n 1, :e 2},
;;;   :vcount 2,
;;;   :vfreq {:e 2},
;;;   :vowels &quot;ee&quot;,
;;;   :word &quot;seen&quot;,
;;;   :length 4,
;;;   :ccount 2,
;;;   :consonants &quot;sn&quot;,
;;;   :cfreq {:s 1, :n 1}}
;;;  {:_id
;;;   #object[org.bson.types.ObjectId 0x14e3b253 &quot;58ae8a2230b6e92f8e3eee9d&quot;],
;;;   :freq {:s 1, :n 1, :e 2},
;;;   :vcount 2,
;;;   :vfreq {:e 2},
;;;   :vowels &quot;ee&quot;,
;;;   :word &quot;snee&quot;,
;;;   :length 4,
;;;   :ccount 2,
;;;   :consonants &quot;sn&quot;,
;;;   :cfreq {:s 1, :n 1}})
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(fetch :words :where {:word "a"})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[],"value":"()"}
;; <=

;; @@

;; @@
