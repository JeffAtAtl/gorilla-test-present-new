;; gorilla-repl.fileformat = 1

;; **
;;; # Couchdb Example
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;; **

;; @@
(ns couchdb-example
  (:use com.ashafa.clutch)
  (:use clojure.repl)
  (:use clojure.pprint))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def db (couch "test"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;couchdb-example/db</span>","value":"#'couchdb-example/db"}
;; <=

;; @@
(create! db)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#&lt;CouchDB com.ashafa.clutch.CouchDB@3bcca0d6&gt;</span>","value":"#<CouchDB com.ashafa.clutch.CouchDB@3bcca0d6>"}
;; <=

;; @@
(:result (meta *1))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(reduce conj! db (for [x (range 5000)]
                      {:_id (str x) :a [1 2 x]}))
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"html","content":"<span class='clj-unkown'>#&lt;CouchDB com.ashafa.clutch.CouchDB@2ccffb44&gt;</span>","value":"#<CouchDB com.ashafa.clutch.CouchDB@2ccffb44>"}
=======
;;; {"type":"html","content":"<span class='clj-unkown'>#object[com.ashafa.clutch.CouchDB 0x78841c20 &quot;com.ashafa.clutch.CouchDB@78841c20&quot;]</span>","value":"#object[com.ashafa.clutch.CouchDB 0x78841c20 \"com.ashafa.clutch.CouchDB@78841c20\"]"}
>>>>>>> Stashed changes
;; <=

;; @@
(count db)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>5000</span>","value":"5000"}
;; <=

;; @@
(get-in db ["68" :a 2])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>68</span>","value":"68"}
;; <=

;; @@
(def copy (into {} db))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;couchdb-example/copy</span>","value":"#'couchdb-example/copy"}
;; <=

;; @@
(get-in copy ["68" :a 2])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>68</span>","value":"68"}
;; <=

;; @@
(first db)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;0&quot;</span>","value":"\"0\""},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-string'>&quot;0&quot;</span>","value":"\"0\""}],"value":"[:_id \"0\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_rev</span>","value":":_rev"},{"type":"html","content":"<span class='clj-string'>&quot;19-023e148e2843854af7a7b4b6be9ae34e&quot;</span>","value":"\"19-023e148e2843854af7a7b4b6be9ae34e\""}],"value":"[:_rev \"19-023e148e2843854af7a7b4b6be9ae34e\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}],"value":"[1 2 0]"}],"value":"[:a [1 2 0]]"}],"value":"{:_id \"0\", :_rev \"19-023e148e2843854af7a7b4b6be9ae34e\", :a [1 2 0]}"}],"value":"[\"0\" {:_id \"0\", :_rev \"19-023e148e2843854af7a7b4b6be9ae34e\", :a [1 2 0]}]"}
;; <=

;; @@
(first copy)
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;3630&quot;</span>","value":"\"3630\""},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-string'>&quot;3630&quot;</span>","value":"\"3630\""}],"value":"[:_id \"3630\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_rev</span>","value":":_rev"},{"type":"html","content":"<span class='clj-string'>&quot;19-44452d9aaaf2f62dba93dd269c2d4825&quot;</span>","value":"\"19-44452d9aaaf2f62dba93dd269c2d4825\""}],"value":"[:_rev \"19-44452d9aaaf2f62dba93dd269c2d4825\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-unkown'>3630</span>","value":"3630"}],"value":"[1 2 3630]"}],"value":"[:a [1 2 3630]]"}],"value":"{:_id \"3630\", :_rev \"19-44452d9aaaf2f62dba93dd269c2d4825\", :a [1 2 3630]}"}],"value":"[\"3630\" {:_id \"3630\", :_rev \"19-44452d9aaaf2f62dba93dd269c2d4825\", :a [1 2 3630]}]"}
=======
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;2828&quot;</span>","value":"\"2828\""},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-string'>&quot;2828&quot;</span>","value":"\"2828\""}],"value":"[:_id \"2828\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_rev</span>","value":":_rev"},{"type":"html","content":"<span class='clj-string'>&quot;19-724911efdf9291db8cc88e69ad0146c0&quot;</span>","value":"\"19-724911efdf9291db8cc88e69ad0146c0\""}],"value":"[:_rev \"19-724911efdf9291db8cc88e69ad0146c0\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-unkown'>2828</span>","value":"2828"}],"value":"[1 2 2828]"}],"value":"[:a [1 2 2828]]"}],"value":"{:_id \"2828\", :_rev \"19-724911efdf9291db8cc88e69ad0146c0\", :a [1 2 2828]}"}],"value":"[\"2828\" {:_id \"2828\", :_rev \"19-724911efdf9291db8cc88e69ad0146c0\", :a [1 2 2828]}]"}
>>>>>>> Stashed changes
;; <=

