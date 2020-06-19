;; gorilla-repl.fileformat = 1

;; **
;;; # Arango DB Examples
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns arangodb-example
  (:require [gorilla-plot.core :as plot])
  (:require [clarango.core :as clacore]
            [clarango.document :as document]
            [clarango.collection :as collection]
            [clarango.graph :as graph]
            [clarango.user :as user])
  (:use clojure.repl))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ## Connection
;; **

;; @@
;; connect to localhost and default port 8529
;;(clacore/set-connection!)
(clacore/set-connection! {
                           :connection-url "http://localhost:8529/"
                           :db-name "my-db"
                           :collection-name "test-collection"
                           :graph-name "test-graph"
                           })
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clarango.core/clarango-connection</span>","value":"#'clarango.core/clarango-connection"}
;; <=

;; @@
(clacore/get-connection)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:connection-url</span>","value":":connection-url"},{"type":"html","content":"<span class='clj-string'>&quot;http://localhost:8529/&quot;</span>","value":"\"http://localhost:8529/\""}],"value":"[:connection-url \"http://localhost:8529/\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:db-name</span>","value":":db-name"},{"type":"html","content":"<span class='clj-string'>&quot;my-db&quot;</span>","value":"\"my-db\""}],"value":"[:db-name \"my-db\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:collection-name</span>","value":":collection-name"},{"type":"html","content":"<span class='clj-string'>&quot;test-collection&quot;</span>","value":"\"test-collection\""}],"value":"[:collection-name \"test-collection\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:graph-name</span>","value":":graph-name"},{"type":"html","content":"<span class='clj-string'>&quot;test-graph&quot;</span>","value":"\"test-graph\""}],"value":"[:graph-name \"test-graph\"]"}],"value":"{:connection-url \"http://localhost:8529/\", :db-name \"my-db\", :collection-name \"test-collection\", :graph-name \"test-graph\"}"}
;; <=

;; @@
;; change default db
;;(clacore/set-default-db! "my-db")
;; create test collection
(collection/create "test-collection")
;;(clacore/set-default-collection! "test-collection")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;error&quot;</span>","value":"\"error\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"error\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;id&quot;</span>","value":"\"id\""},{"type":"html","content":"<span class='clj-string'>&quot;3156&quot;</span>","value":"\"3156\""}],"value":"[\"id\" \"3156\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;isSystem&quot;</span>","value":"\"isSystem\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"isSystem\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;name&quot;</span>","value":"\"name\""},{"type":"html","content":"<span class='clj-string'>&quot;test-collection&quot;</span>","value":"\"test-collection\""}],"value":"[\"name\" \"test-collection\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;waitForSync&quot;</span>","value":"\"waitForSync\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"waitForSync\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;status&quot;</span>","value":"\"status\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"[\"status\" 3]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;isVolatile&quot;</span>","value":"\"isVolatile\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"isVolatile\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;type&quot;</span>","value":"\"type\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"[\"type\" 2]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;code&quot;</span>","value":"\"code\""},{"type":"html","content":"<span class='clj-unkown'>200</span>","value":"200"}],"value":"[\"code\" 200]"}],"value":"{\"error\" false, \"id\" \"3156\", \"isSystem\" false, \"name\" \"test-collection\", \"waitForSync\" false, \"status\" 3, \"isVolatile\" false, \"type\" 2, \"code\" 200}"}
;; <=

;; **
;;; ## Document CRUD
;; **

;; @@
;; create
(document/create-with-key {:description "some test document"} :test-doc)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;test-collection/test-doc&quot;</span>","value":"\"test-collection/test-doc\""}],"value":"[\"_id\" \"test-collection/test-doc\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_key&quot;</span>","value":"\"_key\""},{"type":"html","content":"<span class='clj-string'>&quot;test-doc&quot;</span>","value":"\"test-doc\""}],"value":"[\"_key\" \"test-doc\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1q5Gy---&quot;</span>","value":"\"_US1q5Gy---\""}],"value":"[\"_rev\" \"_US1q5Gy---\"]"}],"value":"{\"_id\" \"test-collection/test-doc\", \"_key\" \"test-doc\", \"_rev\" \"_US1q5Gy---\"}"}
;; <=

