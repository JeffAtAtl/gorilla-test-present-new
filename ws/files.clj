;; gorilla-repl.fileformat = 1

;; **
;;; # Files
;;; 
;;; Examples of file and spreadsheet manipulation.
;; **

;; @@
(ns files
  (:use gorilla-plot.core)
  (:use gorilla-repl.table)
  (:use dk.ative.docjure.spreadsheet)
<<<<<<< Updated upstream
  (:use clojure.pprint)
  (:use clojure.repl))
=======
  (:use clojure.repl)
  (:use clojure.data.json)
  (:use new.numbers))
>>>>>>> Stashed changes
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def ws (java.io.File. "ws"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;files/ws</span>","value":"#'files/ws"}
;; <=

;; @@
(seq (.list ws))
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;redis-example.clj&quot;</span>","value":"\"redis-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;couchdb-example.clj&quot;</span>","value":"\"couchdb-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;mongo-example.clj&quot;</span>","value":"\"mongo-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;graph-examples.clj&quot;</span>","value":"\"graph-examples.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;central-limit.clj&quot;</span>","value":"\"central-limit.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;test.clj&quot;</span>","value":"\"test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;loom-test.clj&quot;</span>","value":"\"loom-test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;new-render.clj&quot;</span>","value":"\"new-render.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;matrix-form-test.clj&quot;</span>","value":"\"matrix-form-test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;files.clj&quot;</span>","value":"\"files.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;words.clj&quot;</span>","value":"\"words.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;second.clj&quot;</span>","value":"\"second.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;introduction.clj&quot;</span>","value":"\"introduction.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;hiccup-test.clj&quot;</span>","value":"\"hiccup-test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;clock-demo.clj&quot;</span>","value":"\"clock-demo.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;expression-render.clj&quot;</span>","value":"\"expression-render.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;first.clj&quot;</span>","value":"\"first.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;scanmaster.clj&quot;</span>","value":"\"scanmaster.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;incanter.clj&quot;</span>","value":"\"incanter.clj\""}],"value":"(\"redis-example.clj\" \"couchdb-example.clj\" \"mongo-example.clj\" \"graph-examples.clj\" \"central-limit.clj\" \"test.clj\" \"loom-test.clj\" \"new-render.clj\" \"matrix-form-test.clj\" \"files.clj\" \"words.clj\" \"second.clj\" \"introduction.clj\" \"hiccup-test.clj\" \"clock-demo.clj\" \"expression-render.clj\" \"first.clj\" \"scanmaster.clj\" \"incanter.clj\")"}
=======
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;expression-render.clj&quot;</span>","value":"\"expression-render.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;central-limit.clj&quot;</span>","value":"\"central-limit.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;second.clj&quot;</span>","value":"\"second.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;specter-example.clj&quot;</span>","value":"\"specter-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;rethinkdb-examples.clj&quot;</span>","value":"\"rethinkdb-examples.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;arangodb-examples.clj&quot;</span>","value":"\"arangodb-examples.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;loom-test.clj&quot;</span>","value":"\"loom-test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;couchdb-example.clj&quot;</span>","value":"\"couchdb-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;words.clj&quot;</span>","value":"\"words.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;hiccup-test.clj&quot;</span>","value":"\"hiccup-test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;rabbitmq-examples.clj&quot;</span>","value":"\"rabbitmq-examples.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;files.clj&quot;</span>","value":"\"files.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;clock-demo.clj&quot;</span>","value":"\"clock-demo.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;scanmaster.clj&quot;</span>","value":"\"scanmaster.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;incanter-example.clj&quot;</span>","value":"\"incanter-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;neocons-ex.clj&quot;</span>","value":"\"neocons-ex.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;first.clj&quot;</span>","value":"\"first.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;unified-update-model.clj&quot;</span>","value":"\"unified-update-model.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;graph-examples.clj&quot;</span>","value":"\"graph-examples.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;sicp-1.clj&quot;</span>","value":"\"sicp-1.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;abrade-ex.clj&quot;</span>","value":"\"abrade-ex.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;mongo-example2.clj&quot;</span>","value":"\"mongo-example2.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;elastisch-examples.clj&quot;</span>","value":"\"elastisch-examples.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;mysql-example.clj&quot;</span>","value":"\"mysql-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;matrix-form-test.clj&quot;</span>","value":"\"matrix-form-test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;introduction.clj&quot;</span>","value":"\"introduction.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;new-render.clj&quot;</span>","value":"\"new-render.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;mongo-example.clj&quot;</span>","value":"\"mongo-example.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;test.clj&quot;</span>","value":"\"test.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;redis-example.clj&quot;</span>","value":"\"redis-example.clj\""}],"value":"(\"expression-render.clj\" \"central-limit.clj\" \"second.clj\" \"specter-example.clj\" \"rethinkdb-examples.clj\" \"arangodb-examples.clj\" \"loom-test.clj\" \"couchdb-example.clj\" \"words.clj\" \"hiccup-test.clj\" \"rabbitmq-examples.clj\" \"files.clj\" \"clock-demo.clj\" \"scanmaster.clj\" \"incanter-example.clj\" \"neocons-ex.clj\" \"first.clj\" \"unified-update-model.clj\" \"graph-examples.clj\" \"sicp-1.clj\" \"abrade-ex.clj\" \"mongo-example2.clj\" \"elastisch-examples.clj\" \"mysql-example.clj\" \"matrix-form-test.clj\" \"introduction.clj\" \"new-render.clj\" \"mongo-example.clj\" \"test.clj\" \"redis-example.clj\")"}
>>>>>>> Stashed changes
;; <=

;; @@
(def wd (java.io.File. "."))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;files/wd</span>","value":"#'files/wd"}
;; <=

;; @@
(seq (.list wd))
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;README.md&quot;</span>","value":"\"README.md\""},{"type":"html","content":"<span class='clj-string'>&quot;data&quot;</span>","value":"\"data\""},{"type":"html","content":"<span class='clj-string'>&quot;.lein-repl-history&quot;</span>","value":"\".lein-repl-history\""},{"type":"html","content":"<span class='clj-string'>&quot;~$spreadsheet.xlsx&quot;</span>","value":"\"~$spreadsheet.xlsx\""},{"type":"html","content":"<span class='clj-string'>&quot;.nrepl-port&quot;</span>","value":"\".nrepl-port\""},{"type":"html","content":"<span class='clj-string'>&quot;test.xlsx&quot;</span>","value":"\"test.xlsx\""},{"type":"html","content":"<span class='clj-string'>&quot;project.clj&quot;</span>","value":"\"project.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;leinGorilla033.bat&quot;</span>","value":"\"leinGorilla033.bat\""},{"type":"html","content":"<span class='clj-string'>&quot;hs_err_pid30266.log&quot;</span>","value":"\"hs_err_pid30266.log\""},{"type":"html","content":"<span class='clj-string'>&quot;src&quot;</span>","value":"\"src\""},{"type":"html","content":"<span class='clj-string'>&quot;ws&quot;</span>","value":"\"ws\""},{"type":"html","content":"<span class='clj-string'>&quot;.gitignore&quot;</span>","value":"\".gitignore\""},{"type":"html","content":"<span class='clj-string'>&quot;target&quot;</span>","value":"\"target\""},{"type":"html","content":"<span class='clj-string'>&quot;LICENCE.txt&quot;</span>","value":"\"LICENCE.txt\""},{"type":"html","content":"<span class='clj-string'>&quot;.gorilla-port&quot;</span>","value":"\".gorilla-port\""},{"type":"html","content":"<span class='clj-string'>&quot;spreadsheet.xlsx&quot;</span>","value":"\"spreadsheet.xlsx\""}],"value":"(\"README.md\" \"data\" \".lein-repl-history\" \"~$spreadsheet.xlsx\" \".nrepl-port\" \"test.xlsx\" \"project.clj\" \"leinGorilla033.bat\" \"hs_err_pid30266.log\" \"src\" \"ws\" \".gitignore\" \"target\" \"LICENCE.txt\" \".gorilla-port\" \"spreadsheet.xlsx\")"}
=======
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;data&quot;</span>","value":"\"data\""},{"type":"html","content":"<span class='clj-string'>&quot;test.xlsx&quot;</span>","value":"\"test.xlsx\""},{"type":"html","content":"<span class='clj-string'>&quot;target&quot;</span>","value":"\"target\""},{"type":"html","content":"<span class='clj-string'>&quot;README.md&quot;</span>","value":"\"README.md\""},{"type":"html","content":"<span class='clj-string'>&quot;spreadsheet.xlsx&quot;</span>","value":"\"spreadsheet.xlsx\""},{"type":"html","content":"<span class='clj-string'>&quot;.gitignore&quot;</span>","value":"\".gitignore\""},{"type":"html","content":"<span class='clj-string'>&quot;src&quot;</span>","value":"\"src\""},{"type":"html","content":"<span class='clj-string'>&quot;project.clj&quot;</span>","value":"\"project.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;.git&quot;</span>","value":"\".git\""},{"type":"html","content":"<span class='clj-string'>&quot;ws&quot;</span>","value":"\"ws\""},{"type":"html","content":"<span class='clj-string'>&quot;.gorilla-port&quot;</span>","value":"\".gorilla-port\""},{"type":"html","content":"<span class='clj-string'>&quot;LICENCE.txt&quot;</span>","value":"\"LICENCE.txt\""},{"type":"html","content":"<span class='clj-string'>&quot;test.txt&quot;</span>","value":"\"test.txt\""},{"type":"html","content":"<span class='clj-string'>&quot;resources&quot;</span>","value":"\"resources\""},{"type":"html","content":"<span class='clj-string'>&quot;.nrepl-port&quot;</span>","value":"\".nrepl-port\""}],"value":"(\"data\" \"test.xlsx\" \"target\" \"README.md\" \"spreadsheet.xlsx\" \".gitignore\" \"src\" \"project.clj\" \".git\" \"ws\" \".gorilla-port\" \"LICENCE.txt\" \"test.txt\" \"resources\" \".nrepl-port\")"}
;; <=

;; @@
(slurp ".nrepl-port")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;38669&quot;</span>","value":"\"38669\""}
;; <=