;; @@
(dissoc! db "68")
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"html","content":"<span class='clj-unkown'>#&lt;CouchDB com.ashafa.clutch.CouchDB@66a3eb31&gt;</span>","value":"#<CouchDB com.ashafa.clutch.CouchDB@66a3eb31>"}
=======
;;; {"type":"html","content":"<span class='clj-unkown'>#object[com.ashafa.clutch.CouchDB 0x424739e6 &quot;com.ashafa.clutch.CouchDB@424739e6&quot;]</span>","value":"#object[com.ashafa.clutch.CouchDB 0x424739e6 \"com.ashafa.clutch.CouchDB@424739e6\"]"}
>>>>>>> Stashed changes
;; <=

;; @@
(get db "68")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(assoc! db :foo {:a 6 :b 7})
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"html","content":"<span class='clj-unkown'>#&lt;CouchDB com.ashafa.clutch.CouchDB@28b0f626&gt;</span>","value":"#<CouchDB com.ashafa.clutch.CouchDB@28b0f626>"}
=======
;;; {"type":"html","content":"<span class='clj-unkown'>#object[com.ashafa.clutch.CouchDB 0x33eb01d6 &quot;com.ashafa.clutch.CouchDB@33eb01d6&quot;]</span>","value":"#object[com.ashafa.clutch.CouchDB 0x33eb01d6 \"com.ashafa.clutch.CouchDB@33eb01d6\"]"}
>>>>>>> Stashed changes
;; <=

;; @@
(:result (meta *1))
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_rev</span>","value":":_rev"},{"type":"html","content":"<span class='clj-string'>&quot;19-efd91ff626987642ea41583f256de47a&quot;</span>","value":"\"19-efd91ff626987642ea41583f256de47a\""}],"value":"[:_rev \"19-efd91ff626987642ea41583f256de47a\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-string'>&quot;:foo&quot;</span>","value":"\":foo\""}],"value":"[:_id \":foo\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"}],"value":"[:a 6]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"}],"value":"[:b 7]"}],"value":"{:_rev \"19-efd91ff626987642ea41583f256de47a\", :_id \":foo\", :a 6, :b 7}"}
=======
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"}],"value":"[:a 6]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"}],"value":"[:b 7]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-string'>&quot;:foo&quot;</span>","value":"\":foo\""}],"value":"[:_id \":foo\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_rev</span>","value":":_rev"},{"type":"html","content":"<span class='clj-string'>&quot;15-9b95a20e8119086c0e6221cb74febedc&quot;</span>","value":"\"15-9b95a20e8119086c0e6221cb74febedc\""}],"value":"[:_rev \"15-9b95a20e8119086c0e6221cb74febedc\"]"}],"value":"{:a 6, :b 7, :_id \":foo\", :_rev \"15-9b95a20e8119086c0e6221cb74febedc\"}"}
>>>>>>> Stashed changes
;; <=