;; @@
;; read
(document/get-by-key :test-doc)
(document/get-by-example {:description "some test document"})
(document/get-by-example {:name "Jeff"})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_key&quot;</span>","value":"\"_key\""},{"type":"html","content":"<span class='clj-string'>&quot;3250&quot;</span>","value":"\"3250\""}],"value":"[\"_key\" \"3250\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;test-collection/3250&quot;</span>","value":"\"test-collection/3250\""}],"value":"[\"_id\" \"test-collection/3250\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1sfNa---&quot;</span>","value":"\"_US1sfNa---\""}],"value":"[\"_rev\" \"_US1sfNa---\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;age&quot;</span>","value":"\"age\""},{"type":"html","content":"<span class='clj-unkown'>59</span>","value":"59"}],"value":"[\"age\" 59]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;name&quot;</span>","value":"\"name\""},{"type":"html","content":"<span class='clj-string'>&quot;Jeff&quot;</span>","value":"\"Jeff\""}],"value":"[\"name\" \"Jeff\"]"}],"value":"{\"_key\" \"3250\", \"_id\" \"test-collection/3250\", \"_rev\" \"_US1sfNa---\", \"age\" 59, \"name\" \"Jeff\"}"}],"value":"[{\"_key\" \"3250\", \"_id\" \"test-collection/3250\", \"_rev\" \"_US1sfNa---\", \"age\" 59, \"name\" \"Jeff\"}]"}
;; <=

;; @@
;; update
(document/update-by-key {:additional "some additional info"} :test-doc)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;test-collection/test-doc&quot;</span>","value":"\"test-collection/test-doc\""}],"value":"[\"_id\" \"test-collection/test-doc\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_key&quot;</span>","value":"\"_key\""},{"type":"html","content":"<span class='clj-string'>&quot;test-doc&quot;</span>","value":"\"test-doc\""}],"value":"[\"_key\" \"test-doc\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1tc3a---&quot;</span>","value":"\"_US1tc3a---\""}],"value":"[\"_rev\" \"_US1tc3a---\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_oldRev&quot;</span>","value":"\"_oldRev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1q5Gy---&quot;</span>","value":"\"_US1q5Gy---\""}],"value":"[\"_oldRev\" \"_US1q5Gy---\"]"}],"value":"{\"_id\" \"test-collection/test-doc\", \"_key\" \"test-doc\", \"_rev\" \"_US1tc3a---\", \"_oldRev\" \"_US1q5Gy---\"}"}
;; <=

;; @@
;; delete
(document/delete-by-key :test-doc)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;test-collection/test-doc&quot;</span>","value":"\"test-collection/test-doc\""}],"value":"[\"_id\" \"test-collection/test-doc\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_key&quot;</span>","value":"\"_key\""},{"type":"html","content":"<span class='clj-string'>&quot;test-doc&quot;</span>","value":"\"test-doc\""}],"value":"[\"_key\" \"test-doc\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1tc3a---&quot;</span>","value":"\"_US1tc3a---\""}],"value":"[\"_rev\" \"_US1tc3a---\"]"}],"value":"{\"_id\" \"test-collection/test-doc\", \"_key\" \"test-doc\", \"_rev\" \"_US1tc3a---\"}"}
;; <=

;; **
;;; ## Graph
;; **

;; @@
;; create graph collections
(collection/create "people" {"type" 2})
(collection/create "content" {"type" 2})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;error&quot;</span>","value":"\"error\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"error\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;id&quot;</span>","value":"\"id\""},{"type":"html","content":"<span class='clj-string'>&quot;3473&quot;</span>","value":"\"3473\""}],"value":"[\"id\" \"3473\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;isSystem&quot;</span>","value":"\"isSystem\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"isSystem\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;name&quot;</span>","value":"\"name\""},{"type":"html","content":"<span class='clj-string'>&quot;content&quot;</span>","value":"\"content\""}],"value":"[\"name\" \"content\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;waitForSync&quot;</span>","value":"\"waitForSync\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"waitForSync\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;status&quot;</span>","value":"\"status\""},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"[\"status\" 3]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;isVolatile&quot;</span>","value":"\"isVolatile\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"isVolatile\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;type&quot;</span>","value":"\"type\""},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"[\"type\" 2]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;code&quot;</span>","value":"\"code\""},{"type":"html","content":"<span class='clj-unkown'>200</span>","value":"200"}],"value":"[\"code\" 200]"}],"value":"{\"error\" false, \"id\" \"3473\", \"isSystem\" false, \"name\" \"content\", \"waitForSync\" false, \"status\" 3, \"isVolatile\" false, \"type\" 2, \"code\" 200}"}
;; <=