;; @@
(doc ..)
;; @@
;; ->
;;; -------------------------
;;; clojure.core/..
;;; ([x form] [x form &amp; more])
;;; Macro
;;;   form =&gt; fieldName-symbol or (instanceMethodName-symbol args*)
;;; 
;;;   Expands into a member access (.) of the first member on the first
;;;   argument, followed by the next member on the result, etc. For
;;;   instance:
;;; 
;;;   (.. System (getProperties) (get &quot;os.name&quot;))
;;; 
;;;   expands to:
;;; 
;;;   (. (. System (getProperties)) (get &quot;os.name&quot;))
;;; 
;;;   but is easier to write, read, and understand.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(->> (file-seq wd)
     (filter #(.. % getName (endsWith ".clj")))
     (map #(.getCanonicalPath %))
     pprint)
;; @@
;; ->
;;; [&quot;\/home\/jtcummi\/gorilla-test-present\/src\/gorilla_test\/expresso_latex.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/gorilla_test\/core.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/sr_basics\/render.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/classpath.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/numbers.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/words.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/mongo.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/core.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/rabbitmq.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/neo.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src\/new\/elastisch.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/project.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/expression-render.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/central-limit.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/second.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/specter-example.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/rethinkdb-examples.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/arangodb-examples.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/loom-test.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/couchdb-example.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/words.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/hiccup-test.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/rabbitmq-examples.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/files.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/clock-demo.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/scanmaster.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/incanter-example.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/neocons-ex.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/first.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/unified-update-model.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/graph-examples.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/sicp-1.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/abrade-ex.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/mongo-example2.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/elastisch-examples.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/mysql-example.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/matrix-form-test.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/introduction.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/new-render.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/mongo-example.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/test.clj&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/ws\/redis-example.clj&quot;]
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
>>>>>>> Stashed changes
;; <=

;; @@
(println (slurp "project.clj"))
;; @@
;; ->
;;; (defproject gorilla-test &quot;0.1.0-SNAPSHOT&quot;
;;;   :description &quot;A test project for the Gorilla REPL.&quot;
<<<<<<< Updated upstream
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
=======
;;;   :dependencies [[org.clojure/clojure &quot;1.8.0&quot;]
;;;                  [instaparse &quot;1.4.2&quot;]
;;;                  [com.vijaykiran/docjure &quot;1.7.0&quot; :exclusions [xml-apis]]
;;;                  [org.clojure/core.match &quot;0.2.2&quot; :exclusions [org.clojure/tools.analyzer.jvm]]
;;;                  [org.clojure/core.unify &quot;0.5.7&quot;]
;;;                  [clj-http &quot;3.2.0&quot;]
;;;                  [clojurewerkz/neocons &quot;3.1.0&quot; :exclusions [clj-http]]
;;;                  [clj-gremlin &quot;0.0.3&quot;]
;;;                  ;;[clj-blueprints2 &quot;0.0.1&quot; :exclusions [com.tinkerpop.blueprints/blueprints-core]]
;;;                  [gavagai &quot;0.3.2&quot;]
;;;                  [prismatic/plumbing &quot;0.5.3&quot;]
;;;                  [clojureql &quot;1.0.4&quot; :exclusions [org.clojure/core.incubator]]
;;;                  [lein-kibit &quot;0.1.2&quot; :exclusions [org.clojure/core.logic]]
;;;                  [rplevy-draker/wabbitmq &quot;0.3.0&quot; :exclusions [org.clojure/clojure]]
;;;                  [com.mysql/connectorj &quot;5.1.12&quot;]
;;;                  [hiccup &quot;1.0.5&quot;]
;;;                  [expresso &quot;0.2.0&quot; :exclusions [org.clojure/core.memoize instaparse]]
;;;                  [aysylu/loom &quot;0.6.0&quot;]
;;;                  [loom-gorilla &quot;0.1.0&quot;]
;;;                  [org.clojure/data.xml &quot;0.0.8&quot;]
;;;                  [incanter-gorilla &quot;0.1.0&quot; :exclusions [xml-apis]]
;;;                  [gorilla-renderable &quot;2.0.0&quot;]
;;;                  [com.microsoft/sqljdbc4 &quot;3.0&quot;]
;;;                  ;;[cn.guoyukun.jdbc/db2jcc &quot;1.4.2&quot;]
;;;                  ;;[cn.guoyukun.jdbc/db2jcc_license_cu &quot;1.4.2&quot;]
;;;                  [com.taoensso/carmine &quot;2.14.0&quot; :exclusions [org.clojure/clojure org.clojure/tools.reader]]
;;;                  [com.ashafa/clutch &quot;0.4.0&quot;]
;;;                  [org.apache.geronimo.specs/geronimo-activation_1.1_spec &quot;1.1&quot;]
;;;                  [com.uswitch/clj-soap &quot;0.2.3&quot; :exclusions [org.apache.geronimo.specs/geronimo-activation_1.1_spec]]
;;;                  [proto-repl &quot;0.3.1&quot;]
;;;                  ;;[abrade &quot;0.1.8&quot;]
;;;                  [clarango &quot;0.7.1&quot;]
;;;                  [clojurewerkz/elastisch &quot;2.2.1&quot;]
;;;                  [im.chit/one.love &quot;0.1.4&quot;]
;;;                  [com.rpl/specter &quot;1.0.0&quot;]]
;;;   :main ^:skip-aot gorilla-test.core
;;;   :target-path &quot;target/%s&quot;
;;;   :plugins [[lein-gorilla &quot;0.4.0&quot;]
;;;             [lein-localrepo &quot;0.5.3&quot;]]
>>>>>>> Stashed changes
;;;   :profiles {:uberjar {:aot :all}})
;;; 
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc create-workbook)
;; @@
;; ->
;;; -------------------------
;;; dk.ative.docjure.spreadsheet/create-workbook
;;; ([sheet-name data])
;;;   Create a new workbook with a single sheet and the data specified.  The
;;;    data is given a vector of vectors, representing the rows and the
;;;    cells of the rows.
;;; 
;;;    For example, to create a workbook with a sheet with two rows of each
;;;    three columns:
;;; 
;;;    (create-workbook &quot;Sheet 1&quot; [[&quot;Name&quot; &quot;Quantity&quot; &quot;Price&quot;]
;;;                     [&quot;Foo Widget&quot; 2 42]])
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; Create a spreadsheet and save it
(let [wb (create-workbook "Price List"
                          [["Name" "Price"]
                           ["Foo Widget" 100]
                           ["Bar Widget" 200]
                           ["Baz Widget" 300]])
      sheet (select-sheet "Price List" wb)
      header-row (first (row-seq sheet))]
  (do
    (set-row-style! header-row (create-cell-style! wb {:background :yellow,
                                                       :font {:bold true}}))
    (save-workbook! "spreadsheet.xlsx" wb)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(table-view (->> (load-workbook "spreadsheet.xlsx")
<<<<<<< Updated upstream
     (select-sheet "Price List")
     (select-columns {:A :name, :B :price})
     (map (juxt :name :price))))
;; @@
;; =>
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-string'>&quot;Name&quot;</span>","value":"\"Name\""},{"type":"html","content":"<span class='clj-string'>&quot;Price&quot;</span>","value":"\"Price\""}],"value":"[\"Name\" \"Price\"]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-string'>&quot;Foo Widget&quot;</span>","value":"\"Foo Widget\""},{"type":"html","content":"<span class='clj-double'>100.0</span>","value":"100.0"}],"value":"[\"Foo Widget\" 100.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-string'>&quot;Bar Widget&quot;</span>","value":"\"Bar Widget\""},{"type":"html","content":"<span class='clj-double'>200.0</span>","value":"200.0"}],"value":"[\"Bar Widget\" 200.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-string'>&quot;Baz Widget&quot;</span>","value":"\"Baz Widget\""},{"type":"html","content":"<span class='clj-double'>300.0</span>","value":"300.0"}],"value":"[\"Baz Widget\" 300.0]"}],"value":"#gorilla_repl.table.TableView{:contents ([\"Name\" \"Price\"] [\"Foo Widget\" 100.0] [\"Bar Widget\" 200.0] [\"Baz Widget\" 300.0]), :opts nil}"}
=======
                 (select-sheet "Price List")
                 (select-columns {:A :name, :B :price})
                 ;rest
                 (map (juxt (comp html-view :name) :price)))
            )
;; @@
;; =>
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"Name","value":"#gorilla_repl.html.HtmlView{:content \"Name\"}"},{"type":"html","content":"<span class='clj-string'>&quot;Price&quot;</span>","value":"\"Price\""}],"value":"[#gorilla_repl.html.HtmlView{:content \"Name\"} \"Price\"]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"Foo Widget","value":"#gorilla_repl.html.HtmlView{:content \"Foo Widget\"}"},{"type":"html","content":"<span class='clj-double'>100.0</span>","value":"100.0"}],"value":"[#gorilla_repl.html.HtmlView{:content \"Foo Widget\"} 100.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"Bar Widget","value":"#gorilla_repl.html.HtmlView{:content \"Bar Widget\"}"},{"type":"html","content":"<span class='clj-double'>200.0</span>","value":"200.0"}],"value":"[#gorilla_repl.html.HtmlView{:content \"Bar Widget\"} 200.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"Baz Widget","value":"#gorilla_repl.html.HtmlView{:content \"Baz Widget\"}"},{"type":"html","content":"<span class='clj-double'>300.0</span>","value":"300.0"}],"value":"[#gorilla_repl.html.HtmlView{:content \"Baz Widget\"} 300.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"Biz Widget","value":"#gorilla_repl.html.HtmlView{:content \"Biz Widget\"}"},{"type":"html","content":"<span class='clj-double'>400.0</span>","value":"400.0"}],"value":"[#gorilla_repl.html.HtmlView{:content \"Biz Widget\"} 400.0]"}],"value":"#gorilla_repl.table.TableView{:contents ([#gorilla_repl.html.HtmlView{:content \"Name\"} \"Price\"] [#gorilla_repl.html.HtmlView{:content \"Foo Widget\"} 100.0] [#gorilla_repl.html.HtmlView{:content \"Bar Widget\"} 200.0] [#gorilla_repl.html.HtmlView{:content \"Baz Widget\"} 300.0] [#gorilla_repl.html.HtmlView{:content \"Biz Widget\"} 400.0]), :opts nil}"}
>>>>>>> Stashed changes
;; <=