;; @@
(get db :foo)
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-string'>&quot;:foo&quot;</span>","value":"\":foo\""}],"value":"[:_id \":foo\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_rev</span>","value":":_rev"},{"type":"html","content":"<span class='clj-string'>&quot;19-efd91ff626987642ea41583f256de47a&quot;</span>","value":"\"19-efd91ff626987642ea41583f256de47a\""}],"value":"[:_rev \"19-efd91ff626987642ea41583f256de47a\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"}],"value":"[:a 6]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}],"value":"[:b 7]"}],"value":"{:_id \":foo\", :_rev \"19-efd91ff626987642ea41583f256de47a\", :a 6, :b 7}"}
=======
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_id</span>","value":":_id"},{"type":"html","content":"<span class='clj-string'>&quot;:foo&quot;</span>","value":"\":foo\""}],"value":"[:_id \":foo\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:_rev</span>","value":":_rev"},{"type":"html","content":"<span class='clj-string'>&quot;15-9b95a20e8119086c0e6221cb74febedc&quot;</span>","value":"\"15-9b95a20e8119086c0e6221cb74febedc\""}],"value":"[:_rev \"15-9b95a20e8119086c0e6221cb74febedc\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"}],"value":"[:a 6]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}],"value":"[:b 7]"}],"value":"{:_id \":foo\", :_rev \"15-9b95a20e8119086c0e6221cb74febedc\", :a 6, :b 7}"}
;; <=

;; @@
(count db)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>5000</span>","value":"5000"}
>>>>>>> Stashed changes
;; <=

;; @@
;; to clear database
(reduce dissoc! db (for [x (keys db)]
                        x))
;; @@
;; =>
<<<<<<< Updated upstream
;;; {"type":"html","content":"<span class='clj-unkown'>#&lt;CouchDB com.ashafa.clutch.CouchDB@4ba20903&gt;</span>","value":"#<CouchDB com.ashafa.clutch.CouchDB@4ba20903>"}
=======
;;; {"type":"html","content":"<span class='clj-unkown'>#object[com.ashafa.clutch.CouchDB 0x35fd9314 &quot;com.ashafa.clutch.CouchDB@35fd9314&quot;]</span>","value":"#object[com.ashafa.clutch.CouchDB 0x35fd9314 \"com.ashafa.clutch.CouchDB@35fd9314\"]"}
>>>>>>> Stashed changes
;; <=

;; @@
(count db)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}
;; <=

;; @@
(dir com.ashafa.clutch)
;; @@
;; ->
;;; -&gt;CouchDB
;;; CouchOps
;;; ad-hoc-view
;;; all-databases
;;; all-documents
;;; assoc!
;;; bulk-update
;;; change-agent
;;; changes
;;; changes-running?
;;; configure-view-server
;;; conj!
;;; copy-document
;;; couch
;;; couchdb-info
;;; create!
;;; create-database
;;; database-info
;;; delete-attachment
;;; delete-database
;;; delete-document
;;; dissoc!
;;; dissoc-meta
;;; document-exists?
;;; get-attachment
;;; get-database
;;; get-document
;;; get-view
;;; put-attachment
;;; put-document
;;; replicate-database
;;; save-design-document
;;; save-filter
;;; save-view
;;; start-changes
;;; stop-changes
;;; update-document
;;; view-server-fns
;;; view-transformer
;;; wildcard-collation-string
;;; with-db
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(all-databases)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;_replicator&quot;</span>","value":"\"_replicator\""},{"type":"html","content":"<span class='clj-string'>&quot;_users&quot;</span>","value":"\"_users\""},{"type":"html","content":"<span class='clj-string'>&quot;test&quot;</span>","value":"\"test\""},{"type":"html","content":"<span class='clj-string'>&quot;wiki&quot;</span>","value":"\"wiki\""}],"value":"(\"_replicator\" \"_users\" \"test\" \"wiki\")"}
;; <=