;; @@
(graph/create :test-graph [{:edge-collection "my-test-edges" :from [:people] :to [:content]}])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;name&quot;</span>","value":"\"name\""},{"type":"html","content":"<span class='clj-string'>&quot;test-graph&quot;</span>","value":"\"test-graph\""}],"value":"[\"name\" \"test-graph\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;edgeDefinitions&quot;</span>","value":"\"edgeDefinitions\""},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;collection&quot;</span>","value":"\"collection\""},{"type":"html","content":"<span class='clj-string'>&quot;my-test-edges&quot;</span>","value":"\"my-test-edges\""}],"value":"[\"collection\" \"my-test-edges\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;from&quot;</span>","value":"\"from\""},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;people&quot;</span>","value":"\"people\""}],"value":"[\"people\"]"}],"value":"[\"from\" [\"people\"]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;to&quot;</span>","value":"\"to\""},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;content&quot;</span>","value":"\"content\""}],"value":"[\"content\"]"}],"value":"[\"to\" [\"content\"]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;orphanCollections&quot;</span>","value":"\"orphanCollections\""},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[],"value":"[]"}],"value":"[\"orphanCollections\" []]"}],"value":"{\"collection\" \"my-test-edges\", \"from\" [\"people\"], \"to\" [\"content\"], \"orphanCollections\" []}"}],"value":"[{\"collection\" \"my-test-edges\", \"from\" [\"people\"], \"to\" [\"content\"], \"orphanCollections\" []}]"}],"value":"[\"edgeDefinitions\" [{\"collection\" \"my-test-edges\", \"from\" [\"people\"], \"to\" [\"content\"], \"orphanCollections\" []}]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;orphanCollections&quot;</span>","value":"\"orphanCollections\""},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[],"value":"[]"}],"value":"[\"orphanCollections\" []]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;isSmart&quot;</span>","value":"\"isSmart\""},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"[\"isSmart\" false]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;numberOfShards&quot;</span>","value":"\"numberOfShards\""},{"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}],"value":"[\"numberOfShards\" 0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;smartGraphAttribute&quot;</span>","value":"\"smartGraphAttribute\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""}],"value":"[\"smartGraphAttribute\" \"\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;_graphs/test-graph&quot;</span>","value":"\"_graphs/test-graph\""}],"value":"[\"_id\" \"_graphs/test-graph\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1vPyu---&quot;</span>","value":"\"_US1vPyu---\""}],"value":"[\"_rev\" \"_US1vPyu---\"]"}],"value":"{\"name\" \"test-graph\", \"edgeDefinitions\" [{\"collection\" \"my-test-edges\", \"from\" [\"people\"], \"to\" [\"content\"], \"orphanCollections\" []}], \"orphanCollections\" [], \"isSmart\" false, \"numberOfShards\" 0, \"smartGraphAttribute\" \"\", \"_id\" \"_graphs/test-graph\", \"_rev\" \"_US1vPyu---\"}"}
;; <=

;; @@
(graph/create-vertex {:name "Rich Hickey"} :people)
(graph/create-vertex {:name "Simple Made Easy"} :content)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;content/3613&quot;</span>","value":"\"content/3613\""}],"value":"[\"_id\" \"content/3613\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_key&quot;</span>","value":"\"_key\""},{"type":"html","content":"<span class='clj-string'>&quot;3613&quot;</span>","value":"\"3613\""}],"value":"[\"_key\" \"3613\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1w2Wa---&quot;</span>","value":"\"_US1w2Wa---\""}],"value":"[\"_rev\" \"_US1w2Wa---\"]"}],"value":"{\"_id\" \"content/3613\", \"_key\" \"3613\", \"_rev\" \"_US1w2Wa---\"}"}
;; <=

