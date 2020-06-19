;; gorilla-repl.fileformat = 1

;; **
;;; # Redis Examples
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;; **

;; @@
(ns redis-example
  (:require [gorilla-plot.core :as plot])
  (:use clojure.repl)
  (:use clojure.pprint)
  (:require [taoensso.carmine :as car :refer (wcar)]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc wcar)
;; @@
;; ->
;;; -------------------------
;;; taoensso.carmine/wcar
;;; ([conn-opts :as-pipeline &amp; body] [conn-opts &amp; body])
;;; Macro
;;;   Evaluates body in the context of a fresh thread-bound pooled connection to
;;;   Redis server. Sends Redis commands to server as pipeline and returns the
;;;   server&#x27;s response. Releases connection back to pool when done.
;;; 
;;;   `conn-opts` arg is a map with connection pool and spec options:
;;;     {:pool {} :spec {:host &quot;127.0.0.1&quot; :port 6379}} ; Default
;;;     {:pool {} :spec {:uri &quot;redis://redistogo:pass@panga.redistogo.com:9475/&quot;}}
;;;     {:pool {} :spec {:host &quot;127.0.0.1&quot; :port 6379
;;;                      :password &quot;secret&quot;
;;;                      :timeout-ms 6000
;;;                      :db 3}}
;;; 
;;;   A `nil` or `{}` `conn-opts` will use defaults. A `:none` pool can be used
;;;   to skip connection pooling (not recommended).
;;;   For other pool options, Ref. http://goo.gl/e1p1h3,
;;;                                http://goo.gl/Sz4uN1 (defaults).
;;; 
;;;   See also `with-replies`.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defmacro wcar* [& body] `(car/wcar {} ~@body))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;redis-example/wcar*</span>","value":"#'redis-example/wcar*"}
;; <=

;; @@
(wcar* (car/ping)
       (car/set "foo" "bar")
       (car/get "foo"))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;PONG&quot;</span>","value":"\"PONG\""},{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-string'>&quot;bar&quot;</span>","value":"\"bar\""}],"value":"[\"PONG\" \"OK\" \"bar\"]"}
;; <=

;; @@
(wcar* (car/spop "foo"))
;; @@

;; @@
(wcar* (car/set  "foo" "bar")
       (car/spop "foo")
       (car/get  "foo"))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-unkown'>#&lt;ExceptionInfo clojure.lang.ExceptionInfo: WRONGTYPE Operation against a key holding the wrong kind of value {:prefix :wrongtype}&gt;</span>","value":"#<ExceptionInfo clojure.lang.ExceptionInfo: WRONGTYPE Operation against a key holding the wrong kind of value {:prefix :wrongtype}>"},{"type":"html","content":"<span class='clj-string'>&quot;bar&quot;</span>","value":"\"bar\""}],"value":"[\"OK\" #<ExceptionInfo clojure.lang.ExceptionInfo: WRONGTYPE Operation against a key holding the wrong kind of value {:prefix :wrongtype}> \"bar\"]"}
;; <=

;; @@
(wcar* (car/set "clj-key" {:bigint (bigint 31415926535897932384626433832795)
                           :vec    (vec (range 5))
                           :set    #{true false :a :b :c :d}
                           :map    {:a 1 :b "one"}
                           :bytes  (byte-array 5)
                           ;; ...
                           })
       (car/get "clj-key"))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:bigint</span>","value":":bigint"},{"type":"html","content":"<span class='clj-bigint'>31415926535897932384626433832795N</span>","value":"31415926535897932384626433832795N"}],"value":"[:bigint 31415926535897932384626433832795N]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:vec</span>","value":":vec"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}],"value":"[0 1 2 3 4]"}],"value":"[:vec [0 1 2 3 4]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:set</span>","value":":set"},{"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-keyword'>:c</span>","value":":c"},{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"html","content":"<span class='clj-keyword'>:d</span>","value":":d"},{"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"},{"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}],"value":"#{:a :c :b :d true false}"}],"value":"[:set #{:a :c :b :d true false}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:map</span>","value":":map"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[:a 1]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"html","content":"<span class='clj-string'>&quot;one&quot;</span>","value":"\"one\""}],"value":"[:b \"one\"]"}],"value":"{:a 1, :b \"one\"}"}],"value":"[:map {:a 1, :b \"one\"}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:bytes</span>","value":":bytes"},{"type":"html","content":"<span class='clj-unkown'>#&lt;byte[] [B@4e9cf6d8&gt;</span>","value":"#<byte[] [B@4e9cf6d8>"}],"value":"[:bytes #<byte[] [B@4e9cf6d8>]"}],"value":"{:bigint 31415926535897932384626433832795N, :vec [0 1 2 3 4], :set #{:a :c :b :d true false}, :map {:a 1, :b \"one\"}, :bytes #<byte[] [B@4e9cf6d8>}"}],"value":"[\"OK\" {:bigint 31415926535897932384626433832795N, :vec [0 1 2 3 4], :set #{:a :c :b :d true false}, :map {:a 1, :b \"one\"}, :bytes #<byte[] [B@4e9cf6d8>}]"}
;; <=

;; @@
(doc car/sort)
;; @@
;; ->
;;; -------------------------
;;; taoensso.carmine/sort
;;; ([key &amp; args])
;;;   SORT key [BY pattern] [LIMIT offset count] [GET pattern [GET pattern ...]] [ASC|DESC] [ALPHA] [STORE destination]
;;; 
;;; Sort the elements in a list, set or sorted set.
;;; 
;;; Available since: 1.0.0.
;;; 
;;; Time complexity: O(N+M*log(M)) where N is the number of elements in the list or set to sort, and M the number of returned elements. When the elements are not sorted, complexity is currently O(N) as there is a copy step that will be avoided in next releases.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn my-set
  [key value]
  (car/lua "return redis.call('set', _:my-key, 'lua '.. _:my-val)"
                  {:my-key key}   ; Named key variables and their values
                  {:my-val value} ; Named non-key variables and their values
                  ))

(wcar* (my-set "foo" "bar")
       (car/get "foo"))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-string'>&quot;lua bar&quot;</span>","value":"\"lua bar\""}],"value":"[\"OK\" \"lua bar\"]"}
;; <=

;; @@
(wcar* (doall (repeatedly 5 car/ping)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;PONG&quot;</span>","value":"\"PONG\""},{"type":"html","content":"<span class='clj-string'>&quot;PONG&quot;</span>","value":"\"PONG\""},{"type":"html","content":"<span class='clj-string'>&quot;PONG&quot;</span>","value":"\"PONG\""},{"type":"html","content":"<span class='clj-string'>&quot;PONG&quot;</span>","value":"\"PONG\""},{"type":"html","content":"<span class='clj-string'>&quot;PONG&quot;</span>","value":"\"PONG\""}],"value":"[\"PONG\" \"PONG\" \"PONG\" \"PONG\" \"PONG\"]"}
;; <=

;; @@
(let [first-names ["Salvatore"  "Rich"]
      surnames    ["Sanfilippo" "Hickey"]]
  (wcar* (mapv #(car/set %1 %2) first-names surnames)
         (mapv car/get first-names)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-string'>&quot;Sanfilippo&quot;</span>","value":"\"Sanfilippo\""},{"type":"html","content":"<span class='clj-string'>&quot;Hickey&quot;</span>","value":"\"Hickey\""}],"value":"[\"OK\" \"OK\" \"Sanfilippo\" \"Hickey\"]"}
;; <=

;; @@
(wcar* (mapv #(car/set (str "key-" %) (rand-int 10)) (range 3))
       (mapv #(car/get (str "key-" %)) (range 3)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-string'>&quot;OK&quot;</span>","value":"\"OK\""},{"type":"html","content":"<span class='clj-string'>&quot;6&quot;</span>","value":"\"6\""},{"type":"html","content":"<span class='clj-string'>&quot;5&quot;</span>","value":"\"5\""},{"type":"html","content":"<span class='clj-string'>&quot;0&quot;</span>","value":"\"0\""}],"value":"[\"OK\" \"OK\" \"OK\" \"6\" \"5\" \"0\"]"}
;; <=

;; @@
(dir taoensso.carmine)
;; @@
;; ->
;;; -&gt;Listener
;;; append
;;; as-bool
;;; as-double
;;; as-float
;;; as-int
;;; as-long
;;; as-map
;;; atomic
;;; atomic*
;;; atomically
;;; auth
;;; bgrewriteaof
;;; bgsave
;;; bitcount
;;; bitop
;;; bitpos
;;; blpop
;;; brpop
;;; brpoplpush
;;; client-getname
;;; client-kill
;;; client-list
;;; client-pause
;;; client-setname
;;; close-listener
;;; config-get
;;; config-resetstat
;;; config-rewrite
;;; config-set
;;; dbsize
;;; debug-object
;;; debug-segfault
;;; decr
;;; decrby
;;; del
;;; discard
;;; dump
;;; echo
;;; ensure-atomically
;;; eval
;;; eval*
;;; evalsha
;;; evalsha*
;;; exec
;;; exists
;;; expire
;;; expireat
;;; flushall
;;; flushdb
;;; freeze
;;; get
;;; getbit
;;; getrange
;;; getset
;;; hash-script
;;; hdel
;;; hexists
;;; hget
;;; hgetall
;;; hgetall*
;;; hincrby
;;; hincrbyfloat
;;; hkeys
;;; hlen
;;; hmget
;;; hmget*
;;; hmset
;;; hmset*
;;; hscan
;;; hset
;;; hsetnx
;;; hvals
;;; incr
;;; incrby
;;; incrbyfloat
;;; info
;;; info*
;;; key
;;; keys
;;; kname
;;; lastsave
;;; lindex
;;; linsert
;;; llen
;;; lpop
;;; lpush
;;; lpushx
;;; lrange
;;; lrem
;;; lset
;;; ltrim
;;; lua
;;; lua-local
;;; lua-script
;;; make-conn-pool
;;; make-conn-spec
;;; make-keyfn
;;; map-&gt;Listener
;;; mget
;;; migrate
;;; monitor
;;; move
;;; mset
;;; msetnx
;;; multi
;;; object
;;; parse
;;; parse-bool
;;; parse-double
;;; parse-float
;;; parse-int
;;; parse-keyword
;;; parse-long
;;; parse-map
;;; parse-nippy
;;; parse-raw
;;; parser-comp
;;; persist
;;; pexpire
;;; pexpireat
;;; pfadd
;;; pfcount
;;; pfmerge
;;; ping
;;; preserve
;;; psetex
;;; psubscribe
;;; pttl
;;; publish
;;; pubsub
;;; punsubscribe
;;; quit
;;; randomkey
;;; raw
;;; redis-call
;;; remember
;;; rename
;;; renamenx
;;; restore
;;; return
;;; role
;;; rpop
;;; rpoplpush
;;; rpush
;;; rpushx
;;; sadd
;;; save
;;; scan
;;; scard
;;; script-exists
;;; script-flush
;;; script-hash
;;; script-kill
;;; script-load
;;; sdiff
;;; sdiffstore
;;; select
;;; serialize
;;; set
;;; setbit
;;; setex
;;; setnx
;;; setrange
;;; shutdown
;;; sinter
;;; sinterstore
;;; sismember
;;; skip-replies
;;; slaveof
;;; slowlog
;;; smembers
;;; smove
;;; sort
;;; sort*
;;; spop
;;; srandmember
;;; srem
;;; sscan
;;; strlen
;;; subscribe
;;; sunion
;;; sunionstore
;;; sync
;;; time
;;; ttl
;;; type
;;; unsubscribe
;;; unwatch
;;; watch
;;; wcar
;;; with-conn
;;; with-new-listener
;;; with-new-pubsub-listener
;;; with-open-listener
;;; with-parser
;;; with-replies
;;; with-reply
;;; with-thaw-opts
;;; zadd
;;; zcard
;;; zcount
;;; zincrby
;;; zinterstore
;;; zinterstore*
;;; zlexcount
;;; zrange
;;; zrangebylex
;;; zrangebyscore
;;; zrank
;;; zrem
;;; zremrangebylex
;;; zremrangebyrank
;;; zremrangebyscore
;;; zrevrange
;;; zrevrangebyscore
;;; zrevrank
;;; zscan
;;; zscore
;;; zunionstore
;;; zunionstore*
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