;; @@
(def db-wiki (couch "wiki"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;couchdb-example/db-wiki</span>","value":"#'couchdb-example/db-wiki"}
;; <=

;; @@
(count db-wiki)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}
;; <=

;; @@
(keys db-wiki)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(&quot;JeffCummings&quot; &quot;MainPage&quot; &quot;NextPage&quot; &quot;TestPage&quot; &quot;WandaCummings&quot;)</span>","value":"(\"JeffCummings\" \"MainPage\" \"NextPage\" \"TestPage\" \"WandaCummings\")"}
;; <=

;; @@
(pprint (map #(get db-wiki %) (keys db-wiki)))
;; @@
;; ->
<<<<<<< Updated upstream
;;; ({:_id &quot;JeffCummings&quot;,
;;;   :_rev &quot;10-20cb2c69bee3fd9b586cf5889fb2f4bd&quot;,
;;;   :content &quot;\r\n\r\nBack to MainPage.&quot;}
;;;  {:_id &quot;MainPage&quot;,
;;;   :_rev &quot;4-a514e2e2e29d5f8d49a7455e7e735bf0&quot;,
;;;   :content
;;;   &quot;Hello JeffCummings\r\n\r\nHello WandaCummings\r\n\r\nGoto TestPage\r\n\r\nGoto NextPage&quot;}
;;;  {:_id &quot;NextPage&quot;,
;;;   :_rev &quot;2-f3e1164c05a57017fb6a8e28da311ec0&quot;,
;;;   :content &quot;This is NextPage.\r\n\r\nBack to MainPage.&quot;}
;;;  {:_id &quot;TestPage&quot;,
;;;   :_rev &quot;9-333924b0ec2efdc5345ff861d0d8afa2&quot;,
;;;   :content
;;;   &quot;This is a TestPage.\r\n\r\nGo to NextPage\r\n\r\nAnother test.\r\n\r\n * Test\r\n\r\n# Test\r\n\r\n## Test\r\n\r\n### Test\r\n\r\nBack to MainPage.&quot;}
;;;  {:_id &quot;WandaCummings&quot;,
;;;   :_rev &quot;2-e16b8e7be5cc6b2ee87adf0a785b87ae&quot;,
;;;   :content &quot;Back to MainPage.&quot;})
=======
;;; ({:_id &quot;JeffreyCummings&quot;,
;;;   :_rev &quot;2-a77018252a0968b6a2237640bc23625a&quot;,
;;;   :content &quot;This is me.\r\n\r\nback to MainPage.&quot;}
;;;  {:_id &quot;MainPage&quot;,
;;;   :_rev &quot;2-4b1448ea9de259fe8f9e715e4a188ae8&quot;,
;;;   :content &quot;This is a test.\r\n\r\nJeffreyCummings&quot;})
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(couchdb-info)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:couchdb</span>","value":":couchdb"},{"type":"html","content":"<span class='clj-string'>&quot;Welcome&quot;</span>","value":"\"Welcome\""}],"value":"[:couchdb \"Welcome\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:uuid</span>","value":":uuid"},{"type":"html","content":"<span class='clj-string'>&quot;fbe0714ddbd1f1c136ed74cb7ef8443c&quot;</span>","value":"\"fbe0714ddbd1f1c136ed74cb7ef8443c\""}],"value":"[:uuid \"fbe0714ddbd1f1c136ed74cb7ef8443c\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:version</span>","value":":version"},{"type":"html","content":"<span class='clj-string'>&quot;1.5.0&quot;</span>","value":"\"1.5.0\""}],"value":"[:version \"1.5.0\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:vendor</span>","value":":vendor"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Ubuntu&quot;</span>","value":"\"Ubuntu\""}],"value":"[:name \"Ubuntu\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:version</span>","value":":version"},{"type":"html","content":"<span class='clj-string'>&quot;14.04&quot;</span>","value":"\"14.04\""}],"value":"[:version \"14.04\"]"}],"value":"{:name \"Ubuntu\", :version \"14.04\"}"}],"value":"[:vendor {:name \"Ubuntu\", :version \"14.04\"}]"}],"value":"{:couchdb \"Welcome\", :uuid \"fbe0714ddbd1f1c136ed74cb7ef8443c\", :version \"1.5.0\", :vendor {:name \"Ubuntu\", :version \"14.04\"}}"}
;; <=