;; @@
(defn diff
  [c]
  (->> c
       (partition 2 1)
       (map reverse)
       (map #(apply - %))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;files/diff</span>","value":"#'files/diff"}
;; <=

;; @@
(diff (range 5))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"(1 1 1 1)"}
;; <=

;; @@
;; Create a spreadsheet and save it
(let [wb (create-workbook "Test"
                          (map (juxt identity
                                     #(* % %))
                               (rest (range 21))))
      sheet (select-sheet "Test" wb)
      header-row (first (row-seq sheet))]
  (do
    (set-row-style! header-row (create-cell-style! wb {:background :yellow,
                                                       :font {:bold true}}))
    (save-workbook! "test.xlsx" wb)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(table-view (->> (load-workbook "test.xlsx")
     (select-sheet "Test")
     (select-columns {:A :number, :B :square})
     (map (juxt :number :square))))
;; @@
;; =>
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>1.0</span>","value":"1.0"},{"type":"html","content":"<span class='clj-double'>1.0</span>","value":"1.0"}],"value":"[1.0 1.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>2.0</span>","value":"2.0"},{"type":"html","content":"<span class='clj-double'>4.0</span>","value":"4.0"}],"value":"[2.0 4.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>3.0</span>","value":"3.0"},{"type":"html","content":"<span class='clj-double'>9.0</span>","value":"9.0"}],"value":"[3.0 9.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>4.0</span>","value":"4.0"},{"type":"html","content":"<span class='clj-double'>16.0</span>","value":"16.0"}],"value":"[4.0 16.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>5.0</span>","value":"5.0"},{"type":"html","content":"<span class='clj-double'>25.0</span>","value":"25.0"}],"value":"[5.0 25.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>6.0</span>","value":"6.0"},{"type":"html","content":"<span class='clj-double'>36.0</span>","value":"36.0"}],"value":"[6.0 36.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>7.0</span>","value":"7.0"},{"type":"html","content":"<span class='clj-double'>49.0</span>","value":"49.0"}],"value":"[7.0 49.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>8.0</span>","value":"8.0"},{"type":"html","content":"<span class='clj-double'>64.0</span>","value":"64.0"}],"value":"[8.0 64.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>9.0</span>","value":"9.0"},{"type":"html","content":"<span class='clj-double'>81.0</span>","value":"81.0"}],"value":"[9.0 81.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>10.0</span>","value":"10.0"},{"type":"html","content":"<span class='clj-double'>100.0</span>","value":"100.0"}],"value":"[10.0 100.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>11.0</span>","value":"11.0"},{"type":"html","content":"<span class='clj-double'>121.0</span>","value":"121.0"}],"value":"[11.0 121.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>12.0</span>","value":"12.0"},{"type":"html","content":"<span class='clj-double'>144.0</span>","value":"144.0"}],"value":"[12.0 144.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>13.0</span>","value":"13.0"},{"type":"html","content":"<span class='clj-double'>169.0</span>","value":"169.0"}],"value":"[13.0 169.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>14.0</span>","value":"14.0"},{"type":"html","content":"<span class='clj-double'>196.0</span>","value":"196.0"}],"value":"[14.0 196.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>15.0</span>","value":"15.0"},{"type":"html","content":"<span class='clj-double'>225.0</span>","value":"225.0"}],"value":"[15.0 225.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>16.0</span>","value":"16.0"},{"type":"html","content":"<span class='clj-double'>256.0</span>","value":"256.0"}],"value":"[16.0 256.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>17.0</span>","value":"17.0"},{"type":"html","content":"<span class='clj-double'>289.0</span>","value":"289.0"}],"value":"[17.0 289.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>18.0</span>","value":"18.0"},{"type":"html","content":"<span class='clj-double'>324.0</span>","value":"324.0"}],"value":"[18.0 324.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>19.0</span>","value":"19.0"},{"type":"html","content":"<span class='clj-double'>361.0</span>","value":"361.0"}],"value":"[19.0 361.0]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-double'>20.0</span>","value":"20.0"},{"type":"html","content":"<span class='clj-double'>400.0</span>","value":"400.0"}],"value":"[20.0 400.0]"}],"value":"#gorilla_repl.table.TableView{:contents ([1.0 1.0] [2.0 4.0] [3.0 9.0] [4.0 16.0] [5.0 25.0] [6.0 36.0] [7.0 49.0] [8.0 64.0] [9.0 81.0] [10.0 100.0] [11.0 121.0] [12.0 144.0] [13.0 169.0] [14.0 196.0] [15.0 225.0] [16.0 256.0] [17.0 289.0] [18.0 324.0] [19.0 361.0] [20.0 400.0]), :opts nil}"}
;; <=

;; @@
(->> (load-workbook "test.xlsx")
     (select-sheet "Test")
     (select-columns {:A :number, :B :square})
     (map (juxt :number :square))
     (map second)
     (diff))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>3.0</span>","value":"3.0"},{"type":"html","content":"<span class='clj-double'>5.0</span>","value":"5.0"},{"type":"html","content":"<span class='clj-double'>7.0</span>","value":"7.0"},{"type":"html","content":"<span class='clj-double'>9.0</span>","value":"9.0"},{"type":"html","content":"<span class='clj-double'>11.0</span>","value":"11.0"},{"type":"html","content":"<span class='clj-double'>13.0</span>","value":"13.0"},{"type":"html","content":"<span class='clj-double'>15.0</span>","value":"15.0"},{"type":"html","content":"<span class='clj-double'>17.0</span>","value":"17.0"},{"type":"html","content":"<span class='clj-double'>19.0</span>","value":"19.0"},{"type":"html","content":"<span class='clj-double'>21.0</span>","value":"21.0"},{"type":"html","content":"<span class='clj-double'>23.0</span>","value":"23.0"},{"type":"html","content":"<span class='clj-double'>25.0</span>","value":"25.0"},{"type":"html","content":"<span class='clj-double'>27.0</span>","value":"27.0"},{"type":"html","content":"<span class='clj-double'>29.0</span>","value":"29.0"},{"type":"html","content":"<span class='clj-double'>31.0</span>","value":"31.0"},{"type":"html","content":"<span class='clj-double'>33.0</span>","value":"33.0"},{"type":"html","content":"<span class='clj-double'>35.0</span>","value":"35.0"},{"type":"html","content":"<span class='clj-double'>37.0</span>","value":"37.0"},{"type":"html","content":"<span class='clj-double'>39.0</span>","value":"39.0"}],"value":"(3.0 5.0 7.0 9.0 11.0 13.0 15.0 17.0 19.0 21.0 23.0 25.0 27.0 29.0 31.0 33.0 35.0 37.0 39.0)"}
;; <=

;; @@
(pprint (sort (.split (System/getProperty "java.class.path") ":")))
;; @@
;; ->
<<<<<<< Updated upstream
;;; [&quot;/root/leinProjects/gorilla-test - 0.3.3/test&quot;,
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/src&quot;,
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/dev-resources&quot;,
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/resources&quot;,
;;;  &quot;/root/leinProjects/gorilla-test - 0.3.3/target/base+system+user+dev/classes&quot;,
;;;  &quot;/root/.m2/repository/concurrent/concurrent/1.3.4/concurrent-1.3.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/core.logic/0.8.4/core.logic-0.8.4.jar&quot;,
;;;  &quot;/root/.m2/repository/clj-http/clj-http/0.7.8/clj-http-0.7.8.jar&quot;,
;;;  &quot;/root/.m2/repository/aysylu/loom/0.5.0/loom-0.5.0.jar&quot;,
;;;  &quot;/root/.m2/repository/clojureql/clojureql/1.0.4/clojureql-1.0.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/tools.macro/0.1.0/tools.macro-0.1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/cn/guoyukun/jdbc/db2jcc_license_cu/1.4.2/db2jcc_license_cu-1.4.2.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/james/apache-mime4j-core/0.7.2/apache-mime4j-core-0.7.2.jar&quot;,
;;;  &quot;/root/.m2/repository/colt/colt/1.2.0/colt-1.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-core/1.5.4/incanter-core-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/scilab/forge/jlatexmath/0.9.6/jlatexmath-0.9.6.jar&quot;,
;;;  &quot;/root/.m2/repository/org/tcrawley/dynapath/0.2.3/dynapath-0.2.3.jar&quot;,
;;;  &quot;/root/.m2/repository/ring/ring-core/1.2.2/ring-core-1.2.2.jar&quot;,
;;;  &quot;/root/.m2/repository/grimradical/clj-semver/0.2.0/clj-semver-0.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/watchtower/watchtower/0.1.1/watchtower-0.1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/tigris/tigris/0.1.1/tigris-0.1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlbeans/xmlbeans/2.3.0/xmlbeans-2.3.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/math.combinatorics/0.0.3/math.combinatorics-0.0.3.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/xalan/xalan/2.6.0/xalan-2.6.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/lowagie/itext/2.1.7/itext-2.1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-transport-local/1.6.2/axis2-transport-local-1.6.2.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-latex/1.5.4/incanter-latex-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/commons/commons-pool2/2.2/commons-pool2-2.2.jar&quot;,
;;;  &quot;/root/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-smile/2.3.1/jackson-dataformat-smile-2.3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/google-closure-library-third-party/0.0-20130212-95c19e7f0f5f/google-closure-library-third-party-0.0-20130212-95c19e7f0f5f.jar&quot;,
;;;  &quot;/root/.m2/repository/com/github/rwl/JKLU/1.0.0/JKLU-1.0.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/poi/poi-ooxml-schemas/3.9/poi-ooxml-schemas-3.9.jar&quot;,
;;;  &quot;/root/.m2/repository/clojurewerkz/support/0.19.0/support-0.19.0.jar&quot;,
;;;  &quot;/root/.m2/repository/clojure-complete/clojure-complete/0.2.3/clojure-complete-0.2.3.jar&quot;,
;;;  &quot;/root/.m2/repository/stax/stax-api/1.0.1/stax-api-1.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-zoo/1.5.4/incanter-zoo-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/lein-kibit/lein-kibit/0.0.8/lein-kibit-0.0.8.jar&quot;,
;;;  &quot;/root/.m2/repository/com/keminglabs/cljx/0.4.0/cljx-0.4.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/tools.cli/0.2.2/tools.cli-0.2.2.jar&quot;,
;;;  &quot;/root/.m2/repository/ring/ring-codec/1.0.0/ring-codec-1.0.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.3.1/jackson-core-2.3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.8.5/jackson-mapper-asl-1.8.5.jar&quot;,
;;;  &quot;/root/.m2/repository/org/jsoup/jsoup/1.7.1/jsoup-1.7.1.jar&quot;,
;;;  &quot;/root/.m2/repository/com/taoensso/nippy/2.6.3/nippy-2.6.3.jar&quot;,
;;;  &quot;/root/.m2/repository/cheshire/cheshire/5.3.1/cheshire-5.3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/clojurescript/0.0-2080/clojurescript-0.0-2080.jar&quot;,
;;;  &quot;/root/.m2/repository/loom-gorilla/loom-gorilla/0.1.0/loom-gorilla-0.1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/bouncycastle/bcmail-jdk14/1.38/bcmail-jdk14-1.38.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/core.cache/0.6.3/core.cache-0.6.3.jar&quot;,
;;;  &quot;/root/.m2/repository/com/novemberain/validateur/1.5.0/validateur-1.5.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/poi/poi-ooxml/3.9/poi-ooxml-3.9.jar&quot;,
;;;  &quot;/root/.m2/repository/com/google/protobuf/protobuf-java/2.4.1/protobuf-java-2.4.1.jar&quot;,
;;;  &quot;/root/.m2/repository/joda-time/joda-time/2.2/joda-time-2.2.jar&quot;,
;;;  &quot;/root/.m2/repository/ch/qos/logback/logback-core/1.1.2/logback-core-1.1.2.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/core.match/0.2.0/core.match-0.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/tinkerpop/gremlin/gremlin-java/2.2.0/gremlin-java-2.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/data.codec/0.1.0/data.codec-0.1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/gavagai/gavagai/0.3.1/gavagai-0.3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.8.5/jackson-core-asl-1.8.5.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-css/1.7/batik-css-1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-ext/1.7/batik-ext-1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-awt-util/1.7/batik-awt-util-1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/jline/jline/2.11/jline-2.11.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-jta_1.1_spec/1.1/geronimo-jta_1.1_spec-1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/com/taoensso/encore/1.7.1/encore-1.7.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/data.xml/0.0.7/data.xml-0.0.7.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/core.incubator/0.1.1/core.incubator-0.1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/javax/ws/rs/jsr311-api/1.0/jsr311-api-1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/jcommon/1.0.16/jcommon-1.0.16.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-excel/1.5.4/incanter-excel-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sourceforge/csparsej/csparsej/1.1.1/csparsej-1.1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/instaparse/instaparse/1.2.2/instaparse-1.2.2.jar&quot;,
;;;  &quot;/root/.m2/repository/net/cgrand/regex/1.1.0/regex-1.1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/java.jdbc/0.2.3/java.jdbc-0.2.3.jar&quot;,
;;;  &quot;/root/.m2/repository/com/google/javascript/closure-compiler/v20130603/closure-compiler-v20130603.jar&quot;,
;;;  &quot;/root/.m2/repository/javax/servlet/servlet-api/2.5/servlet-api-2.5.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-charts/1.5.4/incanter-charts-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/com/mysql/connectorj/5.1.12/connectorj-5.1.12.jar&quot;,
;;;  &quot;/root/.m2/repository/org/hamcrest/hamcrest-core/1.1/hamcrest-core-1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/http-kit/http-kit/2.1.18/http-kit-2.1.18.jar&quot;,
;;;  &quot;/root/.m2/repository/org/jblas/jblas/1.2.3/jblas-1.2.3.jar&quot;,
;;;  &quot;/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/data.priority-map/0.0.5/data.priority-map-0.0.5.jar&quot;,
;;;  &quot;/root/.m2/repository/gorilla-renderable/gorilla-renderable/1.0.0/gorilla-renderable-1.0.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/taoensso/timbre/3.2.1/timbre-3.2.1.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter/1.5.4/incanter-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/mozilla/rhino/1.7R4/rhino-1.7R4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/json/json/20090211/json-20090211.jar&quot;,
;;;  &quot;/root/.m2/repository/congomongo/congomongo/0.3.3/congomongo-0.3.3.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-mongodb/1.5.4/incanter-mongodb-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/net/mikera/core.matrix/0.10.0/core.matrix-0.10.0.jar&quot;,
;;;  &quot;/root/.m2/repository/clj-time/clj-time/0.5.0/clj-time-0.5.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/googlecode/netlib-java/netlib-java/0.9.3/netlib-java-0.9.3.jar&quot;,
;;;  &quot;/root/.m2/repository/com/cemerick/url/0.0.6/url-0.0.6.jar&quot;,
;;;  &quot;/root/.m2/repository/bouncycastle/bcprov-jdk14/138/bcprov-jdk14-138.jar&quot;,
;;;  &quot;/root/.m2/repository/rplevy-draker/wabbitmq/0.3.0/wabbitmq-0.3.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/java.classpath/0.2.0/java.classpath-0.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/woden/woden-api/1.0M9/woden-api-1.0M9.jar&quot;,
;;;  &quot;/root/.m2/repository/cn/guoyukun/jdbc/db2jcc/1.4.2/db2jcc-1.4.2.jar&quot;,
;;;  &quot;/root/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar&quot;,
;;;  &quot;/root/.m2/repository/com/ashafa/clutch/0.4.0/clutch-0.4.0.jar&quot;,
;;;  &quot;/root/.m2/repository/jonase/kibit/0.0.8/kibit-0.0.8.jar&quot;,
;;;  &quot;/root/.m2/repository/org/bouncycastle/bctsp-jdk14/1.38/bctsp-jdk14-1.38.jar&quot;,
;;;  &quot;/root/.m2/repository/cider/cider-nrepl/0.7.0/cider-nrepl-0.7.0.jar&quot;,
;;;  &quot;/root/.m2/repository/compliment/compliment/0.1.3/compliment-0.1.3.jar&quot;,
;;;  &quot;/root/.m2/repository/io/aviso/pretty/0.1.10/pretty-0.1.10.jar&quot;,
;;;  &quot;/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/ws/commons/axiom/axiom-api/1.2.13/axiom-api-1.2.13.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-svggen/1.7/batik-svggen-1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/ws/commons/schema/XmlSchema/1.4.7/XmlSchema-1.4.7.jar&quot;,
;;;  &quot;/root/.m2/repository/bouncycastle/bcmail-jdk14/138/bcmail-jdk14-138.jar&quot;,
;;;  &quot;/root/.m2/repository/com/taoensso/carmine/2.7.0/carmine-2.7.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/codehaus/jettison/jettison/1.3/jettison-1.3.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter-gorilla/incanter-gorilla/0.1.0/incanter-gorilla-0.1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sourceforge/parallelcolt/optimization/1.0/optimization-1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/jfreechart/1.0.13-no-gnujaxp/jfreechart-1.0.13-no-gnujaxp.jar&quot;,
;;;  &quot;/root/.m2/repository/commons-fileupload/commons-fileupload/1.3/commons-fileupload-1.3.jar&quot;,
;;;  &quot;/root/.m2/repository/com/microsoft/sqljdbc4/3.0/sqljdbc4-3.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/woden/woden-impl-commons/1.0M9/woden-impl-commons-1.0M9.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-stax-api_1.0_spec/1.0.1/geronimo-stax-api_1.0_spec-1.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/ragtime/ragtime.core/0.3.4/ragtime.core-0.3.4.jar&quot;,
;;;  &quot;/root/.m2/repository/hiccup/hiccup/1.0.5/hiccup-1.0.5.jar&quot;,
;;;  &quot;/root/.m2/repository/prismatic/plumbing/0.3.3/plumbing-0.3.3.jar&quot;,
;;;  &quot;/root/.m2/repository/potemkin/potemkin/0.3.2/potemkin-0.3.2.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-pdf/1.5.4/incanter-pdf-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/com/tinkerpop/pipes/2.2.0/pipes-2.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/github/rwl/BTFJ/1.0.1/BTFJ-1.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/codehaus/woodstox/wstx-asl/3.2.9/wstx-asl-3.2.9.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/woden/woden-impl-dom/1.0M9/woden-impl-dom-1.0M9.jar&quot;,
;;;  &quot;/root/.m2/repository/clojurewerkz/urly/2.0.0-alpha5/urly-2.0.0-alpha5.jar&quot;,
;;;  &quot;/root/.m2/repository/org/tukaani/xz/1.5/xz-1.5.jar&quot;,
;;;  &quot;/root/.m2/repository/fr/grunwald/lazymap/3.1.0/lazymap-3.1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-activation_1.1_spec/1.0.2/geronimo-activation_1.1_spec-1.0.2.jar&quot;,
;;;  &quot;/root/.m2/repository/ch/qos/logback/logback-classic/1.1.2/logback-classic-1.1.2.jar&quot;,
;;;  &quot;/root/.m2/repository/compojure/compojure/1.1.8/compojure-1.1.8.jar&quot;,
;;;  &quot;/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-javamail_1.4_spec/1.7.1/geronimo-javamail_1.4_spec-1.7.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/tools.reader/0.8.1/tools.reader-0.8.1.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sourceforge/jtransforms/jtransforms/2.4.0/jtransforms-2.4.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/core.memoize/0.5.6/core.memoize-0.5.6.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-io/1.5.4/incanter-io-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/wsdl4j/wsdl4j/1.6.2/wsdl4j-1.6.2.jar&quot;,
;;;  &quot;/root/.m2/repository/expresso/expresso/0.2.0/expresso-0.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/httpcomponents/httpcore/4.3/httpcore-4.3.jar&quot;,
;;;  &quot;/root/.m2/repository/jaxen/jaxen/1.1.3/jaxen-1.1.3.jar&quot;,
;;;  &quot;/root/.m2/repository/net/cgrand/parsley/0.9.1/parsley-0.9.1.jar&quot;,
;;;  &quot;/root/.m2/repository/de/kotka/lazymap/3.1.0/lazymap-3.1.0.jar&quot;,
;;;  &quot;/root/.m2/repository/args4j/args4j/2.0.16/args4j-2.0.16.jar&quot;,
;;;  &quot;/root/.m2/repository/ring/ring-json/0.3.1/ring-json-0.3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/clj-blueprints2/clj-blueprints2/0.0.1/clj-blueprints2-0.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/danlarkin/clojure-json/1.1/clojure-json-1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-xml/1.7/batik-xml-1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-util/1.7/batik-util-1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/gorilla-repl/gorilla-repl/0.3.3/gorilla-repl-0.3.3.jar&quot;,
;;;  &quot;/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sourceforge/parallelcolt/parallelcolt/0.10.0/parallelcolt-0.10.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/data.json/0.2.5/data.json-0.2.5.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/httpcomponents/httpclient/4.3.1/httpclient-4.3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/com/tinkerpop/blueprints/blueprints-core/2.2.0/blueprints-core-2.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/cljs-tooling/cljs-tooling/0.1.3/cljs-tooling-0.1.3.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/geronimo/specs/geronimo-ws-metadata_2.0_spec/1.1.2/geronimo-ws-metadata_2.0_spec-1.1.2.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/core.unify/0.5.6/core.unify-0.5.6.jar&quot;,
;;;  &quot;/root/.m2/repository/clj-gremlin/clj-gremlin/0.0.3/clj-gremlin-0.0.3.jar&quot;,
;;;  &quot;/root/.m2/repository/org/iq80/snappy/snappy/0.3/snappy-0.3.jar&quot;,
;;;  &quot;/root/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar&quot;,
;;;  &quot;/root/.m2/repository/xml-apis/xml-apis-ext/1.3.04/xml-apis-ext-1.3.04.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/neethi/neethi/3.0.2/neethi-3.0.2.jar&quot;,
;;;  &quot;/root/.m2/repository/dom4j/dom4j/1.6.1/dom4j-1.6.1.jar&quot;,
;;;  &quot;/root/.m2/repository/crouton/crouton/0.1.1/crouton-0.1.1.jar&quot;,
;;;  &quot;/root/.m2/repository/junit/junit/4.10/junit-4.10.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/xmlgraphics/batik-dom/1.7/batik-dom-1.7.jar&quot;,
;;;  &quot;/root/.m2/repository/com/rabbitmq/amqp-client/2.8.1/amqp-client-2.8.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/tools.nrepl/0.2.6/tools.nrepl-0.2.6.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/tools.trace/0.7.8/tools.trace-0.7.8.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/tools.namespace/0.2.5/tools.namespace-0.2.5.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-sql/1.5.4/incanter-sql-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/com/cemerick/piggieback/0.1.3/piggieback-0.1.3.jar&quot;,
;;;  &quot;/root/.m2/repository/swingrepl/swingrepl/1.3.0/swingrepl-1.3.0.jar&quot;,
;;;  &quot;/root/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar&quot;,
;;;  &quot;/root/.m2/repository/com/uswitch/clj-soap/0.2.3/clj-soap-0.2.3.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/google-closure-library/0.0-20130212-95c19e7f0f5f/google-closure-library-0.0-20130212-95c19e7f0f5f.jar&quot;,
;;;  &quot;/root/.m2/repository/slingshot/slingshot/0.10.3/slingshot-0.10.3.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojure/clojure/1.5.1/clojure-1.5.1.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sourceforge/jplasma/jplasma/1.2.0/jplasma-1.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/vijaykiran/docjure/1.7.0/docjure-1.7.0.jar&quot;,
;;;  &quot;/root/.m2/repository/com/novemberain/monger/1.7.0-beta1/monger-1.7.0-beta1.jar&quot;,
;;;  &quot;/root/.m2/repository/clout/clout/1.2.0/clout-1.2.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-kernel/1.6.2/axis2-kernel-1.6.2.jar&quot;,
;;;  &quot;/root/.m2/repository/com/github/rwl/AMDJ/1.0.1/AMDJ-1.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/incanter/incanter-svg/1.5.4/incanter-svg-1.5.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/ws/commons/axiom/axiom-impl/1.2.13/axiom-impl-1.2.13.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-adb/1.6.2/axis2-adb-1.6.2.jar&quot;,
;;;  &quot;/root/.m2/repository/prismatic/schema/0.2.4/schema-0.2.4.jar&quot;,
;;;  &quot;/root/.m2/repository/org/mongodb/mongo-java-driver/2.11.2/mongo-java-driver-2.11.2.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/httpcomponents/httpmime/4.3.1/httpmime-4.3.1.jar&quot;,
;;;  &quot;/root/.m2/repository/xml-apis/xml-apis/1.0.b2/xml-apis-1.0.b2.jar&quot;,
;;;  &quot;/root/.m2/repository/pathetic/pathetic/0.4.0/pathetic-0.4.0.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/poi/poi/3.9/poi-3.9.jar&quot;,
;;;  &quot;/root/.m2/repository/org/clojars/trptcolin/sjacket/0.1.0.6/sjacket-0.1.0.6.jar&quot;,
;;;  &quot;/root/.m2/repository/clojurewerkz/neocons/2.0.1/neocons-2.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/net/sourceforge/jplasma/core-lapack/0.1/core-lapack-0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/com/github/rwl/COLAMDJ/1.0.1/COLAMDJ-1.0.1.jar&quot;,
;;;  &quot;/root/.m2/repository/org/apache/axis2/axis2-transport-http/1.6.2/axis2-transport-http-1.6.2.jar&quot;,
;;;  &quot;/root/.m2/repository/org/bouncycastle/bcprov-jdk14/1.38/bcprov-jdk14-1.38.jar&quot;,
;;;  &quot;/root/.m2/repository/clatrix/clatrix/0.3.0/clatrix-0.3.0.jar&quot;]
=======
;;; [&quot;\/home\/jtcummi\/.m2\/repository\/aysylu\/loom\/0.6.0\/loom-0.6.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/bouncycastle\/bcmail-jdk14\/138\/bcmail-jdk14-138.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/bouncycastle\/bcprov-jdk14\/138\/bcprov-jdk14-138.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/ch\/qos\/logback\/logback-classic\/1.1.2\/logback-classic-1.1.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/ch\/qos\/logback\/logback-core\/1.1.2\/logback-core-1.1.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/cheshire\/cheshire\/5.3.1\/cheshire-5.3.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/cider\/cider-nrepl\/0.10.2\/cider-nrepl-0.10.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clarango\/clarango\/0.7.1\/clarango-0.7.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clatrix\/clatrix\/0.3.0\/clatrix-0.3.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clj-gremlin\/clj-gremlin\/0.0.3\/clj-gremlin-0.0.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clj-http\/clj-http\/3.2.0\/clj-http-3.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clj-time\/clj-time\/0.4.4\/clj-time-0.4.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clj-tuple\/clj-tuple\/0.2.2\/clj-tuple-0.2.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clojure-complete\/clojure-complete\/0.2.4\/clojure-complete-0.2.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clojureql\/clojureql\/1.0.4\/clojureql-1.0.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clojurewerkz\/elastisch\/2.2.1\/elastisch-2.2.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clojurewerkz\/neocons\/3.1.0\/neocons-3.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clojurewerkz\/support\/1.1.0\/support-1.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/clout\/clout\/1.2.0\/clout-1.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/colt\/colt\/1.2.0\/colt-1.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/ashafa\/clutch\/0.4.0\/clutch-0.4.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/cemerick\/url\/0.0.6\/url-0.0.6.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/fasterxml\/jackson\/core\/jackson-core\/2.3.1\/jackson-core-2.3.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/fasterxml\/jackson\/dataformat\/jackson-dataformat-smile\/2.3.1\/jackson-dataformat-smile-2.3.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/github\/rwl\/AMDJ\/1.0.1\/AMDJ-1.0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/github\/rwl\/BTFJ\/1.0.1\/BTFJ-1.0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/github\/rwl\/COLAMDJ\/1.0.1\/COLAMDJ-1.0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/github\/rwl\/JKLU\/1.0.0\/JKLU-1.0.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/googlecode\/json-simple\/json-simple\/1.1.1\/json-simple-1.1.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/googlecode\/netlib-java\/netlib-java\/0.9.3\/netlib-java-0.9.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/lowagie\/itext\/2.1.7\/itext-2.1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/microsoft\/sqljdbc4\/3.0\/sqljdbc4-3.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/mysql\/connectorj\/5.1.12\/connectorj-5.1.12.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/rabbitmq\/amqp-client\/2.8.1\/amqp-client-2.8.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/rethinkdb\/rethinkdb-driver\/2.3.2\/rethinkdb-driver-2.3.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/rpl\/specter\/1.0.0\/specter-1.0.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/spatial4j\/spatial4j\/0.4.1\/spatial4j-0.4.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/taoensso\/carmine\/2.14.0\/carmine-2.14.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/taoensso\/encore\/2.67.2\/encore-2.67.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/taoensso\/nippy\/2.12.0\/nippy-2.12.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/taoensso\/timbre\/4.7.3\/timbre-4.7.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/taoensso\/truss\/1.3.3\/truss-1.3.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/tinkerpop\/blueprints\/blueprints-core\/2.2.0\/blueprints-core-2.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/tinkerpop\/gremlin\/gremlin-java\/2.2.0\/gremlin-java-2.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/tinkerpop\/pipes\/2.2.0\/pipes-2.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/uswitch\/clj-soap\/0.2.3\/clj-soap-0.2.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/com\/vijaykiran\/docjure\/1.7.0\/docjure-1.7.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/commons-codec\/commons-codec\/1.10\/commons-codec-1.10.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/commons-fileupload\/commons-fileupload\/1.3\/commons-fileupload-1.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/commons-httpclient\/commons-httpclient\/3.1\/commons-httpclient-3.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/commons-io\/commons-io\/2.5\/commons-io-2.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/commons-logging\/commons-logging\/1.2\/commons-logging-1.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/compliment\/compliment\/0.2.7\/compliment-0.2.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/compojure\/compojure\/1.1.8\/compojure-1.1.8.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/concurrent\/concurrent\/1.3.4\/concurrent-1.3.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/congomongo\/congomongo\/0.3.3\/congomongo-0.3.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/de\/kotka\/lazymap\/3.1.0\/lazymap-3.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/defprecated\/defprecated\/0.1.3\/defprecated-0.1.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/dom4j\/dom4j\/1.6.1\/dom4j-1.6.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/expresso\/expresso\/0.2.0\/expresso-0.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/fr\/grunwald\/lazymap\/3.1.0\/lazymap-3.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/gavagai\/gavagai\/0.3.2\/gavagai-0.3.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/gorilla-plot\/gorilla-plot\/0.1.4\/gorilla-plot-0.1.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/gorilla-renderable\/gorilla-renderable\/2.0.0\/gorilla-renderable-2.0.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/gorilla-repl\/gorilla-repl\/0.4.0\/gorilla-repl-0.4.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/grimradical\/clj-semver\/0.2.0\/clj-semver-0.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/hiccup\/hiccup\/1.0.5\/hiccup-1.0.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/http-kit\/http-kit\/2.1.18\/http-kit-2.1.18.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.class.inheritance\/2.3.7\/hara.class.inheritance-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.common.checks\/2.3.7\/hara.common.checks-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.common.error\/2.3.7\/hara.common.error-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.common.hash\/2.3.7\/hara.common.hash-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.common.primitives\/2.3.7\/hara.common.primitives-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.common.string\/2.3.7\/hara.common.string-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.common\/2.3.7\/hara.common-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.data.map\/2.3.7\/hara.data.map-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.namespace.import\/2.3.7\/hara.namespace.import-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.protocol.string\/2.3.7\/hara.protocol.string-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.reflect\/2.3.7\/hara.reflect-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/hara.string.case\/2.3.7\/hara.string.case-2.3.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/im\/chit\/one.love\/0.1.4\/one.love-0.1.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter-gorilla\/incanter-gorilla\/0.1.0\/incanter-gorilla-0.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-charts\/1.5.5\/incanter-charts-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-core\/1.5.5\/incanter-core-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-excel\/1.5.5\/incanter-excel-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-io\/1.5.5\/incanter-io-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-latex\/1.5.5\/incanter-latex-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-mongodb\/1.5.5\/incanter-mongodb-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-pdf\/1.5.5\/incanter-pdf-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-sql\/1.5.5\/incanter-sql-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-svg\/1.5.5\/incanter-svg-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter-zoo\/1.5.5\/incanter-zoo-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/incanter\/1.5.5\/incanter-1.5.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/jcommon\/1.0.16\/jcommon-1.0.16.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/incanter\/jfreechart\/1.0.13-no-gnujaxp\/jfreechart-1.0.13-no-gnujaxp.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/instaparse\/instaparse\/1.4.2\/instaparse-1.4.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/io\/aviso\/pretty\/0.1.29\/pretty-0.1.29.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/javax\/servlet\/servlet-api\/2.5\/servlet-api-2.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/javax\/ws\/rs\/jsr311-api\/1.0\/jsr311-api-1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/jaxen\/jaxen\/1.1.3\/jaxen-1.1.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/joda-time\/joda-time\/2.1\/joda-time-2.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/jonase\/kibit\/0.1.2\/kibit-0.1.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/junit\/junit\/4.10\/junit-4.10.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/lein-kibit\/lein-kibit\/0.1.2\/lein-kibit-0.1.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/loom-gorilla\/loom-gorilla\/0.1.0\/loom-gorilla-0.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/jpountz\/lz4\/lz4\/1.3\/lz4-1.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/mikera\/core.matrix\/0.10.0\/core.matrix-0.10.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sf\/opencsv\/opencsv\/2.3\/opencsv-2.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sourceforge\/csparsej\/csparsej\/1.1.1\/csparsej-1.1.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sourceforge\/f2j\/arpack_combined_all\/0.1\/arpack_combined_all-0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sourceforge\/jplasma\/core-lapack\/0.1\/core-lapack-0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sourceforge\/jplasma\/jplasma\/1.2.0\/jplasma-1.2.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sourceforge\/jtransforms\/jtransforms\/2.4.0\/jtransforms-2.4.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sourceforge\/parallelcolt\/optimization\/1.0\/optimization-1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/net\/sourceforge\/parallelcolt\/parallelcolt\/0.10.1\/parallelcolt-0.10.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/axis2\/axis2-adb\/1.6.2\/axis2-adb-1.6.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/axis2\/axis2-kernel\/1.6.2\/axis2-kernel-1.6.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/axis2\/axis2-transport-http\/1.6.2\/axis2-transport-http-1.6.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/axis2\/axis2-transport-local\/1.6.2\/axis2-transport-local-1.6.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/commons\/commons-pool2\/2.4.2\/commons-pool2-2.4.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/geronimo\/specs\/geronimo-activation_1.1_spec\/1.1\/geronimo-activation_1.1_spec-1.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/geronimo\/specs\/geronimo-javamail_1.4_spec\/1.7.1\/geronimo-javamail_1.4_spec-1.7.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/geronimo\/specs\/geronimo-jta_1.1_spec\/1.1\/geronimo-jta_1.1_spec-1.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/geronimo\/specs\/geronimo-stax-api_1.0_spec\/1.0.1\/geronimo-stax-api_1.0_spec-1.0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/geronimo\/specs\/geronimo-ws-metadata_2.0_spec\/1.1.2\/geronimo-ws-metadata_2.0_spec-1.1.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/httpcomponents\/httpclient\/4.5.2\/httpclient-4.5.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/httpcomponents\/httpcore\/4.4.5\/httpcore-4.4.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/httpcomponents\/httpmime\/4.5.2\/httpmime-4.5.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/james\/apache-mime4j-core\/0.7.2\/apache-mime4j-core-0.7.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-analyzers-common\/4.10.4\/lucene-analyzers-common-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-core\/4.10.4\/lucene-core-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-grouping\/4.10.4\/lucene-grouping-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-highlighter\/4.10.4\/lucene-highlighter-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-join\/4.10.4\/lucene-join-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-memory\/4.10.4\/lucene-memory-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-misc\/4.10.4\/lucene-misc-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-queries\/4.10.4\/lucene-queries-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-queryparser\/4.10.4\/lucene-queryparser-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-sandbox\/4.10.4\/lucene-sandbox-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-spatial\/4.10.4\/lucene-spatial-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/lucene\/lucene-suggest\/4.10.4\/lucene-suggest-4.10.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/neethi\/neethi\/3.0.2\/neethi-3.0.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/poi\/poi-ooxml-schemas\/3.9\/poi-ooxml-schemas-3.9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/poi\/poi-ooxml\/3.9\/poi-ooxml-3.9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/poi\/poi\/3.9\/poi-3.9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/woden\/woden-api\/1.0M9\/woden-api-1.0M9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/woden\/woden-impl-commons\/1.0M9\/woden-impl-commons-1.0M9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/woden\/woden-impl-dom\/1.0M9\/woden-impl-dom-1.0M9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/ws\/commons\/axiom\/axiom-api\/1.2.13\/axiom-api-1.2.13.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/ws\/commons\/axiom\/axiom-impl\/1.2.13\/axiom-impl-1.2.13.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/ws\/commons\/schema\/XmlSchema\/1.4.7\/XmlSchema-1.4.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlbeans\/xmlbeans\/2.3.0\/xmlbeans-2.3.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlgraphics\/batik-awt-util\/1.7\/batik-awt-util-1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlgraphics\/batik-css\/1.7\/batik-css-1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlgraphics\/batik-dom\/1.7\/batik-dom-1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlgraphics\/batik-ext\/1.7\/batik-ext-1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlgraphics\/batik-svggen\/1.7\/batik-svggen-1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlgraphics\/batik-util\/1.7\/batik-util-1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/apache\/xmlgraphics\/batik-xml\/1.7\/batik-xml-1.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/bouncycastle\/bcmail-jdk14\/1.38\/bcmail-jdk14-1.38.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/bouncycastle\/bcprov-jdk14\/1.38\/bcprov-jdk14-1.38.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/bouncycastle\/bctsp-jdk14\/1.38\/bctsp-jdk14-1.38.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/clojure\/1.8.0\/clojure-1.8.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/core.async\/0.2.374\/core.async-0.2.374.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/core.cache\/0.6.4\/core.cache-0.6.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/core.incubator\/0.1.2\/core.incubator-0.1.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/core.logic\/0.8.4\/core.logic-0.8.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/core.match\/0.2.2\/core.match-0.2.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/core.memoize\/0.5.8\/core.memoize-0.5.8.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/core.unify\/0.5.7\/core.unify-0.5.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/data.codec\/0.1.0\/data.codec-0.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/data.json\/0.2.6\/data.json-0.2.6.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/data.priority-map\/0.0.5\/data.priority-map-0.0.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/data.xml\/0.0.8\/data.xml-0.0.8.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/java.jdbc\/0.2.3\/java.jdbc-0.2.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/math.combinatorics\/0.0.4\/math.combinatorics-0.0.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/tools.analyzer.jvm\/0.6.9\/tools.analyzer.jvm-0.6.9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/tools.analyzer\/0.6.7\/tools.analyzer-0.6.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/tools.cli\/0.3.1\/tools.cli-0.3.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/tools.macro\/0.1.0\/tools.macro-0.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/tools.namespace\/0.2.11\/tools.namespace-0.2.11.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/tools.nrepl\/0.2.12\/tools.nrepl-0.2.12.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/clojure\/tools.reader\/0.8.1\/tools.reader-0.8.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/codehaus\/jackson\/jackson-core-asl\/1.8.5\/jackson-core-asl-1.8.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/codehaus\/jackson\/jackson-mapper-asl\/1.8.5\/jackson-mapper-asl-1.8.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/codehaus\/jettison\/jettison\/1.3\/jettison-1.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/codehaus\/woodstox\/wstx-asl\/3.2.9\/wstx-asl-3.2.9.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/danlarkin\/clojure-json\/1.1\/clojure-json-1.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/elasticsearch\/elasticsearch\/1.7.3\/elasticsearch-1.7.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/hamcrest\/hamcrest-core\/1.1\/hamcrest-core-1.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/iq80\/snappy\/snappy\/0.4\/snappy-0.4.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/jblas\/jblas\/1.2.3\/jblas-1.2.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/mongodb\/mongo-java-driver\/2.9.3\/mongo-java-driver-2.9.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/ow2\/asm\/asm-all\/4.2\/asm-all-4.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/scilab\/forge\/jlatexmath\/0.9.6\/jlatexmath-0.9.6.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/slf4j\/slf4j-api\/1.7.7\/slf4j-api-1.7.7.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/tcrawley\/dynapath\/0.2.3\/dynapath-0.2.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/tukaani\/xz\/1.5\/xz-1.5.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/org\/yaml\/snakeyaml\/1.12\/snakeyaml-1.12.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/pathetic\/pathetic\/0.4.0\/pathetic-0.4.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/potemkin\/potemkin\/0.4.3\/potemkin-0.4.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/prismatic\/plumbing\/0.5.3\/plumbing-0.5.3.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/prismatic\/schema\/1.0.1\/schema-1.0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/proto-repl\/proto-repl\/0.3.1\/proto-repl-0.3.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/riddley\/riddley\/0.1.12\/riddley-0.1.12.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/ring\/ring-codec\/1.0.0\/ring-codec-1.0.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/ring\/ring-core\/1.2.2\/ring-core-1.2.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/ring\/ring-json\/0.3.1\/ring-json-0.3.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/rplevy-draker\/wabbitmq\/0.3.0\/wabbitmq-0.3.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/slingshot\/slingshot\/0.12.2\/slingshot-0.12.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/stax\/stax-api\/1.0.1\/stax-api-1.0.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/tailrecursion\/cljs-priority-map\/1.1.0\/cljs-priority-map-1.1.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/tigris\/tigris\/0.1.1\/tigris-0.1.1.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/wsdl4j\/wsdl4j\/1.6.2\/wsdl4j-1.6.2.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/xalan\/xalan\/2.6.0\/xalan-2.6.0.jar&quot;,
;;;  &quot;\/home\/jtcummi\/.m2\/repository\/xml-apis\/xml-apis-ext\/1.3.04\/xml-apis-ext-1.3.04.jar&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/dev-resources&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/resources&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/src&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/target\/default\/classes&quot;,
;;;  &quot;\/home\/jtcummi\/gorilla-test-present\/test&quot;]
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(clojure.pprint/pprint (->> (all-ns)
                            (map #(.name %))
                            (sort)))
;; @@
;; ->
<<<<<<< Updated upstream
;;; (cemerick.piggieback
;;;  cheshire.core
=======
;;; (cheshire.core
>>>>>>> Stashed changes
;;;  cheshire.factory
;;;  cheshire.generate
;;;  cheshire.parse
;;;  cider.nrepl
;;;  cider.nrepl.middleware.apropos
;;;  cider.nrepl.middleware.classpath
;;;  cider.nrepl.middleware.complete
;;;  cider.nrepl.middleware.info
;;;  cider.nrepl.middleware.inspect
;;;  cider.nrepl.middleware.macroexpand
;;;  cider.nrepl.middleware.resource
;;;  cider.nrepl.middleware.stacktrace
;;;  cider.nrepl.middleware.test
;;;  cider.nrepl.middleware.trace
;;;  cider.nrepl.middleware.util.cljs
;;;  cider.nrepl.middleware.util.inspect
;;;  cider.nrepl.middleware.util.java
;;;  cider.nrepl.middleware.util.java.parser
;;;  cider.nrepl.middleware.util.misc
;;;  clj-semver.core
;;;  clj-time.core
;;;  clj-time.format
;;;  cljs-tooling.complete
;;;  cljs-tooling.info
;;;  cljs-tooling.util.analysis
;;;  cljs-tooling.util.misc
;;;  cljs.analyzer
;;;  cljs.closure
;;;  cljs.compiler
;;;  cljs.env
;;;  cljs.repl
;;;  cljs.repl.rhino
;;;  cljs.source-map
;;;  cljs.source-map.base64
;;;  cljs.source-map.base64-vlq
;;;  cljs.tagged-literals
;;;  clojure.core
;;;  clojure.core.incubator
;;;  clojure.core.protocols
<<<<<<< Updated upstream
;;;  clojure.data.codec.base64
;;;  clojure.data.json
;;;  clojure.data.priority-map
=======
;;;  clojure.core.server
;;;  clojure.data.json
;;;  clojure.edn
>>>>>>> Stashed changes
;;;  clojure.instant
;;;  clojure.java.classpath
;;;  clojure.java.io
;;;  clojure.java.shell
;;;  clojure.main
;;;  clojure.pprint
;;;  clojure.reflect
;;;  clojure.repl
;;;  clojure.set
;;;  clojure.stacktrace
;;;  clojure.string
;;;  clojure.template
;;;  clojure.test
;;;  clojure.tools.macro
;;;  clojure.tools.namespace.dependency
;;;  clojure.tools.namespace.file
;;;  clojure.tools.namespace.find
;;;  clojure.tools.namespace.parse
;;;  clojure.tools.namespace.track
;;;  clojure.tools.nrepl
;;;  clojure.tools.nrepl.ack
;;;  clojure.tools.nrepl.bencode
;;;  clojure.tools.nrepl.middleware
;;;  clojure.tools.nrepl.middleware.interruptible-eval
;;;  clojure.tools.nrepl.middleware.load-file
;;;  clojure.tools.nrepl.middleware.pr-values
;;;  clojure.tools.nrepl.middleware.session
;;;  clojure.tools.nrepl.misc
;;;  clojure.tools.nrepl.server
;;;  clojure.tools.nrepl.transport
;;;  clojure.tools.reader
;;;  clojure.tools.reader.default-data-readers
;;;  clojure.tools.reader.edn
;;;  clojure.tools.reader.impl.ExceptionInfo
;;;  clojure.tools.reader.impl.commons
;;;  clojure.tools.reader.impl.utils
;;;  clojure.tools.reader.reader-types
;;;  clojure.tools.trace
;;;  clojure.uuid
;;;  clojure.walk
;;;  clojure.zip
;;;  clout.core
;;;  complete.core
;;;  compliment.context
;;;  compliment.core
;;;  compliment.sources
;;;  compliment.sources.class-members
;;;  compliment.sources.keywords
;;;  compliment.sources.local-bindings
;;;  compliment.sources.namespaces-and-classes
;;;  compliment.sources.ns-mappings
;;;  compliment.sources.special-forms
;;;  compliment.utils
;;;  compojure.core
;;;  compojure.handler
;;;  compojure.response
;;;  compojure.route
;;;  dk.ative.docjure.spreadsheet
;;;  dynapath.defaults
;;;  dynapath.dynamic-classpath
;;;  dynapath.util
;;;  files
;;;  gorilla-plot.core
;;;  gorilla-plot.util
;;;  gorilla-plot.vega
;;;  gorilla-renderable.core
;;;  gorilla-repl.core
;;;  gorilla-repl.files
;;;  gorilla-repl.html
;;;  gorilla-repl.latex
;;;  gorilla-repl.nrepl
;;;  gorilla-repl.render-values-mw
;;;  gorilla-repl.renderer
;;;  gorilla-repl.table
;;;  gorilla-repl.vega
;;;  gorilla-repl.version
;;;  gorilla-repl.websocket-relay
<<<<<<< Updated upstream
;;;  gorilla-test.core
;;;  introduction
;;;  io.aviso.ansi
;;;  io.aviso.columns
;;;  io.aviso.exception
;;;  io.aviso.writer
;;;  loom-gorilla.render
;;;  loom-test
;;;  loom.alg
;;;  loom.alg-generic
;;;  loom.attr
;;;  loom.flow
;;;  loom.graph
;;;  loom.io
;;;  mongo-example
;;;  org.httpkit.client
;;;  org.httpkit.server
;;;  redis-example
=======
;;;  hara.class.inheritance
;;;  hara.common
;;;  hara.common.checks
;;;  hara.common.error
;;;  hara.common.hash
;;;  hara.common.primitives
;;;  hara.common.string
;;;  hara.data.map
;;;  hara.namespace.import
;;;  hara.protocol.string
;;;  hara.reflect
;;;  hara.reflect.common
;;;  hara.reflect.core.apply
;;;  hara.reflect.core.class
;;;  hara.reflect.core.delegate
;;;  hara.reflect.core.extract
;;;  hara.reflect.core.query
;;;  hara.reflect.element.common
;;;  hara.reflect.element.constructor
;;;  hara.reflect.element.field
;;;  hara.reflect.element.method
;;;  hara.reflect.element.multi
;;;  hara.reflect.hierarchy
;;;  hara.reflect.pretty.args
;;;  hara.reflect.pretty.classes
;;;  hara.reflect.pretty.display
;;;  hara.reflect.pretty.display.filter
;;;  hara.reflect.pretty.display.sort
;;;  hara.reflect.pretty.primitives
;;;  hara.reflect.types.element
;;;  hara.reflect.types.modifiers
;;;  hara.reflect.util
;;;  hara.string.case
;;;  mranderson046.cljfmt.v0v3v0.cljfmt.core
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.coerce
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.comment
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.fn
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.forms
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.integer
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.keyword
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.meta
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.protocols
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.quote
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.reader-macro
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.seq
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.string
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.token
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.uneval
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.whitespace
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.core
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.keyword
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.string
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.token
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.utils
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.whitespace
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.potemkin
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.reader
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.base
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.edit
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.find
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.insert
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.move
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.remove
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.seq
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.subedit
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.utils
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.walk
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.whitespace
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.complete
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.info
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.util.analysis
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.util.misc
;;;  mranderson046.compliment.v0v2v6.compliment.context
;;;  mranderson046.compliment.v0v2v6.compliment.core
;;;  mranderson046.compliment.v0v2v6.compliment.sources
;;;  mranderson046.compliment.v0v2v6.compliment.sources.class-members
;;;  mranderson046.compliment.v0v2v6.compliment.sources.keywords
;;;  mranderson046.compliment.v0v2v6.compliment.sources.local-bindings
;;;  mranderson046.compliment.v0v2v6.compliment.sources.namespaces-and-classes
;;;  mranderson046.compliment.v0v2v6.compliment.sources.ns-mappings
;;;  mranderson046.compliment.v0v2v6.compliment.sources.resources
;;;  mranderson046.compliment.v0v2v6.compliment.sources.special-forms
;;;  mranderson046.compliment.v0v2v6.compliment.utils
;;;  mranderson046.compliment.v0v2v6.defprecated.v0v1v2.defprecated.core
;;;  mranderson046.javaclasspath.v0v2v3.clojure.java.classpath
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.dependency
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.dir
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.file
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.find
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.parse
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.reload
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.track
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.default-data-readers
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.edn
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.impl.commons
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.impl.utils
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.reader-types
;;;  mranderson046.toolstrace.v0v7v9.clojure.tools.trace
;;;  new.numbers
;;;  one.love
;;;  one.love.command
;;;  one.love.command.ast
;;;  one.love.command.js
;;;  one.love.command.lambda
;;;  one.love.common
;;;  one.love.raw.connection
;;;  one.love.raw.db
;;;  one.love.raw.system
;;;  one.love.raw.table
;;;  org.httpkit.client
;;;  org.httpkit.server
;;;  rethinkdb-examples
>>>>>>> Stashed changes
;;;  ring.middleware.content-type
;;;  ring.middleware.cookies
;;;  ring.middleware.file-info
;;;  ring.middleware.flash
;;;  ring.middleware.head
;;;  ring.middleware.json
;;;  ring.middleware.keyword-params
;;;  ring.middleware.multipart-params
;;;  ring.middleware.nested-params
;;;  ring.middleware.params
;;;  ring.middleware.session
;;;  ring.middleware.session.memory
;;;  ring.middleware.session.store
;;;  ring.util.codec
;;;  ring.util.io
;;;  ring.util.mime-type
;;;  ring.util.response
;;;  ring.util.time
<<<<<<< Updated upstream
;;;  somnium.congomongo
;;;  somnium.congomongo.coerce
;;;  somnium.congomongo.config
;;;  sr-basics.render
;;;  taoensso.carmine
;;;  taoensso.carmine.commands
;;;  taoensso.carmine.connections
;;;  taoensso.carmine.protocol
;;;  taoensso.carmine.utils
;;;  taoensso.encore
;;;  taoensso.nippy
;;;  taoensso.nippy.compression
;;;  taoensso.nippy.encryption
;;;  taoensso.nippy.tools
;;;  taoensso.nippy.utils
;;;  taoensso.timbre
;;;  test
;;;  user
;;;  words)
=======
;;;  user)
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir clojure.data.json)
(dir new.numbers)
;; @@
;; ->
;;; -write
;;; JSONWriter
;;; json-str
;;; pprint
;;; pprint-json
;;; print-json
;;; read
;;; read-json
;;; read-str
;;; write
;;; write-json
;;; write-str
;;; add-rect
;;; extract-rect
;;; factor-pairs
;;; factors
;;; gcf
;;; lcm
;;; lpad-num
;;; mult-rect
;;; neg-pos-num-rect
;;; num-rect
;;; part-sum
;;; print-num-rect
;;; print-string-rect
;;; rotate
;;; rows-to-columns
;;; rpad-string
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc clojure.data.json/read-str)
(doc lpad-num)
(source lpad-num)
;; @@
;; ->
;;; -------------------------
;;; clojure.data.json/read-str
;;; ([string &amp; options])
;;;   Reads one JSON value from input String. Options are the same as for
;;;   read.
;;; -------------------------
;;; new.numbers/lpad-num
;;; ([w n])
;;;   nil
;;; (defn lpad-num
;;;   [w n]
;;;   (str (apply str
;;;               (repeat (- w (count (str n)))
;;;                       &quot; &quot;))
;;;        n))
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
<<<<<<< Updated upstream
=======
(write-str {:a 1 :b [{:c "one"} {:d 5}]})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;{\\&quot;a\\&quot;:1,\\&quot;b\\&quot;:[{\\&quot;c\\&quot;:\\&quot;one\\&quot;},{\\&quot;d\\&quot;:5}]}&quot;</span>","value":"\"{\\\"a\\\":1,\\\"b\\\":[{\\\"c\\\":\\\"one\\\"},{\\\"d\\\":5}]}\""}
;; <=

;; @@
(pprint {:a 1 :b [{:c "one"} {:d 5}]})
;; @@
;; ->
;;; {&quot;a&quot;:1, &quot;b&quot;:[{&quot;c&quot;:&quot;one&quot;}, {&quot;d&quot;:5}]}
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(read-str "{\"a\":1, \"b\":[{\"c\":\"one\"}, {\"d\":5}]}" :key-fn keyword)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[:a 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:c</span>","value":":c"},{"type":"html","content":"<span class='clj-string'>&quot;one&quot;</span>","value":"\"one\""}],"value":"[:c \"one\"]"}],"value":"{:c \"one\"}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:d</span>","value":":d"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"[:d 5]"}],"value":"{:d 5}"}],"value":"[{:c \"one\"} {:d 5}]"}],"value":"[:b [{:c \"one\"} {:d 5}]]"}],"value":"{:a 1, :b [{:c \"one\"} {:d 5}]}"}
;; <=

;; @@
(slurp "http://localhost:1880/echo?one=1&two=2")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;{\\&quot;one\\&quot;:\\&quot;1\\&quot;,\\&quot;two\\&quot;:\\&quot;2\\&quot;}&quot;</span>","value":"\"{\\\"one\\\":\\\"1\\\",\\\"two\\\":\\\"2\\\"}\""}
;; <=

;; @@
(read-str (slurp "http://localhost:1880/echo?one=1&two=two&three=true") :key-fn keyword)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:one</span>","value":":one"},{"type":"html","content":"<span class='clj-string'>&quot;1&quot;</span>","value":"\"1\""}],"value":"[:one \"1\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:two</span>","value":":two"},{"type":"html","content":"<span class='clj-string'>&quot;two&quot;</span>","value":"\"two\""}],"value":"[:two \"two\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:three</span>","value":":three"},{"type":"html","content":"<span class='clj-string'>&quot;true&quot;</span>","value":"\"true\""}],"value":"[:three \"true\"]"}],"value":"{:one \"1\", :two \"two\", :three \"true\"}"}
;; <=

