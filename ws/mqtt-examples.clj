;; gorilla-repl.fileformat = 1

;; **
;;; # MQTT Examples
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns mqtt-examples
  (:use gorilla-plot.core)
  (:use clojure.repl)
  (:require [clojurewerkz.machine-head.client :as mh]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def local-conn (mh/connect "tcp://localhost:1883" (mh/generate-id)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mqtt-examples/local-conn</span>","value":"#'mqtt-examples/local-conn"}
;; <=

;; @@
(def suscrb-t-t1 (atom []))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mqtt-examples/suscrb-t-t1</span>","value":"#'mqtt-examples/suscrb-t-t1"}
;; <=

;; @@
(def suscrb-t-t2 (atom []))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mqtt-examples/suscrb-t-t2</span>","value":"#'mqtt-examples/suscrb-t-t2"}
;; <=

;; @@
(mh/subscribe local-conn {"topic/test1" 0} (fn [^String topic _ ^bytes payload]
                                               (swap! suscrb-t-t1 conj (String. payload "UTF-8"))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(mh/subscribe local-conn {"topic/test2" 0} (fn [^String topic _ ^bytes payload]
                                               (swap! suscrb-t-t2 conj (String. payload "UTF-8"))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(mh/publish local-conn "topic/test1" "Hello from gorilla t/t1")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(mh/publish local-conn "topic/test2" "Hello from gorilla t/t2")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
@suscrb-t-t1 
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Hello from gorilla t/t1&quot;</span>","value":"\"Hello from gorilla t/t1\""},{"type":"html","content":"<span class='clj-string'>&quot;Hello from gorilla t/t1&quot;</span>","value":"\"Hello from gorilla t/t1\""},{"type":"html","content":"<span class='clj-string'>&quot;Hello from gorilla t/t1&quot;</span>","value":"\"Hello from gorilla t/t1\""}],"value":"[\"Hello from gorilla t/t1\" \"Hello from gorilla t/t1\" \"Hello from gorilla t/t1\"]"}
;; <=

;; @@
@suscrb-t-t2
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Hello from gorilla t/t2&quot;</span>","value":"\"Hello from gorilla t/t2\""},{"type":"html","content":"<span class='clj-string'>&quot;Hello from gorilla t/t2&quot;</span>","value":"\"Hello from gorilla t/t2\""},{"type":"html","content":"<span class='clj-string'>&quot;Hello from gorilla t/t2&quot;</span>","value":"\"Hello from gorilla t/t2\""}],"value":"[\"Hello from gorilla t/t2\" \"Hello from gorilla t/t2\" \"Hello from gorilla t/t2\"]"}
;; <=

;; @@
(def remote-conn (mh/connect "tcp://broker.hivemq.com:1883" (mh/generate-id)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mqtt-examples/remote-conn</span>","value":"#'mqtt-examples/remote-conn"}
;; <=

;; @@
(def r-suscrb-t-t1 (atom []))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mqtt-examples/r-suscrb-t-t1</span>","value":"#'mqtt-examples/r-suscrb-t-t1"}
;; <=

;; @@
(def r-suscrb-t-t2 (atom []))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;mqtt-examples/r-suscrb-t-t2</span>","value":"#'mqtt-examples/r-suscrb-t-t2"}
;; <=

;; @@
(mh/subscribe remote-conn {"topic/test1" 0} (fn [^String topic _ ^bytes payload]
                                               (swap! r-suscrb-t-t1 conj (String. payload "UTF-8"))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(mh/subscribe remote-conn {"topic/test2" 0} (fn [^String topic _ ^bytes payload]
                                               (swap! r-suscrb-t-t2 conj (String. payload "UTF-8"))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(mh/publish remote-conn "topic/test1" "Hello from Linode gorilla t/t1")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(mh/publish remote-conn "topic/test2" "Hello from Linode gorilla t/t2")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
@r-suscrb-t-t1
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Hello from Linode gorilla t/t1&quot;</span>","value":"\"Hello from Linode gorilla t/t1\""}],"value":"[\"Hello from Linode gorilla t/t1\"]"}
;; <=

;; @@
@r-suscrb-t-t2
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Hello from Linode gorilla t/t2&quot;</span>","value":"\"Hello from Linode gorilla t/t2\""}],"value":"[\"Hello from Linode gorilla t/t2\"]"}
;; <=

;; @@
(print (slurp ".nrepl-port"))
;; @@
;; ->
;;; 36921
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir clojurewerkz.machine-head.client)
;; @@
;; ->
;;; connect
;;; connected?
;;; disconnect
;;; disconnect-and-close
;;; generate-id
;;; pending-delivery-tokens
;;; pending-messages
;;; prepare
;;; publish
;;; subscribe
;;; unsubscribe
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc mh/unsubscribe)
;; @@
;; ->
;;; -------------------------
;;; clojurewerkz.machine-head.client/unsubscribe
;;; ([client topics])
;;;   Unsubscribes from one or multiple topics (if `topics` is a collection
;;;    or sequence)
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