;; @@
(pprint (map #(database-info %) [db db-wiki]))
;; @@
;; ->
<<<<<<< Updated upstream
;;; ({:disk_format_version 6,
;;;   :db_name &quot;test&quot;,
;;;   :doc_del_count 1,
;;;   :committed_update_seq 95020,
;;;   :disk_size 359010417,
;;;   :update_seq 95020,
;;;   :purge_seq 0,
;;;   :data_size 3898506,
;;;   :compact_running false,
;;;   :instance_start_time &quot;1433636961125124&quot;,
;;;   :doc_count 5000}
;;;  {:disk_format_version 6,
;;;   :db_name &quot;wiki&quot;,
;;;   :doc_del_count 0,
;;;   :committed_update_seq 27,
;;;   :disk_size 110696,
;;;   :update_seq 27,
;;;   :purge_seq 0,
;;;   :data_size 1890,
;;;   :compact_running false,
;;;   :instance_start_time &quot;1433637416630020&quot;,
;;;   :doc_count 5})
=======
;;; ({:update_seq 90014,
;;;   :committed_update_seq 90014,
;;;   :compact_running false,
;;;   :disk_size 338923633,
;;;   :db_name &quot;test&quot;,
;;;   :disk_format_version 6,
;;;   :data_size 3599991,
;;;   :instance_start_time &quot;1472093641567470&quot;,
;;;   :doc_del_count 5001,
;;;   :purge_seq 0,
;;;   :doc_count 0}
;;;  {:update_seq 4,
;;;   :committed_update_seq 4,
;;;   :compact_running false,
;;;   :disk_size 16479,
;;;   :db_name &quot;wiki&quot;,
;;;   :disk_format_version 6,
;;;   :data_size 555,
;;;   :instance_start_time &quot;1472435988851950&quot;,
;;;   :doc_del_count 0,
;;;   :purge_seq 0,
;;;   :doc_count 2})
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(str (java.util.Date. ))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Sat Jun 06 20:39:45 EDT 2015&quot;</span>","value":"\"Sat Jun 06 20:39:45 EDT 2015\""}
;; <=

;; @@
(str (java.util.Date. 1433636961125))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Sat Jun 06 20:29:21 EDT 2015&quot;</span>","value":"\"Sat Jun 06 20:29:21 EDT 2015\""}
;; <=

;; @@
<<<<<<< Updated upstream
(str (java.util.Date. 1433637416630))
;; @@
=======
(.getTime (java.util.Date.))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1472436012496</span>","value":"1472436012496"}
;; <=

;; @@
(time (reduce dissoc! db (for [x (keys db)]
                        x)))
;; @@
;; ->
;;; &quot;Elapsed time: 74433.50803 msecs&quot;
;;; 
;; <-
>>>>>>> Stashed changes
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Sat Jun 06 20:36:56 EDT 2015&quot;</span>","value":"\"Sat Jun 06 20:36:56 EDT 2015\""}
;; <=

;; @@
<<<<<<< Updated upstream
(.getTime (java.util.Date.))
=======
(count db)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}
;; <=

;; @@
(time (reduce conj! db (for [x (range 5000)]
                      {:_id (str x) :a [1 2 x]})))
;; @@
;; ->
;;; &quot;Elapsed time: 40544.056437 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#&lt;CouchDB com.ashafa.clutch.CouchDB@6d3d5efa&gt;</span>","value":"#<CouchDB com.ashafa.clutch.CouchDB@6d3d5efa>"}
;; <=

;; @@
(count db)
>>>>>>> Stashed changes
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1433637675705</span>","value":"1433637675705"}
;; <=

;; @@

;; @@