;; @@
(->> (read-str (slurp "http://developer.itsmarta.com/BRDRestService/RestBusRealTimeService/GetAllBus") :key-fn keyword)
     count)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>305</span>","value":"305"}
;; <=

;; @@
(->> (read-str (slurp "http://developer.itsmarta.com/BRDRestService/RestBusRealTimeService/GetAllBus") :key-fn keyword)
     (map :ROUTE)
     (map #(lpad-num 3 %))
     sort
     (partition-by identity)
     (map (juxt first count))
     (apply map list)
     (concat (list (rest (range))))
     (apply map list)
     table-view)
;; @@
;; =>
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;  1&quot;</span>","value":"\"  1\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(1 \"  1\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;  2&quot;</span>","value":"\"  2\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(2 \"  2\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;  3&quot;</span>","value":"\"  3\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(3 \"  3\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-string'>&quot;  4&quot;</span>","value":"\"  4\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(4 \"  4\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;  5&quot;</span>","value":"\"  5\""},{"type":"html","content":"<span class='clj-unkown'>8</span>","value":"8"}],"value":"(5 \"  5\" 8)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-string'>&quot;  6&quot;</span>","value":"\"  6\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(6 \"  6\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-string'>&quot;  8&quot;</span>","value":"\"  8\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(7 \"  8\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-string'>&quot;  9&quot;</span>","value":"\"  9\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(8 \"  9\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-string'>&quot; 12&quot;</span>","value":"\" 12\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(9 \" 12\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-string'>&quot; 14&quot;</span>","value":"\" 14\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(10 \" 14\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"},{"type":"html","content":"<span class='clj-string'>&quot; 15&quot;</span>","value":"\" 15\""},{"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}],"value":"(11 \" 15\" 7)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-string'>&quot; 19&quot;</span>","value":"\" 19\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(12 \" 19\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>13</span>","value":"13"},{"type":"html","content":"<span class='clj-string'>&quot; 21&quot;</span>","value":"\" 21\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(13 \" 21\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-string'>&quot; 24&quot;</span>","value":"\" 24\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(14 \" 24\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-string'>&quot; 25&quot;</span>","value":"\" 25\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(15 \" 25\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-string'>&quot; 26&quot;</span>","value":"\" 26\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(16 \" 26\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>17</span>","value":"17"},{"type":"html","content":"<span class='clj-string'>&quot; 27&quot;</span>","value":"\" 27\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(17 \" 27\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-string'>&quot; 30&quot;</span>","value":"\" 30\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(18 \" 30\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>19</span>","value":"19"},{"type":"html","content":"<span class='clj-string'>&quot; 32&quot;</span>","value":"\" 32\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(19 \" 32\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"},{"type":"html","content":"<span class='clj-string'>&quot; 34&quot;</span>","value":"\" 34\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(20 \" 34\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"},{"type":"html","content":"<span class='clj-string'>&quot; 36&quot;</span>","value":"\" 36\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(21 \" 36\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>22</span>","value":"22"},{"type":"html","content":"<span class='clj-string'>&quot; 37&quot;</span>","value":"\" 37\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(22 \" 37\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"},{"type":"html","content":"<span class='clj-string'>&quot; 39&quot;</span>","value":"\" 39\""},{"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}],"value":"(23 \" 39\" 7)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>24</span>","value":"24"},{"type":"html","content":"<span class='clj-string'>&quot; 40&quot;</span>","value":"\" 40\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(24 \" 40\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>25</span>","value":"25"},{"type":"html","content":"<span class='clj-string'>&quot; 42&quot;</span>","value":"\" 42\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(25 \" 42\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>26</span>","value":"26"},{"type":"html","content":"<span class='clj-string'>&quot; 47&quot;</span>","value":"\" 47\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(26 \" 47\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>27</span>","value":"27"},{"type":"html","content":"<span class='clj-string'>&quot; 49&quot;</span>","value":"\" 49\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(27 \" 49\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>28</span>","value":"28"},{"type":"html","content":"<span class='clj-string'>&quot; 50&quot;</span>","value":"\" 50\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(28 \" 50\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>29</span>","value":"29"},{"type":"html","content":"<span class='clj-string'>&quot; 51&quot;</span>","value":"\" 51\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(29 \" 51\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>30</span>","value":"30"},{"type":"html","content":"<span class='clj-string'>&quot; 55&quot;</span>","value":"\" 55\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(30 \" 55\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>31</span>","value":"31"},{"type":"html","content":"<span class='clj-string'>&quot; 58&quot;</span>","value":"\" 58\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(31 \" 58\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>32</span>","value":"32"},{"type":"html","content":"<span class='clj-string'>&quot; 60&quot;</span>","value":"\" 60\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(32 \" 60\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>33</span>","value":"33"},{"type":"html","content":"<span class='clj-string'>&quot; 66&quot;</span>","value":"\" 66\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(33 \" 66\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>34</span>","value":"34"},{"type":"html","content":"<span class='clj-string'>&quot; 68&quot;</span>","value":"\" 68\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(34 \" 68\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>35</span>","value":"35"},{"type":"html","content":"<span class='clj-string'>&quot; 71&quot;</span>","value":"\" 71\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(35 \" 71\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>36</span>","value":"36"},{"type":"html","content":"<span class='clj-string'>&quot; 73&quot;</span>","value":"\" 73\""},{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"}],"value":"(36 \" 73\" 6)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>37</span>","value":"37"},{"type":"html","content":"<span class='clj-string'>&quot; 74&quot;</span>","value":"\" 74\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(37 \" 74\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>38</span>","value":"38"},{"type":"html","content":"<span class='clj-string'>&quot; 75&quot;</span>","value":"\" 75\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(38 \" 75\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>39</span>","value":"39"},{"type":"html","content":"<span class='clj-string'>&quot; 78&quot;</span>","value":"\" 78\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(39 \" 78\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>40</span>","value":"40"},{"type":"html","content":"<span class='clj-string'>&quot; 79&quot;</span>","value":"\" 79\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(40 \" 79\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>41</span>","value":"41"},{"type":"html","content":"<span class='clj-string'>&quot; 81&quot;</span>","value":"\" 81\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(41 \" 81\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>42</span>","value":"42"},{"type":"html","content":"<span class='clj-string'>&quot; 82&quot;</span>","value":"\" 82\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(42 \" 82\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>43</span>","value":"43"},{"type":"html","content":"<span class='clj-string'>&quot; 83&quot;</span>","value":"\" 83\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(43 \" 83\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>44</span>","value":"44"},{"type":"html","content":"<span class='clj-string'>&quot; 84&quot;</span>","value":"\" 84\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(44 \" 84\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>45</span>","value":"45"},{"type":"html","content":"<span class='clj-string'>&quot; 85&quot;</span>","value":"\" 85\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(45 \" 85\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>46</span>","value":"46"},{"type":"html","content":"<span class='clj-string'>&quot; 86&quot;</span>","value":"\" 86\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(46 \" 86\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>47</span>","value":"47"},{"type":"html","content":"<span class='clj-string'>&quot; 87&quot;</span>","value":"\" 87\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(47 \" 87\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>48</span>","value":"48"},{"type":"html","content":"<span class='clj-string'>&quot; 89&quot;</span>","value":"\" 89\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(48 \" 89\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>49</span>","value":"49"},{"type":"html","content":"<span class='clj-string'>&quot; 93&quot;</span>","value":"\" 93\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(49 \" 93\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>50</span>","value":"50"},{"type":"html","content":"<span class='clj-string'>&quot; 94&quot;</span>","value":"\" 94\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(50 \" 94\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>51</span>","value":"51"},{"type":"html","content":"<span class='clj-string'>&quot; 95&quot;</span>","value":"\" 95\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(51 \" 95\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>52</span>","value":"52"},{"type":"html","content":"<span class='clj-string'>&quot;102&quot;</span>","value":"\"102\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(52 \"102\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>53</span>","value":"53"},{"type":"html","content":"<span class='clj-string'>&quot;103&quot;</span>","value":"\"103\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(53 \"103\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>54</span>","value":"54"},{"type":"html","content":"<span class='clj-string'>&quot;107&quot;</span>","value":"\"107\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(54 \"107\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>55</span>","value":"55"},{"type":"html","content":"<span class='clj-string'>&quot;110&quot;</span>","value":"\"110\""},{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"}],"value":"(55 \"110\" 6)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>56</span>","value":"56"},{"type":"html","content":"<span class='clj-string'>&quot;111&quot;</span>","value":"\"111\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(56 \"111\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>57</span>","value":"57"},{"type":"html","content":"<span class='clj-string'>&quot;114&quot;</span>","value":"\"114\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(57 \"114\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>58</span>","value":"58"},{"type":"html","content":"<span class='clj-string'>&quot;115&quot;</span>","value":"\"115\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(58 \"115\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>59</span>","value":"59"},{"type":"html","content":"<span class='clj-string'>&quot;116&quot;</span>","value":"\"116\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(59 \"116\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>60</span>","value":"60"},{"type":"html","content":"<span class='clj-string'>&quot;117&quot;</span>","value":"\"117\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(60 \"117\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>61</span>","value":"61"},{"type":"html","content":"<span class='clj-string'>&quot;119&quot;</span>","value":"\"119\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(61 \"119\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>62</span>","value":"62"},{"type":"html","content":"<span class='clj-string'>&quot;120&quot;</span>","value":"\"120\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(62 \"120\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>63</span>","value":"63"},{"type":"html","content":"<span class='clj-string'>&quot;121&quot;</span>","value":"\"121\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(63 \"121\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>64</span>","value":"64"},{"type":"html","content":"<span class='clj-string'>&quot;123&quot;</span>","value":"\"123\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(64 \"123\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>65</span>","value":"65"},{"type":"html","content":"<span class='clj-string'>&quot;124&quot;</span>","value":"\"124\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(65 \"124\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>66</span>","value":"66"},{"type":"html","content":"<span class='clj-string'>&quot;125&quot;</span>","value":"\"125\""},{"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}],"value":"(66 \"125\" 4)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>67</span>","value":"67"},{"type":"html","content":"<span class='clj-string'>&quot;126&quot;</span>","value":"\"126\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(67 \"126\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>68</span>","value":"68"},{"type":"html","content":"<span class='clj-string'>&quot;132&quot;</span>","value":"\"132\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(68 \"132\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>69</span>","value":"69"},{"type":"html","content":"<span class='clj-string'>&quot;133&quot;</span>","value":"\"133\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(69 \"133\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>70</span>","value":"70"},{"type":"html","content":"<span class='clj-string'>&quot;140&quot;</span>","value":"\"140\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(70 \"140\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>71</span>","value":"71"},{"type":"html","content":"<span class='clj-string'>&quot;142&quot;</span>","value":"\"142\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(71 \"142\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>72</span>","value":"72"},{"type":"html","content":"<span class='clj-string'>&quot;150&quot;</span>","value":"\"150\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(72 \"150\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>73</span>","value":"73"},{"type":"html","content":"<span class='clj-string'>&quot;153&quot;</span>","value":"\"153\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(73 \"153\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>74</span>","value":"74"},{"type":"html","content":"<span class='clj-string'>&quot;155&quot;</span>","value":"\"155\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(74 \"155\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>75</span>","value":"75"},{"type":"html","content":"<span class='clj-string'>&quot;162&quot;</span>","value":"\"162\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(75 \"162\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>76</span>","value":"76"},{"type":"html","content":"<span class='clj-string'>&quot;165&quot;</span>","value":"\"165\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(76 \"165\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>77</span>","value":"77"},{"type":"html","content":"<span class='clj-string'>&quot;172&quot;</span>","value":"\"172\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(77 \"172\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>78</span>","value":"78"},{"type":"html","content":"<span class='clj-string'>&quot;178&quot;</span>","value":"\"178\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(78 \"178\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>79</span>","value":"79"},{"type":"html","content":"<span class='clj-string'>&quot;180&quot;</span>","value":"\"180\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(79 \"180\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>80</span>","value":"80"},{"type":"html","content":"<span class='clj-string'>&quot;181&quot;</span>","value":"\"181\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(80 \"181\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>81</span>","value":"81"},{"type":"html","content":"<span class='clj-string'>&quot;183&quot;</span>","value":"\"183\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(81 \"183\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>82</span>","value":"82"},{"type":"html","content":"<span class='clj-string'>&quot;185&quot;</span>","value":"\"185\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(82 \"185\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>83</span>","value":"83"},{"type":"html","content":"<span class='clj-string'>&quot;186&quot;</span>","value":"\"186\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(83 \"186\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>84</span>","value":"84"},{"type":"html","content":"<span class='clj-string'>&quot;189&quot;</span>","value":"\"189\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(84 \"189\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>85</span>","value":"85"},{"type":"html","content":"<span class='clj-string'>&quot;191&quot;</span>","value":"\"191\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(85 \"191\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>86</span>","value":"86"},{"type":"html","content":"<span class='clj-string'>&quot;192&quot;</span>","value":"\"192\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(86 \"192\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>87</span>","value":"87"},{"type":"html","content":"<span class='clj-string'>&quot;193&quot;</span>","value":"\"193\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(87 \"193\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>88</span>","value":"88"},{"type":"html","content":"<span class='clj-string'>&quot;194&quot;</span>","value":"\"194\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(88 \"194\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>89</span>","value":"89"},{"type":"html","content":"<span class='clj-string'>&quot;195&quot;</span>","value":"\"195\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(89 \"195\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>90</span>","value":"90"},{"type":"html","content":"<span class='clj-string'>&quot;196&quot;</span>","value":"\"196\""},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"(90 \"196\" 5)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>91</span>","value":"91"},{"type":"html","content":"<span class='clj-string'>&quot;295&quot;</span>","value":"\"295\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(91 \"295\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>92</span>","value":"92"},{"type":"html","content":"<span class='clj-string'>&quot;800&quot;</span>","value":"\"800\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(92 \"800\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>93</span>","value":"93"},{"type":"html","content":"<span class='clj-string'>&quot;809&quot;</span>","value":"\"809\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(93 \"809\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>94</span>","value":"94"},{"type":"html","content":"<span class='clj-string'>&quot;813&quot;</span>","value":"\"813\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(94 \"813\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>95</span>","value":"95"},{"type":"html","content":"<span class='clj-string'>&quot;816&quot;</span>","value":"\"816\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(95 \"816\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>96</span>","value":"96"},{"type":"html","content":"<span class='clj-string'>&quot;823&quot;</span>","value":"\"823\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(96 \"823\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>97</span>","value":"97"},{"type":"html","content":"<span class='clj-string'>&quot;825&quot;</span>","value":"\"825\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(97 \"825\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>98</span>","value":"98"},{"type":"html","content":"<span class='clj-string'>&quot;832&quot;</span>","value":"\"832\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(98 \"832\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>99</span>","value":"99"},{"type":"html","content":"<span class='clj-string'>&quot;850&quot;</span>","value":"\"850\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(99 \"850\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>100</span>","value":"100"},{"type":"html","content":"<span class='clj-string'>&quot;853&quot;</span>","value":"\"853\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(100 \"853\" 3)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>101</span>","value":"101"},{"type":"html","content":"<span class='clj-string'>&quot;856&quot;</span>","value":"\"856\""},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"(101 \"856\" 1)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>102</span>","value":"102"},{"type":"html","content":"<span class='clj-string'>&quot;865&quot;</span>","value":"\"865\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"(102 \"865\" 2)"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>103</span>","value":"103"},{"type":"html","content":"<span class='clj-string'>&quot;867&quot;</span>","value":"\"867\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"(103 \"867\" 3)"}],"value":"#gorilla_repl.table.TableView{:contents ((1 \"  1\" 2) (2 \"  2\" 3) (3 \"  3\" 3) (4 \"  4\" 2) (5 \"  5\" 8) (6 \"  6\" 3) (7 \"  8\" 1) (8 \"  9\" 4) (9 \" 12\" 4) (10 \" 14\" 1) (11 \" 15\" 7) (12 \" 19\" 2) (13 \" 21\" 4) (14 \" 24\" 2) (15 \" 25\" 2) (16 \" 26\" 4) (17 \" 27\" 3) (18 \" 30\" 2) (19 \" 32\" 3) (20 \" 34\" 2) (21 \" 36\" 3) (22 \" 37\" 3) (23 \" 39\" 7) (24 \" 40\" 2) (25 \" 42\" 3) (26 \" 47\" 2) (27 \" 49\" 4) (28 \" 50\" 3) (29 \" 51\" 5) (30 \" 55\" 4) (31 \" 58\" 2) (32 \" 60\" 3) (33 \" 66\" 4) (34 \" 68\" 4) (35 \" 71\" 4) (36 \" 73\" 6) (37 \" 74\" 2) (38 \" 75\" 2) (39 \" 78\" 3) (40 \" 79\" 2) (41 \" 81\" 4) (42 \" 82\" 4) (43 \" 83\" 5) (44 \" 84\" 3) (45 \" 85\" 3) (46 \" 86\" 3) (47 \" 87\" 4) (48 \" 89\" 5) (49 \" 93\" 3) (50 \" 94\" 3) (51 \" 95\" 4) (52 \"102\" 1) (53 \"103\" 2) (54 \"107\" 4) (55 \"110\" 6) (56 \"111\" 4) (57 \"114\" 2) (58 \"115\" 4) (59 \"116\" 3) (60 \"117\" 5) (61 \"119\" 2) (62 \"120\" 4) (63 \"121\" 5) (64 \"123\" 2) (65 \"124\" 3) (66 \"125\" 4) (67 \"126\" 1) (68 \"132\" 1) (69 \"133\" 1) (70 \"140\" 2) (71 \"142\" 1) (72 \"150\" 1) (73 \"153\" 1) (74 \"155\" 2) (75 \"162\" 2) (76 \"165\" 3) (77 \"172\" 2) (78 \"178\" 2) (79 \"180\" 3) (80 \"181\" 5) (81 \"183\" 2) (82 \"185\" 3) (83 \"186\" 3) (84 \"189\" 5) (85 \"191\" 3) (86 \"192\" 2) (87 \"193\" 5) (88 \"194\" 2) (89 \"195\" 2) (90 \"196\" 5) (91 \"295\" 1) (92 \"800\" 1) (93 \"809\" 3) (94 \"813\" 1) (95 \"816\" 3) (96 \"823\" 1) (97 \"825\" 1) (98 \"832\" 2) (99 \"850\" 2) (100 \"853\" 3) (101 \"856\" 1) (102 \"865\" 2) (103 \"867\" 3)), :opts nil}"}
;; <=

;; @@
(->> (read-str (slurp "http://developer.itsmarta.com/BRDRestService/RestBusRealTimeService/GetAllBus") :key-fn keyword)
     (filter #(= (:ROUTE %) "140"))
     ;(filter #(= (:VEHICLE %) "1562"))
     (map (juxt :ROUTE
                :MSGTIME
                :DIRECTION
                :VEHICLE
                :LONGITUDE
                :LATITUDE
                :STOPID
                :BLOCK_ABBR
                :BLOCKID
                :TIMEPOINT
                :TRIPID
                :ADHERENCE))
     sort
     (apply map list)
     (concat (list (rest (range))))
     (apply map list)
     table-view)
;; @@
;; =>
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;140&quot;</span>","value":"\"140\""},{"type":"html","content":"<span class='clj-string'>&quot;11/19/2018 1:51:04 PM&quot;</span>","value":"\"11/19/2018 1:51:04 PM\""},{"type":"html","content":"<span class='clj-string'>&quot;Southbound&quot;</span>","value":"\"Southbound\""},{"type":"html","content":"<span class='clj-string'>&quot;1672&quot;</span>","value":"\"1672\""},{"type":"html","content":"<span class='clj-string'>&quot;-84.3138786&quot;</span>","value":"\"-84.3138786\""},{"type":"html","content":"<span class='clj-string'>&quot;34.0376592&quot;</span>","value":"\"34.0376592\""},{"type":"html","content":"<span class='clj-string'>&quot;903120&quot;</span>","value":"\"903120\""},{"type":"html","content":"<span class='clj-string'>&quot;140-2&quot;</span>","value":"\"140-2\""},{"type":"html","content":"<span class='clj-string'>&quot;123&quot;</span>","value":"\"123\""},{"type":"html","content":"<span class='clj-string'>&quot;Mansell Park &amp; Ride&quot;</span>","value":"\"Mansell Park & Ride\""},{"type":"html","content":"<span class='clj-string'>&quot;6439185&quot;</span>","value":"\"6439185\""},{"type":"html","content":"<span class='clj-string'>&quot;-1&quot;</span>","value":"\"-1\""}],"value":"(1 \"140\" \"11/19/2018 1:51:04 PM\" \"Southbound\" \"1672\" \"-84.3138786\" \"34.0376592\" \"903120\" \"140-2\" \"123\" \"Mansell Park & Ride\" \"6439185\" \"-1\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;140&quot;</span>","value":"\"140\""},{"type":"html","content":"<span class='clj-string'>&quot;11/19/2018 1:51:10 PM&quot;</span>","value":"\"11/19/2018 1:51:10 PM\""},{"type":"html","content":"<span class='clj-string'>&quot;Northbound&quot;</span>","value":"\"Northbound\""},{"type":"html","content":"<span class='clj-string'>&quot;2538&quot;</span>","value":"\"2538\""},{"type":"html","content":"<span class='clj-string'>&quot;-84.3107785&quot;</span>","value":"\"-84.3107785\""},{"type":"html","content":"<span class='clj-string'>&quot;34.0388433&quot;</span>","value":"\"34.0388433\""},{"type":"html","content":"<span class='clj-string'>&quot;903177&quot;</span>","value":"\"903177\""},{"type":"html","content":"<span class='clj-string'>&quot;140-1&quot;</span>","value":"\"140-1\""},{"type":"html","content":"<span class='clj-string'>&quot;122&quot;</span>","value":"\"122\""},{"type":"html","content":"<span class='clj-string'>&quot;Mansell Park &amp; Ride&quot;</span>","value":"\"Mansell Park & Ride\""},{"type":"html","content":"<span class='clj-string'>&quot;6438409&quot;</span>","value":"\"6438409\""},{"type":"html","content":"<span class='clj-string'>&quot;-3&quot;</span>","value":"\"-3\""}],"value":"(2 \"140\" \"11/19/2018 1:51:10 PM\" \"Northbound\" \"2538\" \"-84.3107785\" \"34.0388433\" \"903177\" \"140-1\" \"122\" \"Mansell Park & Ride\" \"6438409\" \"-3\")"}],"value":"#gorilla_repl.table.TableView{:contents ((1 \"140\" \"11/19/2018 1:51:04 PM\" \"Southbound\" \"1672\" \"-84.3138786\" \"34.0376592\" \"903120\" \"140-2\" \"123\" \"Mansell Park & Ride\" \"6439185\" \"-1\") (2 \"140\" \"11/19/2018 1:51:10 PM\" \"Northbound\" \"2538\" \"-84.3107785\" \"34.0388433\" \"903177\" \"140-1\" \"122\" \"Mansell Park & Ride\" \"6438409\" \"-3\")), :opts nil}"}
;; <=