;; @@
(graph/get-vertex "3608" :people)
(graph/get-vertex "3613" :content)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_key&quot;</span>","value":"\"_key\""},{"type":"html","content":"<span class='clj-string'>&quot;3613&quot;</span>","value":"\"3613\""}],"value":"[\"_key\" \"3613\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;content/3613&quot;</span>","value":"\"content/3613\""}],"value":"[\"_id\" \"content/3613\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US1w2Wa---&quot;</span>","value":"\"_US1w2Wa---\""}],"value":"[\"_rev\" \"_US1w2Wa---\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;name&quot;</span>","value":"\"name\""},{"type":"html","content":"<span class='clj-string'>&quot;Simple Made Easy&quot;</span>","value":"\"Simple Made Easy\""}],"value":"[\"name\" \"Simple Made Easy\"]"}],"value":"{\"_key\" \"3613\", \"_id\" \"content/3613\", \"_rev\" \"_US1w2Wa---\", \"name\" \"Simple Made Easy\"}"}
;; <=

;; @@
(graph/create-edge {:type "made"} 
                   (graph/get-vertex "3608" :people) 
                   (graph/get-vertex "3613" :content) 
                   "my-test-edges")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_id&quot;</span>","value":"\"_id\""},{"type":"html","content":"<span class='clj-string'>&quot;my-test-edges/3960&quot;</span>","value":"\"my-test-edges/3960\""}],"value":"[\"_id\" \"my-test-edges/3960\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_key&quot;</span>","value":"\"_key\""},{"type":"html","content":"<span class='clj-string'>&quot;3960&quot;</span>","value":"\"3960\""}],"value":"[\"_key\" \"3960\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_rev&quot;</span>","value":"\"_rev\""},{"type":"html","content":"<span class='clj-string'>&quot;_US12QZC---&quot;</span>","value":"\"_US12QZC---\""}],"value":"[\"_rev\" \"_US12QZC---\"]"}],"value":"{\"_id\" \"my-test-edges/3960\", \"_key\" \"3960\", \"_rev\" \"_US12QZC---\"}"}
;; <=

;; **
;;; ### Traversals
;; **

;; @@
;;(graph/execute-traversal :alice :persons :knows "outbound")
(graph/execute-traversal "3608" :content :my-test-edges "outbound")
;; @@

;; **
;;; ## Documentation
;; **

;; @@
(dir clarango.core)
;; @@
;; ->
;;; clarango-connection
;;; connection-set?
;;; get-connection
;;; set-connection!
;;; set-connection-url!
;;; set-default-collection!
;;; set-default-db!
;;; set-default-graph!
;;; with-collection
;;; with-connection
;;; with-db
;;; with-graph
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir clarango.document)
;; @@
;; ->
;;; create
;;; create-with-key
;;; delete-by-example
;;; delete-by-key
;;; delete-by-keys
;;; get-by-example
;;; get-by-key
;;; get-by-keys
;;; get-first-by-example
;;; get-info
;;; replace-by-example
;;; replace-by-key
;;; update-by-example
;;; update-by-key
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir clarango.collection)
;; @@
;; ->
;;; create
;;; delete
;;; get-all-documents
;;; get-all-indexes
;;; get-delayed-collection
;;; get-extended-info
;;; get-extended-info-count
;;; get-extended-info-figures
;;; get-info
;;; load-mem
;;; modify-properties
;;; rename
;;; rotate
;;; truncate
;;; unload-mem
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir clarango.graph)
;; @@
;; ->
;;; create
;;; create-edge
;;; create-edge-with-key
;;; create-vertex
;;; create-vertex-with-key
;;; delete
;;; delete-edge
;;; delete-vertex
;;; execute-traversal
;;; get-edge
;;; get-info
;;; get-vertex
;;; replace-edge
;;; replace-vertex
;;; update-edge
;;; update-vertex
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir clarango.user)
;; @@
;; ->
;;; create
;;; delete-by-username
;;; exists?
;;; get-all
;;; get-by-username
;;; replace-by-username
;;; update-by-username
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc clarango.graph/get-edge)
;; @@
;; ->
;;; -------------------------
;;; clarango.graph/get-edge
;;; ([key edge-collection &amp; args])
;;;   Gets an edge.
;;; 
;;;   Takes the edge key as the first argument.
;;;   Takes the edge-collection name as the second argument.
;;; 
;;;   Optionally takes a graph-name and a db name as further arguments.
;;;   If omitted, the default graph and db will be used.
;;; 
;;;   Also optional as argument is another map containing further options:
;;;   {&#x27;rev&#x27; revision_id} (replace the single quotes with double quotes)
;;;   - rev is the document revision; if the current document revision_id does not match the given one, an error is thrown;
;;;   The option map might be passed in an arbitrary position after the first argument.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