;; @@
(slurp "http://developer.itsmarta.com/BRDRestService/RestBusRealTimeService/GetAllBus")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;[]&quot;</span>","value":"\"[]\""}
;; <=

;; @@
(dir clojure.xml)
;; @@

;; @@
(require '[clojure.xml :as xml])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(slurp "http://localhost:1880/xml?one=1&two=2&three=true")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;&lt;?xml version=\\&quot;1.0\\&quot; encoding=\\&quot;UTF-8\\&quot; standalone=\\&quot;yes\\&quot;?&gt;&lt;root&gt;&lt;one&gt;1&lt;/one&gt;&lt;two&gt;2&lt;/two&gt;&lt;three&gt;true&lt;/three&gt;&lt;/root&gt;&quot;</span>","value":"\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?><root><one>1</one><two>2</two><three>true</three></root>\""}
;; <=

;; @@
(xml/parse "http://localhost:1880/xml?one=1&two=2&three=true")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tag</span>","value":":tag"},{"type":"html","content":"<span class='clj-keyword'>:root</span>","value":":root"}],"value":"[:tag :root]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:attrs</span>","value":":attrs"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[:attrs nil]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:content</span>","value":":content"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tag</span>","value":":tag"},{"type":"html","content":"<span class='clj-keyword'>:one</span>","value":":one"}],"value":"[:tag :one]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:attrs</span>","value":":attrs"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[:attrs nil]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:content</span>","value":":content"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;1&quot;</span>","value":"\"1\""}],"value":"[\"1\"]"}],"value":"[:content [\"1\"]]"}],"value":"{:tag :one, :attrs nil, :content [\"1\"]}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tag</span>","value":":tag"},{"type":"html","content":"<span class='clj-keyword'>:two</span>","value":":two"}],"value":"[:tag :two]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:attrs</span>","value":":attrs"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[:attrs nil]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:content</span>","value":":content"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;2&quot;</span>","value":"\"2\""}],"value":"[\"2\"]"}],"value":"[:content [\"2\"]]"}],"value":"{:tag :two, :attrs nil, :content [\"2\"]}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tag</span>","value":":tag"},{"type":"html","content":"<span class='clj-keyword'>:three</span>","value":":three"}],"value":"[:tag :three]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:attrs</span>","value":":attrs"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[:attrs nil]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:content</span>","value":":content"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;true&quot;</span>","value":"\"true\""}],"value":"[\"true\"]"}],"value":"[:content [\"true\"]]"}],"value":"{:tag :three, :attrs nil, :content [\"true\"]}"}],"value":"[{:tag :one, :attrs nil, :content [\"1\"]} {:tag :two, :attrs nil, :content [\"2\"]} {:tag :three, :attrs nil, :content [\"true\"]}]"}],"value":"[:content [{:tag :one, :attrs nil, :content [\"1\"]} {:tag :two, :attrs nil, :content [\"2\"]} {:tag :three, :attrs nil, :content [\"true\"]}]]"}],"value":"{:tag :root, :attrs nil, :content [{:tag :one, :attrs nil, :content [\"1\"]} {:tag :two, :attrs nil, :content [\"2\"]} {:tag :three, :attrs nil, :content [\"true\"]}]}"}
;; <=

;; @@
(->> "http://localhost:1880/xml?one=1&two=2&three=true"
     xml/parse
     :content
     (map (juxt :tag 
                (comp first :content)))
     (apply map list)
     (apply zipmap))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:one</span>","value":":one"},{"type":"html","content":"<span class='clj-string'>&quot;1&quot;</span>","value":"\"1\""}],"value":"[:one \"1\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:two</span>","value":":two"},{"type":"html","content":"<span class='clj-string'>&quot;2&quot;</span>","value":"\"2\""}],"value":"[:two \"2\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:three</span>","value":":three"},{"type":"html","content":"<span class='clj-string'>&quot;true&quot;</span>","value":"\"true\""}],"value":"[:three \"true\"]"}],"value":"{:one \"1\", :two \"2\", :three \"true\"}"}
;; <=

;; @@
(println (slurp "http://localhost:1880/html?arg1=3&arg2=2"))
;; @@
;; ->
;;; &lt;html&gt;
;;;     &lt;head&gt;
;;;         &lt;title&gt;HTML&lt;/title&gt;
;;;     &lt;/head&gt;
;;;     &lt;body&gt;
;;;         &lt;p&gt;This is the payload:&lt;/p&gt;
;;;         &lt;ul&gt;
;;;             &lt;li&gt;arg1 = 3&lt;/li&gt;
;;;             &lt;li&gt;arg2 = 2&lt;/li&gt;
;;;         &lt;/ul&gt;
;;;     &lt;/body&gt;
;;; &lt;/html&gt;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
>>>>>>> Stashed changes

;; @@
